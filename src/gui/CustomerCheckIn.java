/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author sachi
 */
public class CustomerCheckIn extends javax.swing.JFrame {

    /**
     * Creates new form CustomerCheckIn
     */
    public CustomerCheckIn() {
        initComponents();
        loadBed();
        loadRoomType();
        loadcustomer();
        loadUsers();
        setIconImage();
        jTextField8.setEditable(false);
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        jTextField9.setText(myFormat.format(cal.getTime()));

    }

    public void loadUsers() {
        try {

            ResultSet rs = MySQL.search("SELECT * FROM booking INNER JOIN customer ON booking.customer_id=customer.id\n"
                    + "INNER JOIN room ON booking.room_id=room.id INNER JOIN room_type ON room.room_type_id=room_type.id\n"
                    + "INNER JOIN bed ON room.bed_id=bed.id ORDER BY  `booking`.`id` ASC");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("name"));
                v.add(rs.getString("email"));
                v.add(rs.getString("room.room_no"));
                v.add(rs.getString("bed.name"));
                v.add(rs.getString("room_type.name"));
                v.add(rs.getString("price"));
                dtm.addRow(v);
            }
            jTable1.setModel(dtm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String bed;
    String roomType;
    String roomNo;
    String price;

    public void roomDetails() {
        jComboBox4.removeAllItems();
        jTextField8.setText("");
        bed = (String) jComboBox2.getSelectedItem();
        roomType = (String) jComboBox3.getSelectedItem();

        try {

            ResultSet rs1 = MySQL.search("SELECT `id` FROM `bed` WHERE `name` = '" + bed + "'");
            rs1.next();

            ResultSet rs2 = MySQL.search("SELECT `id` FROM `room_type` WHERE `name` = '" + roomType + "'");
            rs2.next();

            String bed_id = rs1.getString("id");
            String room_type_id = rs2.getString("id");

            ResultSet rs = MySQL.search("SELECT * FROM `room` WHERE `bed_id`='" + bed_id + "' AND `room_type_id`='" + room_type_id + "' AND `book_or_not_id`= '1'");
            while (rs.next()) {
                jComboBox4.addItem(rs.getString(2));
            }
        } catch (Exception e) {
        }
    }

    public void loadRoomType() {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `room_type`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox3.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadBed() {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `bed`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox2.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadcustomer() {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `customer`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("email"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox1.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField9 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer Check In");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 350, -1));

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Customer");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 210, -1));

        jComboBox2.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 210, -1));

        jLabel10.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Bed");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        jComboBox3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 210, -1));

        jLabel11.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Room Type");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        jComboBox4.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 270, -1));

        jLabel12.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Room Number");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, -1, -1));

        jTextField8.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 200, -1));

        jLabel13.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Price");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 204));
        jButton1.setText("Allote Room");
        jButton1.setPreferredSize(new java.awt.Dimension(79, 31));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 170, 50));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 204));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 170, 50));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 50, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "Room Number", "Bed", "Room Type", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 1040, 320));

        jTextField9.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 200, -1));

        jLabel14.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Check IN");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 34, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/customercheckin.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CustomerCheckIn c = new CustomerCheckIn();
        c.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int id = 1;
        String price = jTextField8.getText();
        String checkin = jTextField9.getText();

        String customer = jComboBox1.getSelectedItem().toString();
        String bed = jComboBox2.getSelectedItem().toString();
        String roomtype = jComboBox3.getSelectedItem().toString();
        String roomnumber = jComboBox4.getSelectedItem().toString();

        if (customer.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Enter Customer", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (roomtype.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Room Type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (bed.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Bed", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Price", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs3 = MySQL.search("SELECT `id` FROM `room` WHERE `room_no` = '" + roomnumber + "'");
                rs3.next();

                ResultSet rs4 = MySQL.search("SELECT `id` FROM `customer` WHERE `email` = '" + customer + "'");
                rs4.next();

                String room_id = rs3.getString("id");
                String customer_id = rs4.getString("id");

                MySQL.iud("INSERT INTO `booking`(`check_in`,`room_id`,`customer_id`)"
                        + "VALUES('" + checkin + "'," + Integer.parseInt(room_id) + "," + Integer.parseInt(customer_id) + ")");

                MySQL.iud("UPDATE `room` SET `book_or_not_id`= '2' WHERE `id`='" + room_id + "' ");

                JOptionPane.showMessageDialog(this, "Allocated Your Room", "success", JOptionPane.INFORMATION_MESSAGE);

                setVisible(false);
                new CustomerCheckIn().setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        roomDetails();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        roomDetails();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        roomNo = (String) jComboBox4.getSelectedItem();
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `room` WHERE `room_no`='" + roomNo + "'");
            while (rs.next()) {
                jTextField8.setText(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int r = jTable1.getSelectedRow();

            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Row", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                int option = JOptionPane.showConfirmDialog(this, "Do you want to Remove This Item?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {

                    loadUsers();
                    JOptionPane.showMessageDialog(this, "GRN Item Remove", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        // TODO add your handling code here:
                String qty = jTextField8.getText();
        String text = qty + evt.getKeyChar();

        if (!Pattern.compile("([1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*))").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField8KeyTyped

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerCheckIn().setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
