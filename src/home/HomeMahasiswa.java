package home;

import component_login_register.Login;
import DB.DatabaseModel;
import form.FormDataDiri;
import form.LengkapiDokumen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class HomeMahasiswa extends javax.swing.JFrame {
    
    private int idAccount;
    private String npm;

    public HomeMahasiswa(int idAccount) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.idAccount = idAccount;
        namaMahasiswa();
        cekStatusBeasiswa();
    }
    
    private void namaMahasiswa(){
        try (Connection conn = DatabaseModel.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT m.nama FROM account a INNER JOIN mahasiswa m ON a.id = m.id_account WHERE a.id = ?");
        ) {
            pstmt.setInt(1, idAccount);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String namaMahasiswa = rs.getString("nama");
                namamahasiswaLabel.setText(namaMahasiswa);
            } else {
                namamahasiswaLabel.setText("Isi terlebih dahulu Data Diri Anda!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cekStatusBeasiswa() {
        try (Connection conn = DatabaseModel.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT m.npm FROM account a INNER JOIN mahasiswa m ON a.id = m.id_account WHERE a.id = ?");
        ) {
            pstmt.setInt(1, idAccount);
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                statusbeasiswaLabel.setText("Dalam Proses Seleksi");
            } else {
                npm = rs.getString("npm");
                cekPeringkat();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cekPeringkat() {
        try (Connection conn = DatabaseModel.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT status FROM ranking WHERE npm = ?");
        ) {
            pstmt.setString(1, npm);
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                statusbeasiswaLabel.setText("Dalam Proses Seleksi");
            } else {
                int status = rs.getInt("status");
                if (status == 1) { // Jika status = 1, pengguna lolos seleksi
                    statusbeasiswaLabel.setText("Selamat Anda Lolos Seleksi Beasiswa!");
                } else {
                    statusbeasiswaLabel.setText("Anda Belum Lolos Seleksi Beasiswa!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        datadiriButton = new javax.swing.JButton();
        lengkapidokumenButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        statusbeasiswaLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namamahasiswaLabel = new javax.swing.JLabel();

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

        datadiriButton.setBackground(new java.awt.Color(72, 202, 228));
        datadiriButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        datadiriButton.setForeground(new java.awt.Color(0, 0, 0));
        datadiriButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/profile.png"))); // NOI18N
        datadiriButton.setText("Data Diri");
        datadiriButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        datadiriButton.setBorderPainted(false);
        datadiriButton.setContentAreaFilled(false);
        datadiriButton.setIconTextGap(20);
        datadiriButton.setPreferredSize(new java.awt.Dimension(147, 30));
        datadiriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datadiriButtonActionPerformed(evt);
            }
        });

        lengkapidokumenButton.setBackground(new java.awt.Color(72, 202, 228));
        lengkapidokumenButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lengkapidokumenButton.setForeground(new java.awt.Color(0, 0, 0));
        lengkapidokumenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/doc.png"))); // NOI18N
        lengkapidokumenButton.setText("Lengkapi Dokumen");
        lengkapidokumenButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        lengkapidokumenButton.setBorderPainted(false);
        lengkapidokumenButton.setContentAreaFilled(false);
        lengkapidokumenButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lengkapidokumenButton.setIconTextGap(15);
        lengkapidokumenButton.setPreferredSize(new java.awt.Dimension(75, 30));
        lengkapidokumenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lengkapidokumenButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 180, 216));

        jButton1.setBackground(new java.awt.Color(0, 180, 216));
        jButton1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/home.png"))); // NOI18N
        jButton1.setText("Home");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setIconTextGap(20);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(datadiriButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lengkapidokumenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datadiriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lengkapidokumenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SELEKSI BEASISWA UPN \"VETERAN\" JAWA TIMUR");

        statusbeasiswaLabel.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        statusbeasiswaLabel.setForeground(java.awt.Color.black);
        statusbeasiswaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusbeasiswaLabel.setText("Anda Belum Lolos Beasiswa UPN \"Veteran\" Jawa Timur");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Selamat Datang!");

        namamahasiswaLabel.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        namamahasiswaLabel.setForeground(java.awt.Color.black);
        namamahasiswaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namamahasiswaLabel.setText("Gevanno Pascal Yohanes Putra Suwandik Harfianto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1418, Short.MAX_VALUE)
                    .addComponent(statusbeasiswaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namamahasiswaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(namamahasiswaLabel)
                        .addGap(28, 28, 28)
                        .addComponent(statusbeasiswaLabel)
                        .addContainerGap(331, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datadiriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datadiriButtonActionPerformed
        this.dispose();
        FormDataDiri FormDataDiriPage = new FormDataDiri(idAccount);
        FormDataDiriPage.setVisible(true);
    }//GEN-LAST:event_datadiriButtonActionPerformed

    private void lengkapidokumenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lengkapidokumenButtonActionPerformed
        this.dispose();
        LengkapiDokumen LengkapiDokumenPage = new LengkapiDokumen(idAccount);
        LengkapiDokumenPage.setVisible(true);
    }//GEN-LAST:event_lengkapidokumenButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        Login LoginPage = new Login();
        LoginPage.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton datadiriButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton lengkapidokumenButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel namamahasiswaLabel;
    private javax.swing.JLabel statusbeasiswaLabel;
    // End of variables declaration//GEN-END:variables
}
