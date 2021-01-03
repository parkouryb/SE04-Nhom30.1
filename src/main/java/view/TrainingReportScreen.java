/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Entity.Subject;
import Entity.TrainingScores;
import Hibernate.HibernateUtils;
import Interactive.getOperation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author Cam Nhung
 */
public class TrainingReportScreen extends javax.swing.JFrame {

//    private boolean toggleStatus = false;

    /**
     * Creates new form UserProfileScreen
     */
    private static String filePath = System.getProperty("user.dir") + "\\loginID.txt";
    public TrainingReportScreen() {
        initComponents();
//        panelToggle.setVisible(toggleStatus);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TrainingReportTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnToggle = new javax.swing.JToggleButton();
        panelToggle = new javax.swing.JPanel();
        btnSchedule = new javax.swing.JButton();
        btnClassList = new javax.swing.JButton();
        btnFund = new javax.swing.JButton();
        btnEvent = new javax.swing.JButton();
        btnTrainingReport = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnStage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TrainingReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Year", "Semeter", "Point"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TrainingReportTable);
        if (TrainingReportTable.getColumnModel().getColumnCount() > 0) {
            TrainingReportTable.getColumnModel().getColumn(0).setResizable(false);
            TrainingReportTable.getColumnModel().getColumn(1).setResizable(false);
            TrainingReportTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 205, 170));

        btnToggle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnToggle.setText("//user full name");
        btnToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleActionPerformed(evt);
            }
        });

        panelToggle.setBackground(new java.awt.Color(102, 205, 170));
        panelToggle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSchedule.setText("Th�?i khóa biểu (edit - view)");
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });

        btnClassList.setText("Danh sách lớp");
        btnClassList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassListActionPerformed(evt);
            }
        });

        btnFund.setText("Quỹ lớp");
        btnFund.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFundActionPerformed(evt);
            }
        });

        btnEvent.setText("Các sự kiện ");
        btnEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventActionPerformed(evt);
            }
        });

        btnTrainingReport.setText("�?iểm rèn luyện");
        btnTrainingReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrainingReportActionPerformed(evt);
            }
        });

        jButton7.setText("Logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        btnStage.setText("Tiến độ môn h�?c (h�?c phần)");
        btnStage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelToggleLayout = new javax.swing.GroupLayout(panelToggle);
        panelToggle.setLayout(panelToggleLayout);
        panelToggleLayout.setHorizontalGroup(
            panelToggleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClassList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFund, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTrainingReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnStage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelToggleLayout.setVerticalGroup(
            panelToggleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelToggleLayout.createSequentialGroup()
                .addComponent(btnStage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClassList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFund, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTrainingReport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelToggle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelToggle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleActionPerformed
        // TODO add your handling code here:
        //show panelToggle when user click on
        UserProfileScreen.main(null);
        this.dispose();
    }//GEN-LAST:event_btnToggleActionPerformed

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
        // TODO add your handling code here:
        ScheduleScreen.main(null);
        this.dispose();
    }//GEN-LAST:event_btnScheduleActionPerformed

    private void btnClassListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassListActionPerformed
        // TODO add your handling code here:
        ClassListScreen.main(null);
        this.dispose();
    }//GEN-LAST:event_btnClassListActionPerformed

    private void btnFundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFundActionPerformed
        // TODO add your handling code here:
        FundScreen.main(null);
        this.dispose();
    }//GEN-LAST:event_btnFundActionPerformed

    private void btnEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventActionPerformed
        // TODO add your handling code here:
        EventScreen.main(null);
        this.dispose();
    }//GEN-LAST:event_btnEventActionPerformed

    private void btnTrainingReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrainingReportActionPerformed
        // TODO add your handling code here:
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        List<TrainingScores> trainingScores = new ArrayList<>();
        try {
            session.getTransaction().begin();
            trainingScores= getOperation.loadAllData(TrainingScores.class, session);
        } catch (Exception e) {
        }
        finally{
            session.close();
        }
        loadTable(trainingScores, readID());
    }//GEN-LAST:event_btnTrainingReportActionPerformed

    private String readID(){
        Scanner scan = null;
        String studentId = "";
        try {
            scan = new Scanner(new File(filePath));
            studentId = scan.nextLine();
            scan.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserProfileScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentId;
    }
    private void loadTable(List<TrainingScores> trainingScores, String StudentId){
        Object[][] data = null;
        List<TrainingScores> student_training = new ArrayList<>();
        for (TrainingScores ts : trainingScores) {
            if(ts.getId().getStudent().getStudentId().equals(StudentId)){
                student_training.add(ts);
            }
        }
        int rows = student_training.size();
        String [][] evt = new String[rows][3];
        for (int i = 0; i < rows; i++) {
            int col = 0;
            String year = student_training.get(i).getId().getSem_year();
            String semes1 = "";
            for(int k = 0; k < 2; k++){
                semes1 += year.charAt(k);
            }
            String semes2 = "";
            for(int k = 3; k < year.length(); k++){
                semes2 += year.charAt(k);
            }
            evt[i][col] = semes2;
            col++;
            evt[i][col] = semes1;
            col++;
            evt[i][col] = Integer.toString(student_training.get(i).getPoint());
        }
        data = evt;
        TrainingReportTable.setModel(new DefaultTableModel(
                data,
                new String[] {
                    "Year", "Semeter", "Points"
                }
                ));
    }
    
    private void btnStageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStageActionPerformed
        // TODO add your handling code here:
        UserProfileScreen.main(null);
        this.dispose();
    }//GEN-LAST:event_btnStageActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
                Login.userCredit = null;
        this.dispose();
        Login.main(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TrainingReportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrainingReportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrainingReportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrainingReportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrainingReportScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TrainingReportTable;
    private javax.swing.JButton btnClassList;
    private javax.swing.JButton btnEvent;
    private javax.swing.JButton btnFund;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JButton btnStage;
    private javax.swing.JToggleButton btnToggle;
    private javax.swing.JButton btnTrainingReport;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelToggle;
    // End of variables declaration//GEN-END:variables
}
