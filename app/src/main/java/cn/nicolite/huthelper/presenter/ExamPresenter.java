package cn.nicolite.huthelper.presenter;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import cn.nicolite.huthelper.base.presenter.BasePresenter;
import cn.nicolite.huthelper.db.dao.ExamDao;
import cn.nicolite.huthelper.model.bean.Configure;
import cn.nicolite.huthelper.model.bean.Exam;
import cn.nicolite.huthelper.model.bean.ExamResult;
import cn.nicolite.huthelper.model.bean.User;
import cn.nicolite.huthelper.network.api.APIUtils;
import cn.nicolite.huthelper.network.exception.ExceptionEngine;
import cn.nicolite.huthelper.utils.EncryptUtils;
import cn.nicolite.huthelper.utils.ListUtils;
import cn.nicolite.huthelper.view.activity.ExamActivity;
import cn.nicolite.huthelper.view.iview.IExamView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ExamPresenter
 * Created by nicolite on 17-11-1.
 */

public class ExamPresenter extends BasePresenter<IExamView, ExamActivity> {
    public ExamPresenter(IExamView view, ExamActivity activity) {
        super(view, activity);
    }

    public void showExam(final boolean isManual) {
        final String userId = getLoginUser();

        if (TextUtils.isEmpty(userId)) {
            getView().showMessage("获取当前登录用户失败，请重新登录！");
            return;
        }

        List<Configure> configureList = getConfigureList();
        if (ListUtils.isEmpty(configureList)) {
            getView().showMessage("获取用户信息失败！");
            return;
        }

        User user = configureList.get(0).getUser();

        if (user == null) {
            getView().showMessage("获取用户信息失败！");
            return;
        }


        final ExamDao examDao = getDaoSession().getExamDao();
        final List<Exam> list = examDao.queryBuilder().where(ExamDao.Properties.UserId.eq(userId)).list();

        APIUtils
                .getExamAPI()
                .getExamData(user.getStudentKH(),
                        EncryptUtils.MD5(user.getStudentKH() + "apiforapp!"))
                .compose(getActivity().<ExamResult>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ExamResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (ListUtils.isEmpty(list) || isManual){
                            getView().showLoading();
                        }
                    }

                    @Override
                    public void onNext(ExamResult examResult) {
                        getView().closeLoading();

                        if (examResult != null && examResult.getStatus().equals("success")) {
                            List<Exam> examList = new ArrayList<>();
                            List<Exam> exam1 = examResult.getRes().getExam();
                            List<Exam> cxexam = examResult.getRes().getCxexam();

                            if (ListUtils.isEmpty(exam1) && ListUtils.isEmpty(cxexam)) {
                                getView().showMessage("没有找到你的考试计划！");
                            }

                            examList.addAll(exam1);

                            if (ListUtils.isEmpty(cxexam)) {
                                examList.addAll(cxexam);
                            }

                            if (!ListUtils.isEmpty(list)) {
                                for (Exam exame : list) {
                                    examDao.delete(exame);
                                }
                            }

                            for (Exam exam : examList) {
                                exam.setUserId(userId);
                                examDao.insert(exam);
                            }

                            getView().showExam(examList);

                        } else {
                            if (!ListUtils.isEmpty(list)) {
                                getView().showExam(list);
                            }
                            getView().showMessage("没有找到你的考试计划！");
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().closeLoading();
                        getView().showExam(list);
                        getView().showMessage("加载失败，" + ExceptionEngine.handleException(e).getMsg());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}