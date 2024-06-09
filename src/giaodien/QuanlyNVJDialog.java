/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package giaodien;

import com.edusys.dao.NhanVienDAO;
import com.edusys.entity.NhanVien;
import com.edusys.utlis.Auth;
import com.edusys.utlis.TBBOX;
import com.sun.source.tree.BreakTree;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nam
 */
public class QuanlyNVJDialog extends javax.swing.JDialog {
private int current;
private NhanVienDAO dao=new NhanVienDAO();
private List<NhanVien> Listnv= dao.selectAll();
    /**
     * Creates new form QuanlyNVJDialog
     */
    public QuanlyNVJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        init();
        xetuser();
    }
    boolean ktList(){
        if(Listnv.size()<1){
            return true;
        }
        else{
            return false;
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
    void fillTable(){
        DefaultTableModel model=(DefaultTableModel) tbnhanvien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list=dao.selectAll();
            for(NhanVien nv:list){
                Object[] row={nv.getMaNV(),nv.getHoTen(),nv.getMatKhau(),nv.isVaiTro()?"Trưởng phòng":"Nhân Viên"};
                model.addRow(row);
            }
            
        } catch (Exception e) {
            TBBOX.alert(this,"LỖI TRUY VẤN DỮ LIỆU");
        }
    }
    void display(int i){
        NhanVien nv=Listnv.get(i);
        txtmanv.setText(nv.getMaNV());
        txthoten.setText(nv.getHoTen());
        txtpassword.setText(nv.getMatKhau());
       if(nv.isVaiTro()){
           rdotruongphong.setSelected(true);
       }
       else {
           rdbnhanvien.setSelected(true);
       }
       txtcofpassword.setText(nv.getMatKhau());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnhanvien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcofpassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnxoa = new javax.swing.JButton();
        btnmoi = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnf = new javax.swing.JButton();
        btnff = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnnn = new javax.swing.JButton();
        btnn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        rdotruongphong = new javax.swing.JRadioButton();
        rdbnhanvien = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN QUẢN TRỊ");

        tbnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ Tên", "Mật khẩu", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbnhanvien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách", jPanel2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mật khẩu");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Xác nhận mật khẩu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Họ và tên");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Vai trò");

        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });
        jPanel5.add(btnthem);

        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });
        jPanel5.add(btnsua);
        jPanel5.add(jLabel13);

        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });
        jPanel5.add(btnxoa);

        btnmoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnmoi.setText("Mới");
        btnmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmoiActionPerformed(evt);
            }
        });
        jPanel5.add(btnmoi);

        jButton5.setText("Thêm");
        jPanel6.add(jButton5);

        jButton6.setText("Sửa");
        jPanel6.add(jButton6);
        jPanel6.add(jLabel14);

        jButton7.setText("Xóa");
        jPanel6.add(jButton7);

        jButton8.setText("Mới");
        jPanel6.add(jButton8);

        jPanel5.add(jPanel6);

        btnf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnf.setText("|<");
        btnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfActionPerformed(evt);
            }
        });
        jPanel7.add(btnf);

        btnff.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnff.setText("<<");
        btnff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnffActionPerformed(evt);
            }
        });
        jPanel7.add(btnff);
        jPanel7.add(jLabel15);

        btnnn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnnn.setText(">>");
        btnnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnnActionPerformed(evt);
            }
        });
        jPanel7.add(btnnn);

        btnn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnn.setText(">|");
        btnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnActionPerformed(evt);
            }
        });
        jPanel7.add(btnn);

        jButton13.setText("Thêm");
        jPanel8.add(jButton13);

        jButton14.setText("Sửa");
        jPanel8.add(jButton14);
        jPanel8.add(jLabel16);

        jButton15.setText("Xóa");
        jPanel8.add(jButton15);

        jButton16.setText("Mới");
        jPanel8.add(jButton16);

        jPanel7.add(jPanel8);

        buttonGroup2.add(rdotruongphong);
        rdotruongphong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdotruongphong.setText("Trưởng phòng");

        buttonGroup2.add(rdbnhanvien);
        rdbnhanvien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdbnhanvien.setText("Nhân Viên");
        rdbnhanvien.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdotruongphong)
                        .addGap(18, 18, 18)
                        .addComponent(rdbnhanvien))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtmanv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                        .addComponent(txtpassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtcofpassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txthoten, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtcofpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdotruongphong)
                            .addComponent(rdbnhanvien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cập nhật", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
boolean kttt(){
    if(txtmanv.getText().equals("") || txtmanv.getText()==null){
        TBBOX.alert(this,"Thông tin không được để trống");
        txtmanv.requestFocus();
        return false;
    }
    else if(txtpassword.getText().equals("") || txtpassword.getText()==null){
         TBBOX.alert(this,"Thông tin không được để trống");
         txtpassword.requestFocus();
     return false;
    }
    else if(txtcofpassword.getText().equals("") || txtcofpassword.getText()==null){
         TBBOX.alert(this,"Thông tin không được để trống");
         txtcofpassword.requestFocus();
        return false;
    }
    else if(!txtpassword.getText().equals(txtcofpassword.getText())){
           TBBOX.alert(this,"Mật khẩu phải trùng nhau");
         return false;
    }
    else if(txthoten.getText().equals("") || txthoten.getText()==null){
         TBBOX.alert(this,"Thông tin không được để trống");
         txthoten.requestFocus();
        return false;
    }
    else{
        return true;
    }
}
    void them(){
    NhanVien nv=new NhanVien();
    nv.setHoTen(txthoten.getText());
    nv.setMaNV(txtmanv.getText());
    nv.setMatKhau(txtpassword.getText());
    nv.setVaiTro(rdotruongphong.isSelected());
        try {
            NhanVien a= dao.selectByid(txtmanv.getText());
            if(a!=null){
                TBBOX.alert(this,"Nhân Viên Đã tồn tại trong hệ thống vui lòng chọn cập nhật hoặc nhập nv khác");
            }
            else{
                dao.insert(nv);
                TBBOX.alert(this,"Thêm Thành Công");
            }
        } catch (Exception e) {
            TBBOX.alert(this,"ĐÃ Xãy ra lỗi");
        }
    
}
    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
     if(kttt()){
         them();
         fillTable();
         clear();
         Listnv=dao.selectAll();
     }
    }//GEN-LAST:event_btnthemActionPerformed
void sua(){
     NhanVien nv=new NhanVien();
    nv.setHoTen(txthoten.getText());
    nv.setMaNV(txtmanv.getText());
    nv.setMatKhau(txtpassword.getText());
    nv.setVaiTro(rdotruongphong.isSelected());
        try {
            NhanVien a= dao.selectByid(txtmanv.getText());
            if(a!=null){
                dao.update(nv);
                TBBOX.alert(this,"Cập nhật thành công");
                 fillTable();
                 clear();
            }
            else{
                TBBOX.alert(this,"Nhân Viên Không tồn tại trong hệ thống");
            }
        } catch (Exception e) {
            TBBOX.alert(this,"ĐÃ Xãy ra lỗi");
        }
}
    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        if(kttt()){
            sua();

             Listnv=dao.selectAll();
        }
    }//GEN-LAST:event_btnsuaActionPerformed
void xoa(){
    try {
        NhanVien a= dao.selectByid(txtmanv.getText());
        if(a!=null){
                dao.delete(txtmanv.getText());
                TBBOX.alert(this,"Xóa Thành công");
                fillTable();
                clear();
            }
            else{
                TBBOX.alert(this,"Nhân Viên Không tồn tại trong hệ thống");
            }
    } catch (Exception e) {
        TBBOX.alert(this,"ĐÃ Xãy ra lỗi");
    }
}
    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        if(kttt()){
            xoa();
             Listnv=dao.selectAll();
        }
    }//GEN-LAST:event_btnxoaActionPerformed
void clear(){
    txtmanv.setText("");
    txthoten.setText("");
    txtcofpassword.setText("");
    txtpassword.setText("");
    buttonGroup2.clearSelection();
    
    
}
    private void btnmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmoiActionPerformed
       clear();
        Listnv=dao.selectAll();
        fillTable();
    }//GEN-LAST:event_btnmoiActionPerformed

    private void tbnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnhanvienMouseClicked
        display(tbnhanvien.getSelectedRow());
    }//GEN-LAST:event_tbnhanvienMouseClicked

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
        if(current==Listnv.size()-1){
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
        current=Listnv.size()-1;
        display(current);
    }//GEN-LAST:event_btnnActionPerformed

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
            java.util.logging.Logger.getLogger(QuanlyNVJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanlyNVJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanlyNVJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanlyNVJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanlyNVJDialog dialog = new QuanlyNVJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnf;
    private javax.swing.JButton btnff;
    private javax.swing.JButton btnmoi;
    private javax.swing.JButton btnn;
    private javax.swing.JButton btnnn;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdbnhanvien;
    private javax.swing.JRadioButton rdotruongphong;
    private javax.swing.JTable tbnhanvien;
    private javax.swing.JTextField txtcofpassword;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtpassword;
    // End of variables declaration//GEN-END:variables

    private void init() {
    fillTable();    }
}
