package com.yunhuakeji.app.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.yunhuakeji.app.greendaomodel.MyApplication;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MY_APPLICATION".
*/
public class MyApplicationDao extends AbstractDao<MyApplication, Long> {

    public static final String TABLENAME = "MY_APPLICATION";

    /**
     * Properties of entity MyApplication.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "Id", true, "_id");
        public final static Property Function_id = new Property(1, int.class, "function_id", false, "FUNCTION_ID");
        public final static Property Function_name = new Property(2, String.class, "function_name", false, "FUNCTION_NAME");
        public final static Property Function_face = new Property(3, String.class, "function_face", false, "FUNCTION_FACE");
        public final static Property Type_name = new Property(4, String.class, "type_name", false, "TYPE_NAME");
        public final static Property Type_id = new Property(5, int.class, "type_id", false, "TYPE_ID");
        public final static Property UserId = new Property(6, String.class, "userId", false, "USER_ID");
        public final static Property Unchange = new Property(7, int.class, "unchange", false, "UNCHANGE");
    }


    public MyApplicationDao(DaoConfig config) {
        super(config);
    }
    
    public MyApplicationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MY_APPLICATION\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: Id
                "\"FUNCTION_ID\" INTEGER NOT NULL UNIQUE ," + // 1: function_id
                "\"FUNCTION_NAME\" TEXT," + // 2: function_name
                "\"FUNCTION_FACE\" TEXT," + // 3: function_face
                "\"TYPE_NAME\" TEXT," + // 4: type_name
                "\"TYPE_ID\" INTEGER NOT NULL ," + // 5: type_id
                "\"USER_ID\" TEXT," + // 6: userId
                "\"UNCHANGE\" INTEGER NOT NULL );"); // 7: unchange
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MY_APPLICATION\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MyApplication entity) {
        stmt.clearBindings();
 
        Long Id = entity.getId();
        if (Id != null) {
            stmt.bindLong(1, Id);
        }
        stmt.bindLong(2, entity.getFunction_id());
 
        String function_name = entity.getFunction_name();
        if (function_name != null) {
            stmt.bindString(3, function_name);
        }
 
        String function_face = entity.getFunction_face();
        if (function_face != null) {
            stmt.bindString(4, function_face);
        }
 
        String type_name = entity.getType_name();
        if (type_name != null) {
            stmt.bindString(5, type_name);
        }
        stmt.bindLong(6, entity.getType_id());
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(7, userId);
        }
        stmt.bindLong(8, entity.getUnchange());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MyApplication entity) {
        stmt.clearBindings();
 
        Long Id = entity.getId();
        if (Id != null) {
            stmt.bindLong(1, Id);
        }
        stmt.bindLong(2, entity.getFunction_id());
 
        String function_name = entity.getFunction_name();
        if (function_name != null) {
            stmt.bindString(3, function_name);
        }
 
        String function_face = entity.getFunction_face();
        if (function_face != null) {
            stmt.bindString(4, function_face);
        }
 
        String type_name = entity.getType_name();
        if (type_name != null) {
            stmt.bindString(5, type_name);
        }
        stmt.bindLong(6, entity.getType_id());
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(7, userId);
        }
        stmt.bindLong(8, entity.getUnchange());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public MyApplication readEntity(Cursor cursor, int offset) {
        MyApplication entity = new MyApplication( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // Id
            cursor.getInt(offset + 1), // function_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // function_name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // function_face
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // type_name
            cursor.getInt(offset + 5), // type_id
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // userId
            cursor.getInt(offset + 7) // unchange
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MyApplication entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFunction_id(cursor.getInt(offset + 1));
        entity.setFunction_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFunction_face(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setType_name(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setType_id(cursor.getInt(offset + 5));
        entity.setUserId(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setUnchange(cursor.getInt(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MyApplication entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MyApplication entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MyApplication entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}