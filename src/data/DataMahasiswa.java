package data;

import component_login_register.Login;
import Dashboard_admin.Dashboard;
import proses.Penghitungan;
import javax.swing.JFrame;
import DB.DatabaseModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

public class DataMahasiswa extends javax.swing.JFrame {

    public DataMahasiswa() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadDataMahasiswa();
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTable1.getSelectedRow();
                if (row != -1) {
                    String npm = jTable1.getValueAt(row, 1).toString();
                    String nama = jTable1.getValueAt(row, 2).toString();
                    String bobotK1 = jTable1.getValueAt(row, 3).toString();
                    String bobotK2 = jTable1.getValueAt(row, 4).toString();
                    String bobotK3 = jTable1.getValueAt(row, 5).toString();
                    String bobotK4 = jTable1.getValueAt(row, 6).toString();
                    String bobotK5 = jTable1.getValueAt(row, 7).toString();
                    String bobotK6 = jTable1.getValueAt(row, 8).toString();

                    jTextField1.setText(npm);
                    jTextField2.setText(nama);
                    jTextField3.setText(bobotK1);
                    jTextField4.setText(bobotK2);
                    jTextField5.setText(bobotK3);
                    jTextField6.setText(bobotK4);
                    jTextField7.setText(bobotK5);
                    jTextField8.setText(bobotK6);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        penghitunganButton = new javax.swing.JButton();
        dataperingkatButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        datamahasiswaButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        dashboardButton = new javax.swing.JButton();
        editkriteriaButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        docK1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        docK2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        docK3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        docK4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        docK5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        docK6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 119, 182));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Logo-small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBackground(new java.awt.Color(72, 202, 228));
        jPanel1.setPreferredSize(new java.awt.Dimension(225, 790));

        penghitunganButton.setBackground(new java.awt.Color(72, 202, 228));
        penghitunganButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        penghitunganButton.setForeground(new java.awt.Color(0, 0, 0));
        penghitunganButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Penghitungan.png"))); // NOI18N
        penghitunganButton.setText("Penghitungan");
        penghitunganButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        penghitunganButton.setBorderPainted(false);
        penghitunganButton.setContentAreaFilled(false);
        penghitunganButton.setIconTextGap(10);
        penghitunganButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penghitunganButtonActionPerformed(evt);
            }
        });

        dataperingkatButton.setBackground(new java.awt.Color(72, 202, 228));
        dataperingkatButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        dataperingkatButton.setForeground(new java.awt.Color(0, 0, 0));
        dataperingkatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Peringkat.png"))); // NOI18N
        dataperingkatButton.setText("Data Peringkat");
        dataperingkatButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        dataperingkatButton.setBorderPainted(false);
        dataperingkatButton.setContentAreaFilled(false);
        dataperingkatButton.setIconTextGap(10);
        dataperingkatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataperingkatButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 180, 216));

        datamahasiswaButton.setBackground(new java.awt.Color(72, 202, 228));
        datamahasiswaButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        datamahasiswaButton.setForeground(new java.awt.Color(0, 0, 0));
        datamahasiswaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/DataMahasiswa.png"))); // NOI18N
        datamahasiswaButton.setText("Data Mahasiswa");
        datamahasiswaButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        datamahasiswaButton.setBorderPainted(false);
        datamahasiswaButton.setContentAreaFilled(false);
        datamahasiswaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        datamahasiswaButton.setIconTextGap(15);
        datamahasiswaButton.setPreferredSize(new java.awt.Dimension(75, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datamahasiswaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(datamahasiswaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(3, 4, 94));

        logoutButton.setBackground(new java.awt.Color(3, 4, 94));
        logoutButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/logout.png"))); // NOI18N
        logoutButton.setText("Log Out");
        logoutButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setIconTextGap(10);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dashboardButton.setBackground(new java.awt.Color(0, 180, 216));
        dashboardButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        dashboardButton.setForeground(new java.awt.Color(0, 0, 0));
        dashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/home.png"))); // NOI18N
        dashboardButton.setText("Dashboard");
        dashboardButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        dashboardButton.setBorderPainted(false);
        dashboardButton.setContentAreaFilled(false);
        dashboardButton.setFocusPainted(false);
        dashboardButton.setIconTextGap(20);
        dashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardButtonActionPerformed(evt);
            }
        });

        editkriteriaButton.setBackground(new java.awt.Color(72, 202, 228));
        editkriteriaButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        editkriteriaButton.setForeground(new java.awt.Color(0, 0, 0));
        editkriteriaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/EditKriteria.png"))); // NOI18N
        editkriteriaButton.setText("Edit Kriteria");
        editkriteriaButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        editkriteriaButton.setBorderPainted(false);
        editkriteriaButton.setContentAreaFilled(false);
        editkriteriaButton.setIconTextGap(20);
        editkriteriaButton.setPreferredSize(new java.awt.Dimension(147, 30));
        editkriteriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editkriteriaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(penghitunganButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dataperingkatButton, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editkriteriaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboardButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(editkriteriaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(penghitunganButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataperingkatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("DATA MAHASISWA");

        jPanel4.setBackground(new java.awt.Color(202, 240, 248));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 4, 94), 6));
        jPanel4.setPreferredSize(new java.awt.Dimension(388, 100));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Detail Data Mahasiswa");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(72, 202, 228));
        jTextField1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(72, 202, 228));
        jTextField2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NPM");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nama Mahasiswa");

        cancelButton.setBackground(new java.awt.Color(0, 180, 215));
        cancelButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(0, 0, 0));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/cancel.png"))); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setIconTextGap(10);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(0, 180, 215));
        saveButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 0, 0));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save.png"))); // NOI18N
        saveButton.setText("Simpan");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Kriteria 1");

        jPanel6.setBackground(new java.awt.Color(3, 4, 94));
        jPanel6.setPreferredSize(new java.awt.Dimension(0, 6));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        jTextField3.setBackground(new java.awt.Color(72, 202, 228));
        jTextField3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        docK1.setBackground(new java.awt.Color(0, 180, 215));
        docK1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        docK1.setForeground(new java.awt.Color(0, 0, 0));
        docK1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/doc.png"))); // NOI18N
        docK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docK1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Kriteria 2");

        jTextField4.setBackground(new java.awt.Color(72, 202, 228));
        jTextField4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        docK2.setBackground(new java.awt.Color(0, 180, 215));
        docK2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        docK2.setForeground(new java.awt.Color(0, 0, 0));
        docK2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/doc.png"))); // NOI18N
        docK2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docK2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.black);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Kriteria 3");

        jTextField5.setBackground(new java.awt.Color(72, 202, 228));
        jTextField5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField5.setForeground(java.awt.Color.black);
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        docK3.setBackground(new java.awt.Color(0, 180, 215));
        docK3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        docK3.setForeground(java.awt.Color.black);
        docK3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/doc.png"))); // NOI18N
        docK3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docK3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.black);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Kriteria 4");

        jTextField6.setBackground(new java.awt.Color(72, 202, 228));
        jTextField6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField6.setForeground(java.awt.Color.black);
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        docK4.setBackground(new java.awt.Color(0, 180, 215));
        docK4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        docK4.setForeground(java.awt.Color.black);
        docK4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/doc.png"))); // NOI18N
        docK4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docK4ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.black);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Kriteria 5");

        jTextField7.setBackground(new java.awt.Color(72, 202, 228));
        jTextField7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField7.setForeground(java.awt.Color.black);
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        docK5.setBackground(new java.awt.Color(0, 180, 215));
        docK5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/doc.png"))); // NOI18N
        docK5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docK5ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.black);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Kriteria 6");

        jTextField8.setBackground(new java.awt.Color(72, 202, 228));
        jTextField8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField8.setForeground(java.awt.Color.black);
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        docK6.setBackground(new java.awt.Color(0, 180, 215));
        docK6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        docK6.setForeground(java.awt.Color.black);
        docK6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/doc.png"))); // NOI18N
        docK6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docK6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))))
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6)
                    .addComponent(jTextField7)
                    .addComponent(jTextField8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(docK2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(docK3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(docK4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(docK1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(docK5)
                    .addComponent(docK6))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(docK1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField4)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(docK2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(docK3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField5)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField6)
                    .addComponent(docK4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(docK5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(docK6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "NPM", "Nama", "K1", "K2", "K3", "K4", "K5", "K6"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void penghitunganButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penghitunganButtonActionPerformed
        Penghitungan PenghitunganPage = new Penghitungan();
        PenghitunganPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_penghitunganButtonActionPerformed

    private void dataperingkatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataperingkatButtonActionPerformed
        DataPeringkat DataPeringkatPage = new DataPeringkat();
        DataPeringkatPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dataperingkatButtonActionPerformed

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        Dashboard DashboardPage = new Dashboard();
        DashboardPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void editkriteriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editkriteriaButtonActionPerformed
        Kriteria KriteriaPage = new Kriteria();
        KriteriaPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editkriteriaButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        jTextField1.setText(""); // Reset nilai npm
        jTextField2.setText(""); // Reset nilai nama
        jTextField3.setText(""); // Reset nilai bobot k1
        jTextField4.setText(""); // Reset nilai bobot k2
        jTextField5.setText(""); // Reset nilai bobot k3
        jTextField6.setText(""); // Reset nilai bobot k4
        jTextField7.setText(""); // Reset nilai bobot k5
        jTextField8.setText(""); // Reset nilai bobot k6
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            String idAccount = jTable1.getValueAt(row, 0).toString();
            double k1 = Double.parseDouble(jTextField3.getText());
            double k2 = Double.parseDouble(jTextField4.getText());
            double k3 = Double.parseDouble(jTextField5.getText());
            double k4 = Double.parseDouble(jTextField6.getText());
            double k5 = Double.parseDouble(jTextField7.getText());
            double k6 = Double.parseDouble(jTextField8.getText());

            try {
                Connection conn = DatabaseModel.getConnection();
                String sql = "UPDATE datakriteria SET bobot = ? WHERE id_account = ? AND id_kriteria = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Update bobot untuk setiap kriteria
                pstmt.setDouble(1, k1);
                pstmt.setString(2, idAccount);
                pstmt.setInt(3, 1); // ID kriteria untuk K1
                pstmt.executeUpdate();

                pstmt.setDouble(1, k2);
                pstmt.setString(2, idAccount);
                pstmt.setInt(3, 2); // ID kriteria untuk K2
                pstmt.executeUpdate();

                pstmt.setDouble(1, k3);
                pstmt.setString(2, idAccount);
                pstmt.setInt(3, 3); // ID kriteria untuk K3
                pstmt.executeUpdate();

                pstmt.setDouble(1, k4);
                pstmt.setString(2, idAccount);
                pstmt.setInt(3, 4); // ID kriteria untuk K4
                pstmt.executeUpdate();

                pstmt.setDouble(1, k5);
                pstmt.setString(2, idAccount);
                pstmt.setInt(3, 5); // ID kriteria untuk K5
                pstmt.executeUpdate();

                pstmt.setDouble(1, k6);
                pstmt.setString(2, idAccount);
                pstmt.setInt(3, 6); // ID kriteria untuk K6
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Bobot berhasil diperbarui ke database.");
                loadDataMahasiswa();

                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal memperbarui bobot: " + e.getMessage());
                loadDataMahasiswa();
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data mahasiswa terlebih dahulu.");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void docK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docK1ActionPerformed
        openDocument(1);
    }//GEN-LAST:event_docK1ActionPerformed

    private void docK2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docK2ActionPerformed
        openDocument(2);
    }//GEN-LAST:event_docK2ActionPerformed

    private void docK3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docK3ActionPerformed
        openDocument(3);
    }//GEN-LAST:event_docK3ActionPerformed

    private void docK4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docK4ActionPerformed
        openDocument(4);
    }//GEN-LAST:event_docK4ActionPerformed

    private void docK5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docK5ActionPerformed
        openDocument(5);
    }//GEN-LAST:event_docK5ActionPerformed

    private void docK6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docK6ActionPerformed
        openDocument(6);
    }//GEN-LAST:event_docK6ActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        Login LoginPage = new Login();
        LoginPage.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void loadDataMahasiswa() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Kosongkan tabel sebelum memuat data baru

        try {
            Connection conn = DatabaseModel.getConnection();
            String sql = "SELECT m.NPM, m.Nama, d1.bobot AS K1, d2.bobot AS K2, d3.bobot AS K3, d4.bobot AS K4, d5.bobot AS K5, d6.bobot AS K6, m.id_account " +
                         "FROM mahasiswa m " +
                         "LEFT JOIN datakriteria d1 ON m.id_account = d1.id_account AND d1.id_kriteria = 1 " +
                         "LEFT JOIN datakriteria d2 ON m.id_account = d2.id_account AND d2.id_kriteria = 2 " +
                         "LEFT JOIN datakriteria d3 ON m.id_account = d3.id_account AND d3.id_kriteria = 3 " +
                         "LEFT JOIN datakriteria d4 ON m.id_account = d4.id_account AND d4.id_kriteria = 4 " +
                         "LEFT JOIN datakriteria d5 ON m.id_account = d5.id_account AND d5.id_kriteria = 5 " +
                         "LEFT JOIN datakriteria d6 ON m.id_account = d6.id_account AND d6.id_kriteria = 6 ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String npm = rs.getString("NPM");
                String nama = rs.getString("Nama");
                double k1 = rs.getDouble("K1");
                double k2 = rs.getDouble("K2");
                double k3 = rs.getDouble("K3");
                double k4 = rs.getDouble("K4");
                double k5 = rs.getDouble("K5");
                double k6 = rs.getDouble("K6");
                String idAccount = rs.getString("id_account"); // Ambil id_account

                // Tambahkan data ke dalam tabel
                model.addRow(new Object[]{idAccount, npm, nama, k1, k2, k3, k4, k5, k6}); // Tambahkan id_account ke dalam tabel
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data mahasiswa: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void openDocument(int idKriteria) {
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            String idAccount = jTable1.getValueAt(row, 0).toString();

            try {
                DatabaseModel db = new DatabaseModel();
                Connection connection = db.getConnection();
                String query = "SELECT dokumen FROM datakriteria WHERE id_account = ? AND id_kriteria = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, idAccount);
                statement.setInt(2, idKriteria);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    byte[] fileBytes = resultSet.getBytes("dokumen");

                    // Buat file sementara untuk menyimpan data PDF
                    File tempFile = File.createTempFile("Kriteria" + idKriteria, ".pdf");
                    try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                        fos.write(fileBytes);
                    }

                    // Buka file PDF menggunakan aplikasi default
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(tempFile);
                    } else {
                        JOptionPane.showMessageDialog(this, "Tidak ada aplikasi yang support!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Dokumen tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal memuat dokumen!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data mahasiswa terlebih dahulu.");
        }
    }
    
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
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton datamahasiswaButton;
    private javax.swing.JButton dataperingkatButton;
    private javax.swing.JButton docK1;
    private javax.swing.JButton docK2;
    private javax.swing.JButton docK3;
    private javax.swing.JButton docK4;
    private javax.swing.JButton docK5;
    private javax.swing.JButton docK6;
    private javax.swing.JButton editkriteriaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton penghitunganButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
