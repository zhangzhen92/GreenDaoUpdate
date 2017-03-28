package com.example.lzc.greendaodemo.dao;

/**
 * 类描述：greendao 实体类
 * 创建人：zz
 * 创建时间： 2017/2/15 14:42
 */

public class User {
    private Long id;
    private String name;
    private String passWord;
    private String Sex;                          //TODO 新增字段重新创建SQL语句创建表,删除注解，不然无法修改版本号
    public String getSex() {
        return this.Sex;
    }
    public void setSex(String Sex) {
        this.Sex = Sex;
    }
    public String getPassWord() {
        return this.passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User(Long id, String name, String passWord, String Sex) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.Sex = Sex;
    }
    public User() {
    }

}
