package data;

import component_login_register.Login;
import Dashboard_admin.Dashboard;
import proses.Penghitungan;

import DB.DatabaseModel;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class DataPeringkat extends javax.swing.JFrame {

    public DataPeringkat() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadDataMahasiswaLolos();
        loadDataMahasiswaTidakLolos();
    }
    
    // Method untuk memuat data mahasiswa yang lolos.
    private void loadDataMahasiswaLolos() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        try {
            Connection conn = DatabaseModel.getConnection();
            String sql = "SELECT m.NPM, m.Nama, d1.bobot AS K1, d2.bobot AS K2, d3.bobot AS K3, d4.bobot AS K4, d5.bobot AS K5, d6.bobot AS K6, r.nilai AS `Nilai Total`, r.ranking AS `Ranking` " +
                    "FROM mahasiswa m " +
                    "LEFT JOIN datakriteria d1 ON m.id_account = d1.id_account AND d1.id_kriteria = 1 " +
                    "LEFT JOIN datakriteria d2 ON m.id_account = d2.id_account AND d2.id_kriteria = 2 " +
                    "LEFT JOIN datakriteria d3 ON m.id_account = d3.id_account AND d3.id_kriteria = 3 " +
                    "LEFT JOIN datakriteria d4 ON m.id_account = d4.id_account AND d4.id_kriteria = 4 " +
                    "LEFT JOIN datakriteria d5 ON m.id_account = d5.id_account AND d5.id_kriteria = 5 " +
                    "LEFT JOIN datakriteria d6 ON m.id_account = d6.id_account AND d6.id_kriteria = 6 " +
                    "LEFT JOIN ranking r ON m.NPM = r.npm " +
                    "WHERE r.status = 1 " + // Hanya tampilkan data dengan status = 1 yang artinya lolos.
                    "ORDER BY r.ranking ASC"; // Urutkan data dari terkecil hingga terbesar.

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            int rank = 1; // memanggil peringkat 1

            while (rs.next()) {
                String npm = rs.getString("NPM");
                String nama = rs.getString("Nama");
                double k1 = rs.getDouble("K1");
                double k2 = rs.getDouble("K2");
                double k3 = rs.getDouble("K3");
                double k4 = rs.getDouble("K4");
                double k5 = rs.getDouble("K5");
                double k6 = rs.getDouble("K6");
                double nilaiTotal = rs.getDouble("Nilai Total");

                model.addRow(new Object[]{npm, nama, k1, k2, k3, k4, k5, k6, nilaiTotal, rank});

                rank++;
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data mahasiswa: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Method untuk memuat data mahasiswa yang tidak lolos.
    private void loadDataMahasiswaTidakLolos() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

        try {
            Connection conn = DatabaseModel.getConnection();
            String sql = "SELECT m.NPM, m.Nama, d1.bobot AS K1, d2.bobot AS K2, d3.bobot AS K3, d4.bobot AS K4, d5.bobot AS K5, d6.bobot AS K6, r.nilai AS `Nilai Total`, r.ranking AS `Ranking` " +
                    "FROM mahasiswa m " +
                    "LEFT JOIN datakriteria d1 ON m.id_account = d1.id_account AND d1.id_kriteria = 1 " +
                    "LEFT JOIN datakriteria d2 ON m.id_account = d2.id_account AND d2.id_kriteria = 2 " +
                    "LEFT JOIN datakriteria d3 ON m.id_account = d3.id_account AND d3.id_kriteria = 3 " +
                    "LEFT JOIN datakriteria d4 ON m.id_account = d4.id_account AND d4.id_kriteria = 4 " +
                    "LEFT JOIN datakriteria d5 ON m.id_account = d5.id_account AND d5.id_kriteria = 5 " +
                    "LEFT JOIN datakriteria d6 ON m.id_account = d6.id_account AND d6.id_kriteria = 6 " +
                    "LEFT JOIN ranking r ON m.NPM = r.npm " +
                    "WHERE r.status = 0 " + // Hanya tampilkan data dengan status = 0 yang artinya tidak lolos.
                    "ORDER BY r.ranking ASC"; // Urutkan data dari terkecil hingga terbesar.

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            int rank = getJumlahPenerimaBeasiswa() + 1; // Memulai urutan peringkat dari yang lolos.

            while (rs.next()) {
                String npm = rs.getString("NPM");
                String nama = rs.getString("Nama");
                double k1 = rs.getDouble("K1");
                double k2 = rs.getDouble("K2");
                double k3 = rs.getDouble("K3");
                double k4 = rs.getDouble("K4");
                double k5 = rs.getDouble("K5");
                double k6 = rs.getDouble("K6");
                double nilaiTotal = rs.getDouble("Nilai Total"); // Ambil nilai total

                model.addRow(new Object[]{npm, nama, k1, k2, k3, k4, k5, k6, nilaiTotal, rank});

                rank++;
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data mahasiswa yang tidak lolos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Method untuk mencari jumlah mahasiswa yang lolos.
    private int getJumlahPenerimaBeasiswa() {
        int jumlah = 0;
        try {
            Connection conn = DatabaseModel.getConnection();
            String sql = "SELECT COUNT(*) AS jumlah FROM ranking WHERE status = 1";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                jumlah = rs.getInt("jumlah");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil jumlah penerima beasiswa: " + e.getMessage());
            e.printStackTrace();
        }
        return jumlah;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dataperingkatButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        dashboardButton = new javax.swing.JButton();
        editkriteriaButton = new javax.swing.JButton();
        datamahasiswaButton = new javax.swing.JButton();
        penghitunganButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

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

        jPanel3.setBackground(new java.awt.Color(0, 180, 216));

        dataperingkatButton.setBackground(new java.awt.Color(72, 202, 228));
        dataperingkatButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        dataperingkatButton.setForeground(new java.awt.Color(0, 0, 0));
        dataperingkatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Peringkat.png"))); // NOI18N
        dataperingkatButton.setText("Data Peringkat");
        dataperingkatButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        dataperingkatButton.setBorderPainted(false);
        dataperingkatButton.setContentAreaFilled(false);
        dataperingkatButton.setIconTextGap(10);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataperingkatButton, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dataperingkatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        datamahasiswaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datamahasiswaButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editkriteriaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dashboardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(datamahasiswaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(penghitunganButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(editkriteriaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datamahasiswaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(penghitunganButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATA PERINGKAT");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setPreferredSize(new java.awt.Dimension(691, 4));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data Mahasiswa Lolos Beasiswa");

        jTable1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NPM", "Nama", "K1", "K2", "K3", "K4", "K5", "K6", "Nilai Total", "Ranking"
            }
        ));
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(80);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(2).setMinWidth(40);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(3).setMinWidth(50);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(5).setMinWidth(50);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(6).setMinWidth(50);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(7).setMinWidth(50);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(9).setMinWidth(30);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Data Mahasiswa Tidak Lolos Beasiswa");

        jTable2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NPM", "Nama", "K1", "K2", "K3", "K4", "K5", "K6", "Nilai Total", "Ranking"
            }
        ));
        jTable2.setRowHeight(25);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(80);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(80);
            jTable2.getColumnModel().getColumn(2).setMinWidth(40);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(40);
            jTable2.getColumnModel().getColumn(3).setMinWidth(50);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(5).setMinWidth(50);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(5).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(6).setMinWidth(50);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(6).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(7).setMinWidth(50);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(7).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(9).setMinWidth(30);
            jTable2.getColumnModel().getColumn(9).setPreferredWidth(30);
            jTable2.getColumnModel().getColumn(9).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        Login LoginPage = new Login();
        LoginPage.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

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

    private void datamahasiswaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datamahasiswaButtonActionPerformed
        DataMahasiswa DataMahasiswaPage = new DataMahasiswa();
        DataMahasiswaPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_datamahasiswaButtonActionPerformed

    private void penghitunganButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penghitunganButtonActionPerformed
        Penghitungan PenghitunganPage = new Penghitungan();
        PenghitunganPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_penghitunganButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DataPeringkat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPeringkat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPeringkat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPeringkat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPeringkat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton datamahasiswaButton;
    private javax.swing.JButton dataperingkatButton;
    private javax.swing.JButton editkriteriaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton penghitunganButton;
    // End of variables declaration//GEN-END:variables
}
