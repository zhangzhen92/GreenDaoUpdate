package com.example.lzc.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.lzc.greendaodemo.dao.GreenDaoManager;
import com.example.lzc.greendaodemo.dao.userdao.DaoMaster;
import com.example.lzc.greendaodemo.dao.userdao.DaoSession;

/**
 * 类描述：Application类
 * 创建人：zz
 * 创建时间： 2017/2/15 15:00
 */


public class MyApplication extends Application{
    private static MyApplication instance;
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        GreenDaoManager.getInstance();                 //数据库初始化
    }



}
