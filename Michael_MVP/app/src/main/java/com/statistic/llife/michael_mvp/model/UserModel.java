package com.statistic.llife.michael_mvp.model;

import michael.db.greendao.Note;

/**
 * Created by lizhiming211223 on 2017/3/9.
 */

public class UserModel implements IDataModel{

    private String mUserName;
    private String mComment;


    @Override
    public void setUserName(String userName) {
        mUserName=userName;
    }

    @Override
    public void setComment(String comment) {
        mComment=comment;
        Note note=new Note();
        note.setText(mUserName);
        note.setComment(comment);
        DBManager.getInstance().getNoteDao().insert(note);
    }

    @Override
    public Note load(String userName) {
        Note note=DBManager.getInstance().getNote(userName);
        return note;
    }
}
