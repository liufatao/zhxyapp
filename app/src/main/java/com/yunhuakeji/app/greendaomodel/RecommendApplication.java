package com.yunhuakeji.app.greendaomodel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 推荐应用GreenDao 数据模型类
 */
@Entity
public class RecommendApplication {
    @org.greenrobot.greendao.annotation.Id
    private Long Id;//主键
    @Property
    private String function_face;//应用图片地址
    @Unique
    private int function_id;// 应用唯一标识创建唯一约束
    @Property
    private int unchange;
    @Property
    private String type_name;
    @Property
    private String function_name;
    @Property
    private int type_id;
    @Property
    private String apply_json;
    @Property
    private String userId;
    @Generated(hash = 1447705593)
    public RecommendApplication(Long Id, String function_face, int function_id,
            int unchange, String type_name, String function_name, int type_id,
            String apply_json, String userId) {
        this.Id = Id;
        this.function_face = function_face;
        this.function_id = function_id;
        this.unchange = unchange;
        this.type_name = type_name;
        this.function_name = function_name;
        this.type_id = type_id;
        this.apply_json = apply_json;
        this.userId = userId;
    }
    @Generated(hash = 452768640)
    public RecommendApplication() {
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public String getFunction_face() {
        return this.function_face;
    }
    public void setFunction_face(String function_face) {
        this.function_face = function_face;
    }
    public int getFunction_id() {
        return this.function_id;
    }
    public void setFunction_id(int function_id) {
        this.function_id = function_id;
    }
    public int getUnchange() {
        return this.unchange;
    }
    public void setUnchange(int unchange) {
        this.unchange = unchange;
    }
    public String getType_name() {
        return this.type_name;
    }
    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
    public String getFunction_name() {
        return this.function_name;
    }
    public void setFunction_name(String function_name) {
        this.function_name = function_name;
    }
    public int getType_id() {
        return this.type_id;
    }
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    public String getApply_json() {
        return this.apply_json;
    }
    public void setApply_json(String apply_json) {
        this.apply_json = apply_json;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
   

}
