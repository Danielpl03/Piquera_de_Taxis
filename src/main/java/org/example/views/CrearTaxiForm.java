/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.example.views;

import org.example.models.Taxi;
import org.example.models.TaxiEstatal;
import org.example.models.TaxiParticular;
import org.example.services.TaxisService;
import org.example.services.Views;

import javax.swing.*;
import javax.swing.text.View;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author Daniel
 */
public class CrearTaxiForm extends javax.swing.JDialog {
    private final Taxi taxi;
    private final ButtonGroup bg = new ButtonGroup();


    /**
     * Creates new form CrearTaxiForm
     */
    public CrearTaxiForm(java.awt.Frame parent, boolean modal, Taxi taxi) {
        super(parent, modal);
        this.taxi = taxi;
        initComponents();
        cargarDatosTaxi();
        this.setVisible(true);
    }

    private void cargarDatosTaxi(){
        if (taxi != null){
            tf_chapa.setText(taxi.getId());
            tf_chofer.setText(taxi.getChofer());
            tf_marca.setText(taxi.getMarca());
            tf_capacidad.setText(String.valueOf(taxi.getCapacidad()));
            tf_combustible.setText(String.valueOf(taxi.getCombustible()));
            box_estado.setSelectedIndex(taxi.getEstado().equals("libre") ? 0 :
                                        taxi.getEstado().equals("ocupado") ? 1 : 2);
            if (taxi instanceof TaxiEstatal){
                rb_taxiEstatal.setSelected(true);
                tf_empresa.setText( ((TaxiEstatal)taxi).getEmpresa() );
            }else {
                rb_taxiParticular.setSelected(true);
                tf_noPatente.setText(((TaxiParticular) taxi).getNoPatente());
            }
            tf_chapa.setEnabled(false);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_combustible = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_capacidad = new javax.swing.JTextField();
        tf_marca = new javax.swing.JTextField();
        tf_chofer = new javax.swing.JTextField();
        tf_chapa = new javax.swing.JTextField();
        box_estado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        rb_taxiEstatal = new javax.swing.JRadioButton();
        rb_taxiParticular = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        panel_empresa = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tf_empresa = new javax.swing.JTextField();
        panel_particular = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tf_noPatente = new javax.swing.JTextField();
        btn_registrar = new javax.swing.JButton();
        btn_Atrás = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Introduce los datos del taxi");

        tf_combustible.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Chapa:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Marca:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Combustible:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Chofer:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Capacidad:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Estado:");

        tf_capacidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tf_marca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tf_chofer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tf_chapa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        box_estado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        box_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libre", "Ocupado", "En reparacion" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tipo:");

        bg.add(rb_taxiEstatal);
        rb_taxiEstatal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rb_taxiEstatal.setSelected(true);
        rb_taxiEstatal.setText("Estatal");
        rb_taxiEstatal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb_taxiEstatalStateChanged(evt);
            }
        });

        bg.add(rb_taxiParticular);
        rb_taxiParticular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rb_taxiParticular.setText("Particular");

        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Empresa:");

        tf_empresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panel_empresaLayout = new javax.swing.GroupLayout(panel_empresa);
        panel_empresa.setLayout(panel_empresaLayout);
        panel_empresaLayout.setHorizontalGroup(
            panel_empresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_empresaLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel9)
                .addGap(31, 31, 31)
                .addComponent(tf_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        panel_empresaLayout.setVerticalGroup(
            panel_empresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_empresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_empresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel2.add(panel_empresa, "card3");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("No.Patente:");

        tf_noPatente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panel_particularLayout = new javax.swing.GroupLayout(panel_particular);
        panel_particular.setLayout(panel_particularLayout);
        panel_particularLayout.setHorizontalGroup(
            panel_particularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_particularLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(tf_noPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        panel_particularLayout.setVerticalGroup(
            panel_particularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_particularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_particularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tf_noPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel2.add(panel_particular, "card2");

        btn_registrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_registrar.setText("Registrar");
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        btn_Atrás.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Atrás.setText("Atrás");
        btn_Atrás.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrásActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rb_taxiEstatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(rb_taxiParticular))
                    .addComponent(tf_chapa)
                    .addComponent(tf_combustible)
                    .addComponent(tf_capacidad)
                    .addComponent(tf_marca)
                    .addComponent(tf_chofer)
                    .addComponent(box_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btn_registrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Atrás)
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_chapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_chofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_combustible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(box_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rb_taxiEstatal)
                    .addComponent(rb_taxiParticular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_registrar)
                    .addComponent(btn_Atrás))
                .addContainerGap(39, Short.MAX_VALUE))
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

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        if(Views.validarCamposVacios(tf_capacidad, tf_chapa, tf_chofer, tf_combustible, tf_marca)){
            String estado = Objects.requireNonNull(box_estado.getSelectedItem()).toString().toLowerCase();
            String chapa = tf_chapa.getText();
            String marca = tf_marca.getText();
            String chofer = tf_chofer.getText();
            String tipo, caracteristica;
            if (rb_taxiEstatal.isSelected()){
                if (!Views.validarCamposVacios(tf_empresa))return;
                tipo = "taxi_estatal";
                caracteristica = tf_empresa.getText();

            }else{
                if (!Views.validarCamposVacios(tf_noPatente))return;
                tipo = "taxi_particular";
                caracteristica = tf_noPatente.getText();
            }
            try {
                float combustible = Float.parseFloat(tf_combustible.getText());
                int capacidad = Integer.parseInt(tf_capacidad.getText());
                Taxi taxi;
                if(tipo.equals("taxi_estatal")){
                    taxi = new TaxiEstatal(chapa, estado, marca, capacidad, combustible, chofer, caracteristica);
                }else{
                    taxi = new TaxiParticular(chapa, estado, marca, capacidad, combustible, chofer, caracteristica);
                }
                System.out.println("!!!");
                TaxisService.registrarTaxi(taxi);
                Views.vaciarTf(tf_noPatente, tf_empresa, tf_marca, tf_combustible, tf_capacidad, tf_chofer, tf_chapa);
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Debe introducir datos válidos");
            }
        }
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void btn_AtrásActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrásActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_AtrásActionPerformed

    private void rb_taxiEstatalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb_taxiEstatalStateChanged
        if (rb_taxiEstatal.isSelected()){
            Views.change_panel(panel_empresa, panel_particular);
        }else 
            Views.change_panel(panel_particular, panel_empresa);
    }//GEN-LAST:event_rb_taxiEstatalStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_estado;
    private javax.swing.JButton btn_Atrás;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panel_empresa;
    private javax.swing.JPanel panel_particular;
    private javax.swing.JRadioButton rb_taxiEstatal;
    private javax.swing.JRadioButton rb_taxiParticular;
    private javax.swing.JTextField tf_capacidad;
    private javax.swing.JTextField tf_chapa;
    private javax.swing.JTextField tf_chofer;
    private javax.swing.JTextField tf_combustible;
    private javax.swing.JTextField tf_empresa;
    private javax.swing.JTextField tf_marca;
    private javax.swing.JTextField tf_noPatente;
    // End of variables declaration//GEN-END:variables
}