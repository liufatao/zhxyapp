package com.yunhuakeji.app.greendaoutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.yunhuakeji.app.greendao.DaoMaster;
import com.yunhuakeji.app.greendao.MyApplicationDao;
import com.yunhuakeji.app.greendao.RecommendApplicationDao;

/**
 * GreenDao 数据库升级
 */

public class MySQLiteOpenHelper extends DaoMaster.OpenHelper{

    public MySQLiteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //所以Dao类都放在这里进行数据升级
        MigrationHelper.migrate(db, MyApplicationDao.class, RecommendApplicationDao.class);
    }
}
