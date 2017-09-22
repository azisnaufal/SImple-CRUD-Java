/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package SimpleCrud;

import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oazisn
 */
public class frmMain extends javax.swing.JFrame {
    String username, host, password, port, db,act;
    DefaultTableModel dtm;
    SettingPanel sp;
    Connection koneksi;
    Vector kelas,makanan, id_kelas, id_makanan;
    int no;
    int row;
    PenyimpananData pd;
    /**
     * Creates new form frmMain
     */
    public frmMain() {
        sp = new SettingPanel();
        host = sp.getValue("host");
        username = sp.getValue("username");
        password = sp.getValue("password");
        db = sp.getValue("db");
        koneksi = Koneksi.getKoneksi(host,port,username,password,db);
        pd = new PenyimpananData();
        pd.setKoneksi(koneksi);
        
        initComponents();
        setLocationRelativeTo(null);
        loadData();
        loadComboBox();
        
        disabler();
        jTable1.setAutoCreateRowSorter(true);
       
    }
    private void disabler(){
        lblNIS.setEnabled(false);
        lblNama.setEnabled(false);
        lblKelas.setEnabled(false);
        lblMakanan.setEnabled(false);
        tbNIS.setEnabled(false);
        tbNama.setEnabled(false);
        cbKelas.setEnabled(false);
        cbMakanan.setEnabled(false);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        btnHapus.setEnabled(false);
        btnUbah.setEnabled(false);
        if(no==0){
            btnLaporan.setEnabled(false);
        }
    }
    private void loadComboBox(){
        kelas = new Vector();
        id_kelas = new Vector();
        try {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * From tb_kelas";
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            kelas.add("");
            id_kelas.add("");
            while (rs.next()) {
                kelas.add(rs.getString("kelas"));
                id_kelas.add(rs.getString("id_kelas"));
                no++;
            }
            cbKelas.setModel(new DefaultComboBoxModel(kelas));
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            cbKelas.setModel(new DefaultComboBoxModel(kelas));
        }
        
        makanan = new Vector();
        id_makanan = new Vector();
        try {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * From tb_makanan";
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            makanan.add("");
            id_makanan.add("");
            while (rs.next()) {
                makanan.add(rs.getString("makanan"));
                id_makanan.add(rs.getString("id_makanan"));
                no++;
            }
            cbMakanan.setModel(new DefaultComboBoxModel(makanan));
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            cbMakanan.setModel(new DefaultComboBoxModel(makanan));
        }
    }
    private void loadData() {
        String[] kolom = { "NIS", "Nama", "Kelas", "Makanan"};
        String SQL = "SELECT\n" +
                "    `tb_siswa`.`nis`\n" +
                "    , `tb_siswa`.`nama`\n" +
                "    , `tb_kelas`.`kelas`\n" +
                "    , `tb_makanan`.`makanan`\n" +
                "FROM\n" +
                "    `tb_siswa`\n" +
                "    INNER JOIN `tb_makanan` \n" +
                "        ON (`tb_siswa`.`id_makanan` = `tb_makanan`.`id_makanan`)\n" +
                "    INNER JOIN `tb_kelas` \n" +
                "        ON (`tb_siswa`.`id_kelas` = `tb_kelas`.`id_kelas`) order by nis;";
        dtm = new DefaultTableModel(null, kolom);
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            no = 0;
            while (rs.next()) {
                String nis = rs.getString("nis");
                String nama = rs.getString("nama");
                String kelas = rs.getString("kelas");
                String makanan = rs.getString("makanan");
                dtm.addRow(new Object[] {nis, nama, kelas, makanan});
                no++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTable1.setModel(dtm);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jButton1 = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        lblNIS = new javax.swing.JLabel();
        tbNIS = new javax.swing.JTextField();
        tbNama = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        lblKelas = new javax.swing.JLabel();
        lblMakanan = new javax.swing.JLabel();
        cbKelas = new javax.swing.JComboBox<>();
        cbMakanan = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Fira Sans Semi-Light", 1, 13)); // NOI18N
        jLabel1.setText("Data makanan yang paling disukai siswa");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnLaporan.setText("Buat Laporan");
        btnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanActionPerformed(evt);
            }
        });

        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Manage Kelas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Manage Makanan");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        lblNIS.setText("NIS");

        lblNama.setText("Nama");

        lblKelas.setText("Kelas");

        lblMakanan.setText("Makanan");

        cbKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMakanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNIS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tbNIS, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNama)
                                    .addComponent(lblKelas)
                                    .addComponent(lblMakanan))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbNama, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNIS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKelas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMakanan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLaporan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah)
                    .addComponent(jButton5)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        act="tambah";
        disabler();
        lblNIS.setEnabled(true);
        lblNama.setEnabled(true);
        lblKelas.setEnabled(true);
        lblMakanan.setEnabled(true);
        tbNIS.setEnabled(true);
        tbNama.setEnabled(true);
        cbKelas.setEnabled(true);
        cbMakanan.setEnabled(true);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try{
            Statement stmt = koneksi.createStatement();
            String query = "DELETE FROM tb_siswa WHERE nis = '" +jTable1.getValueAt(row, 0)+"';";
            int berhasil = stmt.executeUpdate(query);
            if (berhasil == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                dtm.getDataVector().removeAllElements();
                jTable1.setModel(dtm);
                loadData();
                btnHapus.setEnabled(false);
                btnUbah.setEnabled(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus");
                btnHapus.setEnabled(false);
                btnUbah.setEnabled(false);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            btnHapus.setEnabled(false);
            btnUbah.setEnabled(false);
        }
        disabler();
    }//GEN-LAST:event_btnHapusActionPerformed
    
    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        act = "ubah";
        disabler();
        tbNIS.setText(jTable1.getValueAt(row, 0)+"");
        tbNama.setText(jTable1.getValueAt(row, 1)+"");
        cbKelas.setSelectedItem(jTable1.getValueAt(row, 2));
        cbMakanan.setSelectedItem(jTable1.getValueAt(row, 3));
        lblNIS.setEnabled(true);
        lblNama.setEnabled(true);
        lblKelas.setEnabled(true);
        lblMakanan.setEnabled(true);
        tbNIS.setEnabled(true);
        tbNama.setEnabled(true);
        cbKelas.setEnabled(true);
        cbMakanan.setEnabled(true);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_btnUbahActionPerformed
    
    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnLaporanActionPerformed
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        frmManageKelas frm = new frmManageKelas(pd);
        frm.setVisible(true);
        frm.setLocationRelativeTo(this);
        
    }//GEN-LAST:event_jButton6ActionPerformed
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        frmManageMakanan frm = new frmManageMakanan(pd);
        frm.setVisible(true);
        frm.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton7ActionPerformed
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(act.equals("ubah")){
            try
            {
                Statement stmt = koneksi.createStatement();
                String query= "UPDATE `db_makanan_kesukaan`.`tb_siswa` SET "
                        + "`nis` = '"+tbNIS.getText()+"' , "
                        + "`nama` = '"+tbNama.getText()+"' , "
                        + "`id_kelas` = '"+id_kelas.get(cbKelas.getSelectedIndex())+"' , "
                        + "`id_makanan` = '"+id_makanan.get(cbMakanan.getSelectedIndex())+"' "
                        + "WHERE `nis` = '"+jTable1.getValueAt(row, 0)+"'; \00\00\00";
                
                System.out.println(query);
                int berhasil = stmt.executeUpdate(query);
                if (berhasil == 1)
                {
                    JOptionPane.showMessageDialog(null, "Tersimpan!");
                    dtm.getDataVector().removeAllElements();
                    jTable1.setModel(dtm);
                    loadData();
                    btnHapus.setEnabled(false);
                    btnUbah.setEnabled(false);
                    lblNIS.setEnabled(false);
                    lblNama.setEnabled(false);
                    lblKelas.setEnabled(false);
                    lblMakanan.setEnabled(false);
                    tbNIS.setEnabled(false);
                    tbNIS.setText("");
                    tbNama.setEnabled(false);
                    tbNama.setText("");
                    cbKelas.setEnabled(false);
                    cbKelas.setSelectedIndex(0);
                    cbMakanan.setEnabled(false);
                    cbMakanan.setSelectedIndex(0);
                    btnSave.setEnabled(false);
                    btnCancel.setEnabled(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Data gagal dimasukkan");
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam database");
                dtm.getDataVector().removeAllElements();
                jTable1.setModel(dtm);
                loadData();
                btnHapus.setEnabled(false);
                btnUbah.setEnabled(false);
                lblNIS.setEnabled(false);
                lblNama.setEnabled(false);
                lblKelas.setEnabled(false);
                lblMakanan.setEnabled(false);
                tbNIS.setEnabled(false);
                tbNIS.setText("");
                tbNama.setEnabled(false);
                tbNama.setText("");
                cbKelas.setEnabled(false);
                cbKelas.setSelectedIndex(0);
                cbMakanan.setEnabled(false);
                cbMakanan.setSelectedIndex(0);
                btnSave.setEnabled(false);
                btnCancel.setEnabled(false);
            }
        }
        if(act.equals("tambah")){
            try
            {
                Statement stmt = koneksi.createStatement();
                String query= "INSERT INTO `db_makanan_kesukaan`.`tb_siswa` (`nis`, `nama`, `id_kelas`, `id_makanan`) VALUES ("
                        + "'"+tbNIS.getText()+"', "
                        + "'"+tbNama.getText()+"', "
                        + "'"+id_kelas.get(cbKelas.getSelectedIndex())+"', "
                        + "'"+id_makanan.get(cbMakanan.getSelectedIndex())+"'); \00\00";
                
                System.out.println(query);
                int berhasil = stmt.executeUpdate(query);
                if (berhasil == 1)
                {
                    JOptionPane.showMessageDialog(null, "Tersimpan!");
                    dtm.getDataVector().removeAllElements();
                    jTable1.setModel(dtm);
                    loadData();
                    btnHapus.setEnabled(false);
                    btnUbah.setEnabled(false);
                    lblNIS.setEnabled(false);
                    lblNama.setEnabled(false);
                    lblKelas.setEnabled(false);
                    lblMakanan.setEnabled(false);
                    tbNIS.setEnabled(false);
                    tbNIS.setText("");
                    tbNama.setEnabled(false);
                    tbNama.setText("");
                    cbKelas.setEnabled(false);
                    cbKelas.setSelectedIndex(0);
                    cbMakanan.setEnabled(false);
                    cbMakanan.setSelectedIndex(0);
                    btnSave.setEnabled(false);
                    btnCancel.setEnabled(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Data gagal dimasukkan");
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam database");
                dtm.getDataVector().removeAllElements();
                jTable1.setModel(dtm);
                loadData();
                btnHapus.setEnabled(false);
                btnUbah.setEnabled(false);
                lblNIS.setEnabled(false);
                lblNama.setEnabled(false);
                lblKelas.setEnabled(false);
                lblMakanan.setEnabled(false);
                tbNIS.setEnabled(false);
                tbNIS.setText("");
                tbNama.setEnabled(false);
                tbNama.setText("");
                cbKelas.setEnabled(false);
                cbKelas.setSelectedIndex(0);
                cbMakanan.setEnabled(false);
                cbMakanan.setSelectedIndex(0);
                btnSave.setEnabled(false);
                btnCancel.setEnabled(false);
            }
        }
        disabler();
    }//GEN-LAST:event_btnSaveActionPerformed
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        lblNIS.setEnabled(false);
        lblNama.setEnabled(false);
        lblKelas.setEnabled(false);
        lblMakanan.setEnabled(false);
        tbNIS.setEnabled(false);
        tbNIS.setText("");
        tbNama.setEnabled(false);
        tbNama.setText("");
        cbKelas.setEnabled(false);
        cbKelas.setSelectedIndex(0);
        cbMakanan.setEnabled(false);
        cbMakanan.setSelectedIndex(0);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
    }//GEN-LAST:event_btnCancelActionPerformed
    
    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        JTable table = (JTable)evt.getSource();
        Point p = evt.getPoint();
        int row = jTable1.rowAtPoint(p);
        if(evt.getClickCount() == 2){
            JOptionPane.showMessageDialog(this, "Klik tombol edit untuk mengubah nilai!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jTable1MousePressed
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        row = jTable1.getSelectedRow();
        disabler();
        btnHapus.setEnabled(true);
        btnUbah.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked
    
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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Set System L&F
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                }
                catch (UnsupportedLookAndFeelException e) {
                    // handle exception
                }
                catch (ClassNotFoundException e) {
                    // handle exception
                }
                catch (InstantiationException e) {
                    // handle exception
                }
                catch (IllegalAccessException e) {
                    // handle exception
                }
                new frmMain().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbKelas;
    private javax.swing.JComboBox<String> cbMakanan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblKelas;
    private javax.swing.JLabel lblMakanan;
    private javax.swing.JLabel lblNIS;
    private javax.swing.JLabel lblNama;
    private javax.swing.JTextField tbNIS;
    private javax.swing.JTextField tbNama;
    // End of variables declaration//GEN-END:variables
    
}
