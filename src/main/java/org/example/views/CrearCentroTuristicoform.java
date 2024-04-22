/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.example.views;

import org.example.models.CentroTuristico;
import org.example.models.Solicitud;
import org.example.services.Services;
import org.example.services.Views;

import java.awt.*;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class CrearCentroTuristicoform extends javax.swing.JDialog {
    private final Services services = Services.getInstance();
    private final CentroTuristico centroTuristico;
    private final Solicitud solicitud;

    /**
     * Creates new form CrearCentroTuristicoform
     */
    public CrearCentroTuristicoform(java.awt.Frame parent, boolean modal, CentroTuristico centroTuristico, Solicitud solicitud) {
        super(parent, modal);
        this.centroTuristico = centroTuristico;
        this.solicitud = solicitud;
        initComponents();
        this.setVisible(true);
        cargarCentroTuristico();
    }

    private void cargarCentroTuristico(){
        tf_nombreCentro.setText(centroTuristico.getNombre() != null ? centroTuristico.getNombre() : "");
        cb_tieneContrato.setSelected(centroTuristico.isTieneContrato());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_tieneContrato = new javax.swing.JCheckBox();
        btn_registrarCentro = new javax.swing.JButton();
        btn_atrasCentro = new javax.swing.JButton();
        tf_nombreCentro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Introduce los datos del centro");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del centro:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tiene Contrato?");

        btn_registrarCentro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_registrarCentro.setText("Registrar");
        btn_registrarCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btn_registrarCentroActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btn_atrasCentro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_atrasCentro.setText("Atrás");
        btn_atrasCentro.setMaximumSize(new java.awt.Dimension(84, 27));
        btn_atrasCentro.setMinimumSize(new java.awt.Dimension(84, 27));
        btn_atrasCentro.setPreferredSize(new java.awt.Dimension(84, 27));
        btn_atrasCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btn_atrasCentroActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cb_tieneContrato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tf_nombreCentro)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_registrarCentro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(btn_atrasCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_nombreCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_tieneContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_registrarCentro)
                    .addComponent(btn_atrasCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registrarCentroActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btn_registrarCentroActionPerformed
        String nombreCentro = tf_nombreCentro.getText();
        boolean tieneContrato = cb_tieneContrato.isSelected();

        centroTuristico.setNombre(nombreCentro);
        centroTuristico.setTieneContrato(tieneContrato);

        services.registrarCentroTuristico(centroTuristico);
        Views.vaciarTf(tf_nombreCentro);
    }//GEN-LAST:event_btn_registrarCentroActionPerformed

    private void btn_atrasCentroActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btn_atrasCentroActionPerformed
        this.dispose();
        CrearSolicitudForm csf = new CrearSolicitudForm((Frame) getParent(), true, solicitud);
    }//GEN-LAST:event_btn_atrasCentroActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CrearCentroTuristicoform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CrearCentroTuristicoform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CrearCentroTuristicoform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CrearCentroTuristicoform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                CrearCentroTuristicoform dialog = new CrearCentroTuristicoform(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atrasCentro;
    private javax.swing.JButton btn_registrarCentro;
    private javax.swing.JCheckBox cb_tieneContrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tf_nombreCentro;
    // End of variables declaration//GEN-END:variables
}
