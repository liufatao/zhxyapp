package com.yunhuakeji.app.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.yunhuakeji.app.greendaomodel.RecommendApplication;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "RECOMMEND_APPLICATION".
*/
public class RecommendApplicationDao extends AbstractDao<RecommendApplication, Long> {

    public static final String TABLENAME = "RECOMMEND_APPLICATION";

    /**
     * Properties of entity RecommendApplication.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "Id", true, "_id");
        public final static Property Function_face = new Property(1, String.class, "function_face", false, "FUNCTION_FACE");
        public final static Property Function_id = new Property(2, int.class, "function_id", false, "FUNCTION_ID");
        public final static Property Unchange = new Property(3, int.class, "unchange", false, "UNCHANGE");
        public final static Property Type_name = new Property(4, String.class, "type_name", false, "TYPE_NAME");
        public final static Property Function_name = new Property(5, String.class, "function_name", false, "FUNCTION_NAME");
        public final static Property Type_id = new Property(6, int.class, "type_id", false, "TYPE_ID");
        public final static Property Apply_json = new Property(7, String.class, "apply_json", false, "APPLY_JSON");
        public final static Property UserId = new Property(8, String.class, "userId", false, "USER_ID");
    }


    public RecommendApplicationDao(DaoConfig config) {
        super(config);
    }
    
    public RecommendApplicationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"RECOMMEND_APPLICATION\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: Id
                "\"FUNCTION_FACE\" TEXT," + // 1: function_face
                "\"FUNCTION_ID\" INTEGER NOT NULL UNIQUE ," + // 2: function_id
                "\"UNCHANGE\" INTEGER NOT NULL ," + // 3: unchange
                "\"TYPE_NAME\" TEXT," + // 4: type_name
                "\"FUNCTION_NAME\" TEXT," + // 5: function_name
                "\"TYPE_ID\" INTEGER NOT NULL ," + // 6: type_id
                "\"APPLY_JSON\" TEXT," + // 7: apply_json
                "\"USER_ID\" TEXT);"); // 8: userId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RECOMMEND_APPLICATION\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RecommendApplication entity) {
        stmt.clearBindings();
 
        Long Id = entity.getId();
        if (Id != null) {
            stmt.bindLong(1, Id);
        }
 
        String function_face = entity.getFunction_face();
        if (function_face != null) {
            stmt.bindString(2, function_face);
        }
        stmt.bindLong(3, entity.getFunction_id());
        stmt.bindLong(4, entity.getUnchange());
 
        String type_name = entity.getType_name();
        if (type_name != null) {
            stmt.bindString(5, type_name);
        }
 
        String function_name = entity.getFunction_name();
        if (function_name != null) {
            stmt.bindString(6, function_name);
        }
        stmt.bindLong(7, entity.getType_id());
 
        String apply_json = entity.getApply_json();
        if (apply_json != null) {
            stmt.bindString(8, apply_json);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(9, userId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RecommendApplication entity) {
        stmt.clearBindings();
 
        Long Id = entity.getId();
        if (Id != null) {
            stmt.bindLong(1, Id);
        }
 
        String function_face = entity.getFunction_face();
        if (function_face != null) {
            stmt.bindString(2, function_face);
        }
        stmt.bindLong(3, entity.getFunction_id());
        stmt.bindLong(4, entity.getUnchange());
 
        String type_name = entity.getType_name();
        if (type_name != null) {
            stmt.bindString(5, type_name);
        }
 
        String function_name = entity.getFunction_name();
        if (function_name != null) {
            stmt.bindString(6, function_name);
        }
        stmt.bindLong(7, entity.getType_id());
 
        String apply_json = entity.getApply_json();
        if (apply_json != null) {
            stmt.bindString(8, apply_json);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(9, userId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public RecommendApplication readEntity(Cursor cursor, int offset) {
        RecommendApplication entity = new RecommendApplication( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // Id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // function_face
            cursor.getInt(offset + 2), // function_id
            cursor.getInt(offset + 3), // unchange
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // type_name
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // function_name
            cursor.getInt(offset + 6), // type_id
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // apply_json
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // userId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RecommendApplication entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFunction_face(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFunction_id(cursor.getInt(offset + 2));
        entity.setUnchange(cursor.getInt(offset + 3));
        entity.setType_name(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setFunction_name(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setType_id(cursor.getInt(offset + 6));
        entity.setApply_json(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setUserId(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(RecommendApplication entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(RecommendApplication entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(RecommendApplication entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}