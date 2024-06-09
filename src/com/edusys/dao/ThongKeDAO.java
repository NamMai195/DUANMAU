/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.utlis.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Nam
 */
public class ThongKeDAO {
    private List<Object[]> getListOfArray(String sql,String[] cols,Object...args){
        try {
            List<Object[]> list=new ArrayList<>();
            ResultSet rs=JdbcHelper.query(sql, args);
            while(rs.next()){
                Object[] vals=new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i]=rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Object[]> getBangDem (Integer maKH){
        String sql="{CALL sp_BangDiem(?)}";
        String[] cols={"MaNH","HoTen","Diem"};
        return getListOfArray(sql, cols,maKH);
    }
      public List<Object[]> getLuongNguoiHoc (){
        String sql="{CALL SP_THONGKENGUOIHOC}";
        String[] cols={"Nam","SoLuong","Dautien","CuoiCung"};
        return getListOfArray(sql, cols);
    }
       public List<Object[]> getDiemChuyenDe (){
        String sql="{CALL SP_THONGKEDIEM}";
        String[] cols={"CHUYENDE","SOHV","THAPNHAT","CAONHAT","TRUNGBINH"};
        return getListOfArray(sql, cols);
    }
        public List<Object[]> getDoanhThu (Integer year){
        String sql="{CALL SP_THONGKEDOANHTHU(?)}";
        String[] cols={"CHUYENDE","SoKH","SoHV","DoanhThu","ThapNhat","CaoNhat","TrungBinh"};
        return getListOfArray(sql, cols,year);
    }
}
