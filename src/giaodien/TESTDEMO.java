package giaodien;



import com.edusys.dao.ChuyenDeDAO;
import com.edusys.dao.NhanVienDAO;
import com.edusys.dao.ThongKeDAO;
import com.edusys.entity.ChuyenDe;
import com.edusys.entity.NhanVien;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nam
 */
public class TESTDEMO {
    public static void main(String[] args) {
//        NhanVienDAO dao=new NhanVienDAO();
//////        dao.insert(new NhanVien("namnv2","testttt","1234",true));
////    dao.delete("namnv2");
//        List<NhanVien> list= dao.selectAll();
//        for(NhanVien nv:list){
//            System.out.println("=>"+nv.toString());
//        }
//        ThongKeDAO tkDao=new ThongKeDAO();
//        List<Object[]> list =tkDao.getBangDem(Integer.SIZE);
        ChuyenDeDAO cd=new ChuyenDeDAO();
        List<ChuyenDe> list= cd.selectAll();
        for(ChuyenDe nv:list){
            System.out.println("=>"+nv.toString());
        }
    }
}
