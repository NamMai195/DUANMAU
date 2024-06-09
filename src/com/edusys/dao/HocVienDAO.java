package com.edusys.dao;


import com.edusys.entity.HocVien;
import com.edusys.entity.NguoiHoc;
import com.edusys.entity.NhanVien;
import com.edusys.utlis.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nam
 */
public class HocVienDAO extends EduSysDAO<HocVien, Integer>{
    final  String INSERT_SQL="INSERT INTO HocVien(maKH,maNH,diem) VALUES(?,?,?)";
    final String UPDATE_SQL="UPDATE HocVien SET maKH=?,maNH=?,diem=? Where maHV=?";
    final String DELETE_SQL="DELETE FROM HocVien WHERE maHV=?";
    final String SELECT_ALL_SQL="SELECT * FROM HocVien";
    final String SELECT_BY_ID_SQL="SELECT * FROM HocVien WHERE maHV=?";
    @Override
    public void insert(HocVien entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaKH(),entity.getMaNH(),entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getMaKH(),entity.getMaNH(),entity.getDiem(),entity.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<HocVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HocVien selectByid(Integer id) {
        List<HocVien> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);  
    }

    @Override
    public List<HocVien> selectBySql(String sql, Object... args) {
 List<HocVien> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                HocVien entity = new HocVien();
                entity.setMaHV(rs.getInt("maHV"));
                entity.setMaKH(rs.getInt("maKH"));
                entity.setMaNH(rs.getString("maNH"));
                entity.setDiem(rs.getFloat("diem"));
                list.add(entity);
            }
             rs.getStatement().getConnection().close();
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;    }
    public List<HocVien> selectByKhoaHoc (int maKH){
        String sql="SELECT * FROM HocVien WHERE MaKH=?";
        return this.selectBySql(sql,maKH);
    }
}
