package Started;

import MAIN.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Join extends javax.swing.JFrame {

    public Join() {
        initComponents();
        showSubjects();
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    public String Username;
    public String StudentName;
    
    public Join(String SName, String email, String U) {
        initComponents();
        qwer.setText(SName);
        e.setText(email);
        StudentName = SName; 
        Username = U;
        showSubjects();
    }

    public void create() {
        String un = "matija";
        String pw = "1234";
        String teach = "";
        String sub = "";
        Object selectedItem = box.getSelectedItem();
        String s = selectedItem.toString();
        String g = "";

        Connection conn = null; //Database Connection
        PreparedStatement pstmt = null;
        ResultSet rs = null; //Represent The Data From The DataBase

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from CLASSES");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                
                sub = rs.getString("Subject");
                teach = rs.getString("Teacher");
                

                if (s.contains(teach) && s.contains(sub)) {
                    g = teach + sub;
                    
                    PreparedStatement add = conn.prepareStatement("Insert into STUDENTS values (?, ?, ?)");

                    add.setString(1, StudentName);
                    add.setString(2, g);
                    add.setString(3, Username);

                    add.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Successfully Joined Your First Class!!!");
                    JOptionPane.showMessageDialog(null, "Welcome!!!");
                    new Student(Username).setVisible(true);
                    close();
                }
            }

            conn.close();
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    
    public void showSubjects() {
        String un = "matija";
        String pw = "1234";

        Connection conn = null; 
        PreparedStatement pstmt = null;
        ResultSet rs = null; 

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from CLASSES");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                box.addItem(rs.getString("Teacher") + "'s " + rs.getString("Subject") + " Class");
            }

            conn.close();
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!\n");

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        qwer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        box = new javax.swing.JComboBox<>();
        join = new javax.swing.JButton();
        e = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        qwer.setForeground(new java.awt.Color(0, 0, 51));
        qwer.setText("jLabel3");

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("This is it!");

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Choose Your Subject");

        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        join.setBackground(new java.awt.Color(255, 255, 255));
        join.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        join.setText("Join");
        join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinActionPerformed(evt);
            }
        });

        e.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        e.setForeground(new java.awt.Color(255, 153, 51));
        e.setText("email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(join, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(175, 175, 175))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(qwer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(e)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(join, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qwer)
                    .addComponent(e))
                .addContainerGap())
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

    private void joinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinActionPerformed
        Object selectedItem = box.getSelectedItem();
        String s = selectedItem.toString();
        if (s.equals("Select")) {
            JOptionPane.showMessageDialog(null, "Please Select a Class");
        } else {
            create();
        }

    }//GEN-LAST:event_joinActionPerformed

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
            java.util.logging.Logger.getLogger(Join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Join().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> box;
    public javax.swing.JLabel e;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JButton join;
    public javax.swing.JLabel qwer;
    // End of variables declaration//GEN-END:variables
}
