package Dashboard_admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Locale;
import form.AturKriteria;
import form.formMhs;
import component_login_register.Login;

public class Dashboard_admin extends javax.swing.JFrame {

    private JTable dataTable;
 
    public Dashboard_admin() {
        initComponents();
        displayData();
        displayApprovalCount();
        displayRejectedCount();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pdashboard = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dashboard = new javax.swing.JLabel();
        pdashboard1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        dashboard1 = new javax.swing.JLabel();
        pdashboard2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        dashboard2 = new javax.swing.JLabel();
        pdashboard3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        dashboard3 = new javax.swing.JLabel();
        pdashboard4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        dashboard4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dashboardpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jumlahfeb = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jumlahfad = new javax.swing.JLabel();
        jumlahfaperta = new javax.swing.JLabel();
        jumlahfasilkom = new javax.swing.JLabel();
        jumlahhukum = new javax.swing.JLabel();
        jumlahfisip = new javax.swing.JLabel();
        jumlahteknik = new javax.swing.JLabel();
        jumlahkedokteran = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        setujup = new javax.swing.JLabel();
        setujuj = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        persentolak = new javax.swing.JLabel();
        jumlahtolak = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(227, 227, 254));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("MENU");

        pdashboard.setBackground(new java.awt.Color(225, 225, 253));
        pdashboard.setDoubleBuffered(false);
        pdashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pdashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pdashboardMouseExited(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/home (1).png"))); // NOI18N
        jLabel6.setText("jLabel6");

        dashboard.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dashboard.setForeground(new java.awt.Color(102, 102, 102));
        dashboard.setText("DASHBOARD");

        javax.swing.GroupLayout pdashboardLayout = new javax.swing.GroupLayout(pdashboard);
        pdashboard.setLayout(pdashboardLayout);
        pdashboardLayout.setHorizontalGroup(
            pdashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdashboardLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        pdashboardLayout.setVerticalGroup(
            pdashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pdashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dashboard)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22))
        );

        pdashboard1.setBackground(new java.awt.Color(225, 225, 253));
        pdashboard1.setDoubleBuffered(false);
        pdashboard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pdashboard1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pdashboard1MouseExited(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/multiple.png"))); // NOI18N
        jLabel20.setText("jLabel6");

        dashboard1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dashboard1.setForeground(new java.awt.Color(102, 102, 102));
        dashboard1.setText("TAMBAH KRITERIA");
        dashboard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboard1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pdashboard1Layout = new javax.swing.GroupLayout(pdashboard1);
        pdashboard1.setLayout(pdashboard1Layout);
        pdashboard1Layout.setHorizontalGroup(
            pdashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdashboard1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pdashboard1Layout.setVerticalGroup(
            pdashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdashboard1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pdashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dashboard1)
                    .addComponent(jLabel20))
                .addGap(22, 22, 22))
        );

        pdashboard2.setBackground(new java.awt.Color(225, 225, 253));
        pdashboard2.setDoubleBuffered(false);
        pdashboard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pdashboard2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pdashboard2MouseExited(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/hands-holding-diamond.png"))); // NOI18N
        jLabel21.setText("jLabel6");

        dashboard2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dashboard2.setForeground(new java.awt.Color(102, 102, 102));
        dashboard2.setText("NILAI KRITERIA");
        dashboard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pdashboard2Layout = new javax.swing.GroupLayout(pdashboard2);
        pdashboard2.setLayout(pdashboard2Layout);
        pdashboard2Layout.setHorizontalGroup(
            pdashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdashboard2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        pdashboard2Layout.setVerticalGroup(
            pdashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdashboard2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pdashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dashboard2)
                    .addComponent(jLabel21))
                .addGap(22, 22, 22))
        );

        pdashboard3.setBackground(new java.awt.Color(225, 225, 253));
        pdashboard3.setDoubleBuffered(false);
        pdashboard3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pdashboard3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pdashboard3MouseExited(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/rank.png"))); // NOI18N
        jLabel22.setText("jLabel6");

        dashboard3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dashboard3.setForeground(new java.awt.Color(102, 102, 102));
        dashboard3.setText("PERANGKINGAN");

        javax.swing.GroupLayout pdashboard3Layout = new javax.swing.GroupLayout(pdashboard3);
        pdashboard3.setLayout(pdashboard3Layout);
        pdashboard3Layout.setHorizontalGroup(
            pdashboard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdashboard3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboard3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pdashboard3Layout.setVerticalGroup(
            pdashboard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdashboard3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pdashboard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dashboard3)
                    .addComponent(jLabel22))
                .addGap(22, 22, 22))
        );

        pdashboard4.setBackground(new java.awt.Color(225, 225, 253));
        pdashboard4.setDoubleBuffered(false);
        pdashboard4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pdashboard4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pdashboard4MouseExited(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/sign-out-alt.png"))); // NOI18N
        jLabel23.setText("jLabel6");

        dashboard4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dashboard4.setForeground(new java.awt.Color(102, 102, 102));
        dashboard4.setText("LOGOUT");
        dashboard4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pdashboard4Layout = new javax.swing.GroupLayout(pdashboard4);
        pdashboard4.setLayout(pdashboard4Layout);
        pdashboard4Layout.setHorizontalGroup(
            pdashboard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdashboard4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboard4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        pdashboard4Layout.setVerticalGroup(
            pdashboard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdashboard4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pdashboard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dashboard4)
                    .addComponent(jLabel23))
                .addGap(22, 22, 22))
        );

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setText("TAMBAHAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdashboard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdashboard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(pdashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pdashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pdashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pdashboard3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(pdashboard4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1240, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        dashboardpanel.setBackground(new java.awt.Color(230, 225, 254));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ASAL FAKULTAS MAHASISWA");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("FAD");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("FAPERTA");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 255));
        jLabel8.setText("FEB");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("FISIP");

        jumlahfeb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jumlahfeb.setForeground(new java.awt.Color(51, 204, 255));
        jumlahfeb.setText("0");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 51));
        jLabel10.setText("FASILKOM");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("HUKUM");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("KEDOKTERAN");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 0, 204));
        jLabel13.setText("TEKNIK");

        jumlahfad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jumlahfad.setForeground(new java.awt.Color(102, 0, 102));
        jumlahfad.setText("0");

        jumlahfaperta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jumlahfaperta.setForeground(new java.awt.Color(0, 153, 51));
        jumlahfaperta.setText("0");

        jumlahfasilkom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jumlahfasilkom.setForeground(new java.awt.Color(255, 153, 51));
        jumlahfasilkom.setText("0");

        jumlahhukum.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jumlahhukum.setForeground(new java.awt.Color(255, 0, 0));
        jumlahhukum.setText("0");

        jumlahfisip.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jumlahfisip.setForeground(new java.awt.Color(255, 204, 0));
        jumlahfisip.setText("0");

        jumlahteknik.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jumlahteknik.setForeground(new java.awt.Color(51, 0, 204));
        jumlahteknik.setText("0");

        jumlahkedokteran.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jumlahkedokteran.setForeground(new java.awt.Color(0, 153, 153));
        jumlahkedokteran.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jumlahteknik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumlahkedokteran, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                            .addComponent(jumlahhukum, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jumlahfisip, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jumlahfasilkom, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jumlahfaperta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jumlahfad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jumlahfeb, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jumlahfad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jumlahfaperta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jumlahfasilkom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jumlahfeb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jumlahfisip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahhukum)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jumlahkedokteran))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jumlahteknik))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("STATUS PENGAJUAN");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 0));
        jLabel14.setText("DISETUJUI");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/contract_approved_icon_152023.png"))); // NOI18N

        setujup.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        setujup.setText("0");

        setujuj.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        setujuj.setText("0");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 255, 0));
        jLabel17.setText("Berkas telah disetuji");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setujuj, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 101, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(setujup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(setujup))
                .addGap(24, 24, 24)
                .addComponent(setujuj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("DITOLAK");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/rejected_reject_cross_delete_document_paper_bad_quality_sheet_archive_icon_225915.png"))); // NOI18N

        persentolak.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        persentolak.setText("0");

        jumlahtolak.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jumlahtolak.setText("0");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Berkas ditolak");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(persentolak, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumlahtolak, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(persentolak))
                .addGap(18, 18, 18)
                .addComponent(jumlahtolak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dashboardpanelLayout = new javax.swing.GroupLayout(dashboardpanel);
        dashboardpanel.setLayout(dashboardpanelLayout);
        dashboardpanelLayout.setHorizontalGroup(
            dashboardpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardpanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(dashboardpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(dashboardpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardpanelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dashboardpanelLayout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(849, Short.MAX_VALUE))
        );
        dashboardpanelLayout.setVerticalGroup(
            dashboardpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardpanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(dashboardpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(dashboardpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(1371, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dashboardpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pdashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdashboardMouseEntered
       pdashboard.setBackground(new Color(210,210,251));
        
    }//GEN-LAST:event_pdashboardMouseEntered

    private void pdashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdashboardMouseExited
        pdashboard.setBackground(new Color(225,225,253));
    }//GEN-LAST:event_pdashboardMouseExited

    private void pdashboard1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdashboard1MouseEntered
        // TODO add your handling code here:
        pdashboard.setBackground(new Color(210,210,251));
    }//GEN-LAST:event_pdashboard1MouseEntered

    private void pdashboard1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdashboard1MouseExited
        // TODO add your handling code here:
        pdashboard.setBackground(new Color(225,225,253));
    }//GEN-LAST:event_pdashboard1MouseExited

    private void pdashboard2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdashboard2MouseEntered
        // TODO add your handling code here:
        pdashboard.setBackground(new Color(210,210,251));
    }//GEN-LAST:event_pdashboard2MouseEntered

    private void pdashboard2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdashboard2MouseExited
        // TODO add your handling code here:
         pdashboard.setBackground(new Color(225,225,253));
    }//GEN-LAST:event_pdashboard2MouseExited

    private void pdashboard3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdashboard3MouseEntered
        // TODO add your handling code here:
        pdashboard.setBackground(new Color(210,210,251));
    }//GEN-LAST:event_pdashboard3MouseEntered

    private void pdashboard3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdashboard3MouseExited
        // TODO add your handling code here:
         pdashboard.setBackground(new Color(225,225,253));
    }//GEN-LAST:event_pdashboard3MouseExited

    private void pdashboard4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdashboard4MouseEntered
        // TODO add your handling code here:
        pdashboard.setBackground(new Color(210,210,251));
    }//GEN-LAST:event_pdashboard4MouseEntered

    private void pdashboard4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdashboard4MouseExited
        // TODO add your handling code here:
         pdashboard.setBackground(new Color(225,225,253));
    }//GEN-LAST:event_pdashboard4MouseExited

    private void dashboard1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard1MouseEntered
        // TODO add your handling code here:
        pdashboard.setBackground(new Color(210,210,251));
    }//GEN-LAST:event_dashboard1MouseEntered

    private void dashboard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard1MouseClicked
        // TODO add your handling code here:
        AturKriteria AturKriteriaForm = new AturKriteria();
        AturKriteriaForm.setVisible(true);
        AturKriteriaForm.pack();
        this.dispose();
    }//GEN-LAST:event_dashboard1MouseClicked

    private void dashboard2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard2MouseClicked
        // TODO add your handling code here:
        formMhs FormMahasiswa = new formMhs();
        FormMahasiswa.setVisible(true);
        FormMahasiswa.pack();
        this.dispose();
    }//GEN-LAST:event_dashboard2MouseClicked

    private void dashboard4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard4MouseClicked
        // TODO add your handling code here:
        Login LoginForm = new Login();
        LoginForm.setVisible(true);
        LoginForm.pack();
        this.dispose();
    }//GEN-LAST:event_dashboard4MouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard_admin().setVisible(true);
            }
        });
    }

    private void displayData() {
    try {
        // Koneksi ke database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbo", "root", "");

        // Daftar fakultas yang ingin ditampilkan
        String[] fakultas = {"fisip", "fasilkom", "feb", "fad", "faperta", "hukum", "kedokteran", "teknik"};

        // Eksekusi query untuk setiap fakultas
        for (String namaFakultas : fakultas) {
            // Query untuk mendapatkan jumlah data fakultas dengan nama tertentu
            String query = "SELECT COUNT(*) AS jumlah FROM fakultas WHERE nama = '" + namaFakultas + "'";

            // Eksekusi query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Mendapatkan hasil query
            if (rs.next()) {
                int jumlah = rs.getInt("jumlah");

                // Mengatur teks pada label sesuai dengan nama fakultas
                switch (namaFakultas) {
                    case "fisip":
                        jumlahfisip.setText(String.valueOf(jumlah));
                        break;
                    case "fasilkom":
                        jumlahfasilkom.setText(String.valueOf(jumlah));
                        break;
                    case "feb":
                        jumlahfeb.setText(String.valueOf(jumlah));
                        break;
                    case "fad":
                        jumlahfad.setText(String.valueOf(jumlah));
                        break;
                    case "faperta":
                        jumlahfaperta.setText(String.valueOf(jumlah));
                        break;
                    case "hukum":
                        jumlahhukum.setText(String.valueOf(jumlah));
                        break;
                    case "kedokteran":
                        jumlahkedokteran.setText(String.valueOf(jumlah));
                        break;
                    case "teknik":
                        jumlahteknik.setText(String.valueOf(jumlah));
                        break;
                    default:
                        break;
                }
            }

            // Menutup sumber daya terkait
            rs.close();
            stmt.close();
        }

        // Menutup koneksi
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle exception
    }
}
   
    
private void displayApprovalCount() {
    try {
        // Koneksi ke database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbo", "root", "");

        // Query untuk mendapatkan jumlah data dengan status "setuju"
        String query = "SELECT COUNT(*) AS jumlah_setuju FROM ajuan WHERE status = 'setuju'";

        // Eksekusi query
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // Mendapatkan hasil query
        if (rs.next()) {
            int jumlahSetuju = rs.getInt("jumlah_setuju");
            setujuj.setText(String.valueOf(jumlahSetuju)); // Menampilkan jumlah pada label setujuj

            // Query untuk mendapatkan jumlah total data
            String totalQuery = "SELECT COUNT(*) AS total FROM ajuan";
            Statement totalStmt = conn.createStatement();
            ResultSet totalRs = totalStmt.executeQuery(totalQuery);
            double total = 0;
            if (totalRs.next()) {
                total = totalRs.getDouble("total");
            }

            // Menghitung persentase
            double percentage = (jumlahSetuju / total) * 100;
            String formattedPercentage = String.format("%.2f%%", percentage);
            setujup.setText(formattedPercentage); // Menampilkan persentase pada label setujub

            // Menutup sumber daya terkait
            totalRs.close();
            totalStmt.close();
        }

        // Menutup sumber daya terkait
        rs.close();
        stmt.close();
        conn.close(); // Menutup koneksi
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle exception
    }
}

private void displayRejectedCount() {
    try {
        // Koneksi ke database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbo", "root", "");

        // Query untuk mendapatkan jumlah data dengan status "setuju"
        String query = "SELECT COUNT(*) AS jumlah_setuju FROM ajuan WHERE status = 'tolak'";

        // Eksekusi query
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // Mendapatkan hasil query
        if (rs.next()) {
            int jumlahSetuju = rs.getInt("jumlah_setuju");
            jumlahtolak.setText(String.valueOf(jumlahSetuju)); // Menampilkan jumlah pada label setujuj

            // Query untuk mendapatkan jumlah total data
            String totalQuery = "SELECT COUNT(*) AS total FROM ajuan";
            Statement totalStmt = conn.createStatement();
            ResultSet totalRs = totalStmt.executeQuery(totalQuery);
            double total = 0;
            if (totalRs.next()) {
                total = totalRs.getDouble("total");
            }

            // Menghitung persentase
            double percentage = (jumlahSetuju / total) * 100;
            String formattedPercentage = String.format("%.2f%%", percentage);
            persentolak.setText(formattedPercentage); // Menampilkan persentase pada label setujub

            // Menutup sumber daya terkait
            totalRs.close();
            totalStmt.close();
        }

        // Menutup sumber daya terkait
        rs.close();
        stmt.close();
        conn.close(); // Menutup koneksi
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle exception
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dashboard;
    private javax.swing.JLabel dashboard1;
    private javax.swing.JLabel dashboard2;
    private javax.swing.JLabel dashboard3;
    private javax.swing.JLabel dashboard4;
    private javax.swing.JPanel dashboardpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jumlahfad;
    private javax.swing.JLabel jumlahfaperta;
    private javax.swing.JLabel jumlahfasilkom;
    private javax.swing.JLabel jumlahfeb;
    private javax.swing.JLabel jumlahfisip;
    private javax.swing.JLabel jumlahhukum;
    private javax.swing.JLabel jumlahkedokteran;
    private javax.swing.JLabel jumlahteknik;
    private javax.swing.JLabel jumlahtolak;
    private javax.swing.JPanel pdashboard;
    private javax.swing.JPanel pdashboard1;
    private javax.swing.JPanel pdashboard2;
    private javax.swing.JPanel pdashboard3;
    private javax.swing.JPanel pdashboard4;
    private javax.swing.JLabel persentolak;
    private javax.swing.JLabel setujuj;
    private javax.swing.JLabel setujup;
    // End of variables declaration//GEN-END:variables
}
