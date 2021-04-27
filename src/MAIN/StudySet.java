package MAIN;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class StudySet extends javax.swing.JFrame {

    public StudySet() {
        initComponents();
    }

    public String usern;

    public StudySet(String n, String us) {
        initComponents();
        name.setText(n);
        usern = us;
        checkForSets();
        showSubjects();
        fillTable();
        show.setVisible(false);
        back.setVisible(false);
        table.setEnabled(false);
    }

    String un = "matija";
    String pw = "1234";

    Connection conn = null; //Database Connection
    PreparedStatement pstmt = null;
    ResultSet rs = null; //Represent The Data From The DataBase
    
    public int ff = 0;

    public void checkForSets() {
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from STUDENTSETS where Username=?");
            pstmt.setString(1, usern);
            rs = pstmt.executeQuery();
            while(rs.next()){
                ff++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudySet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    public void showSubjects() {

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from STUDENTS where Username=?");
            pstmt.setString(1, usern);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                box.addItem(rs.getString("Subject"));
            }
            
            if(ff>1){
                box.addItem("My Study Set");
            }
            conn.close();
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!\n");

        }

    }

    public int checker;

    public void fillTable() {
        try {
            Connection DB = null; //Database Connection for the whole class
            Statement ST = null; //Statement for the whole class
            ResultSet RS = null;
            Object selectedItem = box.getSelectedItem();
            String where = selectedItem.toString();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            if (where.equals("My Study Set")) {
                where = "STUDENTSETS";
                String query = "SELECT * FROM " + where + " WHERE Username=?";


                DB = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw); //connecting to the database
                PreparedStatement ps = DB.prepareStatement(query);
                ps.setString(1, usern);
                RS = ps.executeQuery();
                if (RS.next()) {
                    int rowCount = model.getRowCount();
                    for (int i = rowCount - 1; i >= 0; i--) {
                        model.removeRow(i);
                    }
                    while (RS.next()) {
                        model.addRow(new Object[]{RS.getString("NAMEOFSET"), RS.getString("TERM"), RS.getString("DEFINITION")});
                    }
                    showCard();
                } else {
                    int rowCount = model.getRowCount();
                    for (int i = rowCount - 1; i >= 0; i--) {
                        model.removeRow(i);
                    }
                    model.addRow(new Object[]{"No Elements Here...", "", ""});
                    main.setText("No Cards to be Shown");
                }

            } else {
                String query = "SELECT * FROM " + where + "";

                String un = "matija";
                String pw = "1234";

                DB = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw); //connecting to the database
                ST = DB.createStatement();
                RS = ST.executeQuery(query);

                if (RS.next()) {
                    table.setModel(DbUtils.resultSetToTableModel(RS));
                    showCard();
                } else {
                    int rowCount = model.getRowCount();
                    if (rowCount != 0) {
                        rowCount++;
                        for (int i = rowCount - 1; i >= 0; i--) {
                            model.removeRow(i);
                        }
                        model.addRow(new Object[]{"No Elements Here...", "", ""});
                        main.setText("No Cards to be Shown");
                    } else {
                        model.addRow(new Object[]{"No Elements Here...", "", ""});
                        main.setText("No Cards to be Shown");
                    }

                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "WARNING!\n\nYou Don't Have Any Study Sets Created");

        }

    }

    public int counter = 0;

    public void showCard() {
        String term = (String) (table.getModel().getValueAt(counter, 1));
        main.setText(term);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        main = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        next = new javax.swing.JButton();
        box = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        finish = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        show = new javax.swing.JButton();
        head = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

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

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Study Your Study Set");

        main.setEditable(false);
        main.setFont(new java.awt.Font("Georgia", 2, 48)); // NOI18N
        main.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        main.setText("Term/Definition");
        main.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMouseClicked(evt);
            }
        });
        main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Click the Card to See Definition");

        back.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        next.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        box.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        box.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                boxFocusLost(evt);
            }
        });
        box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boxMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxMouseClicked(evt);
            }
        });
        box.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                boxInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });
        box.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                boxPropertyChange(evt);
            }
        });

        table.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Set", "Term", "Definition"
            }
        ));
        jScrollPane1.setViewportView(table);

        finish.setText("Finish");
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Name");

        show.setBackground(new java.awt.Color(255, 153, 0));
        show.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        show.setText("Show Table");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        head.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        head.setForeground(new java.awt.Color(255, 255, 255));
        head.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        head.setText("Term:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE))
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(show)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(next)
                        .addGap(318, 318, 318))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 617, Short.MAX_VALUE)
                .addComponent(finish, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(617, 617, 617))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(head)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(back)
                            .addComponent(next)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show)))
                .addGap(12, 12, 12)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(finish, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        next.setVisible(true);
        if (counter > 0) {
            counter--;
            if (counter == 0) {
                back.setVisible(false);

            } else {
                back.setVisible(true);
                jPanel1.revalidate();
                jPanel1.repaint();
            }
            //Enter to show flashcard
        }
        head.setText("Term:");
        showCard();
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_backActionPerformed

    private void finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishActionPerformed
        new Student(usern).setVisible(true);
        close();
    }//GEN-LAST:event_finishActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        back.setVisible(true);
        int rows = table.getRowCount();
        if (counter < rows) {
            counter++;

        }
        if (counter == rows - 1) {
            next.setVisible(false);

        } else {
            next.setVisible(true);
        }
        showCard();
        head.setText("Term:");

        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_nextActionPerformed


    private void mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMouseClicked
        table.setVisible(false);
        show.setVisible(true);
        jPanel1.revalidate();
        jPanel1.repaint();

        String un = "matija";
        String pw = "1234";

        Connection conn = null; //Database Connection
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String t = (String) (table.getModel().getValueAt(counter, 1));
        Object selectedItem = box.getSelectedItem();
        String where = selectedItem.toString();
        String c = main.getText();
        String d = "";

        try {

            if (where.equals("My Study Set")) {
                where = "STUDENTSETS";
            }

            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from " + where + " WHERE Term =?");
            pstmt.setString(1, t);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                d = rs.getString("Definition");
            }

            if (c.equals(t)) {
                main.setText(d);
                head.setText("Definition:");
            }
            if (c.equals(d)) {
                main.setText(t);
                head.setText("Term:");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_mainMouseClicked

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        table.setVisible(true);
        show.setVisible(false);
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_showActionPerformed

    private void boxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxMouseClicked
        fillTable();
        showCard();
    }//GEN-LAST:event_boxMouseClicked

    private void mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainActionPerformed

    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed
        fillTable();
        showCard();
    }//GEN-LAST:event_boxActionPerformed

    private void boxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxMouseReleased
        fillTable();
        showCard();
    }//GEN-LAST:event_boxMouseReleased

    private void boxInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_boxInputMethodTextChanged
        fillTable();
        showCard();
    }//GEN-LAST:event_boxInputMethodTextChanged

    private void boxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_boxFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_boxFocusLost

    private void boxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_boxPropertyChange

    }//GEN-LAST:event_boxPropertyChange

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
            java.util.logging.Logger.getLogger(StudySet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudySet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudySet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudySet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new StudySet().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton back;
    public javax.swing.JComboBox<String> box;
    public javax.swing.JButton finish;
    public javax.swing.JLabel head;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField main;
    public javax.swing.JLabel name;
    public javax.swing.JButton next;
    public javax.swing.JButton show;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
