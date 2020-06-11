/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.stms.view;

import com.industrialmaster.stms.controller.CourseController;
import com.industrialmaster.stms.controller.PaymentController;
import com.industrialmaster.stms.controller.PaymentController;
import com.industrialmaster.stms.controller.StuCourseController;
import com.industrialmaster.stms.controller.StudentController;
import com.industrialmaster.stms.model.Course;
import com.industrialmaster.stms.model.Payment;
import com.industrialmaster.stms.model.Payment;
import com.industrialmaster.stms.model.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hasi CP
 */
public class PaymentDetails extends javax.swing.JPanel {

    /**
     * Creates new form StudentsWithPayment
     */
    public PaymentDetails() {
        initComponents();
        loadallStudent_ID();
        loadallCourseID();
        loadAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbStu = new javax.swing.JComboBox<>();
        cmbCourses = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPaidAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 0));

        cmbStu.setBackground(new java.awt.Color(102, 204, 0));
        cmbStu.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        cmbStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStuActionPerformed(evt);
            }
        });

        cmbCourses.setBackground(new java.awt.Color(102, 255, 51));
        cmbCourses.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N

        tblView.setBackground(new java.awt.Color(204, 204, 0));
        tblView.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tblView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment_ID", "Stu_ID", "CousreID", "Course Fee", "Total Paid", "Blance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblView);
        if (tblView.getColumnModel().getColumnCount() > 0) {
            tblView.getColumnModel().getColumn(0).setMinWidth(80);
            tblView.getColumnModel().getColumn(0).setMaxWidth(80);
            tblView.getColumnModel().getColumn(1).setMinWidth(150);
            tblView.getColumnModel().getColumn(1).setMaxWidth(150);
            tblView.getColumnModel().getColumn(2).setMinWidth(150);
            tblView.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        jButton1.setBackground(new java.awt.Color(102, 51, 0));
        jButton1.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 0, 255));
        btnSave.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(255, 0, 0));
        btndelete.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Student_ID");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setText("Course_ID");

        txtPaidAmount.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setText("Paid Amount(Rs):");

        btnUpdate.setBackground(new java.awt.Color(102, 0, 204));
        btnUpdate.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Unispace", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("                                  Payment Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnUpdate)
                .addGap(30, 30, 30)
                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbStu, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cmbCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(213, 213, 213)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtPaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 272, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadallStudent_ID(){
        try {
            ArrayList<String> allStudent_ID = StuCourseController.getAllStu_ID();
            
            for (String id : allStudent_ID) {
                
                cmbStu.addItem(id);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadallCourseID(){
        
        try {
            ArrayList<String> allCourseID = StuCourseController.getAllCourse_ID();
            
            for (String id : allCourseID) {
                
                cmbCourses.addItem(id);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        try {

            String sid=(String) cmbStu.getSelectedItem();
            String cid=(String) cmbCourses.getSelectedItem();
            Double amount=Double.parseDouble(txtPaidAmount.getText());
            
            Payment pay=new Payment();
            pay.setStudent_ID(Integer.parseInt(sid));
            pay.setCourseID(cid);
            pay.setPaidAmount(amount);
            
            
            boolean isSaved=PaymentController.Save(pay);

            if(isSaved){
                JOptionPane.showMessageDialog(this, "Saved");
            }else{
                JOptionPane.showMessageDialog(this, "Error");
            }

        } catch (Exception ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnSaveActionPerformed
        
    
    
    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try {
            // TODO add your handling code here:
            int row=tblView.getSelectedRow();
            String id=(String) tblView.getValueAt(row, 0);

            boolean isDeleted=PaymentController.Delete(Integer.parseInt(id));

            if(isDeleted)
            JOptionPane.showMessageDialog(this, "DELETED");
            else
            JOptionPane.showMessageDialog(this, "Error");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void cmbStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStuActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbStuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {

          DefaultTableModel dtm=(DefaultTableModel) tblView.getModel();
            dtm.setRowCount(0);

            List<Payment> list=PaymentController.selectAll();
            Course cs=new Course();
            
           

            for (Payment pay : list) {
                
                Course courseFee = PaymentController.getCourseFee(pay.getCourseID());
                Object[] row={""+pay.getPayment_ID(),""+pay.getStudent_ID(),""+pay.getCourseID(),courseFee.getFee(),pay.getPaidAmount(),courseFee.getFee()-pay.getPaidAmount()};
                dtm.addRow(row);

            }


        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException ex){
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewMouseClicked
       
        try {
            int row =tblView.getSelectedRow();
            String id= (String) tblView.getValueAt(row, 0);
            
            Payment pay=PaymentController.get(Integer.parseInt(id));
            
            cmbStu.setSelectedItem(""+pay.getStudent_ID());
            cmbCourses.setSelectedItem(pay.getCourseID());
           txtPaidAmount.setText(""+pay.getPaidAmount());
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tblViewMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        try {
            int row=tblView.getSelectedRow();
            String id=(String) tblView.getValueAt(row,0);
            
            Payment pay=new Payment();
            
            Double paid = Double.parseDouble(txtPaidAmount.getText());
            pay.setPaidAmount(paid);
            pay.setPayment_ID(Integer.parseInt(id));
            boolean isUpdated=PaymentController.Update(pay);
            
            if(isUpdated)
                JOptionPane.showMessageDialog(this, "Updated Successfully");
            else
                JOptionPane.showMessageDialog(this, "Error Updating");            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btndelete;
    private javax.swing.JComboBox<String> cmbCourses;
    private javax.swing.JComboBox<String> cmbStu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblView;
    private javax.swing.JTextField txtPaidAmount;
    // End of variables declaration//GEN-END:variables

    private void loadAll() {
          try {

            DefaultTableModel dtm=(DefaultTableModel) tblView.getModel();
            dtm.setRowCount(0);

            List<Payment> list=PaymentController.selectAll();
            Course cs=new Course();
            
           

            for (Payment pay : list) {
                
                Course courseFee = PaymentController.getCourseFee(pay.getCourseID());
                Object[] row={""+pay.getPayment_ID(),""+pay.getStudent_ID(),""+pay.getCourseID(),courseFee.getFee(),pay.getPaidAmount(),courseFee.getFee()-pay.getPaidAmount()};
                dtm.addRow(row);

            }


           
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException ex){
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}