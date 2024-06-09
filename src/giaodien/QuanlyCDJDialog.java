/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package giaodien;

import com.edusys.dao.ChuyenDeDAO;

import com.edusys.entity.ChuyenDe;
import com.edusys.entity.NhanVien;
import com.edusys.utlis.Auth;
import com.edusys.utlis.TBBOX;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nam
 */
public class QuanlyCDJDialog extends javax.swing.JDialog {
private int current;
private ChuyenDeDAO dao=new ChuyenDeDAO();
private List<ChuyenDe> List= dao.selectAll();
String diachianh=null;
//kt list
 boolean ktList(){
        if(List.size()<1){
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
//fill table
 void fillTable(){
        DefaultTableModel model=(DefaultTableModel) tblchuyende.getModel();
        model.setRowCount(0);
        try {
            List<ChuyenDe> list=dao.selectAll();
            for(ChuyenDe cd:list){
                Object[] row={cd.getMaCD(),cd.getTenCD(),cd.getThoiLuong(),cd.getHocPhi(),cd.getMoTa(),cd.getHinh()};
                model.addRow(row);
            }
            
        } catch (Exception e) {
            TBBOX.alert(this,"LỖI TRUY VẤN DỮ LIỆU");
        }
    }
// display
  void display(int i){
        ChuyenDe cd=List.get(i);
        txtmacd.setText(cd.getMaCD());
        txttencd.setText(cd.getTenCD());
        txtthoiluong.setText(String.valueOf(cd.getThoiLuong()));
        txthocphi.setText(String.valueOf(cd.getHocPhi()));
        txtmota.setText(cd.getMoTa());
        if(cd.getHinh()==null || cd.getHinh().equals("")){
             
        txthinhcd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/anhdaidienmatdinh.jpg")));
        }
        else{
            ImageIcon icon = new ImageIcon(cd.getHinh());
        txthinhcd.setIcon(icon);
        }
    }
    public QuanlyCDJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        init();
        xetuser();
    }
//kttt
    boolean kttt(){
    if(txtmacd.getText().equals("") || txtmacd.getText()==null){
        
        TBBOX.alert(this,"Thông tin không được để trống");
        txtmacd.requestFocus();
        return false;
    }
    else if(txttencd.getText().equals("") || txttencd.getText()==null){
         TBBOX.alert(this,"Thông tin không được để trống");
         txttencd.requestFocus();
     return false;
    }
    else if(txtthoiluong.getText().equals("") || txtthoiluong.getText()==null){
          try {
         int kt=Integer.parseInt(txtthoiluong.getText());
     } catch (Exception e) {
         JOptionPane.showMessageDialog(this,"ĐIỂM TA KHÔNG ĐÚNG ĐỊNH DẠNG");
         txtthoiluong.requestFocus();
         return false;
     }
         TBBOX.alert(this,"Thông tin không được để trống");
         txtthoiluong.requestFocus();
        return false;
    }
    else if(!txthocphi.getText().equals(txthocphi.getText())){
         try {
         Float kt=Float.parseFloat(txthocphi.getText());
     } catch (Exception e) {
         JOptionPane.showMessageDialog(this,"ĐIỂM TA KHÔNG ĐÚNG ĐỊNH DẠNG");
         txthocphi.requestFocus();
         return false;
     }
              TBBOX.alert(this,"Thông tin không được để trống");
         txthocphi.requestFocus();
         return false;
    }
    else if(txtmota.getText().equals("") || txtmota.getText()==null){
         TBBOX.alert(this,"Thông tin không được để trống");
         txtmota.requestFocus();
        return false;
    }
    else{
        return true;
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txthinhcd = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtmacd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txttencd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtthoiluong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmota = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnxoa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
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
        jLabel3 = new javax.swing.JLabel();
        txthocphi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblchuyende = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ CHUYÊN ĐỀ");

        jLabel2.setText("Hình logo");

        txthinhcd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        txthinhcd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txthinhcdMouseClicked(evt);
            }
        });

        jLabel4.setText("Mã chuyên đề");

        jLabel5.setText("Tên chuyên đề");

        jLabel6.setText("Thời lượng (giờ)");

        jLabel7.setText("Mô tả chuyên đề");

        txtmota.setColumns(20);
        txtmota.setRows(5);
        jScrollPane2.setViewportView(txtmota);

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });
        jPanel5.add(btnthem);

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });
        jPanel5.add(btnsua);
        jPanel5.add(jLabel13);

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });
        jPanel5.add(btnxoa);

        jButton1.setText("Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);

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

        btnf.setText("|<");
        btnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfActionPerformed(evt);
            }
        });
        jPanel7.add(btnf);

        btnff.setText("<<");
        btnff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnffActionPerformed(evt);
            }
        });
        jPanel7.add(btnff);
        jPanel7.add(jLabel15);

        btnnn.setText(">>");
        btnnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnnActionPerformed(evt);
            }
        });
        jPanel7.add(btnnn);

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

        jLabel3.setText("Học Phí");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(73, 73, 73)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txthinhcd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(txtthoiluong, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                                            .addComponent(txttencd)
                                            .addComponent(txtmacd)
                                            .addComponent(jLabel3)
                                            .addComponent(txthocphi))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txthinhcd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtmacd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttencd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtthoiluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9)
                        .addComponent(txthocphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CẬP NHẬT", jPanel1);

        tblchuyende.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã CD", "Tên CD", "Thời Lượng", "Học Phí", "Mô Tả", "Hình Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblchuyende.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblchuyendeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblchuyende);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DANH SÁCH", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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

    private void txthinhcdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txthinhcdMouseClicked
           JFileChooser jfc = new JFileChooser("src\\main\\java\\images");
        int result = jfc.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            try {
                
                 diachianh=jfc.getSelectedFile().getPath();
                  ImageIcon icon = new ImageIcon(diachianh);
               txthinhcd.setIcon(icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txthinhcdMouseClicked
 void them(){
    ChuyenDe cd=new ChuyenDe();
    cd.setMaCD(txtmacd.getText());
    cd.setTenCD(txttencd.getText());
    cd.setThoiLuong(Integer.parseInt(txtthoiluong.getText()));
    cd.setHocPhi(Double.parseDouble(txthocphi.getText()));
    cd.setMoTa(txtmota.getText());
    if(diachianh==null){
        cd.setHinh("/rs/anhdaidienmatdinh.jpg");
    }
    else{
        cd.setHinh(diachianh);
    }
    diachianh=null;
        try {
            ChuyenDe a= dao.selectByid(txtmacd.getText());
            if(a!=null){
                TBBOX.alert(this,"Chuyên Đề Đã tồn tại trong hệ thống vui lòng chọn cập nhật hoặc nhập khác");
            }
            else{
                dao.insert(cd);
                TBBOX.alert(this,"Thêm Thành Công");
                clear();
            }
        } catch (Exception e) {
            System.out.println(e);
            TBBOX.alert(this,"ĐÃ Xãy ra lỗi");
        }
    
}
 
void clear(){
    txtmacd.setText("");
    txttencd.setText("");
    txtthoiluong.setText("");
    txthocphi.setText("");
    txtmota.setText("");
    txthinhcd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/anhdaidienmatdinh.jpg")));
}
    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if(kttt()){
            this.them();
            fillTable();
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       clear();
       fillTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblchuyendeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblchuyendeMouseClicked
       List=dao.selectAll();
        display(tblchuyende.getSelectedRow());
    }//GEN-LAST:event_tblchuyendeMouseClicked
void sua(){
    ChuyenDe cd=new ChuyenDe();
    cd.setMaCD(txtmacd.getText());
    cd.setTenCD(txttencd.getText());
    cd.setThoiLuong(Integer.parseInt(txtthoiluong.getText()));
    cd.setHocPhi(Double.parseDouble(txthocphi.getText()));
    cd.setMoTa(txtmota.getText());
    if(diachianh==null){
        cd.setHinh("/rs/anhdaidienmatdinh.jpg");
    }
    else{
        cd.setHinh(diachianh);
    }
    diachianh=null;
        try {
            ChuyenDe a= dao.selectByid(txtmacd.getText());
            if(a!=null){
                 dao.update(cd);
                TBBOX.alert(this,"UPdate Thành Công");
                clear();               
            }
            else{
               TBBOX.alert(this,"Chuyên Đề Không tồn tại trong hệ thống");
            }
        } catch (Exception e) {
            System.out.println(e);
            TBBOX.alert(this,"ĐÃ Xãy ra lỗi");
        }
    
}
    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
      if(kttt()){
          this.sua();
          fillTable();
      }
    }//GEN-LAST:event_btnsuaActionPerformed
void xoa(){
    
    diachianh=null;
        try {
            ChuyenDe a= dao.selectByid(txtmacd.getText());
            if(a!=null){
                 dao.delete(txtmacd.getText());
                TBBOX.alert(this,"Delect Thành Công");
                clear();               
            }
            else{
               TBBOX.alert(this,"Chuyên Đề Không tồn tại trong hệ thống");
            }
        } catch (Exception e) {
            System.out.println(e);
            TBBOX.alert(this,"ĐÃ Xãy ra lỗi");
        }
    
}
    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
       if(kttt()){
           this.xoa();
           fillTable();
       }
    }//GEN-LAST:event_btnxoaActionPerformed

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
        if(current==List.size()-1){
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
        current=List.size()-1;
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
            java.util.logging.Logger.getLogger(QuanlyCDJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanlyCDJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanlyCDJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanlyCDJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanlyCDJDialog dialog = new QuanlyCDJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnn;
    private javax.swing.JButton btnnn;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblchuyende;
    private javax.swing.JLabel txthinhcd;
    private javax.swing.JTextField txthocphi;
    private javax.swing.JTextField txtmacd;
    private javax.swing.JTextArea txtmota;
    private javax.swing.JTextField txttencd;
    private javax.swing.JTextField txtthoiluong;
    // End of variables declaration//GEN-END:variables

    private void init() {
        fillTable();
    }
}
