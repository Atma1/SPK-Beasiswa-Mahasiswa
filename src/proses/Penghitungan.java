package proses;

import component_login_register.Login;
import Dashboard_admin.Dashboard;
import data.Kriteria;
import data.DataMahasiswa;
import data.DataPeringkat;

import DB.DatabaseModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Penghitungan extends javax.swing.JFrame {
    
    // Membuat objek bobot yang diambil dari database.
    private final double[] BOBOT = mengambilBobot();
    
    // Boolean flags
    private boolean isNormalized = false;
    private boolean isRanked = false;

    public Penghitungan() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    // Metode untuk mengambil Bobot pada tabel kriteria.
    private double[] mengambilBobot() {
        double[] bobot = new double[6]; // sesuaikan dengan jumlah kriteria
        try (Connection conn = DatabaseModel.getConnection();
             Statement stmt = conn.createStatement()) {
            String query = "SELECT bobot FROM kriteria ORDER BY id";
            ResultSet rs = stmt.executeQuery(query);
            int index = 0;
            while (rs.next()) {
                bobot[index++] = rs.getDouble("bobot");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bobot;
    }
    
    // Metode untuk mengambil data pada database.
    private ArrayList<Object[]> mengambilData() {
        ArrayList<Object[]> dataList = new ArrayList<>();
        try (Connection conn = DatabaseModel.getConnection();
             Statement stmt = conn.createStatement()) {
            
            String query = "SELECT m.npm, m.nama, " +
                           "dk1.bobot AS K1, dk2.bobot AS K2, dk3.bobot AS K3, " +
                           "dk4.bobot AS K4, dk5.bobot AS K5, dk6.bobot AS K6 " +
                           "FROM mahasiswa m " +
                           "JOIN datakriteria dk1 ON m.id_account = dk1.id_account AND dk1.id_kriteria = 1 " +
                           "JOIN datakriteria dk2 ON m.id_account = dk2.id_account AND dk2.id_kriteria = 2 " +
                           "JOIN datakriteria dk3 ON m.id_account = dk3.id_account AND dk3.id_kriteria = 3 " +
                           "JOIN datakriteria dk4 ON m.id_account = dk4.id_account AND dk4.id_kriteria = 4 " +
                           "JOIN datakriteria dk5 ON m.id_account = dk5.id_account AND dk5.id_kriteria = 5 " +
                           "JOIN datakriteria dk6 ON m.id_account = dk6.id_account AND dk6.id_kriteria = 6";
            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dataList.add(new Object[] {
                    rs.getString("npm"),
                    rs.getString("nama"),
                    rs.getDouble("K1"),
                    rs.getDouble("K2"),
                    rs.getDouble("K3"),
                    rs.getDouble("K4"),
                    rs.getDouble("K5"),
                    rs.getDouble("K6")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
    
    // Metode penghitungan normalisasi berdasarkan metode SAW.
    private ArrayList<Object[]> normalisasiData(ArrayList<Object[]> dataList) {
        double[] maxValues = new double[6];
        double[] minValues = new double[6];
        for (int i = 0; i < 6; i++) {
            minValues[i] = Double.MAX_VALUE;
        }

        for (Object[] row : dataList) {
            for (int i = 2; i <= 7; i++) {
                maxValues[i - 2] = Math.max(maxValues[i - 2], (double) row[i]);
                minValues[i - 2] = Math.min(minValues[i - 2], (double) row[i]);
            }
        }

        ArrayList<Object[]> normalizedDataList = new ArrayList<>();
        for (Object[] row : dataList) {
            Object[] normalizedRow = new Object[8];
            normalizedRow[0] = row[0];
            normalizedRow[1] = row[1];
            for (int i = 2; i <= 7; i++) {
                if (i == 4) {  // K3 adalah cost (semakin rendah bobotnya, maka semakin prioritas).
                    normalizedRow[i] = minValues[i - 2] / (double) row[i];
                } else {
                    normalizedRow[i] = (double) row[i] / maxValues[i - 2];
                }
            }
            normalizedDataList.add(normalizedRow);
        }
        return normalizedDataList;
    }
    
    //Metode untuk menghitung Peringkat Sementara
    private ArrayList<Object[]> hitungSkorAkhirSAW(ArrayList<Object[]> normalizedDataList) {
        ArrayList<Object[]> sawDataList = new ArrayList<>();
        for (Object[] row : normalizedDataList) {
            double score = 0.0;
            for (int i = 2; i <= 7; i++) {
                score += (double) row[i] * BOBOT[i - 2];
            }
            Object[] sawRow = new Object[4];
            sawRow[0] = row[0];
            sawRow[1] = row[1];
            sawRow[2] = score;
            sawDataList.add(sawRow);
        }

        // Mengurutkan nilai total dari terbesar hingga terkecil.
        Collections.sort(sawDataList, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                return Double.compare((double) o2[2], (double) o1[2]);
            }
        });

        // Menetapkan Peringkat Sementara
        for (int i = 0; i < sawDataList.size(); i++) {
            sawDataList.get(i)[3] = i + 1;
        }

        return sawDataList;
    }
    
    // Metode untuk menampilkan data pada jTable1
    private void tampilkanData(ArrayList<Object[]> dataList, javax.swing.JTable table, String[] columnNames) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(columnNames);
        for (Object[] row : dataList) {
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        dataperingkatButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        penghitunganButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        dashboardButton = new javax.swing.JButton();
        editkriteriaButton = new javax.swing.JButton();
        datamahasiswaButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        normalisasiButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        ranktempButton = new javax.swing.JButton();
        publishButton = new javax.swing.JButton();

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

        penghitunganButton.setBackground(new java.awt.Color(72, 202, 228));
        penghitunganButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        penghitunganButton.setForeground(new java.awt.Color(0, 0, 0));
        penghitunganButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Penghitungan.png"))); // NOI18N
        penghitunganButton.setText("Penghitungan");
        penghitunganButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        penghitunganButton.setBorderPainted(false);
        penghitunganButton.setContentAreaFilled(false);
        penghitunganButton.setIconTextGap(10);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penghitunganButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(penghitunganButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataperingkatButton, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editkriteriaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(dashboardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(datamahasiswaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataperingkatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("PENGHITUNGAN");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setPreferredSize(new java.awt.Dimension(691, 4));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tabel Normalisasi");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NPM", "Nama", "K1", "K2", "K3", "K4", "K5", "K6"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        normalisasiButton.setBackground(new java.awt.Color(0, 180, 215));
        normalisasiButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        normalisasiButton.setForeground(java.awt.Color.black);
        normalisasiButton.setText("Mulai Hitung Normalisasi");
        normalisasiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalisasiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addComponent(normalisasiButton)
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(normalisasiButton)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel6.setPreferredSize(new java.awt.Dimension(691, 4));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tabel Peringkat Sementara");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NPM", "Nama", "Nilai Total", "Ranking"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        ranktempButton.setBackground(new java.awt.Color(0, 180, 215));
        ranktempButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        ranktempButton.setForeground(java.awt.Color.black);
        ranktempButton.setText("Cari Peringkat Sementara");
        ranktempButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ranktempButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(ranktempButton)
                .addContainerGap(224, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ranktempButton)
                .addContainerGap())
        );

        publishButton.setBackground(new java.awt.Color(0, 180, 215));
        publishButton.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        publishButton.setForeground(java.awt.Color.black);
        publishButton.setText("Tetapkan Peringkat");
        publishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishButtonActionPerformed(evt);
            }
        });

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(publishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(publishButton)))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dataperingkatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataperingkatButtonActionPerformed
        DataPeringkat DataPeringkatPage = new DataPeringkat();
        DataPeringkatPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dataperingkatButtonActionPerformed

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

    private void normalisasiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalisasiButtonActionPerformed
        ArrayList<Object[]> dataList = mengambilData();
        ArrayList<Object[]> normalizedDataList = normalisasiData(dataList);
        tampilkanData(normalizedDataList, jTable1, new String[] {"NPM", "Nama", "K1", "K2", "K3", "K4", "K5", "K6"});
        isNormalized = true;
    }//GEN-LAST:event_normalisasiButtonActionPerformed

    private void ranktempButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ranktempButtonActionPerformed
        if(!isNormalized) {
            JOptionPane.showMessageDialog(this,"Lakukan normalisasi terlebih dahulu!");
        }
        ArrayList<Object[]> dataList = mengambilData();
        ArrayList<Object[]> normalizedDataList = normalisasiData(dataList);
        ArrayList<Object[]> sawDataList = hitungSkorAkhirSAW(normalizedDataList);
        tampilkanData(sawDataList, jTable2, new String[] {"NPM", "Nama", "Nilai", "Ranking"});
        isRanked = true;
    }//GEN-LAST:event_ranktempButtonActionPerformed

    private void publishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishButtonActionPerformed
        if (!isNormalized || !isRanked) {
            JOptionPane.showMessageDialog(this, "Lakukan normalisasi dan penetapan ranking sementara terlebih dahulu!");
            return;
        }

        // Tampilkan dialog konfirmasi
        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mempublish hasil penghitungan?", "Konfirmasi Publish", JOptionPane.YES_NO_OPTION);

        // Jika pengguna memilih "No", batalkan operasi
        if (response == JOptionPane.NO_OPTION) {
            return;
        }

        ArrayList<Object[]> dataList = mengambilData();
        ArrayList<Object[]> sawDataList = hitungSkorAkhirSAW(normalisasiData(dataList));

        memasukkanData(sawDataList);

        JOptionPane.showMessageDialog(this, "Data peringkat berhasil ditetapkan dan sudah terpublish kepada mahasiswa.");
    }//GEN-LAST:event_publishButtonActionPerformed
    
    // Metode untuk memasukkan data pada Peringkat Sementara ke Database.
    private void memasukkanData(ArrayList<Object[]> sawDataList) {
        try (Connection conn = DatabaseModel.getConnection()) {
            for (Object[] row : sawDataList) {
                if (dataTersedia(conn, (String) row[0])) {
                    updateData(conn, row);
                } else {
                    tambahData(conn, row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Metode untuk mengecek apakah data dengan NPM yang sama sudah ada di tabel ranking.
    private boolean dataTersedia(Connection conn, String npm) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM ranking WHERE npm = ?")) {
            pstmt.setString(1, npm);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        }
    }
    
    // Metode untuk pembaharuan data jika data NPM ada yang sama di tabel ranking.
    private void updateData(Connection conn, Object[] row) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("UPDATE ranking SET nilai = ?, ranking = ?, status = ? WHERE npm = ?")) {
            pstmt.setDouble(1, (double) row[2]); // Nilai total
            pstmt.setInt(2, (int) row[3]); // Ranking

            // Set status based on ranking
            if ((int) row[3] <= 20) {
                pstmt.setInt(3, 1); // Status = 1 untuk mahasiswa yang lolos.
            } else {
                pstmt.setInt(3, 0); // Status = 0 untuk mahasiswa yang tidak lolos.
            }

            pstmt.setString(4, (String) row[0]); // NPM

            pstmt.executeUpdate();
        }
    }

    // Metode untuk penambahan data jika data NPM tidak ada yang sama di tabel ranking.
    private void tambahData(Connection conn, Object[] row) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ranking (npm, nama, nilai, ranking, status) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, (String) row[0]); // NPM
            pstmt.setString(2, (String) row[1]); // Nama
            pstmt.setDouble(3, (double) row[2]); // Nilai total
            pstmt.setInt(4, (int) row[3]); // Ranking

            // Set status based on ranking
            if ((int) row[3] <= 20) {
                pstmt.setInt(5, 1); // Status = 1 untuk mahasiswa yang lolos.
            } else {
                pstmt.setInt(5, 0); // Status = 0 untuk mahasiswa yang tidak lolos.
            }

            pstmt.executeUpdate();
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
            java.util.logging.Logger.getLogger(Penghitungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penghitungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penghitungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penghitungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penghitungan().setVisible(true);
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
    private javax.swing.JButton normalisasiButton;
    private javax.swing.JButton penghitunganButton;
    private javax.swing.JButton publishButton;
    private javax.swing.JButton ranktempButton;
    // End of variables declaration//GEN-END:variables
}
