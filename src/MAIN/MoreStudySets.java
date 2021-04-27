package MAIN;

import CreateNew.StudentCreateSet;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MoreStudySets extends javax.swing.JFrame {

    public MoreStudySets() {
        initComponents();
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    public String nam;
    public String usern;

    public MoreStudySets(String n, String u) {
        initComponents();
        nam = n;
        usern = u;
        nn.setText(nam);
        la.setText(usern);
        showSubjects();
        removeSubjects();
        create.setBackground(Color.gray);
        create.setEnabled(false);
        box.setEnabled(false);
        go.setEnabled(false);
        box.setBackground(Color.gray);
        go.setBackground(Color.gray);

    }

    String un = "matija";
    String pw = "1234";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public void join() {
        Object selectedItem = box.getSelectedItem();
        

        try {
            String where = selectedItem.toString();
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            PreparedStatement add = conn.prepareStatement("Insert into STUDENTS values (?, ?, ?)");
            add.setString(1, nam);
            add.setString(2, where);
            add.setString(3, usern);
            add.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Joined " + where + "!!!");
            new Student(usern).setVisible(true);
            close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You Have no Subjects to Join...");

        }
    }

    public void showSubjects() {

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from CLASSES");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                box.addItem(rs.getString("Teacher") + rs.getString("Subject"));

            }

            conn.close();
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!\n");

        }

    }

    public void removeSubjects() {
        String user = "";
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from STUDENTS");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = rs.getString("Username");
                if (usern.equals(user)) {
                    box.removeItem(rs.getString("Subject"));
                }

            }

            conn.close();
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!\n");

        }
    }
    
    public void Create(){
        new StudentCreateSet(usern).setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        b1 = new javax.swing.JRadioButton();
        box = new javax.swing.JComboBox<>();
        la = new javax.swing.JLabel();
        go = new javax.swing.JButton();
        create = new javax.swing.JButton();
        nn = new javax.swing.JLabel();
        b2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add More Study Sets");

        b1.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        b1.setForeground(new java.awt.Color(255, 153, 0));
        b1.setText("Join Another Class:");
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
        });
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        box.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });

        la.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        la.setForeground(new java.awt.Color(255, 153, 0));
        la.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        la.setText("Username");

        go.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        go.setText("Join");
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goActionPerformed(evt);
            }
        });

        create.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        create.setText("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        nn.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        nn.setForeground(new java.awt.Color(255, 153, 0));
        nn.setText("Name");

        b2.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        b2.setForeground(new java.awt.Color(255, 153, 0));
        b2.setText("Create Your Study Set");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(la, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b1)
                    .addComponent(b2))
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(go, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(box, 0, 200, Short.MAX_VALUE)
                    .addComponent(create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(b1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(box, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(go, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(la)
                            .addComponent(nn))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
         join();
         
    }//GEN-LAST:event_goActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        Create();
        close();
    }//GEN-LAST:event_createActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        if (b1.isSelected()) {
            b2.setSelected(false);
            create.setBackground(Color.gray);
            create.setEnabled(false);

            box.setEnabled(true);
            go.setEnabled(true);
            box.setBackground(Color.white);
            go.setBackground(Color.orange);

            jPanel1.revalidate();
            jPanel1.repaint();

        }
    }//GEN-LAST:event_b1ActionPerformed

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
        
    }//GEN-LAST:event_b1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Student(usern).setVisible(true);
        close();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        if (b2.isSelected()) {
            b1.setSelected(false);
            create.setBackground(Color.orange);
            create.setEnabled(true);

            box.setEnabled(false);
            go.setEnabled(false);
            box.setBackground(Color.gray);
            go.setBackground(Color.gray);

            jPanel1.revalidate();
            jPanel1.repaint();
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxActionPerformed

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
            java.util.logging.Logger.getLogger(MoreStudySets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoreStudySets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoreStudySets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoreStudySets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MoreStudySets().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton b1;
    public javax.swing.JRadioButton b2;
    public javax.swing.JComboBox<String> box;
    public javax.swing.JButton create;
    public javax.swing.JButton go;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel la;
    public javax.swing.JLabel nn;
    // End of variables declaration//GEN-END:variables

}
