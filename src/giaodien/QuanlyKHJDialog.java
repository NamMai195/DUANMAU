/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package giaodien;

import com.edusys.dao.ChuyenDeDAO;
import com.edusys.dao.KhoaHocDAO;
import com.edusys.dao.NhanVienDAO;
import com.edusys.entity.ChuyenDe;
import com.edusys.entity.KhoaHoc;
import com.edusys.utlis.Auth;
import com.edusys.utlis.TBBOX;
import com.edusys.utlis.XDate;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nam
 */
public class QuanlyKHJDialog extends javax.swing.JDialog {
private int current;
private KhoaHocDAO dao=new KhoaHocDAO();
private List<KhoaHoc> List= dao.selectAll();
ChuyenDeDAO daocd=new ChuyenDeDAO();
   List<ChuyenDe> ListCD=daocd.selectAll();

    public QuanlyKHJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();this.setLocationRelativeTo(null);
        init();
        xetuser();
    }
void loaddatatoCombobox(){
    for(ChuyenDe cd:ListCD){
        cbbCD.addItem(cd.getTenCD());
    }
}
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
        DefaultTableModel model=(DefaultTableModel) tblKH.getModel();
        model.setRowCount(0);
        try {
            List<KhoaHoc> list=dao.selectAll();
            for(KhoaHoc kh:list){
                Object[] row={kh.getMaKH(),kh.getHocPhi(),kh.getThoiLuong(),kh.getNgayKG(),kh.getMaNV(),kh.getNgayTao()};
                model.addRow(row);
            }
            
        } catch (Exception e) {
            TBBOX.alert(this,"LỖI TRUY VẤN DỮ LIỆU");
        }
    }
// display
  void display(int i){
        KhoaHoc cd=List.get(i);
        txtkhaigiang.setText(cd.getNgayKG().toString());
        txthocphi.setText(String.valueOf(cd.getHocPhi()));
        txtthoiluong.setText(String.valueOf(cd.getThoiLuong()));
        txtngaytao.setText(cd.getNgayTao().toString());
        txttennv.setText(cd.getMaNV());
        txtghichu.setText(cd.getGhiChu());
        laberCD.setText(new ChuyenDeDAO().selectByid(cd.getMaCD()).getTenCD());
    }
//  voo hieeu qua
  void vohieuqua(){
      txthocphi.setEnabled(false);
      txtthoiluong.setEnabled(false);
      txttennv.setEnabled(false);
      txtngaytao.setEnabled(false);
  }
 boolean kttt(){
    if(txtkhaigiang.getText().equals("") || txtkhaigiang.getText()==null){
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
        jPanel1 = new javax.swing.JPanel();
        cbbCD = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        laberCD = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtkhaigiang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txthocphi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtthoiluong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txttennv = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtngaytao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtghichu = new javax.swing.JTextArea();
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
        btnn = new javax.swing.JButton();
        btnnn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("CHUYÊN ĐỀ");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbbCD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbCDItemStateChanged(evt);
            }
        });
        cbbCD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCDMouseClicked(evt);
            }
        });
        cbbCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbCD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Học Phí", "Thời Lượng", "Ngày KG", "Tạo Bởi", "Ngày Tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblKHMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblKH);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("DANH SÁCH", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Chuyên đề");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        laberCD.setText("Lập trình java cơi bản");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(laberCD, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(laberCD))
        );

        jLabel4.setText("Khai giảng");

        jLabel5.setText("Học phí");

        txthocphi.setText("0.0");

        jLabel6.setText("Thời lượng (giờ)");

        txtthoiluong.setText("0");

        jLabel7.setText("Người tạo");

        txttennv.setText("TenNV");

        jLabel8.setText("Ngày tạo");

        jLabel9.setText("Ghi chú");

        txtghichu.setColumns(20);
        txtghichu.setRows(5);
        jScrollPane2.setViewportView(txtghichu);

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

        btnn.setText(">>");
        btnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnActionPerformed(evt);
            }
        });
        jPanel7.add(btnn);

        btnnn.setText(">|");
        btnnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnnActionPerformed(evt);
            }
        });
        jPanel7.add(btnnn);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(txttennv)
                                    .addComponent(txthocphi)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(txtngaytao, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                                    .addComponent(txtthoiluong)
                                    .addComponent(txtkhaigiang))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkhaigiang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthocphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtthoiluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("CẬP NHẬT", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
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

    private void cbbCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCDActionPerformed

        laberCD.setText(ListCD.get(cbbCD.getSelectedIndex()).getTenCD());
        txthocphi.setText(String.valueOf(ListCD.get(cbbCD.getSelectedIndex()).getHocPhi()));
        txtthoiluong.setText(String.valueOf(ListCD.get(cbbCD.getSelectedIndex()).getThoiLuong()));
        txttennv.setText(Auth.user.getMaNV());
        txtngaytao.setText(XDate.now().toString());
    }//GEN-LAST:event_cbbCDActionPerformed

    private void tblKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKHMouseEntered

    private void tblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHMouseClicked
          List=dao.selectAll();
        display(tblKH.getSelectedRow());
    }//GEN-LAST:event_tblKHMouseClicked

    private void cbbCDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbCDItemStateChanged

    }//GEN-LAST:event_cbbCDItemStateChanged

    private void cbbCDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCDMouseClicked
        
    }//GEN-LAST:event_cbbCDMouseClicked
void them(){
    KhoaHoc a=new KhoaHoc();
    a.setMaCD(ListCD.get(cbbCD.getSelectedIndex()).getMaCD());
    a.setHocPhi(ListCD.get(cbbCD.getSelectedIndex()).getHocPhi());
    a.setNgayKG(XDate.toDate(txtkhaigiang.getText(),"yyyy-MM-dd"));
    a.setGhiChu(txtghichu.getText());
    a.setMaNV(Auth.user.getMaNV());
    a.setNgayTao(XDate.now());
    a.setThoiLuong(Integer.parseInt(txtthoiluong.getText()));
    try {
        dao.insert(a);
        TBBOX.alert(this,"Thêm Thành Công");
        clean();
    } catch (Exception e) {
        System.out.println(e);
    }
}
    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
     them();
     fillTable();
    }//GEN-LAST:event_btnthemActionPerformed
void clean(){
    cbbCD.setSelectedIndex(0);
    txtkhaigiang.setText("");
    txtghichu.setText("");
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clean();
    }//GEN-LAST:event_jButton1ActionPerformed
void sua(){
    KhoaHoc a=new KhoaHoc();
    a.setMaCD(ListCD.get(cbbCD.getSelectedIndex()).getMaCD());
    a.setHocPhi(ListCD.get(cbbCD.getSelectedIndex()).getHocPhi());
    a.setNgayKG(XDate.toDate(txtkhaigiang.getText(),"yyyy-MM-dd"));
    a.setGhiChu(txtghichu.getText());
    a.setMaNV(Auth.user.getMaNV());
    a.setNgayTao(XDate.now());
    a.setThoiLuong(Integer.parseInt(txtthoiluong.getText()));
    a.setMaKH(List.get(tblKH.getSelectedRow()).getMaKH());
    try {
        KhoaHoc test=dao.selectByid(List.get(tblKH.getSelectedRow()).getMaKH());
        if(test!=null){
        dao.update(a);
        TBBOX.alert(this,"Sửa Thành Công");
        clean();
        }
        else{
            TBBOX.alert(this,"Khóa Học Không tồn tại");
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
if(kttt()){
    sua();
    fillTable();
}      
    }//GEN-LAST:event_btnsuaActionPerformed
void xoa(){
    KhoaHoc a=new KhoaHoc();
    a.setMaCD(ListCD.get(cbbCD.getSelectedIndex()).getMaCD());
    a.setHocPhi(ListCD.get(cbbCD.getSelectedIndex()).getHocPhi());
    a.setNgayKG(XDate.toDate(txtkhaigiang.getText(),"yyyy-MM-dd"));
    a.setGhiChu(txtghichu.getText());
    a.setMaNV(Auth.user.getMaNV());
    a.setNgayTao(XDate.now());
    a.setThoiLuong(Integer.parseInt(txtthoiluong.getText()));
    a.setMaKH(List.get(tblKH.getSelectedRow()).getMaKH());
    try {
        KhoaHoc test=dao.selectByid(List.get(tblKH.getSelectedRow()).getMaKH());
        if(test!=null){
        dao.delete(a.getMaKH());
        TBBOX.alert(this,"Xóa Thành Công");
        clean();
        }
        else{
            TBBOX.alert(this,"Khóa Học Không tồn tại");
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        if (kttt()) {
            xoa();
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

    private void btnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnActionPerformed
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
    }//GEN-LAST:event_btnnActionPerformed

    private void btnnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnnActionPerformed
        if(ktList()){
          TBBOX.alert(this,"Chưa có nhân viên nào");
           return;
      }
        current=List.size()-1;
        display(current);
    }//GEN-LAST:event_btnnnActionPerformed

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
            java.util.logging.Logger.getLogger(QuanlyKHJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanlyKHJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanlyKHJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanlyKHJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanlyKHJDialog dialog = new QuanlyKHJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbbCD;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel laberCD;
    private javax.swing.JTable tblKH;
    private javax.swing.JTextArea txtghichu;
    private javax.swing.JTextField txthocphi;
    private javax.swing.JTextField txtkhaigiang;
    private javax.swing.JTextField txtngaytao;
    private javax.swing.JTextField txttennv;
    private javax.swing.JTextField txtthoiluong;
    // End of variables declaration//GEN-END:variables

    private void init() {
        loaddatatoCombobox();
        fillTable();
        vohieuqua();
    }
}
