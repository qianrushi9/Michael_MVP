package com.statistic.llife.michael_mvp.Presenter;

import com.statistic.llife.michael_mvp.View.ui.IUserView;
import com.statistic.llife.michael_mvp.model.IDataModel;
import com.statistic.llife.michael_mvp.model.UserModel;

import michael.db.greendao.Note;

/**
 * Created by lizhiming211223 on 2017/3/9.
 */

public class UserPresenter implements IUserPresenter{
    private IUserView iUserView;
    private IDataModel iDataModel;


    public UserPresenter(IUserView iUserView){
        this.iUserView=iUserView;
        this.iDataModel=new UserModel();
    }


    @Override
    public void saveUser(String userName, String comment) {
        iDataModel.setUserName(userName);
        iDataModel.setComment(comment);
    }

    @Override
    public void loadUser(String userName) {
        Note note=iDataModel.load(userName);
        iUserView.setUserName(note.getText());
        iUserView.setComment(note.getComment());
    }
}
