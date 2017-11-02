package cn.nicolite.huthelper.view.iview;

import java.util.List;

import cn.nicolite.huthelper.base.iview.IBaseView;
import cn.nicolite.huthelper.model.bean.Menu;
import cn.nicolite.huthelper.model.bean.TimeAxis;
import cn.nicolite.huthelper.model.bean.User;

/**
 * Created by nicolite on 17-10-22.
 */

public interface IMainView extends IBaseView {
    void showWeather(String city, String tmp, String content);
    void showTimeAxis(List<TimeAxis> timeAxisList);
    void showNotice();
    void showSyllabus();
    void showMenu(List<Menu> menuList);
    void showUser(User user);
}