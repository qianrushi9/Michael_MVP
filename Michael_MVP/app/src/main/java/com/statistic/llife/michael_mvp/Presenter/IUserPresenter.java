package com.statistic.llife.michael_mvp.Presenter;

/**
 * Created by lizhiming211223 on 2017/3/9.
 */

public interface IUserPresenter {
    void saveUser(String userName,String comment);
    void loadUser(String userName);
}
