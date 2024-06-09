package form;

import component_login_register.Login;
import home.HomeMahasiswa;
import DB.DatabaseModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class FormDataDiri extends javax.swing.JFrame {
    
    private int idAccount;

    public FormDataDiri(int idAccount) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.idAccount = idAccount;
        mengambilDataDiri();
    }
    
    // Method untuk mengambil data diri jika pada database sudah ada data.
    private void mengambilDataDiri() {
        Connection conn = DatabaseModel.getConnection();

        // Mengambil data diri berdasarkan idAccount.
        String sql = "SELECT * FROM mahasiswa WHERE id_account = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idAccount);
            ResultSet rs = pstmt.executeQuery();

            // Jika data ditemukan, mengganti inputan menjadi text yang ada di database.
            if (rs.next()) {
                String nama = rs.getString("nama");
                String npm = rs.getString("npm");
                String jeniskelamin = rs.getString("jeniskelamin");
                String alamat = rs.getString("alamat");
                String fakultas = rs.getString("fakultas");
                String prodi = rs.getString("prodi");
                
                jTextField1.setText(npm);
                jTextField2.setText(nama);
                jComboBox3.setSelectedItem(jeniskelamin);
                jTextArea1.setText(alamat);
                jComboBox1.setSelectedItem(fakultas);
                jComboBox2.setSelectedItem(prodi);
                
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil data diri: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lengkapidokumenButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        datadiriButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        savedataButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datadiriButton, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(datadiriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        homeButton.setBackground(new java.awt.Color(0, 180, 216));
        homeButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        homeButton.setForeground(new java.awt.Color(0, 0, 0));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/home.png"))); // NOI18N
        homeButton.setText("Home");
        homeButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        homeButton.setIconTextGap(20);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lengkapidokumenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lengkapidokumenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(202, 240, 248));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATA DIRI MAHASISWA");

        savedataButton.setBackground(new java.awt.Color(0, 180, 215));
        savedataButton.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        savedataButton.setForeground(java.awt.Color.black);
        savedataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save-data.png"))); // NOI18N
        savedataButton.setText("Simpan Data");
        savedataButton.setIconTextGap(10);
        savedataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savedataButtonActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(144, 224, 239));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("NPM :");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setText("Nama Lengkap :");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.black);
        jLabel5.setText("Jenis Kelamin :");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setText("Alamat :");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("Fakultas :");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.black);
        jLabel8.setText("Program Studi :");

        jTextField1.setBackground(new java.awt.Color(72, 202, 228));
        jTextField1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jTextField1.setForeground(java.awt.Color.black);
        jTextField1.setPreferredSize(new java.awt.Dimension(94, 27));

        jTextField2.setBackground(new java.awt.Color(72, 202, 228));
        jTextField2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jTextField2.setForeground(java.awt.Color.black);

        jTextArea1.setBackground(new java.awt.Color(72, 202, 228));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextArea1.setForeground(java.awt.Color.black);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jComboBox2.setBackground(new java.awt.Color(72, 202, 228));
        jComboBox2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jComboBox2.setForeground(java.awt.Color.black);
        jComboBox2.setMaximumRowCount(28);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Akuntansi", "Manajemen", "Ekonomi Pembangunan", "Kewirausahaan", "Agroteknologi", "Agribisnis", "Teknik Kimia", "Teknik Industri", "Teknologi Pangan", "Teknik Lingkungan", "Teknik Sipil", "Teknik Mesin", "Fisika", "Administrasi Publik", "Administrasi Bisnis", "Ilmu Komunikasi", "Ilmu Hubungan Internasional", "Pariwisata", "Linguistik Indonesia", "Arsitektur", "Desain Komunikasi Visual", "Desain Interior", "Informatika", "Sistem Informasi", "Data Sains", "Bisnis Digital", "Ilmu Hukum", "Sarjana Kedokteran" }));
        jComboBox2.setToolTipText("Pilih Program Studi Anda");

        jComboBox1.setBackground(new java.awt.Color(72, 202, 228));
        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jComboBox1.setForeground(java.awt.Color.black);
        jComboBox1.setMaximumRowCount(8);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ekonomi dan Bisnis", "Pertanian", "Teknik", "Ilmu Sosial dan Ilmu Politik", "Arsitektur dan Desain", "Ilmu Komputer", "Hukum", "Kedokteran" }));

        jComboBox3.setBackground(new java.awt.Color(72, 202, 228));
        jComboBox3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jComboBox3.setForeground(java.awt.Color.black);
        jComboBox3.setMaximumRowCount(2);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addGap(122, 122, 122))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(43, 43, 43)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jComboBox2, 0, 351, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(590, Short.MAX_VALUE)
                        .addComponent(savedataButton)
                        .addGap(0, 590, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(395, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(395, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(savedataButton)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lengkapidokumenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lengkapidokumenButtonActionPerformed
        this.dispose();
        LengkapiDokumen LengkapiDokumenPage = new LengkapiDokumen(idAccount);
        LengkapiDokumenPage.setVisible(true);
    }//GEN-LAST:event_lengkapidokumenButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        this.dispose();
        HomeMahasiswa HomeMahasiswaPage = new HomeMahasiswa(idAccount);
        HomeMahasiswaPage.setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        Login LoginPage = new Login();
        LoginPage.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void savedataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savedataButtonActionPerformed
        // Tangkap teks
        String npm = jTextField1.getText();
        String nama = jTextField2.getText();
        String jeniskelamin = (String) jComboBox3.getSelectedItem();
        String alamat = jTextArea1.getText();
        String fakultas = (String) jComboBox1.getSelectedItem();
        String prodi = (String) jComboBox2.getSelectedItem();

        Connection conn = DatabaseModel.getConnection();

        // Memeriksa data diri dalam database.
        String checkSql = "SELECT * FROM mahasiswa WHERE id_account = ?";
        try {
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, idAccount);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Jika data sudah ada, lakukan update data.
                String updateSql = "UPDATE mahasiswa SET nama = ?, npm = ?, jeniskelamin = ?, alamat = ?, fakultas = ?, prodi = ? WHERE id_account = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setString(1, nama);
                updateStmt.setString(2, npm);
                updateStmt.setString(3, jeniskelamin);
                updateStmt.setString(4, alamat);
                updateStmt.setString(5, fakultas);
                updateStmt.setString(6, prodi);
                updateStmt.setInt(7, idAccount);
                updateStmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
                updateStmt.close();
            } else {
                // Jika data belum ada, lakukan tambah data.
                String insertSql = "INSERT INTO mahasiswa (id_account, nama, npm, jeniskelamin, alamat, fakultas, prodi) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setInt(1, idAccount);
                insertStmt.setString(2, nama);
                insertStmt.setString(3, npm);
                insertStmt.setString(4, jeniskelamin);
                insertStmt.setString(5, alamat);
                insertStmt.setString(6, fakultas);
                insertStmt.setString(7, prodi);
                insertStmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
                insertStmt.close();
            }

            rs.close();
            checkStmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan atau mengupdate data: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_savedataButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton datadiriButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton lengkapidokumenButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton savedataButton;
    // End of variables declaration//GEN-END:variables
}
