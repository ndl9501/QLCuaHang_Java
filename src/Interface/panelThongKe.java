/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controller.Excel;
import Process.ThongKe;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author llong
 */
public class panelThongKe extends javax.swing.JPanel {
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    ThongKe TK = new ThongKe();
    Excel excel = new Excel();
    final DefaultTableModel DoanhThuTableModel = new DefaultTableModel();
    final DefaultTableModel MonAnHotTableModel = new DefaultTableModel();
    String []ColsnameDoanhThu = {"Mã HD","Tên NV", "Tên KH","Ngày HD", "Tổng Tiền"};
    String []ColsnameMonAn = {"Mã Món","Tên Món", "Đơn Giá","Số Lượng", "Tổng Tiền"};
    /**
     * Creates new form panelThongKe
     */
    public panelThongKe() {
        initComponents();
        
        DoanhThuTableModel.setColumnIdentifiers(ColsnameDoanhThu);
        tbDanhThu.setModel(DoanhThuTableModel);
        
        
        MonAnHotTableModel.setColumnIdentifiers(ColsnameMonAn);
        tbMonAnHot.setModel(MonAnHotTableModel);
        
        clearData(true);
        ShowData(true);
        clearData(false);
        ShowData(false);
    }
    private boolean checkDate(String str){
         formatter.setLenient(false);
            try {
                Date date= formatter.parse(str.replaceAll("-", "/"));
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Ngày Không Hợp Lệ !");
                return false;
            }
    }
    // true Doanh Thu - false Mon An
    private void clearData(boolean x){
        clearTB(x);
        if(x){
            txtNgayBD.setText("");
            txtNgayKT.setText("");
        }else{
            txtNgayBD1.setText("");
            txtNgayKT1.setText("");
        }
        
    }
    private void ShowData(boolean x){
        ResultSet rs = null;
        try {
            if(x){
                rs = TK.getData_BCDoanhThu();
                int TongDanhThu = 0;
                while(rs.next()){
                    String rows[] = new String[5];
                    rows[0] = rs.getString("MaHD");
                    rows[1] = rs.getString("TenNV");
                    rows[2] = rs.getString("TenKH");
                    rows[3] = rs.getString("NgayHD");
                    rows[4] = rs.getString("TongTien");
                    TongDanhThu += Integer.parseInt(rows[4]);
                    DoanhThuTableModel.addRow(rows);
                }
                lbTongDanhThu.setText(""+TongDanhThu);
            }else{
                rs = TK.getData_BCMonAn();
                int TongDanhThu = 0;
                while(rs.next()){
                    String rows[] = new String[5];
                    rows[0] = rs.getString("MaMon");
                    rows[1] = rs.getString("TenMon");
                    rows[2] = rs.getString("SoLuong");
                    rows[3] = rs.getString("DonGia");
                    rows[4] = rs.getString("TongTien");
                    TongDanhThu += Integer.parseInt(rows[4]);
                    MonAnHotTableModel.addRow(rows);
                }
            }
        } catch (Exception e) {
            System.out.println("Err : " + e.getMessage());
        }
    }
    private void clearTB(boolean x){
        
        int n = x ? (DoanhThuTableModel.getRowCount()-1) : (MonAnHotTableModel.getRowCount()-1) ;
        while(n>=0){
            if(x) DoanhThuTableModel.removeRow(n--);
            else MonAnHotTableModel.removeRow(n--);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnXuatDT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhThu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnTaiLai = new javax.swing.JButton();
        lbTongDanhThu = new javax.swing.JLabel();
        txtNgayBD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgayKT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbTuyChon = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnXuatMA = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnTaiLaiMA = new javax.swing.JButton();
        txtNgayBD1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNgayKT1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMonAnHot = new javax.swing.JTable();
        cbbTuyChon1 = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(1040, 610));
        setMinimumSize(new java.awt.Dimension(1040, 610));

        jTabbedPane1.setBackground(new java.awt.Color(255, 204, 102));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Doanh Thu"));

        btnXuatDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXuatDT.setText("Xuất Excel");
        btnXuatDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDTActionPerformed(evt);
            }
        });

        tbDanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbDanhThu);
        if (tbDanhThu.getColumnModel().getColumnCount() > 0) {
            tbDanhThu.getColumnModel().getColumn(0).setResizable(false);
            tbDanhThu.getColumnModel().getColumn(1).setResizable(false);
            tbDanhThu.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Báo Cáo Doanh Thu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tổng Doanh Thu :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("VND");

        btnTaiLai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnTaiLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ref.png"))); // NOI18N
        btnTaiLai.setText("Tải Lại");
        btnTaiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiLaiActionPerformed(evt);
            }
        });

        lbTongDanhThu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTongDanhThu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTongDanhThu.setText(" ");

        txtNgayBD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNgayBD.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Từ Ngày :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Đến Ngày :");

        txtNgayKT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNgayKT.setEnabled(false);

        jLabel6.setText("dd-mm-yyyy");

        cbbTuyChon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbTuyChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tùy Chọn", "Tất Cả" }));
        cbbTuyChon.setSelectedIndex(1);
        cbbTuyChon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTuyChonItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(477, 556, Short.MAX_VALUE)
                        .addComponent(cbbTuyChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnTaiLai)
                        .addGap(73, 73, 73)
                        .addComponent(btnXuatDT)))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(lbTongDanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(72, 72, 72))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnTaiLai, btnXuatDT, cbbTuyChon});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatDT)
                    .addComponent(btnTaiLai)
                    .addComponent(cbbTuyChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lbTongDanhThu))
                .addGap(27, 27, 27))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnTaiLai, btnXuatDT, cbbTuyChon});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Báo Cáo Doanh Thu", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Món Ăn Hot"));

        btnXuatMA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXuatMA.setText("Xuất Excel");
        btnXuatMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatMAActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Báo Cáo Món Ăn HOT");

        btnTaiLaiMA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnTaiLaiMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ref.png"))); // NOI18N
        btnTaiLaiMA.setText("Tải Lại");
        btnTaiLaiMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiLaiMAActionPerformed(evt);
            }
        });

        txtNgayBD1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNgayBD1.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Từ Ngày :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Đến Ngày :");

        txtNgayKT1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNgayKT1.setEnabled(false);

        jLabel12.setText("dd-mm-yyyy");

        tbMonAnHot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbMonAnHot);

        cbbTuyChon1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbTuyChon1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tùy Chọn", "Tất Cả" }));
        cbbTuyChon1.setSelectedIndex(1);
        cbbTuyChon1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTuyChon1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbTuyChon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(btnTaiLaiMA)
                .addGap(73, 73, 73)
                .addComponent(btnXuatMA)
                .addGap(23, 23, 23))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jLabel7))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayBD1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayKT1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)))
                .addContainerGap(427, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnTaiLaiMA, btnXuatMA, cbbTuyChon1});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatMA)
                    .addComponent(btnTaiLaiMA)
                    .addComponent(cbbTuyChon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayBD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txtNgayKT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnTaiLaiMA, btnXuatMA, cbbTuyChon1});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Báo Cáo Món Ăn HOT", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiLaiActionPerformed
        // TODO add your handling code here:
        System.out.println(cbbTuyChon.getSelectedItem());
        if(cbbTuyChon.getSelectedItem().equals("Tùy Chọn")){
            String NgayBD = txtNgayBD.getText();
            String NgayKT = txtNgayKT.getText();
            System.out.println(NgayBD);
            if(checkDate(NgayKT) && checkDate(NgayBD)){
                try {
                    ResultSet rs = null;
                    rs = TK.getData_BCDoanhThu(NgayBD, NgayKT);
                    clearTB(true);
                    int TongDanhThu = 0;
                    while(rs.next()){
                        String rows[] = new String[5];
                        rows[0] = rs.getString("MaHD");
                        rows[1] = rs.getString("TenNV");
                        rows[2] = rs.getString("TenKH");
                        rows[3] = rs.getString("NgayHD");
                        rows[4] = rs.getString("TongTien");
                        TongDanhThu += Integer.parseInt(rows[4]);
                        DoanhThuTableModel.addRow(rows);
                    }
                    lbTongDanhThu.setText(""+TongDanhThu);
                } catch (Exception ex) {
                    Logger.getLogger(panelThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }else{
            clearData(true);
            txtNgayBD.setEnabled(false);
            txtNgayKT.setEnabled(false);
            clearTB(true);
            ShowData(true);
        }
    }//GEN-LAST:event_btnTaiLaiActionPerformed

    private void cbbTuyChonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTuyChonItemStateChanged
        try {
            // TODO add your handling code here:
            String cbb = cbbTuyChon.getSelectedItem().toString();
            switch(cbb){
                case "Tất Cả" :
                    clearData(true);
                    txtNgayBD.setEnabled(false);
                    txtNgayKT.setEnabled(false);
                    clearTB(true);
                    ShowData(true);
                    break;
                case "Tùy Chọn":
                    txtNgayBD.setText("");
                    txtNgayKT.setText("");
                    txtNgayBD.setEnabled(true);
                    txtNgayKT.setEnabled(true);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(panelThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cbbTuyChonItemStateChanged

    private void cbbTuyChon1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTuyChon1ItemStateChanged
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String cbb = cbbTuyChon1.getSelectedItem().toString();
            switch(cbb){
                case "Tất Cả" :
                    clearData(false);
                    txtNgayBD1.setEnabled(false);
                    txtNgayKT1.setEnabled(false);
                    clearTB(false);
                    ShowData(false);
                    break;
                case "Tùy Chọn":
                    txtNgayBD1.setText("");
                    txtNgayKT1.setText("");
                    txtNgayBD1.setEnabled(true);
                    txtNgayKT1.setEnabled(true);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(panelThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbbTuyChon1ItemStateChanged

    private void btnTaiLaiMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiLaiMAActionPerformed
        // TODO add your handling code here:
        if(cbbTuyChon1.getSelectedItem().equals("Tùy Chọn")){
            String NgayBD = txtNgayBD1.getText();
            String NgayKT = txtNgayKT1.getText();
            System.out.println(NgayBD);
            if(checkDate(NgayKT) && checkDate(NgayBD)){
                try {
                    ResultSet rs = null;
                    rs = TK.getData_BCMonAn(NgayBD, NgayKT);
                    clearTB(false);
                    while(rs.next()){
                        System.out.println("data");
                        String rows[] = new String[5];
                        rows[0] = rs.getString("MaMon");
                        rows[1] = rs.getString("TenMon");
                        rows[2] = rs.getString("DonGia");
                        rows[3] = rs.getString("SoLuong");
                        rows[4] = rs.getString("TongTien");
                        MonAnHotTableModel.addRow(rows);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(panelThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }else{
            clearData(false);
            txtNgayBD.setEnabled(false);
            txtNgayKT.setEnabled(false);
            clearTB(false);
            ShowData(false);
        }
    }//GEN-LAST:event_btnTaiLaiMAActionPerformed

    private void btnXuatMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatMAActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Bạn Muốn Xuất Execl ?") == JOptionPane.OK_OPTION){
            String Excel_Name = "BCMonAn_";
            try {
                ResultSet rs = null;
                if(cbbTuyChon1.getSelectedItem().equals("Tùy Chọn")){
                    
                    String NgayBD = txtNgayBD1.getText();
                    String NgayKT = txtNgayKT1.getText();
                    Excel_Name+="Date_"+ NgayBD + "-"+NgayKT;
                    System.out.println(NgayBD);
                    if(checkDate(NgayKT) && checkDate(NgayBD)){
                        try {
                            rs = TK.getData_BCMonAn(NgayBD, NgayKT);
                        } catch (Exception ex) {
                            Logger.getLogger(panelThongKe.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }else{
                    try {
                        Excel_Name+="ALL"+(int)(Math.random()*100 + 1);
                        rs = TK.getData_BCMonAn();
                    } catch (Exception ex) {
                        Logger.getLogger(panelThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                excel.WriteExcel(Excel_Name, ColsnameMonAn, rs);
                JOptionPane.showMessageDialog(this, "Hoàn Thành với file name : " +  Excel_Name);
            } catch (Exception ex) {
                Logger.getLogger(panelThongKe.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Có Lỗi Xảy Ra !");
            }
        }
    }//GEN-LAST:event_btnXuatMAActionPerformed

    private void btnXuatDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDTActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Bạn Muốn Xuất Execl ?") == JOptionPane.OK_OPTION){
            String Excel_Name = "BCDoanhThu_";
            try {
                ResultSet rs = null;
                if(cbbTuyChon.getSelectedItem().equals("Tùy Chọn")){
                    
                    String NgayBD = txtNgayBD.getText();
                    String NgayKT = txtNgayKT.getText();
                    Excel_Name+="Date_"+ NgayBD + "-"+NgayKT;
                    System.out.println(NgayBD);
                    if(checkDate(NgayKT) && checkDate(NgayBD)){
                        try {
                            rs = TK.getData_BCDoanhThu(NgayBD, NgayKT);
                        } catch (Exception ex) {
                            Logger.getLogger(panelThongKe.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }else{
                    try {
                        Excel_Name+="ALL"+(int)(Math.random()*100 + 1);
                        rs = TK.getData_BCMonAn();
                    } catch (Exception ex) {
                        Logger.getLogger(panelThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                excel.WriteExcel(Excel_Name, ColsnameMonAn, rs);
            } catch (Exception ex) {
                Logger.getLogger(panelThongKe.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Có Lỗi Xảy Ra !");
            }
            JOptionPane.showMessageDialog(this, "Hoàn Thành với file name : " +  Excel_Name);
        }
    }//GEN-LAST:event_btnXuatDTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaiLai;
    private javax.swing.JButton btnTaiLaiMA;
    private javax.swing.JButton btnXuatDT;
    private javax.swing.JButton btnXuatMA;
    private javax.swing.JComboBox<String> cbbTuyChon;
    private javax.swing.JComboBox<String> cbbTuyChon1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbTongDanhThu;
    private javax.swing.JTable tbDanhThu;
    private javax.swing.JTable tbMonAnHot;
    private javax.swing.JTextField txtNgayBD;
    private javax.swing.JTextField txtNgayBD1;
    private javax.swing.JTextField txtNgayKT;
    private javax.swing.JTextField txtNgayKT1;
    // End of variables declaration//GEN-END:variables
}
