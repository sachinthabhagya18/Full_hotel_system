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
public class foodbill extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("0.00");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form CustomerCheckOut
     */
    public foodbill() {
        initComponents();
        loadUsers();
        loadcustomer();
        setIconImage();
    }

    public void loadUsers() {

        try {

            ResultSet rs = MySQL.search("SELECT * FROM food_payment INNER JOIN customer ON food_payment.customer_id= customer.id\n"
                    + "INNER JOIN payment_type ON food_payment.payment_type_id=payment_type.id\n"
                    + "INNER JOIN package ON food_payment.package_id=package.id\n"
                    + "INNER JOIN drinks ON package.drinks_id=drinks.id\n"
                    + "INNER JOIN food_time ON package.food_time_id=food_time.id\n"
                    + "INNER JOIN desert ON package.desert_id=desert.id  ORDER BY  `food_payment`.`id` ASC");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("package.id"));
                v.add(rs.getString("package_name"));
                v.add(rs.getString("customer.email"));
                v.add(rs.getString("food_items"));
                v.add(rs.getString("price"));
                v.add(rs.getString("qty"));
                v.add(rs.getString("total"));
                v.add(rs.getString("payment"));
                v.add(rs.getString("balance"));
                dtm.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadUsers(String text) {
        try {

            ResultSet rs = MySQL.search("SELECT * FROM food_payment INNER JOIN customer ON food_payment.customer_id= customer.id\n"
                    + "INNER JOIN payment_type ON food_payment.payment_type_id=payment_type.id\n"
                    + "INNER JOIN package ON food_payment.package_id=package.id\n"
                    + "INNER JOIN drinks ON package.drinks_id=drinks.id\n"
                    + "INNER JOIN food_time ON package.food_time_id=food_time.id\n"
                    + "INNER JOIN desert ON package.desert_id=desert.id  WHERE `customer`.`id` LIKE '" + text + "%' ");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("package.id"));
                v.add(rs.getString("package_name"));
                v.add(rs.getString("customer.email"));
                v.add(rs.getString("food_items"));
                v.add(rs.getString("price"));
                v.add(rs.getString("qty"));
                v.add(rs.getString("total"));
                v.add(rs.getString("payment"));
                v.add(rs.getString("balance"));
                dtm.addRow(v);

            }
            jTable1.setModel(dtm);
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

    public void UpdateTotal() {
        double total = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String t = jTable1.getValueAt(i, 6).toString();
            total = total + Double.parseDouble(t);
        }
        jLabel22.setText(df.format(total));
    }

    public void UpdatePayment() {
        double total = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String t = jTable1.getValueAt(i, 7).toString();
            total = total + Double.parseDouble(t);
        }
        jLabel23.setText(df.format(total));
    }

    public void UpdateBalance() {
        double total = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String t = jTable1.getValueAt(i, 8).toString();
            total = total + Double.parseDouble(t);
        }
        jLabel24.setText(df.format(total));
    }

    public void Resetfild() {
        jLabel23.setText("0.00");
        jLabel22.setText("0.00");
        jLabel24.setText("0.00");

        jComboBox1.setSelectedIndex(0);

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
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
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

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer Bill");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 250, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Package Name", "Customer Email", "Food Item", "Price", "Qty", "Total", "Payment", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 1040, 230));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 53, 49));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 61, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Customer");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));

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
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, 240, -1));

        jButton5.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 204));
        jButton5.setText("Print Bill");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 610, 390, 61));

        jLabel22.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("0.00");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 213, -1));

        jLabel25.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Total");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, -1, -1));

        jLabel23.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("0.00");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, 213, -1));

        jLabel26.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Payment");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, -1, -1));

        jLabel24.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("0.00");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, 213, -1));

        jLabel27.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Balance");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/foodorder.png"))); // NOI18N
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

                UpdateBalance();
                UpdatePayment();
                UpdateTotal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        String payment = jLabel23.getText();
        String C_email = jComboBox1.getSelectedItem().toString();
        String balance = jLabel24.getText();
        String total = jLabel22.getText();

        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please Add Product", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (C_email.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Customer", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                JOptionPane.showMessageDialog(this, "Please Wait", "Success", JOptionPane.INFORMATION_MESSAGE);


                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();


                InputStream filepath = getClass().getResourceAsStream("/report/foodbill.jrxml");
                JasperReport jr = JasperCompileManager.compileReport(filepath);



                HashMap parameters = new HashMap();
                parameters.put("Parameter1", payment);
                parameters.put("Parameter2", balance);
                parameters.put("Parameter3", total);

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
            java.util.logging.Logger.getLogger(foodbill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(foodbill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(foodbill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(foodbill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new foodbill().setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
