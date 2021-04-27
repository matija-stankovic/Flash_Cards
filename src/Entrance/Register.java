package Entrance;

import Recover.RecoverData;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

public class Register extends javax.swing.JFrame {

    Connection DB = null; //Database Connection for the whole class
    Statement ST = null; //Statement for the whole class
    ResultSet RS = null; //Represent The Data From The DataBase
    ResultSetMetaData mymeta = null;
    PreparedStatement pstmt = null;

    public Register() {
        initComponents();
        p1.setEchoChar((char) 0);
        p2.setEchoChar((char) 0);
        username.setForeground(Color.gray);
        name.setForeground(Color.gray);
        email.setForeground(Color.gray);
        p1.setForeground(Color.gray);
        p2.setForeground(Color.gray); //this sets the initial state of the GUI

        String query = "SELECT * FROM MATIJA.MYTABLE1";

        String un = "matija";
        String pw = "1234";

        try {
            DB = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw); //connecting to the database
            ST = DB.createStatement();
            RS = ST.executeQuery(query); //Get data
            mymeta = RS.getMetaData(); //This is for DataAnalysis from the DB, useful for loops

        } catch (SQLException e) {
            e.printStackTrace();
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
        name = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        p1 = new javax.swing.JPasswordField();
        p2 = new javax.swing.JPasswordField();
        check = new javax.swing.JCheckBox();
        back = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        box = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Register");

        name.setBackground(new java.awt.Color(0, 0, 51));
        name.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Name");
        name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
        });

        username.setBackground(new java.awt.Color(0, 0, 51));
        username.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Username");
        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
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

        email.setBackground(new java.awt.Color(0, 0, 51));
        email.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("Email");
        email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailMouseClicked(evt);
            }
        });
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
        });

        p1.setBackground(new java.awt.Color(0, 0, 51));
        p1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 255, 255));
        p1.setText("Enter Password");
        p1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        p1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1MouseClicked(evt);
            }
        });
        p1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1ActionPerformed(evt);
            }
        });
        p1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                p1KeyPressed(evt);
            }
        });

        p2.setBackground(new java.awt.Color(0, 0, 51));
        p2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        p2.setForeground(new java.awt.Color(255, 255, 255));
        p2.setText("Repeat Password");
        p2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        p2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p2MouseClicked(evt);
            }
        });
        p2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2ActionPerformed(evt);
            }
        });
        p2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                p2KeyPressed(evt);
            }
        });

        check.setFont(new java.awt.Font("Georgia", 0, 13)); // NOI18N
        check.setForeground(new java.awt.Color(255, 255, 255));
        check.setText("Make Passwords Visible");
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

        back.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("I am a:");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        box.setBackground(new java.awt.Color(255, 153, 0));
        box.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Student", "Teacher" }));
        box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxMouseClicked(evt);
            }
        });
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });
        box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boxKeyPressed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(check)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(22, 22, 22))
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

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        register();
    }//GEN-LAST:event_emailActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (pw1.equals("Enter Password")) {
            p1.setEchoChar((char) 0);
        } else {
            if (check.isSelected()) { //Show Password
                p1.setEchoChar((char) 0);
            } else {
                p1.setEchoChar('*');
            }
        }

        if (pw2.equals("Repeat Password")) {
            p2.setEchoChar((char) 0);
        } else {
            if (check.isSelected()) { //Show Password
                p2.setEchoChar((char) 0);
            } else {
                p2.setEchoChar('*');
            }

        }
    }//GEN-LAST:event_checkActionPerformed

    private void p1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1ActionPerformed
        register();
    }//GEN-LAST:event_p1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Go Back", "Back", JOptionPane.OK_CANCEL_OPTION);

        if (p == 0) {
            new Login().setVisible(true);
            close();
        }
    }//GEN-LAST:event_backActionPerformed

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (n.equals("Name")) {
            name.setText("");
            name.setForeground(Color.WHITE);
        }
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
        if (e.equals("")) {
            email.setText("Email");
            email.setForeground(Color.gray);
        }
        if (pw1.equals("")) {
            p1.setText("Enter Password");
            p1.setForeground(Color.gray);
        }
        if (pw2.equals("")) {
            p2.setText("Repeat Password");
            p2.setForeground(Color.gray);
            p2.setEchoChar((char) 0);
        }

    }//GEN-LAST:event_nameKeyPressed

    private void p2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2ActionPerformed
        register();
    }//GEN-LAST:event_p2ActionPerformed

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (n.equals("Name")) {
            name.setText("");
            name.setForeground(Color.WHITE);
        }
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
        if (e.equals("")) {
            email.setText("Email");
            email.setForeground(Color.gray);
        }
        if (pw1.equals("")) {
            p1.setText("Enter Password");
            p1.setForeground(Color.gray);
        }
        if (pw2.equals("")) {
            p2.setText("Repeat Password");
            p2.setForeground(Color.gray);
            p2.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_nameMouseClicked

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (u.equals("Username")) {
            username.setText("");
            username.setForeground(Color.WHITE);
        }
        if (n.equals("")) {
            name.setText("Name");
            name.setForeground(Color.gray);
        }
        if (e.equals("")) {
            email.setText("Email");
            email.setForeground(Color.gray);
        }
        if (pw1.equals("")) {
            p1.setText("Enter Password");
            p1.setForeground(Color.gray);
            p1.setEchoChar((char) 0);
        }
        if (pw2.equals("")) {
            p2.setText("Repeat Password");
            p2.setForeground(Color.gray);
            p2.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_usernameKeyPressed

    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (u.equals("Username")) {
            username.setText("");
            username.setForeground(Color.WHITE);
        }
        if (n.equals("")) {
            name.setText("Name");
            name.setForeground(Color.gray);
        }
        if (e.equals("")) {
            email.setText("Email");
            email.setForeground(Color.gray);
        }
        if (pw1.equals("")) {
            p1.setText("Enter Password");
            p1.setForeground(Color.gray);
            p1.setEchoChar((char) 0);
        }
        if (pw2.equals("")) {
            p2.setText("Repeat Password");
            p2.setForeground(Color.gray);
            p2.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_usernameMouseClicked

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (e.equals("Email")) {
            email.setText("");
            email.setForeground(Color.WHITE);
        }
        if (n.equals("")) {
            name.setText("Name");
            name.setForeground(Color.gray);
        }
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
        if (pw1.equals("")) {
            p1.setText("Enter Password");
            p1.setForeground(Color.gray);
            p1.setEchoChar((char) 0);
        }
        if (pw2.equals("")) {
            p2.setText("Repeat Password");
            p2.setForeground(Color.gray);
            p2.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_emailKeyPressed

    private void emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseClicked
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (e.equals("Email")) {
            email.setText("");
            email.setForeground(Color.WHITE);
        }
        if (n.equals("")) {
            name.setText("Name");
            name.setForeground(Color.gray);
        }
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
        if (pw1.equals("")) {
            p1.setText("Enter Password");
            p1.setForeground(Color.gray);
            p1.setEchoChar((char) 0);
        }
        if (pw2.equals("")) {
            p2.setText("Repeat Password");
            p2.setForeground(Color.gray);
            p2.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_emailMouseClicked

    private void p1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p1KeyPressed
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (pw1.equals("Enter Password")) {
            p1.setText("");
            p1.setForeground(Color.WHITE);
            p1.setEchoChar('*');
        }
        if (n.equals("")) {
            name.setText("Name");
            name.setForeground(Color.gray);
        }
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
        if (e.equals("")) {
            email.setText("Email");
            email.setForeground(Color.gray);
        }
        if (pw2.equals("")) {
            p2.setText("Repeat Password");
            p2.setForeground(Color.gray);
            p2.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_p1KeyPressed

    private void p1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseClicked
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (pw1.equals("Enter Password")) {
            p1.setText("");
            p1.setForeground(Color.WHITE);
            p1.setEchoChar('*');
        }
        if (n.equals("")) {
            name.setText("Name");
            name.setForeground(Color.gray);
        }
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
        if (e.equals("")) {
            email.setText("Email");
            email.setForeground(Color.gray);
        }
        if (pw2.equals("")) {
            p2.setText("Repeat Password");
            p2.setForeground(Color.gray);
            p2.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_p1MouseClicked

    private void p2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p2KeyPressed
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (pw2.equals("Repeat Password")) {
            p2.setText("");
            p2.setForeground(Color.WHITE);
            p2.setEchoChar('*');
        }
        if (n.equals("")) {
            name.setText("Name");
            name.setForeground(Color.gray);
        }
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
        if (e.equals("")) {
            email.setText("Email");
            email.setForeground(Color.gray);
        }
        if (pw1.equals("")) {
            p1.setText("Enter Password");
            p1.setForeground(Color.gray);
            p1.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_p2KeyPressed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        register();
    }//GEN-LAST:event_nameActionPerformed

    private void p2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MouseClicked
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (pw2.equals("Repeat Password")) {
            p2.setText("");
            p2.setForeground(Color.WHITE);
            p2.setEchoChar('*');
        }
        if (n.equals("")) {
            name.setText("Name");
            name.setForeground(Color.gray);
        }
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
        if (e.equals("")) {
            email.setText("Email");
            email.setForeground(Color.gray);
        }
        if (pw1.equals("")) {
            p1.setText("Enter Password");
            p1.setForeground(Color.gray);
            p1.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_p2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        register();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void boxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxMouseClicked
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (n.equals("")) {
            name.setText("Name");
            name.setForeground(Color.gray);
        }
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
        if (e.equals("")) {
            email.setText("Email");
            email.setForeground(Color.gray);
        }
        if (pw1.equals("")) {
            p1.setText("Enter Password");
            p1.setForeground(Color.gray);
        }
        if (pw2.equals("")) {
            p2.setText("Repeat Password");
            p2.setForeground(Color.gray);
            p2.setEchoChar((char) 0);
        }

    }//GEN-LAST:event_boxMouseClicked

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nameKeyReleased

    private void checkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMouseClicked
        String n = name.getText();
        String u = username.getText();
        String e = email.getText();
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());

        if (n.equals("")) {
            name.setText("Name");
            name.setForeground(Color.gray);
        }
        if (u.equals("")) {
            username.setText("Username");
            username.setForeground(Color.gray);
        }
        if (e.equals("")) {
            email.setText("Email");
            email.setForeground(Color.gray);
        }
        if (pw1.equals("")) {
            p1.setText("Enter Password");
            p1.setForeground(Color.gray);
        }
        if (pw2.equals("")) {
            p2.setText("Repeat Password");
            p2.setForeground(Color.gray);
            p2.setEchoChar((char) 0);
        }

    }//GEN-LAST:event_checkMouseClicked

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        register();
    }//GEN-LAST:event_usernameActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        recover();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed
        
    }//GEN-LAST:event_boxActionPerformed

    private void boxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxKeyPressed
        register();
    }//GEN-LAST:event_boxKeyPressed

    public void recover() {
        new RecoverData().setVisible(true);
        close();
    }

    public void register() {
        String pw1 = new String(p1.getPassword());
        String pw2 = new String(p2.getPassword());
        String n = name.getText();
        String u = username.getText().toLowerCase();
        String e = email.getText();
        Object selectedItem = box.getSelectedItem();
        String b = selectedItem.toString();
        int selector;
        int trig = 0;

        String e1 = "@gmail.com";
        String e2 = "@yahoo.com";
        String e3 = "@muwci.net";

        int number; //generates a one-time 6-digit password for the email 
        Random r = new Random();
        number = 100000 + r.nextInt(899999);
        String random = number + "";

        /*This next part checks if everything that is entered is correct*/
        if (!(b.equals("Select"))) {
            if (!(n.equals("Name")) && !(n.equals(""))) {
                if (!(u.equals("Username")) && !(u.equals(""))) {

                    String un = "matija"; //Copy of the username and password check
                    String pw = "1234";
                    int t = 0;
                    Connection conn = null; //Database Connection
                    ResultSet rs = null; //Represent The Data From The DataBase

                    String user = username.getText();

                    try {
                        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
                        pstmt = conn.prepareStatement("Select * from MyTable1");
                        rs = pstmt.executeQuery();

                        while (rs.next()) {
                            if (user.equals(rs.getString("Username"))) {
                                t = 1;
                            }
                        }
                    } catch (SQLException zxcv) {
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
                        JOptionPane.showMessageDialog(null, "Error!\nUsername Already Exists");
                    }
                    if (t == 0) {
                        if (!(e.equals("Email")) && !(e.equals("")) && (e.toLowerCase().contains(e1.toLowerCase()) || e.toLowerCase().contains(e2.toLowerCase()) || e.toLowerCase().contains(e3.toLowerCase()))) {
                            if ((!(pw1.equals(pw2)) || (pw1.equals("Enter Password")) || (pw2.equals("Repeat Password")))) {
                                JOptionPane.showMessageDialog(null, "Error!\nThe Passwords you Have Entered do NOT Match");
                            } else {
                                try {
                                    pstmt = DB.prepareStatement("Select * from MyTable1");
                                    RS = pstmt.executeQuery();

                                    while (RS.next()) {
                                        if (e.equals(RS.getString("Email"))) {
                                            trig = 1;
                                        } else {
                                            trig = 0;
                                        }
                                    }
                                    if (trig == 1) {
                                        JOptionPane.showMessageDialog(null, "Error!\nThis Email is Already Registered");
                                    } else {

                                        if (b.equals("Student")) {
                                            selector = 1;
                                        } else {
                                            selector = 0;
                                        }
                                        StringBuilder sb = new StringBuilder(n);
                                        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
                                        n = sb.toString();
                                        new Confirm(n, e, random, selector, b, n, u, e, pw1).setVisible(true);
                                        mail(random);
                                        System.out.print(random);

                                        close();

                                    }
                                } catch (Exception p) {
                                    JOptionPane.showMessageDialog(null, "Error!");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error!\nCheck Your Email\nNote: Only Available for @gmail, @yahoo and @muwci");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error!\nYou Must Enter a Username");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error!\nYou Must Enter a Name");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error!\nYou Must Select Either Teacher or Student");
        }
    }

    public void mail(String random) { //Sends Email
        String n = name.getText();
        StringBuilder sb = new StringBuilder(n);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        n = sb.toString();
        try {

            String host = "smtp.gmail.com";
            String user = "ia.flashcards@gmail.com";
            String pass = "Kelthazard1";
            String to = email.getText();
            String from = "IA.FlashCards@gmail.com";
            String subject = "Registration For Your Flashcards";
            String messageText = "Dear " + n + ",\nYour Registration Code is: \n\n" + random + "\n\nPlease use this Code to Finish your Registration\nThank You!";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (Exception ex) {
            System.out.println(ex);
        }
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton back;
    public javax.swing.JComboBox<String> box;
    public javax.swing.JCheckBox check;
    public javax.swing.JTextField email;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JTextField name;
    public javax.swing.JPasswordField p1;
    public javax.swing.JPasswordField p2;
    public javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
