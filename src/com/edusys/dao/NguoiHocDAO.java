/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.KhoaHoc;
import com.edusys.entity.NguoiHoc;
import com.edusys.entity.NhanVien;
import com.edusys.utlis.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nam
 */
public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String>{
    final  String INSERT_SQL="INSERT INTO NguoiHoc(maNH,hoTen,ngaySinh,GioiTinh,dienThoai,email,ghiChu,maNV,ngayDK) VALUES(?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL="UPDATE NguoiHoc SET hoTen=?,ngaySinh=?,GioiTinh=?,dienThoai=?,email=?,ghiChu=?,maNV=?,ngayDK=? Where maNH=?";
    final String DELETE_SQL="DELETE FROM NguoiHoc WHERE maNH=?";
    final String SELECT_ALL_SQL="SELECT * FROM NguoiHoc";
    final String SELECT_BY_ID_SQL="SELECT * FROM NguoiHoc WHERE maNH=?";
    @Override
    public void insert(NguoiHoc entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaNH(),entity.getHoTen(),entity.getNgaySinh()
       ,entity.isGioiTinh(),entity.getDienThoai(),entity.getEmail(),entity.getGhiChu(),entity.getMaNV(),entity.getNgayDK());
    }

    @Override
    public void update(NguoiHoc entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getHoTen(),entity.getNgaySinh()
       ,entity.isGioiTinh(),entity.getDienThoai(),entity.getEmail(),entity.getGhiChu(),entity.getMaNV(),entity.getNgayDK(),entity.getMaNH());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NguoiHoc selectByid(String id) {
    List<NguoiHoc> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);    }

    @Override
    public List<NguoiHoc> selectBySql(String sql, Object... args) {
       List<NguoiHoc> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                NguoiHoc entity = new NguoiHoc();
                entity.setMaNH(rs.getString("maNH"));
                entity.setHoTen(rs.getString("hoTen"));
                entity.setNgaySinh(rs.getDate("ngaySinh"));
                entity.setGioiTinh(rs.getBoolean("gioitinh"));
                entity.setDienThoai(rs.getString("dienThoai"));
                entity.setEmail(rs.getString("email"));
                entity.setGhiChu(rs.getString("ghiChu"));
                entity.setMaNV(rs.getString("maNV"));
                entity.setNgayDK(rs.getDate("ngayDK"));
                list.add(entity);
            }
             rs.getStatement().getConnection().close();
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public  List<NguoiHoc> selectNotInCourse(int makh,String keword){
        String sql="SELECT * FROM NguoiHoc"
                + " WHERE HoTen LIKE ? AND"
                + " MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?)";
        return this.selectBySql(sql,"%"+keword+"%",makh);
    }
    
}
