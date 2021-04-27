package CreateNew;

import MAIN.AnswerQuestions;
import MAIN.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ChooseSentQuestions extends javax.swing.JFrame {

    public ChooseSentQuestions() {
        initComponents();
    }

    public String Name;
    public String Username;

    public ChooseSentQuestions(String n, String u) {
        initComponents();
        Name = n;
        Username = u;
        nn.setText(Name);
        la.setText(Username);
        showSubjects();
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
            pstmt = conn.prepareStatement("Select * from STUDENTS where Username=?");
            pstmt.setString(1, Username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int i = 0;
                String qwer = rs.getString("Subject");

                PreparedStatement ch = conn.prepareCall("Select * from SENTQUESTIONS where SUBJECT=?");
                ch.setString(1, qwer);
                ResultSet RS = ch.executeQuery();
                while (RS.next()) {
                    i++;
                    if (RS.getString("StudentsCompleted").contains(Name)) {
                        i--;
                    }

                }

                if (i != 0) {
                    box1.addItem(qwer);
                }

            }

            conn.close();
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!\n");

        }
    }

    public void showStudySets() {
        String box = box1.getSelectedItem().toString();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from SENTQUESTIONS where SUBJECT=?");
            pstmt.setString(1, box);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                box2.addItem(rs.getString("NameOfSet"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeExtraSets() {
        int c = box2.getItemCount();

        String[] box = new String[c];
        for (int i = 0; i < c; i++) {
            box[i] = box2.getItemAt(i);
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
        box2.removeAllItems();
        for (int i = 0; i < c; i++) {
            box2.addItem(box[i]);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        box1 = new javax.swing.JComboBox<>();
        box2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        la = new javax.swing.JLabel();
        nn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose Which Question Set To Answer");

        box1.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });

        box2.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        box2.setMaximumRowCount(20);
        box2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Study Set", " ", " ", " ", " " }));
        box2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                box2MouseClicked(evt);
            }
        });
        box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jButton1.setText("Continue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        la.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        la.setForeground(new java.awt.Color(255, 153, 0));
        la.setText("Username");

        nn.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        nn.setForeground(new java.awt.Color(255, 153, 0));
        nn.setText("Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(box2, 0, 250, Short.MAX_VALUE)
                            .addComponent(box1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(194, 194, 194))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(la)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(la)
                    .addComponent(nn))
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
        new Student(Username).setVisible(true);
        close();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void box2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_box2MouseClicked
        box2.removeAllItems();
        box2.addItem("Select Study Set");
        showStudySets();
        removeExtraSets();
        box2.revalidate();
        box2.repaint();
    }//GEN-LAST:event_box2MouseClicked

    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed

    }//GEN-LAST:event_box1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String b1 = box1.getSelectedItem().toString();
        String b2 = box2.getSelectedItem().toString();
        if (b2.equals("Select Study Set")) {
            JOptionPane.showMessageDialog(null, "ERROR\nPlease Select a Study Set");
        } else {
            new AnswerQuestions(Name, b1, b2, Username).setVisible(true);
            close();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box2ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseSentQuestions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new ChooseSentQuestions().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> box1;
    public javax.swing.JComboBox<String> box2;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel la;
    public javax.swing.JLabel nn;
    // End of variables declaration//GEN-END:variables
}
