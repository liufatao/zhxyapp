package com.yunhuakeji.app.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.yunhuakeji.app.greendaomodel.MyApplication;
import com.yunhuakeji.app.greendaomodel.RecommendApplication;

import com.yunhuakeji.app.greendao.MyApplicationDao;
import com.yunhuakeji.app.greendao.RecommendApplicationDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig myApplicationDaoConfig;
    private final DaoConfig recommendApplicationDaoConfig;

    private final MyApplicationDao myApplicationDao;
    private final RecommendApplicationDao recommendApplicationDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        myApplicationDaoConfig = daoConfigMap.get(MyApplicationDao.class).clone();
        myApplicationDaoConfig.initIdentityScope(type);

        recommendApplicationDaoConfig = daoConfigMap.get(RecommendApplicationDao.class).clone();
        recommendApplicationDaoConfig.initIdentityScope(type);

        myApplicationDao = new MyApplicationDao(myApplicationDaoConfig, this);
        recommendApplicationDao = new RecommendApplicationDao(recommendApplicationDaoConfig, this);

        registerDao(MyApplication.class, myApplicationDao);
        registerDao(RecommendApplication.class, recommendApplicationDao);
    }
    
    public void clear() {
        myApplicationDaoConfig.clearIdentityScope();
        recommendApplicationDaoConfig.clearIdentityScope();
    }

    public MyApplicationDao getMyApplicationDao() {
        return myApplicationDao;
    }

    public RecommendApplicationDao getRecommendApplicationDao() {
        return recommendApplicationDao;
    }

}