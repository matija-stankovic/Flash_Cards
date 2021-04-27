package CreateNew;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ChooseQuestionType extends javax.swing.JFrame {

    public ChooseQuestionType() {
        initComponents();
    }

    public String teacherName;
    public String teacherUsername;

    public ChooseQuestionType(String un, String n) {
        initComponents();
        nn.setText(n);
        la.setText(un);
        teacherName = n;
        teacherUsername = un;
        send.setBackground(Color.gray);
        send.setEnabled(false);
        box3.setEnabled(false);
        box3.setBackground(Color.gray);
        create.setEnabled(false);
        create.setBackground(Color.gray);
        showSubjects();
        showNamesOfSets();
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    String un = "matija";
    String pw = "1234";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public void showSubjects() {
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);

            pstmt = conn.prepareStatement("Select * from CLASSES where Teacher=?");
            pstmt.setString(1, teacherName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                box1.addItem(rs.getString("Subject"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void removeExtraSets() {

        int c = box3.getItemCount();

        String[] box = new String[c];
        for (int i = 0; i < c; i++) {
            box[i] = box3.getItemAt(i);
        }

        for (int i = 0; i < c - 1; i++) {
            for (int y = i + 1; y < c; y++) {
                if (box[i].equalsIgnoreCase(box[y]) == true) {
                    box[y] = box[c - 1];
                    c--;
                    y--;
                }
            }
        }
        box3.removeAllItems();
        for (int i = 0; i < c; i++) {
            box3.addItem(box[i]);
        }
    }

    public void showNamesOfSets() {
        Object selectedItem = box1.getSelectedItem();
        String where = teacherName + selectedItem.toString();
        String s = "";
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from " + where + "");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                s = rs.getString("Name");
                if (!(s.equals("Base"))) {
                    box3.addItem(s);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        b2 = new javax.swing.JRadioButton();
        nn = new javax.swing.JLabel();
        send = new javax.swing.JButton();
        create = new javax.swing.JButton();
        la = new javax.swing.JLabel();
        box1 = new javax.swing.JComboBox<>();
        b1 = new javax.swing.JRadioButton();
        box3 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nos = new javax.swing.JTextField();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose What to Send to Students");

        jButton2.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        b2.setForeground(new java.awt.Color(255, 153, 0));
        b2.setText("Send an Existing Set");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        nn.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        nn.setForeground(new java.awt.Color(255, 153, 0));
        nn.setText("Name");

        send.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        create.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        create.setText("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        la.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        la.setForeground(new java.awt.Color(255, 153, 0));
        la.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        la.setText("Username");

        box1.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });

        b1.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        b1.setForeground(new java.awt.Color(255, 153, 0));
        b1.setText("Create Your Questions");
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

        box3.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        box3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Name of Set" }));
        box3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                box3MouseClicked(evt);
            }
        });
        box3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Select Your Subject");

        nos.setBackground(new java.awt.Color(0, 0, 51));
        nos.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        nos.setForeground(new java.awt.Color(255, 255, 255));
        nos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)), "Name the Homework", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Georgia", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(249, 249, 249)
                                .addComponent(la, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b1)
                                    .addComponent(b2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nos))
                                .addGap(18, 18, 18)
                                .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(b2)
                            .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(la)
                        .addComponent(nn))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        close();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        if (b2.isSelected()) {
            b1.setSelected(false);
            send.setBackground(Color.orange);
            send.setEnabled(true);
            box3.setEnabled(true);
            box3.setBackground(Color.white);

            create.setEnabled(false);
            create.setBackground(Color.gray);

            jPanel1.revalidate();
            jPanel1.repaint();
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        String SetName = box3.getSelectedItem().toString();
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String SentOn = sdf.format(date);
        String SubjectName = teacherName + box1.getSelectedItem().toString();
        String NOS = nos.getText().replace(" ", "");

        if (SetName.equals("Select Name of Set")) {
            JOptionPane.showMessageDialog(null, "Error\nSelect the Study Set you Want to Send");
        } else {
            if (nos.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error\nName the Homework");
            } else {
                try {
                    conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
                    pstmt = conn.prepareStatement("Select * from " + SubjectName + " Where Name =?");
                    pstmt.setString(1, SetName);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        PreparedStatement add = conn.prepareStatement("Insert Into SENTQUESTIONS values (?, ?, ?, ?, ?, ?, ?)");

                        add.setString(1, SentOn);
                        add.setString(2, teacherName);
                        add.setString(3, SubjectName);
                        add.setString(4, NOS);
                        add.setString(5, rs.getString("Term"));
                        add.setString(6, rs.getString("Definition"));
                        add.setString(7, "");

                        add.executeUpdate();

                    }
                    JOptionPane.showMessageDialog(null, "The Study Set " + SetName + " has been sent to Your Students");
                    close();

                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        }
    }//GEN-LAST:event_sendActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        String subject = box1.getSelectedItem().toString();
        new NewQuestions(teacherName, subject).setVisible(true);
        close();
    }//GEN-LAST:event_createActionPerformed

    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed

    }//GEN-LAST:event_box1ActionPerformed

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked

    }//GEN-LAST:event_b1MouseClicked

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        if (b1.isSelected()) {
            b2.setSelected(false);
            send.setBackground(Color.gray);
            send.setEnabled(false);
            box3.setEnabled(false);
            box3.setBackground(Color.gray);

            create.setEnabled(true);
            create.setBackground(Color.orange);

            jPanel1.revalidate();
            jPanel1.repaint();

        }
    }//GEN-LAST:event_b1ActionPerformed

    private void box3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_box3MouseClicked
        box3.removeAllItems();
        box3.addItem("Select Name of Set");
        showNamesOfSets();
        removeExtraSets();
        removeExtraSets();
    }//GEN-LAST:event_box3MouseClicked

    private void box3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box3ActionPerformed

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
            java.util.logging.Logger.getLogger(ChooseQuestionType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseQuestionType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseQuestionType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseQuestionType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseQuestionType().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton b1;
    public javax.swing.JRadioButton b2;
    public javax.swing.JComboBox<String> box1;
    public javax.swing.JComboBox<String> box3;
    public javax.swing.JButton create;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JRadioButton jRadioButton1;
    public javax.swing.JLabel la;
    public javax.swing.JLabel nn;
    public javax.swing.JTextField nos;
    public javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables
}
