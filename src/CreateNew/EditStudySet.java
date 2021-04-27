package CreateNew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EditStudySet extends javax.swing.JFrame {

    public EditStudySet() {
        initComponents();
    }

    public EditStudySet(String receive) {
        initComponents();
        qwer.setText(receive);
        fillTable();
        createAdd.setVisible(false);
        edit.setVisible(false);
        delete.setVisible(false);
    }

    public EditStudySet(int i, String receive, String newTerm) {
        initComponents();
        qwer.setText(receive);
        fillTable();
        t.setText(newTerm);
        edit.setVisible(false);
        delete.setVisible(false);
        add.setVisible(false);
        table.setEnabled(false);
        edit.setVisible(false);
        delete.setVisible(false);
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    public void send() {
        int row = table.getSelectedRow();
        String term = (String) (table.getModel().getValueAt(row, 1));
        String definition = (String) (table.getModel().getValueAt(row, 2));
        String name = (String) (table.getModel().getValueAt(row, 0));

        t.setText(term);
        def.setText(definition);
        n.setText(name);
    }

    public void update() {
        String receive = qwer.getText();
        Connection DB = null; //Database Connection for the whole class
        String un = "matija";
        String pw = "1234";
        String sql = "Update " + receive + " set Definition = ?, Name= ? Where Term = ?";

        try {

            DB = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw); //connecting to the database

            PreparedStatement preparedStmt = DB.prepareStatement(sql);
            preparedStmt.setString(1, def.getText());
            preparedStmt.setString(2, n.getText());
            preparedStmt.setString(3, t.getText());
            preparedStmt.executeUpdate();

            DB.close();

            t.setText("");
            n.setText("");
            def.setText("");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        fillTable();
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String a = ""; //name of set
        String b = ""; //term
        String c = ""; //definition
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        try {
            Connection DB = null; //Database Connection for the whole class
            Statement ST = null; //Statement for the whole class
            ResultSet RS = null;
            String receive = qwer.getText();
            System.out.print(qwer);
            String query = "SELECT * FROM " + receive + "";

            String un = "matija";
            String pw = "1234";

            DB = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw); //connecting to the database
            ST = DB.createStatement();
            RS = ST.executeQuery(query);
            while (RS.next()) {
                a = RS.getString("NAME");
                b = RS.getString("TERM");
                c = RS.getString("DEFINITION");

                if (!(a.equals("Base") && b.equals("Base") && c.equals("Base"))) {
                    model.addRow(new Object[]{a, b, c});

                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "WARNING!\n\nYou Don't Have Any Study Sets Created");

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        create = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        t = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        def = new javax.swing.JTextArea();
        edit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        qwer = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        createAdd = new javax.swing.JButton();
        n = new javax.swing.JTextField();

        create.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        create.setText("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        label.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Edit a Study Set");

        table.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name of Study Set", "Term", "Definition"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        t.setEditable(false);
        t.setBackground(new java.awt.Color(0, 0, 51));
        t.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        t.setForeground(new java.awt.Color(255, 255, 255));
        t.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Term", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMouseClicked(evt);
            }
        });
        t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tActionPerformed(evt);
            }
        });

        def.setBackground(new java.awt.Color(0, 0, 51));
        def.setColumns(20);
        def.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        def.setForeground(new java.awt.Color(255, 255, 255));
        def.setRows(5);
        def.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Definition", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane1.setViewportView(def);

        edit.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        edit.setText("Done Editing");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jButton2.setText("Finish");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        qwer.setForeground(new java.awt.Color(0, 0, 51));
        qwer.setText("name");

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

        delete.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        add.setText("Add Term");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        createAdd.setBackground(new java.awt.Color(255, 153, 0));
        createAdd.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        createAdd.setText("Create the Added Term");
        createAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAddActionPerformed(evt);
            }
        });

        n.setBackground(new java.awt.Color(0, 0, 51));
        n.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        n.setForeground(new java.awt.Color(255, 255, 255));
        n.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)), "Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(546, 546, 546)
                                .addComponent(qwer))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(75, 75, 75)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(429, 429, 429)
                                        .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(78, 78, 78)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(createAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(466, 466, 466)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(createAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edit)
                        .addGap(18, 18, 18)
                        .addComponent(delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(qwer)
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

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed

    }//GEN-LAST:event_createActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        String SName = n.getText(); //Name of the Set
        String term = t.getText();
        String definition = def.getText();
        if (SName.equals("") || SName.equals("Name the Set")) {
            JOptionPane.showMessageDialog(null, "Please Name the Study Set");
        } else {
            if (term.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Add the Term");
            } else {
                if (definition.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Define the Term");
                } else {
                    update();
                    t.setText("");
                    def.setText("");
                    edit.setVisible(false);
                    delete.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String receive = qwer.getText();
        System.out.println(receive);
        Connection DB = null; //Database Connection for the whole class
        String un = "matija";
        String pw = "1234";

        try {

            DB = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw); //connecting to the database

            PreparedStatement st = DB.prepareStatement("DELETE FROM " + receive + " WHERE Term = ?");
            st.setString(1, t.getText());
            st.executeUpdate();

            t.setText("");
            n.setText("");
            def.setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failure");
        }
        fillTable();
    }//GEN-LAST:event_deleteActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        send();
        edit.setVisible(true);
        delete.setVisible(true);
    }//GEN-LAST:event_tableMouseClicked

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        send();
    }//GEN-LAST:event_tableKeyPressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

    }//GEN-LAST:event_jPanel1MouseClicked

    private void tMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseClicked
        JOptionPane.showMessageDialog(null, "You Cannot Change the Term Itself\nIf You Want to Replace a Term, You Must Delete the Original one");
    }//GEN-LAST:event_tMouseClicked

    private void nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String receive = qwer.getText();
        new Term(receive).setVisible(true);
        close();
    }//GEN-LAST:event_addActionPerformed

    private void tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tActionPerformed

    private void createAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAddActionPerformed
        String SName = n.getText(); //Name of the Set
        String term = t.getText();
        String definition = def.getText();
        if (SName.equals("") || SName.equals("Name the Set")) {
            JOptionPane.showMessageDialog(null, "Please Name the Study Set");
        } else {
            if (term.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Add the Term");
            } else {
                if (definition.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Define the Term");
                } else {
                    store();
                    fillTable();
                    t.setText("");
                    def.setText("");
                    n.setText("");
                    createAdd.setVisible(false);
                    edit.setVisible(false);
                    delete.setVisible(false);
                    add.setVisible(true);
                    table.setEnabled(true);
                    jPanel1.revalidate();
                    jPanel1.repaint();

                }
            }
        }
    }//GEN-LAST:event_createAddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        close();
    }//GEN-LAST:event_jButton2ActionPerformed

    void store() {
        String SName = n.getText(); //Name of the Set
        String term = t.getText();
        String definition = def.getText();
        String receive = qwer.getText();

        String un = "matija";
        String pw = "1234";

        Connection DB = null; //Database Connection for the whole class
        Statement ST = null; //Statement for the whole class
        ResultSet RS = null;

        try {
            DB = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw); //connecting to the database
            ST = DB.createStatement();
            String query = "SELECT * FROM " + receive + "";
            RS = ST.executeQuery(query);

            PreparedStatement add = DB.prepareStatement("Insert Into " + receive + " values (?, ?, ?)");

            add.setString(1, SName);
            add.setString(2, term);
            add.setString(3, definition);

            add.executeUpdate();
            DB.close();
            RS.close();

        } catch (SQLException E) {
            E.printStackTrace();
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
            java.util.logging.Logger.getLogger(EditStudySet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStudySet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStudySet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStudySet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new EditStudySet().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    public javax.swing.JButton create;
    public javax.swing.JButton createAdd;
    public javax.swing.JTextArea def;
    public javax.swing.JButton delete;
    public javax.swing.JButton edit;
    public javax.swing.JButton jButton2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel label;
    public javax.swing.JTextField n;
    public javax.swing.JLabel qwer;
    public javax.swing.JTextField t;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
