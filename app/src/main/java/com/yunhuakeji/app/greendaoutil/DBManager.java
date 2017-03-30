package com.yunhuakeji.app.greendaoutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yunhuakeji.app.greendao.DaoMaster;
import com.yunhuakeji.app.greendao.DaoSession;
import com.yunhuakeji.app.greendao.MyApplicationDao;
import com.yunhuakeji.app.greendao.RecommendApplicationDao;
import com.yunhuakeji.app.greendaomodel.MyApplication;
import com.yunhuakeji.app.greendaomodel.RecommendApplication;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 数据库操作管理类
 */

public class DBManager {

    private final static String dbName = "yunhua";//数据库名称
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    /**
     * 创建数据库
     *
     * @param context
     */
    public DBManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    /**
     * 获得当前引用
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }


    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    /**
     * 获得DaoSession
     * @return DaoSession
     */
    private DaoSession getDaoSession(){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }
    /**
     * 我的应用插入一条记录
     *
     * @param myApplication 插入对象
     */
    public void insertMyApplication(MyApplication myApplication) {
        MyApplicationDao applicationDao = getDaoSession().getMyApplicationDao();
        applicationDao.insertOrReplace(myApplication);
    }

    /**
     * 插入我的应用集合
     *
     * @param applications
     */
    public void insertMyApplicationList(List<MyApplication> applications) {
        if (applications == null || applications.isEmpty()) {
            return;
        }

        MyApplicationDao applicationDao = getDaoSession().getMyApplicationDao();
        applicationDao.insertInTx(applications);
    }

    /**
     * 根据条件删除一条记录
     *
     * @param userId
     */
    public void deleteMyApplication(String userId,int function_id) {

       MyApplicationDao applicationDao = getDaoSession().getMyApplicationDao();
        MyApplication myApplication = applicationDao.queryBuilder().where(MyApplicationDao.Properties.UserId.eq(userId),MyApplicationDao.Properties.Function_id.eq(function_id)).build().unique();
        if(myApplication != null){
            applicationDao.delete(myApplication);
        }
    }


    /**
     *根据userID查询我的应用列表
     * 根据UserId进行排序
     *
     */
    public List<MyApplication> queryMyApplicationList(String useId) {
        MyApplicationDao applicationDao= getDaoSession().getMyApplicationDao();
        QueryBuilder<MyApplication> qb = applicationDao.queryBuilder();
        qb.where(MyApplicationDao.Properties.UserId.eq(useId));
        List<MyApplication> list = qb.list();
        return list;
    }
  /*
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    下面是推荐应用模块相关操作
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   */

    /**
     * 插入推荐应用一条记录
     * @param recommendApplication
     */
    public void insertRecommendApplication(RecommendApplication recommendApplication){
       RecommendApplicationDao recommendApplicationDao=getDaoSession().getRecommendApplicationDao();
        recommendApplicationDao.insertOrReplace(recommendApplication);
    }

    /**
     * 插入推荐应用集合
     *
     * @param applications
     */
    public void insertRecommendApplicationList(List<RecommendApplication> applications) {
        if (applications == null || applications.isEmpty()) {
            return;
        }
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        RecommendApplicationDao recommendApplicationDao = daoSession.getRecommendApplicationDao();
        recommendApplicationDao.insertInTx(applications);
    }

    /**
     * 根据条件删除推荐应用一条记录
     * 查询符合userID的所以数据
     * 如果有就删除
     * @param userId
     */
    public void deleteRecommendApplication(String userId) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        RecommendApplicationDao recommendApplicationDao= daoSession.getRecommendApplicationDao();
        RecommendApplication recommendApplication =  recommendApplicationDao.queryBuilder().where(RecommendApplicationDao.Properties.UserId.eq(userId)).build().unique();
        if(recommendApplication != null){
            recommendApplicationDao.delete(recommendApplication);
        }
    }


    /**
     * 查询推荐应用列表
     */
    public List<RecommendApplication> queryRecommendApplicationList() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        RecommendApplicationDao recommendApplicationDao= daoSession.getRecommendApplicationDao();
        QueryBuilder<RecommendApplication> qb = recommendApplicationDao.queryBuilder();
        List<RecommendApplication> list = qb.list();
        return list;
    }

    /**
     * 根据条件查询我的应用列表
     * 查询和该userID相同的所以应用数据
     */
    public List<RecommendApplication> queryRecommendApplication(String useId) {
        RecommendApplicationDao recommendApplicationDao = getDaoSession().getRecommendApplicationDao();
        List<RecommendApplication> list = recommendApplicationDao.queryBuilder().where(RecommendApplicationDao.Properties.UserId.eq(useId)).list();

        return list;
    }



}
