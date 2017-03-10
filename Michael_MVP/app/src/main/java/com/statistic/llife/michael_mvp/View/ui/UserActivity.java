package com.statistic.llife.michael_mvp.View.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.statistic.llife.michael_mvp.Presenter.UserPresenter;
import com.statistic.llife.michael_mvp.R;

/**
 * Created by lizhiming211223 on 2017/3/10.
 */

public class UserActivity extends Activity implements View.OnClickListener,IUserView{

    private EditText mUserName , mComment  ;
    private Button mSaveButton , mLoadButton ;
    private UserPresenter userPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_querydb_main);
        findWidgets();
        userPresenter=new UserPresenter(this);

    }


    void findWidgets() {
        mUserName = (EditText) findViewById(R.id.first_name_edt);
        mComment = (EditText) findViewById(R.id.last_name_edt);
        mSaveButton = (Button) findViewById(R.id.saveButton);
        mLoadButton = (Button) findViewById(R.id.loadButton);
        mSaveButton.setOnClickListener(this);
        mLoadButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.saveButton:
                userPresenter.saveUser(getUserName(),getComment());
                break;
            case R.id.loadButton:
                userPresenter.loadUser(getUserName());
                break;
        }
    }

    @Override
    public String getUserName() {
        return mUserName.getText().toString();
    }

    @Override
    public String getComment() {
        return mComment.getText().toString();
    }

    @Override
    public void setUserName(String userName) {
        mUserName.setText(userName);
    }

    @Override
    public void setComment(String comment) {
        mComment.setText(comment);
    }
}
