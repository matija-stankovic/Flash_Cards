package MAIN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class studentList extends javax.swing.JFrame {

    public studentList() {
        initComponents();
    }

    public String Name;

    public studentList(String name) {
        initComponents();
        n.setText(name);
        showSubjects();
        sm.setEnabled(false);
        Name = name;
        search.setEnabled(false);
    }

    String un = "matija";
    String pw = "1234";

    Connection conn = null; //Database Connection
    PreparedStatement pstmt = null;
    ResultSet rs = null; //Represent The Data From The DataBase

    public void showSubjects() {
        String teacherName = n.getText();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);
            pstmt = conn.prepareStatement("Select * from CLASSES where Teacher=?");
            pstmt.setString(1, teacherName);
            rs = pstmt.executeQuery();

            pstmt = conn.prepareStatement("Select * from CLASSES where Teacher=?");
            pstmt.setString(1, teacherName);
            while (rs.next()) {
                box.addItem(rs.getString("Subject"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }
    

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        String Name = n.getText();
        Object selectedItem = box.getSelectedItem();
        String subject = selectedItem.toString();
        String where = Name + subject;

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);

            pstmt = conn.prepareStatement("Select * from STUDENTS where Subject=?");
            pstmt.setString(1, where);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("Name"), rs.getString("Username")});

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        box = new javax.swing.JComboBox<>();
        n = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        sm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jButton1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Table.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Username"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        box.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });

        n.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        n.setForeground(new java.awt.Color(255, 255, 255));
        n.setText("Name");

        jButton2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton2.setText("Go");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Search by Name:");

        search.setBackground(new java.awt.Color(0, 0, 51));
        search.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        search.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                searchComponentAdded(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                searchPropertyChange(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        sm.setBackground(new java.awt.Color(255, 153, 0));
        sm.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        sm.setForeground(new java.awt.Color(255, 255, 255));
        sm.setText("Send a Message");
        sm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(n)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(n)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed

    }//GEN-LAST:event_boxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fillTable();
        search.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        String s = search.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        
        Vector OTM;
        OTM = (Vector) model.getDataVector().clone();
        
        DefaultTableModel currentModel = (DefaultTableModel) Table.getModel();
        currentModel.setRowCount(0);
        
        for(Object rows : OTM){
            Vector rowVector = (Vector) rows;
            for(Object column : rowVector){
                if(column.toString().toLowerCase().contains(s)){
                    currentModel.addRow(rowVector);
                    break;
                }
            }
        }
    }//GEN-LAST:event_searchKeyPressed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        fillTable();
        String s = search.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        
        Vector OTM;
        OTM = (Vector) model.getDataVector().clone();
        
        DefaultTableModel currentModel = (DefaultTableModel) Table.getModel();
        currentModel.setRowCount(0);
        
        for(Object rows : OTM){
            Vector rowVector = (Vector) rows;
            for(Object column : rowVector){
                if(column.toString().toLowerCase().contains(s)){
                    currentModel.addRow(rowVector);
                    break;
                }
            }
        }
    }//GEN-LAST:event_searchKeyReleased

    public int select(){
        int i = Table.getSelectedRow();
        return i;
    }
    
    private void smActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smActionPerformed
        
        int sl = select();
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        String u = model.getValueAt(sl, 1).toString();
        String mail = "";
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IA", un, pw);

            pstmt = conn.prepareStatement("Select * from MyTable1 where Username=?");
            pstmt.setString(1, u);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                mail = rs.getString("Email");
            }
            new SendMessage(mail, Name).setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_smActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        sm.setEnabled(true);
    }//GEN-LAST:event_TableMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_searchPropertyChange

    private void searchComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_searchComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_searchComponentAdded

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new studentList().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Table;
    public javax.swing.JComboBox<String> box;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel n;
    public javax.swing.JTextField search;
    public javax.swing.JButton sm;
    // End of variables declaration//GEN-END:variables
}
