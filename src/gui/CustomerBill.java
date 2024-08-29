/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Toolkit;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sachi
 */
public class CustomerBill extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("0.00");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form CustomerCheckOut
     */
    public CustomerBill() {
        initComponents();
        loadUsers();
        loadcustomer();
        loadpamentmethod();
        setIconImage();
    }

    public void loadUsers() {

        try {

            ResultSet rs = MySQL.search("SELECT * FROM booking INNER JOIN customer ON booking.customer_id=customer.id\n"
                    + "INNER JOIN room ON booking.room_id=room.id INNER JOIN room_type ON room.room_type_id=room_type.id\n"
                    + "INNER JOIN bed ON room.bed_id=bed.id\n"
                    + "INNER JOIN country ON customer.country_id=country.id  ORDER BY  `booking`.`id` ASC");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("room.id"));
                v.add(rs.getString("customer.name"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("customer.email"));
                v.add(rs.getString("price"));
                v.add(rs.getString("room.room_no"));
                v.add(rs.getString("bed.name"));
                v.add(rs.getString("room_type.name"));
                v.add(rs.getString("number_of_date"));
                v.add(rs.getString("total"));
                dtm.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadUsers(String text) {
        try {

            ResultSet rs = MySQL.search("SELECT * FROM booking INNER JOIN customer ON booking.customer_id=customer.id\n"
                    + "INNER JOIN room ON booking.room_id=room.id INNER JOIN room_type ON room.room_type_id=room_type.id\n"
                    + "INNER JOIN bed ON room.bed_id=bed.id\n"
                    + "INNER JOIN `country` ON `customer`.`country_id`=`country`.`id` WHERE `customer`.`id` LIKE '" + text + "%' ");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("booking.id"));
                v.add(rs.getString("customer.name"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("customer.email"));
                v.add(rs.getString("price"));
                v.add(rs.getString("room.room_no"));
                v.add(rs.getString("bed.name"));
                v.add(rs.getString("room_type.name"));
                v.add(rs.getString("number_of_date"));
                v.add(rs.getString("total"));
                dtm.addRow(v);

                UpdateTotal();

            }
            jTable1.setModel(dtm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Resetfild() {
        jLabel26.setText("0.00");
        jTextField3.setText("");
        jTextField3.setEditable(false);
        jComboBox1.setSelectedIndex(0);

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

    public void loadpamentmethod() {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `payment_type`");

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

    public void UpdateTotal() {
        double total = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String t = jTable1.getValueAt(i, 9).toString();
            total = total + Double.parseDouble(t);
        }
        jLabel22.setText(df.format(total));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

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
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer Bill");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 260, -1));

        jTable1.setFont(new java.awt.Font("Corbel Light", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Mobile", "Email", "Room Number", "Bed", "Room Type", "Price per Day", "NumbesOf Date", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 1040, 280));

        jButton3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 204));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 140, 40));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 50, 50));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 61, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Customer");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 240, -1));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 580, 230, -1));

        jLabel24.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Payment");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, -1, -1));

        jLabel25.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Balance");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 540, -1, -1));

        jLabel26.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("0.00");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 580, 213, -1));

        jComboBox2.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, 210, 30));

        jLabel23.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Payment Method");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, -1, -1));

        jLabel19.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Total Payment");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        jLabel22.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("0.00");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 186, -1));

        jButton5.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 204));
        jButton5.setText("Print Bill");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 640, 350, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/customerbill.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        String customerEmail = jComboBox1.getSelectedItem().toString();
        try {
            // ResultSet rs = MySQL.search("SELECT * FROM `customer` WHERE `email`='" + customerEmail + "'");
            ResultSet rs4 = MySQL.search("SELECT `id` FROM `customer` WHERE `email` = '" + customerEmail + "'");
            while (rs4.next()) {
                // jTextField8.setText(rs.getString(3));

                String text = rs4.getString("id");
                //String text = rs.getString(3);
                loadUsers(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:

        String text = jComboBox2.getSelectedItem().toString();

        if (text.equals("Select")) {
            jTextField3.setEditable(false);
            jTextField3.setText("");
            jLabel26.setText("0.00");
            jLabel26.setForeground(Color.GREEN);
        } else {
            jTextField3.setEditable(true);
        }

    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased

        if (jTextField3.getText().isEmpty()) {
            jLabel26.setText("0.00");
            jLabel26.setForeground(Color.GREEN);
        } else {

            String total = jLabel22.getText();
            String payment = jTextField3.getText();

            double balance = Double.parseDouble(payment) - Double.parseDouble(total);
            if (balance < 0) {
                jLabel26.setForeground(Color.RED);
            } else {
                jLabel26.setForeground(Color.GREEN);
            }
            jLabel26.setText(df.format(balance));
        }

    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        String qty = jTextField3.getText();
        String text = qty + evt.getKeyChar();

        if (!Pattern.compile("([1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*))").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        UpdateTotal();
        Resetfild();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        String payment = jTextField3.getText();
        String paymentType = jComboBox2.getSelectedItem().toString();
        String balance = jLabel26.getText();
        String total = jLabel22.getText();

        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please Add Product", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (paymentType.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Payment Type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("((0)|[1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*))").matcher(payment).matches()) {
            JOptionPane.showMessageDialog(this, "Please Enter Valid Pament", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            long mTime = System.currentTimeMillis();

            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            String dNow = sdf2.format(new Date());

            try {

                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    String billid = jTable1.getValueAt(i, 0).toString();
                    String email = jTable1.getValueAt(i, 3).toString();

                    ResultSet rs = MySQL.search("SELECT `id` FROM `payment_type` WHERE `name` = '" + paymentType + "'");
                    rs.next();
                    String paymentType_id = rs.getString("id");

                    MySQL.iud("INSERT INTO `payment` (`payment`,`balance`,`booking_id`,`payment_type_id`,`date`)VALUES('" + payment + "','" + balance + "','" + billid + "'," + Integer.parseInt(paymentType_id) + ",'" + dNow + "')");

                    //Resetfild();
                }
                JOptionPane.showMessageDialog(this, "Please Wait", "Success", JOptionPane.INFORMATION_MESSAGE);

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                InputStream filepath = getClass().getResourceAsStream("/report/invo.jrxml");
                JasperReport jr = JasperCompileManager.compileReport(filepath);

                HashMap parameters = new HashMap();
                parameters.put("Parameter1", payment);
                parameters.put("Parameter2", paymentType);
                parameters.put("Parameter3", balance);
                parameters.put("Parameter4", total);

                //----table model ekak naththan----///
               // JREmptyDataSource datasource = new JREmptyDataSource();

                TableModel tm = jTable1.getModel();
                JRTableModelDataSource datasource = new JRTableModelDataSource(tm);
                JasperPrint jp = JasperFillManager.fillReport(jr, parameters, datasource);
                JasperPrintManager.printReport(jp, true);

            } catch (Exception e) {
                e.printStackTrace();
            }

            Resetfild();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerBill().setVisible(true);
            }
        });

    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
