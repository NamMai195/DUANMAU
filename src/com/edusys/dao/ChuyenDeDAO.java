/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.ChuyenDe;
import com.edusys.entity.NhanVien;
import com.edusys.utlis.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nam
 */
public class ChuyenDeDAO extends EduSysDAO<ChuyenDe, String>{
    final String INSERT_SQL="INSERT INTO ChuyenDe(MaCD,TenCD,hocPhi,thoiLuong,hinh,mota) VALUES(?,?,?,?,?,?)";
    final String UPDATE_SQL="UPDATE ChuyenDe SET TenCD=?,hocPhi=?,thoiLuong=?,hinh=?,moTa=? Where MaCD=?";
    final String DELETE_SQL="DELETE FROM ChuyenDe WHERE MaCD=?";
    final String SELECT_ALL_SQL="SELECT * FROM ChuyenDe";
    final String SELECT_BY_ID_SQL="SELECT * FROM ChuyenDe WHERE MaCD=?";
    @Override
    public void insert(ChuyenDe entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaCD(),entity.getTenCD(),entity.getHocPhi(),entity.getThoiLuong(),entity.getHinh(),entity.getMoTa());
    }

    @Override
    public void update(ChuyenDe entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getTenCD(),entity.getHocPhi(),entity.getThoiLuong(),entity.getHinh(),entity.getMoTa(),entity.getMaCD());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChuyenDe selectByid(String id) {
        List<ChuyenDe> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChuyenDe> selectBySql(String sql, Object... args) {
        List<ChuyenDe> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                ChuyenDe entity = new ChuyenDe();
                entity.setMaCD(rs.getString("MaCD"));
                entity.setTenCD(rs.getString("tenCD"));
                entity.setHocPhi(rs.getFloat("hocPhi"));
                entity.setThoiLuong(rs.getInt("thoiLuong"));
                entity.setHinh(rs.getString("hinh"));
                entity.setMoTa(rs.getString("moTa"));
                list.add(entity);
            }
             rs.getStatement().getConnection().close();
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
