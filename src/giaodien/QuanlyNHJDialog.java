/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package giaodien;

import com.edusys.dao.NguoiHocDAO;
import com.edusys.entity.NguoiHoc;
import com.edusys.entity.NhanVien;
import com.edusys.utlis.Auth;
import com.edusys.utlis.TBBOX;
import com.edusys.utlis.XDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nam
 */
public class QuanlyNHJDialog extends javax.swing.JDialog {
private int current;
private NguoiHocDAO dao=new NguoiHocDAO();
private List<NguoiHoc> Listnh= dao.selectAll();

    public QuanlyNHJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.init();
        xetuser();
    }
 void fillTable(){
        DefaultTableModel model=(DefaultTableModel) tblnguoihoc.getModel();
        model.setRowCount(0);
        try {
            List<NguoiHoc> list=dao.selectAll();
            for(NguoiHoc nh:list){
                Object[] row={nh.getMaNH(),nh.getHoTen(),nh.isGioiTinh()?"Nam":"Nữ",nh.getNgaySinh(),nh.getDienThoai(),nh.getEmail(),nh.getGhiChu(),nh.getMaNV(),nh.getNgayDK()};
                model.addRow(row);
            }
            
        } catch (Exception e) {
            TBBOX.alert(this,"LỖI TRUY VẤN DỮ LIỆU");
        }
    }
//---kiem tra
 boolean kttt(){
     if(txtmanh.getText().equals("") || txtmanh.getText()==null){
         TBBOX.alert(this,"Thông tin không được để trống");
         return false;
     }
     else if(txthoten.getText().equals("") || txthoten.getText()==null){
         TBBOX.alert(this,"Thông tin không được để trống");
         return false;
     }
//     else if(txtngaysinh.getText().equals("") || txtngaysinh.getText()==null){
//         TBBOX.alert(this,"Thông tin không được để trống");
//         return false;
//     }
     else if(txtemail.getText().equals("") || txtemail.getText()==null){
         TBBOX.alert(this,"Thông tin không được trống");
         return  false;
     }
     else if(txtdienthoai.getText().equals("") || txtdienthoai.getText()==null){
         TBBOX.alert(this,"Thông tin không được để trống");
         return false;
     }
     
     else{
         return true;
     }
     
 }
  void xetuser(){
     if(Auth.isManager()){
         
     }
     else
     {
     btnsua.setEnabled(false);
     btnxoa.setEnabled(false);
     btnf.setEnabled(false);
     btnff.setEnabled(false);
     btnn.setEnabled(false);
     btnnn.setEnabled(false);
 }
 }
// --- dislay
  void display(int i){
        NguoiHoc nv=Listnh.get(i);
        txtmanh.setText(nv.getMaNH());
        txthoten.setText(nv.getHoTen());
        txtngaysinh.setText(nv.getNgaySinh().toString());
        txtemail.setText(nv.getEmail());
        txtdienthoai.setText(nv.getDienThoai());
        txtghichu.setText(nv.getGhiChu());
       if(nv.isGioiTinh()){
           rdbmale.setSelected(true);
       }
       else {
           rdbfemale.setSelected(true);
       }
    }
//  --- kt list
   boolean ktList(){
        if(Listnh.size()<1){
            return true;
        }
        else{
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmanh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtghichu = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        rdbmale = new javax.swing.JRadioButton();
        rdbfemale = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        btnadd = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnnew = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnf = new javax.swing.JButton();
        btnff = new javax.swing.JButton();
        btnnn = new javax.swing.JButton();
        btnn = new javax.swing.JButton();
        txthoten = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtngaysinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdienthoai = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnguoihoc = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EduSys - Quản Lý");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã Người Học");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Họ Và Tên");

        txtghichu.setColumns(20);
        txtghichu.setRows(5);
        jScrollPane2.setViewportView(txtghichu);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Giới tính");

        buttonGroup1.add(rdbmale);
        rdbmale.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdbmale.setText("Male");

        buttonGroup1.add(rdbfemale);
        rdbfemale.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdbfemale.setText("Female");

        btnadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnadd.setText("Thêm");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel4.add(btnadd);

        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });
        jPanel4.add(btnsua);

        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });
        jPanel4.add(btnxoa);

        btnnew.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnnew.setText("Mới");
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });
        jPanel4.add(btnnew);

        btnf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnf.setText("|<");
        btnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfActionPerformed(evt);
            }
        });
        jPanel5.add(btnf);

        btnff.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnff.setText("<<");
        btnff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnffActionPerformed(evt);
            }
        });
        jPanel5.add(btnff);

        btnnn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnnn.setText(">>");
        btnnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnnActionPerformed(evt);
            }
        });
        jPanel5.add(btnnn);

        btnn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnn.setText(">|");
        btnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnActionPerformed(evt);
            }
        });
        jPanel5.add(btnn);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Ngày Sinh");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Địa Chỉ email");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Ghi Chú");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Điện thoại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdbmale)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbfemale))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(txtdienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(102, 102, 102)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(txtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(txtngaysinh)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtmanh, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                    .addComponent(txthoten)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbmale)
                    .addComponent(rdbfemale)
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("CẬP NHẬT", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });

        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/Icon Application/Search.png"))); // NOI18N
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txttimkiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btntimkiem)
        );

        tblnguoihoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Người Học", "Họ Tên", "Giới tính", "Ngày sinh", "Điện thoại", "email", "ghi chú", "mã nhân viên ", "ngày đk"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblnguoihoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnguoihocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblnguoihoc);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("DANH SÁCH", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void clear(){
        txtmanh.setText(null);
        txthoten.setText(null);
        txtngaysinh.setText(null);
        txtemail.setText(null);
        txtdienthoai.setText(null);
        buttonGroup1.clearSelection();
        txtghichu.setText(null);
    }
    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
       this.clear();
    }//GEN-LAST:event_btnnewActionPerformed
void add(){
    NguoiHoc nh=new NguoiHoc();
    nh.setMaNH(txtmanh.getText());
    nh.setHoTen(txthoten.getText());
    nh.setDienThoai(txtdienthoai.getText());
    nh.setGhiChu(txtghichu.getText());
    nh.setGioiTinh(rdbmale.isSelected());
    nh.setEmail(txtemail.getText());
    nh.setNgaySinh(XDate.toDate(txtngaysinh.getText(),"yyyy-MM-dd"));
    nh.setMaNV(Auth.user.getMaNV());
    nh.setNgayDK(XDate.now());
     try {
            NguoiHoc a= dao.selectByid(txtmanh.getText());
            if(a!=null){
                TBBOX.alert(this,"Người Học Đã tồn tại trong hệ thống vui lòng chọn cập nhật hoặc nhập NH khác");
            }
            else{
                dao.insert(nh);
                TBBOX.alert(this,"Thêm Thành Công");
                this.clear();
            }
        } catch (Exception e) {
            TBBOX.alert(this,"ĐÃ Xãy ra lỗi");
            System.out.println(e);
        }
    
}
    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
       if(kttt()){
           this.add();
           this.fillTable();
       }
    }//GEN-LAST:event_btnaddActionPerformed
void sua(){
    NguoiHoc nh=new NguoiHoc();
    nh.setMaNH(txtmanh.getText());
    nh.setHoTen(txthoten.getText());
    nh.setDienThoai(txtdienthoai.getText());
    nh.setGhiChu(txtghichu.getText());
    nh.setGioiTinh(rdbmale.isSelected());
    nh.setEmail(txtemail.getText());
    nh.setNgaySinh(XDate.toDate(txtngaysinh.getText(),"yyyy-MM-dd"));
    nh.setMaNV(Auth.user.getMaNV());
    nh.setNgayDK(XDate.now());
     try {
            NguoiHoc a= dao.selectByid(txtmanh.getText());
            if(a!=null){
                 dao.update(nh);
                TBBOX.alert(this,"Update Thành Công");
                this.clear();        
            }
            else{
                TBBOX.alert(this,"Người Học Không tồn tại trong hệ thống");
            }
        } catch (Exception e) {
            TBBOX.alert(this,"ĐÃ Xãy ra lỗi");
            System.out.println(e);
        }
}
    
    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
      if(kttt()){
          this.sua();
          fillTable();
      }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void tblnguoihocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnguoihocMouseClicked
       Listnh=dao.selectAll();
        display(tblnguoihoc.getSelectedRow());
    }//GEN-LAST:event_tblnguoihocMouseClicked
void xoa(){
    try {
        NguoiHoc a=dao.selectByid(txtmanh.getText());
        if(a==null){
            TBBOX.alert(this,"Người học không tồn tại trong hệ thống");
        }
        else {
            dao.delete(txtmanh.getText());
             TBBOX.alert(this,"Xóa Thành Công");
                this.clear();    
        }
    } catch (Exception e) {
    }
}
    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
      if(kttt()){
         this.xoa();
         fillTable();
      }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfActionPerformed
    if(ktList()){
          TBBOX.alert(this,"Chưa có nhân viên nào");
           return;
      }
      else{
             current=0;
        display(current);
      }
    }//GEN-LAST:event_btnfActionPerformed

    private void btnffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnffActionPerformed
        if(ktList()){
          TBBOX.alert(this,"Chưa có nhân viên nào");
           return;
      }
        if(current==0){
            JOptionPane.showMessageDialog(this,"Đang ở đầu danh sách!");
            return;
        }
        current--;
        display(current);
    }//GEN-LAST:event_btnffActionPerformed

    private void btnnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnnActionPerformed
        if(ktList()){
          TBBOX.alert(this,"Chưa có nhân viên nào");
           return;
      }
        if(current==Listnh.size()-1){
          JOptionPane.showMessageDialog(this,"Đang cuối danh sách!");
          return;
      }
      current++;
        display(current);
    }//GEN-LAST:event_btnnnActionPerformed

    private void btnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnActionPerformed
        if(ktList()){
          TBBOX.alert(this,"Chưa có nhân viên nào");
           return;
      }
        current=Listnh.size()-1;
        display(current);
    }//GEN-LAST:event_btnnActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
       NguoiHoc nv=dao.selectByid(txttimkiem.getText());
       if(nv!=null){
           txtmanh.setText(nv.getMaNH());
        txthoten.setText(nv.getHoTen());
        txtngaysinh.setText(nv.getNgaySinh().toString());
        txtemail.setText(nv.getEmail());
        txtdienthoai.setText(nv.getDienThoai());
        txtghichu.setText(nv.getGhiChu());
       if(nv.isGioiTinh()){
           rdbmale.setSelected(true);
       }
       else {
           rdbfemale.setSelected(true);
       }
           TBBOX.alert(this,"Tìm thành công");
         
       }
       else{
          TBBOX.alert(this,"NGƯỜI HỌC KHÔNG TỒN TẠI");
       }
    }//GEN-LAST:event_btntimkiemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanlyNHJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanlyNHJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanlyNHJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanlyNHJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanlyNHJDialog dialog = new QuanlyNHJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnf;
    private javax.swing.JButton btnff;
    private javax.swing.JButton btnn;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnnn;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdbfemale;
    private javax.swing.JRadioButton rdbmale;
    private javax.swing.JTable tblnguoihoc;
    private javax.swing.JTextField txtdienthoai;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextArea txtghichu;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmanh;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setLocationRelativeTo(null);
        fillTable();
    }
}
