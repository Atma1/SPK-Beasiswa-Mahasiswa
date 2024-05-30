package form;

import config.koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class formMhs extends javax.swing.JFrame {

    private Connection conn;
    
    public formMhs() {
        initComponents();
        conn = koneksi.getConnection();
        getData();
        nonAktifButton();
        aktifButton();
        
    }

     private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "Select * From mahasiswa";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                int id                      = rs.getInt("id");
                String npm                  = rs.getNString("npm");
                String nama                 = rs.getNString("nama");
                String jenis_kelamin        = rs.getNString("jenis_kelamin");
                String alamat               = rs.getNString("alamat");
                String prodi                = rs.getNString("prodi");
                String fakultas             = rs.getNString("fakultas");
                
                Object[] rowData = {id,npm,nama,jenis_kelamin,alamat,prodi,fakultas};
                model.addRow(rowData);
            }
            
            rs.close();
            st.close();
        } catch (SQLException e) {
             Logger.getLogger(formMhs.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t_npm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        t_nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        t_jeniskelamin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t_alamat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        t_prodi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        t_fakultas = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        t_search = new javax.swing.JTextField();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Data Mahasiswa");

        jLabel2.setText("NPM");

        jLabel3.setText("Nama");

        jLabel4.setText("Jenis Kelamin");

        t_jeniskelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_jeniskelaminActionPerformed(evt);
            }
        });

        jLabel5.setText("Alamat");

        jLabel6.setText("Prodi");

        jLabel7.setText("Fakultas");

        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_cancel.setText("CANCEL");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        tbl_data.setForeground(new java.awt.Color(102, 102, 102));
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NPM", "Nama", "Jenis Kelamin", "Alamat", "Prodi", "Fakultas"
            }
        ));
        tbl_data.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        t_search.setText("Search");
        t_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_searchMouseClicked(evt);
            }
        });
        t_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_searchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_fakultas, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_prodi, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_jeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_npm, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_add)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancel)
                        .addGap(13, 13, 13)
                        .addComponent(btn_delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addComponent(t_search))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(t_npm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_jeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(t_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_prodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_fakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(t_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_jeniskelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_jeniskelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_jeniskelaminActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
       int selectedRow = tbl_data.getSelectedRow();
       if(selectedRow == -1){
           JOptionPane.showMessageDialog(this, "Pilih baris yang akan diperbarui");
           return;
       }
       
       int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
       if(confirm == JOptionPane.YES_OPTION){
           String id = tbl_data.getValueAt(selectedRow, 0).toString();
           
           try {
               String sql = "DELETE FROM mahasiswa WHERE id=?";
               PreparedStatement st = conn.prepareStatement(sql);
               st.setString(1, id);
               
               int rowDelete = st.executeUpdate();
               if(rowDelete > 0) {
                   JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
               }
               
               st.close();
           } catch (SQLException e) {
               Logger.getLogger(formMhs.class.getName()).log(Level.SEVERE,null, e);
           }
       }
       
        resetForm();
        getData();
        aktifButton();
        nonAktifButton();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String npm = t_npm.getText();
        String nama = t_nama.getText();
        String jenis_kelamin = t_jeniskelamin.getText();
        String alamat = t_alamat.getText();
        String prodi = t_prodi.getText();
        String fakultas = t_fakultas.getText();
        
        if(npm.isEmpty() || nama.isEmpty() || jenis_kelamin.isEmpty() ||  
          alamat.isEmpty() ||  prodi.isEmpty() || fakultas.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String sql = "INSERT INTO mahasiswa (npm,nama,jenis_kelamin,alamat,prodi,fakultas) VALUE (?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, npm);
            st.setString(2, nama);
            st.setString(3, jenis_kelamin);
            st.setString(4, alamat);
            st.setString(5, prodi);
            st.setString(6, fakultas);
            
            int rowInserted = st.executeUpdate();
            if(rowInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                resetForm();
                getData();
            }
            
            st.close();
        } catch (SQLException e) {
             Logger.getLogger(formMhs.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        resetForm();
        aktifButton();
        nonAktifButton();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       int selectedRow = tbl_data.getSelectedRow();
       if(selectedRow == -1){
           JOptionPane.showMessageDialog(this, "Pilih baris yang akan diperbarui");
           return;
       }
       
       String id = tbl_data.getValueAt(selectedRow, 0).toString();
       String npm = t_npm.getText();
       String nama = t_nama.getText();
       String jenis_kelamin = t_jeniskelamin.getText();
       String alamat = t_alamat.getText();
       String prodi = t_prodi.getText();
       String fakultas = t_fakultas.getText();
       
       if(npm.isEmpty() || nama.isEmpty() || jenis_kelamin.isEmpty() ||  
          alamat.isEmpty() ||  prodi.isEmpty() || fakultas.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String sql = "UPDATE mahasiswa SET npm=?, nama=?, jenis_kelamin=?, alamat=?, prodi=?, fakultas=? WHERE id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, npm);
            st.setString(2, nama);
            st.setString(3, jenis_kelamin);
            st.setString(4, alamat);
            st.setString(5, prodi);
            st.setString(6, fakultas);
            st.setString(7, id);
            
            int rowUpdated = st.executeUpdate();
            if(rowUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");
                resetForm();
                getData();
            }
            
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(formMhs.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        int selectedRow = tbl_data.getSelectedRow();
        if(selectedRow != -1) {
            String npm = tbl_data.getValueAt(selectedRow, 1).toString();
            String nama = tbl_data.getValueAt(selectedRow, 2).toString();
            String jenis_kelamin = tbl_data.getValueAt(selectedRow, 3).toString();
            String alamat = tbl_data.getValueAt(selectedRow, 4).toString();
            String prodi = tbl_data.getValueAt(selectedRow, 5).toString();
            String fakultas = tbl_data.getValueAt(selectedRow, 6).toString();
            
            t_npm.setText(npm);
            t_nama.setText(nama);
            t_jeniskelamin.setText(jenis_kelamin);
            t_alamat.setText(alamat);
            t_prodi.setText(prodi);
            t_fakultas.setText(fakultas);
            
        }
        
        btn_update.setEnabled(true);
        btn_add.setEnabled(false);
        btn_delete.setEnabled(true);
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void t_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_searchKeyTyped
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        String search = t_search.getText();
        
        try {
            String sql = "Select * From mahasiswa WHERE npm LIKE ? OR nama LIKE ? OR prodi LIKE ? OR fakultas LIKE?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + search + "%");
            st.setString(2, "%" + search + "%");
            st.setString(3, "%" + search + "%");
            st.setString(4, "%" + search + "%");
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                int id                      = rs.getInt("id");
                String npm                  = rs.getNString("npm");
                String nama                 = rs.getNString("nama");
                String jenis_kelamin        = rs.getNString("jenis_kelamin");
                String alamat               = rs.getNString("alamat");
                String prodi                = rs.getNString("prodi");
                String fakultas             = rs.getNString("fakultas");
                
                Object[] rowData = {id,npm,nama,jenis_kelamin,alamat,prodi,fakultas};
                model.addRow(rowData);
            }
            
            rs.close();
            st.close();
        } catch (SQLException e) {
             Logger.getLogger(formMhs.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_t_searchKeyTyped

    private void t_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_searchMouseClicked
       t_search.setText("");
    }//GEN-LAST:event_t_searchMouseClicked
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formMhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_alamat;
    private javax.swing.JTextField t_fakultas;
    private javax.swing.JTextField t_jeniskelamin;
    private javax.swing.JTextField t_nama;
    private javax.swing.JTextField t_npm;
    private javax.swing.JTextField t_prodi;
    private javax.swing.JTextField t_search;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
      t_npm.setText("");
      t_nama.setText("");
      t_jeniskelamin.setText("");
      t_alamat.setText("");
      t_prodi.setText("");
      t_fakultas.setText("");       
    }

    private void nonAktifButton() {
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);
    }

    private void aktifButton() {
        btn_add.setEnabled(true);
        btn_cancel.setEnabled(true);
    }

   
}
