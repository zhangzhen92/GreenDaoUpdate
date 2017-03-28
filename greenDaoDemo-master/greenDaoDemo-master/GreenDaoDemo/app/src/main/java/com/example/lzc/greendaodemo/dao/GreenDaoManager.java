package com.example.lzc.greendaodemo.dao;

import android.database.sqlite.SQLiteDatabase;

import com.example.lzc.greendaodemo.MyApplication;
import com.example.lzc.greendaodemo.dao.userdao.DaoMaster;
import com.example.lzc.greendaodemo.dao.userdao.DaoSession;


/**
 * 类描述：greendao管理类
 * 创建人：zz
 * 创建时间： 2017/2/27 15:38
 */


public class GreenDaoManager {
    private static GreenDaoManager instance = null;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private GreenDaoManager() {
        if(instance == null){
            DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(MyApplication.getInstance(), "user_db", null);
            db = mHelper.getWritableDatabase();
            mDaoMaster = new DaoMaster(db);
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static GreenDaoManager getInstance(){
       if(instance == null){
           synchronized (GreenDaoManager.class){
               instance = new GreenDaoManager();
           }
       }
        return instance;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }


    public DaoMaster getmDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

}
