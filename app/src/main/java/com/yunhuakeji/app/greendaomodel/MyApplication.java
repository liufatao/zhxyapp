package com.yunhuakeji.app.greendaomodel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 我的应用GreenDao 数据模型类
 */
@Entity
public class MyApplication {
    @org.greenrobot.greendao.annotation.Id
    private Long Id;//主键
    @Unique
    private int function_id;// 应用唯一标识创建唯一约束
    @Property
    private String function_name;//应用名称
    @Property
    private String function_face;//应用图片地址
    @Property
    private String type_name;// 组名
    @Property
    private int type_id;// 组标识
    @Property
    private String userId;// 用户Id
    @Property
    private int unchange;//判断应用是否可删除
    @Generated(hash = 2054696590)
    public MyApplication(Long Id, int function_id, String function_name,
            String function_face, String type_name, int type_id, String userId,
            int unchange) {
        this.Id = Id;
        this.function_id = function_id;
        this.function_name = function_name;
        this.function_face = function_face;
        this.type_name = type_name;
        this.type_id = type_id;
        this.userId = userId;
        this.unchange = unchange;
    }
    @Generated(hash = 1126741959)
    public MyApplication() {
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public int getFunction_id() {
        return this.function_id;
    }
    public void setFunction_id(int function_id) {
        this.function_id = function_id;
    }
    public String getFunction_name() {
        return this.function_name;
    }
    public void setFunction_name(String function_name) {
        this.function_name = function_name;
    }
    public String getFunction_face() {
        return this.function_face;
    }
    public void setFunction_face(String function_face) {
        this.function_face = function_face;
    }
    public String getType_name() {
        return this.type_name;
    }
    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
    public int getType_id() {
        return this.type_id;
    }
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public int getUnchange() {
        return this.unchange;
    }
    public void setUnchange(int unchange) {
        this.unchange = unchange;
    }

    @Override
    public String toString() {
        return getFunction_id()+getFunction_name();
    }
}
