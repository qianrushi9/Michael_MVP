package com.statistic.llife.michael_mvp.model;

import android.database.sqlite.SQLiteDatabase;

import com.statistic.llife.michael_mvp.BaseApplication;
import com.statistic.llife.michael_mvp.utils.Constants;

import java.util.List;

import de.greenrobot.dao.query.Query;
import michael.db.greendao.DaoMaster;
import michael.db.greendao.DaoSession;
import michael.db.greendao.Note;
import michael.db.greendao.NoteDao;

/**
 * Created by lizhiming211223 on 2017/3/9.
 */

public class DBManager {
    private static DBManager dbm = new DBManager();
    public DaoSession daoSession;
    public SQLiteDatabase db;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;


    private DBManager() {
    }
    public static DBManager getInstance() {
        return dbm;
    }
    public void init(){
        helper = new DaoMaster.DevOpenHelper(BaseApplication.getInstance(), Constants.DB_NAME, null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public Note getNote(String userName){
        // Query 类代表了一个可以被重复执行的查询
        Query query = getNoteDao().queryBuilder()
                .where(NoteDao.Properties.Text.eq(userName))
                .build();

        List<Note> notes = query.list();
        if(notes.size()==0){
            return null;
        }
        return   notes.get(0);
    }

    public NoteDao getNoteDao() {
        return daoSession.getNoteDao();
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
