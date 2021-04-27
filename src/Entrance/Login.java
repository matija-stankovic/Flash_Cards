package Entrance;

import MAIN.Student;
import MAIN.Teacher;
import Recover.RecoverData;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        password.setEchoChar((char) 0);
        username.setForeground(Color.gray);
        password.setForeground(Color.gray);
        attempts.setVisible(false);
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        check = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        attempts = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome!");

        username.setBackground(new java.awt.Color(0, 0, 51));
        username.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(204, 204, 204));
        username.setText("Username");
        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        username.setSize(new java.awt.Dimension(200, 40));
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameMouseClicked(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
        });

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Or");

        register.setBackground(new java.awt.Color(255, 255, 255));
        register.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        password.setBackground(new java.awt.Color(0, 0, 51));
        password.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(204, 204, 204));
        password.setText("Password");
        password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
        });
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        check.setFont(new java.awt.Font("Georgia", 0, 13)); // NOI18N
        check.setForeground(new java.awt.Color(255, 255, 255));
        check.setText("Make Password Visible");
        check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMouseClicked(evt);
            }
        });
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Forgot Your Password?");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 0)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        attempts.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        attempts.setForeground(new java.awt.Color(255, 0, 0));
        attempts.setText("You have x attempts left");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(check)
                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                        .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                        .addComponent(attempts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 34, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(141, 141, 141))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(check)
                .addGap(18, 18, 18)
                .addComponent(attempts)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(42, 42, 42))
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

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        go();
    }//GEN-LAST:event_usernameActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        new Register().setVisible(true);
        close();
    }//GEN-LAST:event_registerActionPerformed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        String u = username.getText(); //Start Typing Username
        if (u.equals("Username")) {
            username.setText("");
            username.setForeground(Color.white);
        }

        String p = new String(password.getPassword()); //Resets Password
        if (p.equals("")) {
            password.setEchoChar((char) 0);
            password.setText("Password");
            password.setForeground(Color.gray);
        }
    }//GEN-LAST:event_usernameKeyPressed

    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked
        String u = username.getText(); //Start Typing Username
        if (u.equals("Username")) {
            username.setText("");
            username.setForeground(Color.white);
        }

        String p = new String(password.getPassword()); //Resets Password
        if (p.equals("")) {
            password.setEchoChar((char) 0);
            password.setText("Password");
            password.setForeground(Color.gray);
        }
    }//GEN-LAST:event_usernameMouseClicked

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        String p = new String(password.getPassword()); //Start Typing Password
        if (p.equals("Password")) {
            password.setText("");
            password.setEchoChar('*');
            password.setForeground(Color.white);
        }

        String u = username.getText(); //Resets Username if Nothing Has Been Typed
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passwordKeyPressed

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked
        String p = new String(password.getPassword()); //Start Typing Password
        if (p.equals("Password")) {
            password.setText("");
            password.setEchoChar('*');
            password.setForeground(Color.white);
        }

        String u = username.getText(); //Resets Username if Nothing Has Been Typed
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passwordMouseClicked

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        String p = new String(password.getPassword());
        if (p.equals("Password")) {
            password.setEchoChar((char) 0);
        } else {
            if (check.isSelected()) { //Show Password
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_checkActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        go();
    }//GEN-LAST:event_loginActionPerformed

    private void checkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMouseClicked
        String u = username.getText(); //Start Typing Username
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }

        String p = new String(password.getPassword()); //Resets Password
        if (p.equals("")) {
            password.setEchoChar((char) 0);
            password.setText("Password");
            password.setForeground(Color.gray);
        }
    }//GEN-LAST:event_checkMouseClicked

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        go();
    }//GEN-LAST:event_passwordActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        recover();
    }//GEN-LAST:event_jLabel3MouseClicked

    public void recover() {
        new RecoverData().setVisible(true);
        close();
    }

    public int counter = 0;

    Connection conn = null; //Database Connection
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String un = "matija";
    String pw = "1234";

    public void check() { //Checks for password matched with username
        int t = 0;

        String user = username.getText().toLowerCase();
        String pass = password.getText();

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);

            pstmt = conn.prepareStatement("Select * from MyTable1 where username=?");
            pstmt.setString(1, user);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (pass.equals(rs.getString("Password"))) {
                    t = 1;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!\n");

        }
        if (t == 1) {
            transfer();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR!\nWrong Password");
            counter = counter + 1;

            if (3 - counter == 0) {
                JOptionPane.showMessageDialog(null, "You Have Ran Out of Attempts");
                username.setEnabled(false);
                password.setEnabled(false);
            } else {
                int q = 3 - counter;
                attempts.setVisible(true);
                attempts.setText("You Have " + q + " Attempts Left");
                jPanel1.revalidate();
                jPanel1.repaint();
            }

        }

    }

    void go() {
        int t = 0;
        String user = username.getText().toLowerCase();

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from MyTable1");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (user.equalsIgnoreCase(rs.getString("Username"))) {
                    t = 1;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!\n");
        } finally {
            try {
                conn.close();
                pstmt.close();
                rs.close();
            } catch (SQLException E) {
                JOptionPane.showMessageDialog(null, "Error!\n");
            }
        }
        if (t == 1) {
            check();
        }
        if (t == 0) {
            JOptionPane.showMessageDialog(null, "Error!\nUsername Doesn't Exist");
            counter = counter + 1;

            if (3 - counter == 0) {
                JOptionPane.showMessageDialog(null, "You Have Ran Out of Attempts");
                username.setEnabled(false);
                password.setEnabled(false);
                login.setEnabled(false);
            } else {
                int q = 3 - counter;
                attempts.setVisible(true);
                attempts.setText("You Have " + q + " Attempts Left");
                jPanel1.revalidate();
                jPanel1.repaint();
            }
        }
    }

    void transfer() {
        String c = "Student";

        int trigger = 0;

        String user = username.getText().toLowerCase();

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from MyTable1 where username=?");
            pstmt.setString(1, user);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (c.equals(rs.getString("Title"))) {
                    trigger = 1;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!\n");
        }

        if (trigger == 1) {
            new Student(user).setVisible(true);
        }
        if (trigger == 0) {
            new Teacher(user).setVisible(true);
        }
        close();
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel attempts;
    public javax.swing.JCheckBox check;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JProgressBar jProgressBar1;
    public javax.swing.JButton login;
    public javax.swing.JPasswordField password;
    public javax.swing.JButton register;
    public javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
