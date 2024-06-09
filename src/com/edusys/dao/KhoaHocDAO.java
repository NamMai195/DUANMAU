/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.ChuyenDe;
import com.edusys.entity.KhoaHoc;
import com.edusys.entity.NhanVien;
import com.edusys.utlis.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nam
 */
public class KhoaHocDAO extends EduSysDAO<KhoaHoc, Integer>{
 final  String INSERT_SQL="INSERT INTO KhoaHoc(maCD,hocPhi,ThoiLuong,ngayKG,ghiChu,maNV,ngayTao) VALUES(?,?,?,?,?,?,?)";
    final String UPDATE_SQL="UPDATE KhoaHoc SET maCD=?,hocPhi=?,thoiLuong=?,ngayKG=?,ghiChu=?,maNV=?,ngayTao=? Where MaKH=?";
    final String DELETE_SQL="DELETE FROM KhoaHoc WHERE maKH=?";
    final String SELECT_ALL_SQL="SELECT * FROM KhoaHoc";
    final String SELECT_BY_ID_SQL="SELECT * FROM KhoaHoc WHERE maKH=?";
    final String SELECT_BY_MA_CD_SQL="SELECT * FROM KhoaHoc WHERE maCD=?";
    @Override
    public void insert(KhoaHoc entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaCD(),entity.getHocPhi(),entity.getThoiLuong(),entity.getNgayKG(),entity.getGhiChu(),entity.getMaNV(),entity.getNgayTao());
    }

    @Override
    public void update(KhoaHoc entity) {
              JdbcHelper.update(UPDATE_SQL,entity.getMaCD(),entity.getHocPhi(),entity.getThoiLuong(),entity.getNgayKG(),entity.getGhiChu(),entity.getMaNV(),entity.getNgayTao(),entity.getMaKH());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhoaHoc selectByid(Integer id) {
    List<KhoaHoc> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhoaHoc> selectBySql(String sql, Object... args) {
          List<KhoaHoc> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                KhoaHoc entity = new KhoaHoc();
                entity.setMaKH(rs.getInt("maKH"));
                entity.setMaCD(rs.getString("maCD"));
                entity.setHocPhi(rs.getFloat("hocPhi"));
                entity.setThoiLuong(rs.getInt("thoiLuong"));
                entity.setNgayKG(rs.getDate("ngayKG"));
                entity.setGhiChu(rs.getString("ghiChu"));
                entity.setNgayTao(rs.getDate("ngayTao"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
            }
             rs.getStatement().getConnection().close();
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
      public List<KhoaHoc> selectKhoaHocByChuyenDe(String macd) {
        return selectBySql(SELECT_BY_MA_CD_SQL, macd);
    }
    public List<Integer> selectYears(){
        String sql="SELECT DISTINCT Year(NgayKG) as year FROM KHOAHOC ORDER BY year DESC";
        List<Integer> list=new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
