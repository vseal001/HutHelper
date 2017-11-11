package cn.nicolite.huthelper.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.nicolite.huthelper.app.MApplication;
import cn.nicolite.huthelper.db.DaoHelper;
import cn.nicolite.huthelper.db.dao.ConfigureDao;
import cn.nicolite.huthelper.db.dao.DaoSession;
import cn.nicolite.huthelper.model.bean.Configure;
import cn.nicolite.huthelper.model.bean.User;
import cn.nicolite.huthelper.model.bean.Valid;
import cn.nicolite.huthelper.network.api.APIUtils;
import cn.nicolite.huthelper.network.exception.ExceptionEngine;
import cn.nicolite.huthelper.utils.ListUtils;
import cn.nicolite.huthelper.utils.LogUtils;
import cn.nicolite.huthelper.view.activity.OffsiteLoginDialogActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * 登录服务，检测是否已在其它设备登录
 * Created by nicolite on 17-11-2.
 */

public class LoginService extends IntentService {

    private static final int DELAY = 2 * 1000;
    private static final int PERIOD = 15 * 1000;
    private static final String ACTION_INIT_WHEN_APP_CREATE = "cn.nicolite.huthelper.service.action.INIT";
    private static final String TAG = "LoginService";
    private Timer timer;

    private DaoSession daoSession = DaoHelper.getDaoHelper(MApplication.AppContext).getDaoSession();

    public LoginService() {
        super("LoginService");
    }

    public LoginService(String name) {
        super(name);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginService.class);
        intent.setAction(ACTION_INIT_WHEN_APP_CREATE);
        context.startService(intent);
        LogUtils.d(TAG, "start");

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isLoginOnOtherPlace();
            }
        }, DELAY, PERIOD);
    }

    private void isLoginOnOtherPlace() {
        String userId = getSharedPreferences("login_user", Context.MODE_PRIVATE).getString("userId", null);
        if (userId == null || userId.equals("*")) {
            LogUtils.d(TAG, "没有找到登录用户");
            return;
        }

        List<Configure> list = daoSession.getConfigureDao().queryBuilder().where(ConfigureDao.Properties.UserId.eq(userId)).list();

        if (ListUtils.isEmpty(list)) {
            LogUtils.d(TAG, "没有找到登录用户");
            return;
        }

        Configure configure = list.get(0);
        User user = configure.getUser();

        APIUtils
                .getMessageAPI()
                .isValid(user.getStudentKH(), configure.getAppRememberCode())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Valid>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Valid valid) {
                        if (!valid.isCode()) {
                            LogUtils.d(TAG, "帐号已在在另一台设备登录！");
                            startLogin();
                        } else {
                            LogUtils.d(TAG, "未发现在其他设备登录！");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.d(TAG, ExceptionEngine.handleException(e).getMsg());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void startLogin() {
        Intent intent = new Intent(this, OffsiteLoginDialogActivity.class);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        if (timer != null) {
            timer.cancel();
        }
        stopService(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.d(TAG, "destroy");
    }
}
