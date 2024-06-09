/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.NhanVien;
import com.edusys.utlis.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Nam
 */
public class NhanVienDAO extends EduSysDAO<NhanVien, String>{
    final  String INSERT_SQL="INSERT INTO NhanVien(MaNV,MatKhau,HoTen,VaiTro) VALUES(?,?,?,?)";
    final String UPDATE_SQL="UPDATE NhanVien SET MatKhau=?,HoTen=?,VaiTro=? Where MaNV=?";
    final String DELETE_SQL="DELETE FROM NhanVien WHERE MaNV=?";
    final String SELECT_ALL_SQL="SELECT * FROM NhanVien";
    final String SELECT_BY_ID_SQL="SELECT * FROM NhanVien WHERE MaNV=?";
    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaNV(),entity.getMatKhau(),entity.getHoTen(),entity.isVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getMatKhau(),entity.getHoTen(),entity.isVaiTro(),entity.getMaNV());
    }

    @Override
    public void delete(String id) {
         JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<NhanVien> selectAll() {
         return this.selectBySql(SELECT_ALL_SQL);

    }

    @Override
    public NhanVien selectByid(String id) {
        List<NhanVien> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
       List<NhanVien> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                
                entity.setHoTen(rs.getString("HoTen"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
       
    }
    
}
