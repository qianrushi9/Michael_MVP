package com.statistic.llife.michael_mvp.model;

import michael.db.greendao.Note;

/**
 * Created by lizhiming211223 on 2017/3/9.
 */

public interface IDataModel {
    void setUserName (String userName);
    void setComment (String comment);
    Note load (String userName);//通过id读取user信息,返回一个UserBean
}
