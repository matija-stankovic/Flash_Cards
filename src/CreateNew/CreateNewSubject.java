package CreateNew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CreateNewSubject extends javax.swing.JFrame {

    Connection con;
    Statement ST;
    ResultSet RS;
    PreparedStatement pstmt = null;

    public CreateNewSubject() {
        initComponents();
    }

    public CreateNewSubject(String name) {
        initComponents();
        text.setText(name);
    }

    void add() {
        try {
            String sn = subjectName.getText().replace(" ", "");
            String tname = text.getText();
            pstmt = con.prepareStatement("Select * from CLASSES");
            RS = pstmt.executeQuery();

            PreparedStatement add = con.prepareStatement("Insert Into matija.CLASSES values (?, ?)");
            add.setString(1, sn);
            add.setString(2, tname);
            add.executeUpdate();
            con.close();
            pstmt.close();
            RS.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int cc = 0;

    public void createTable() {
        String sn = subjectName.getText();
        String tname = text.getText();

        String un = "matija";
        String pw = "1234";

        String where = tname + sn.replace(" ", "");

        try {
            cc = 0;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);

            pstmt = con.prepareStatement("Select * from CLASSES where Teacher=?");
            pstmt.setString(1, tname);
            RS = pstmt.executeQuery();
            while (RS.next()) {
                if (RS.getString("Subject").equals(sn)) {
                    JOptionPane.showMessageDialog(null, "This Subject Already Exists");
                    cc = 1;
                } else {
                    cc = 0;
                }
            }
            if (cc == 0) {
                String c = "CREATE TABLE " + where + " ("
                        + "Name varchar(100),"
                        + "Term varchar(100),"
                        + "Definition varchar(1000)"
                        + ")";
                try (Statement stmt = con.createStatement()) {
                    stmt.execute(c);
                    PreparedStatement add = con.prepareStatement("Insert Into " + where + " values (?, ?, ?)");
                    add.setString(1, "Base");
                    add.setString(2, "Base");
                    add.setString(3, "Base");
                    add.executeUpdate();
                    add();
                    close();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "This Subject Already Exists... Failed");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        text = new javax.swing.JLabel();
        subjectName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create a New Subject:");

        text.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        text.setForeground(new java.awt.Color(255, 255, 255));
        text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text.setText("Name");

        subjectName.setBackground(new java.awt.Color(0, 0, 51));
        subjectName.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        subjectName.setForeground(new java.awt.Color(255, 255, 255));
        subjectName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Name of Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(255, 153, 0))); // NOI18N
        subjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectNameActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jButton2.setText("Cancel");
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(subjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(text)
                .addGap(40, 40, 40)
                .addComponent(subjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
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

    private void subjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectNameActionPerformed

    }//GEN-LAST:event_subjectNameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Cancel", "Cancel", JOptionPane.YES_NO_OPTION);

        if (p == 0) {
            close();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String b = text.getText() + subjectName.getText().replace(" ", "");
        if (subjectName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Name the Subject");
        } else {
            try {
                String un = "matija";
                String pw = "1234";
                int t = 0;

                Connection conn = null; //Database Connection
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
                pstmt = conn.prepareStatement("Select * from STUDENTS");
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    if (b.equals(rs.getString("Subject"))) {
                        t = 1;
                    }
                }

                if (t == 1) {
                    JOptionPane.showMessageDialog(null, "ERROR\nThis Class Already Exists");
                } else {
                    int p = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Create a New Subject", "Confirm", JOptionPane.YES_NO_OPTION);

                    if (p == 0) {
                        createTable();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CreateNewSubject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CreateNewSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CreateNewSubject().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JTextField subjectName;
    public javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
