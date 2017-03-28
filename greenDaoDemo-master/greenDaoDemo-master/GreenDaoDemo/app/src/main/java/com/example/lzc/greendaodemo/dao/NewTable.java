package com.example.lzc.greendaodemo.dao;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2017/3/28 15:24
 */

public class NewTable {
    private Long id;
    private String name;
    private String age;
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
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
    public NewTable(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public NewTable() {
    }

}
