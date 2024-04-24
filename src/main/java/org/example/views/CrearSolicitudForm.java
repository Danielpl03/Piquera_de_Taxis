/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.example.views;

import org.example.estructuras.Cola;
import org.example.estructuras.Node;
import org.example.models.CentroTuristico;
import org.example.models.Solicitud;
import org.example.services.CentrosTuristicosService;
import org.example.services.SolicitudesService;
import org.example.services.Views;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Daniel
 */
public class CrearSolicitudForm extends javax.swing.JDialog {
    private Solicitud solicitud;
    DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>();

    /**
     * Creates new form CrearSolicitudForm
     */
    public CrearSolicitudForm(java.awt.Frame parent, boolean modal, Solicitud solicitud) throws SQLException {
        super(parent, modal);
        this.solicitud = solicitud;
        llenarBoxCentros(CentrosTuristicosService.getCentrosTuristicos());
        initComponents();
        llenarCampos();
        this.setVisible(true);
    }

    private void llenarCampos(){
        box_elejirCentro.setSelectedItem(solicitud.getCentro() != null ? solicitud.getCentro().getNombre() : 0);
        tf_direccion.setText(solicitud.getDireccion() != null ? solicitud.getDireccion() : "" );
        tf_destino.setText(solicitud.getDestino() != null ? solicitud.getDestino() : "" );
        tf_hora.setText(solicitud.getHora() != null ? String.valueOf(solicitud.getHora()) : "");
        tf_personas.setText(solicitud.getCantPersonas() > 0 ? String.valueOf(solicitud.getCantPersonas()) : "");
        tf_km.setText(solicitud.getCantKm() > 0 ? String.valueOf(solicitud.getCantKm()) : "");
    }

    private void llenarBoxCentros(Cola<CentroTuristico> centros){

        if (!centros.isEmpty()){
            Node<CentroTuristico> nodo = centros.top();
            while (nodo != null){
                boxModel.addElement(nodo.getDate().getNombre());
                nodo = nodo.getNext();
            }
        }else
            boxModel.addElement("No hay centros");
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
        tf_personas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_destino = new javax.swing.JTextField();
        tf_hora = new javax.swing.JTextField();
        tf_direccion = new javax.swing.JTextField();
        tf_km = new javax.swing.JTextField();
        btn_crear = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        box_elejirCentro = new javax.swing.JComboBox<>();
        btn_crearCentro = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_inmediato = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Centro:");

        tf_personas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_personasKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Direccion:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Destino:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Hora:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Personas:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Km:");

        tf_hora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_horaKeyTyped(evt);
            }
        });

        tf_km.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_kmActionPerformed(evt);
            }
        });
        tf_km.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_kmKeyTyped(evt);
            }
        });

        btn_crear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_crear.setText("Registrar");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btn_crearActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btn_atras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_atras.setText("Atras");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        box_elejirCentro.setModel(boxModel);
        box_elejirCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_elejirCentroActionPerformed(evt);
            }
        });

        btn_crearCentro.setText("Nuevo");
        btn_crearCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearCentroActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Introduce los datos de la solicitud");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Inmediato?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(43, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_crear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 45, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_inmediato)
                                .addGap(309, 309, 309))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_direccion)
                            .addComponent(tf_destino)
                            .addComponent(tf_hora)
                            .addComponent(tf_personas)
                            .addComponent(tf_km)
                            .addComponent(box_elejirCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_crearCentro)))
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(box_elejirCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_crearCentro))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_destino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_personas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(cb_inmediato))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crear)
                    .addComponent(btn_atras))
                .addGap(77, 77, 77))
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

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btn_crearActionPerformed
        if(boxModel.getSelectedItem().equals("No hay centros")){
            JOptionPane.showMessageDialog(this, "Debe seleccinar un centro turistico");
            return;
        }
        if (Views.validarCamposVacios(tf_destino, tf_direccion, tf_personas, tf_km, tf_hora)) {
            int index = box_elejirCentro.getSelectedIndex();
            String direccion = tf_direccion.getText().trim();
            String destino = tf_destino.getText().trim();
            boolean inmediato = cb_inmediato.isSelected();
            try{
                LocalTime hora = LocalTime.parse(tf_hora.getText().trim());
                int personas = Integer.parseInt(tf_personas.getText().trim());
                float km = Float.parseFloat(tf_km.getText().trim());

                SolicitudesService.registrarSolicitud(solicitud.getId(), index, direccion, destino, hora, personas, km, inmediato);

                Views.vaciarTf(tf_direccion, tf_destino, tf_hora, tf_personas, tf_km);
                this.dispose();
            }catch (NumberFormatException | DateTimeParseException e){
                JOptionPane.showMessageDialog(this, "Debe introducir datos válidos");
            }
        }
    }//GEN-LAST:event_btn_crearActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void tf_kmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_kmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_kmActionPerformed

    private void box_elejirCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_elejirCentroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_elejirCentroActionPerformed

    private void btn_crearCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearCentroActionPerformed
        this.dispose();
        CrearCentroTuristicoform ctf = new CrearCentroTuristicoform((Frame) getParent(), true, new CentroTuristico(), solicitud);
    }//GEN-LAST:event_btn_crearCentroActionPerformed

    private void tf_horaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_horaKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != ':')
            evt.consume();
    }//GEN-LAST:event_tf_horaKeyTyped

    private void tf_personasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_personasKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_tf_personasKeyTyped

    private void tf_kmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_kmKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != '.')
            evt.consume();
    }//GEN-LAST:event_tf_kmKeyTyped



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_elejirCentro;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_crear;
    private javax.swing.JButton btn_crearCentro;
    private javax.swing.JCheckBox cb_inmediato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tf_destino;
    private javax.swing.JTextField tf_direccion;
    private javax.swing.JTextField tf_hora;
    private javax.swing.JTextField tf_km;
    private javax.swing.JTextField tf_personas;
    // End of variables declaration//GEN-END:variables
}
