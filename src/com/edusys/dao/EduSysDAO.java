/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import java.util.List;

/**
 *
 * @author Nam
 */
public abstract class EduSysDAO<Enti, Key> {
    public abstract void insert(Enti entity);
    public abstract void update(Enti entity);
    public abstract void delete(Key id);
    public abstract List<Enti> selectAll();
    public abstract Enti selectByid(Key id);
    public abstract List<Enti> selectBySql(String sql, Object... args);
}
