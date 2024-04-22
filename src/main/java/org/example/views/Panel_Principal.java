package org.example.views;

import org.example.estructuras.Cola;
import org.example.estructuras.Node;
import org.example.models.CentroTuristico;
import org.example.models.Solicitud;
import org.example.services.Services;
import org.example.services.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Panel_Principal extends javax.swing.JFrame {
    private final Services services = Services.getInstance();
    JTable                  target            = new JTable();
    static int row   = -1;

    /**
     * Creates new form Panel_Principal
     */
    public Panel_Principal() {
        initComponents();
    }


    private void llenarTabla(Cola<Solicitud> solicitudes){
        DefaultTableModel modeloT = (DefaultTableModel) tabla_solicitudes.getModel();
        for (int i = modeloT.getRowCount() - 1; i >= 0; i--) {
            modeloT.removeRow(i);
        }
        if(solicitudes.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay datos para mostrar");
            return;
        }

        Node<Solicitud> nodo = solicitudes.top();
        while (nodo != null){
            String centro = nodo.getDate().getCentro().getNombre();
            String direccion = nodo.getDate().getDireccion();
            String destino = nodo.getDate().getDestino();
            LocalTime hora = nodo.getDate().getHora();
            int personas = nodo.getDate().getCantPersonas();
            float km = nodo.getDate().getCantKm();

            Object[] datos = {centro, direccion, destino, hora, personas, km};
            modeloT.addRow(datos);
            nodo = nodo.getNext();
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

        panel_bg = new javax.swing.JPanel();
        panel_home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_solicitudes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_solicitudes = new javax.swing.JTable();
        btn_crearSolicitud = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        btn_Atras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_buscar = new javax.swing.JTextField();
        btn_buscarSolicitud = new javax.swing.JButton();
        btn_editarSolicitud = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnMenu_G_solicitudes = new javax.swing.JMenuItem();
        btnMenu_G_taxis = new javax.swing.JMenuItem();
        btnMenu_G_servicios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_bg.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Piquera de Taxis");

        javax.swing.GroupLayout panel_homeLayout = new javax.swing.GroupLayout(panel_home);
        panel_home.setLayout(panel_homeLayout);
        panel_homeLayout.setHorizontalGroup(
            panel_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        panel_homeLayout.setVerticalGroup(
            panel_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_homeLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        panel_bg.add(panel_home, "card3");

        tabla_solicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Centro", "Dir. Recogida", "Destino", "Hora", "Personas", "Kilómetros"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_solicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_solicitudesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_solicitudes);
        if (tabla_solicitudes.getColumnModel().getColumnCount() > 0) {
            tabla_solicitudes.getColumnModel().getColumn(0).setResizable(false);
            tabla_solicitudes.getColumnModel().getColumn(1).setResizable(false);
            tabla_solicitudes.getColumnModel().getColumn(3).setResizable(false);
            tabla_solicitudes.getColumnModel().getColumn(4).setResizable(false);
            tabla_solicitudes.getColumnModel().getColumn(5).setResizable(false);
        }

        btn_crearSolicitud.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_crearSolicitud.setText("Registrar solicitud");
        btn_crearSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btn_crearSolicitudActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Actualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ActualizarActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btn_Atras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Atras.setText("Atras");
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Solicitudes ");

        tf_buscar.setText("Buscar...");
        tf_buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_buscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_buscarFocusLost(evt);
            }
        });

        btn_buscarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btn_buscarSolicitudActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btn_editarSolicitud.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_editarSolicitud.setText("Editar solicitud");
        btn_editarSolicitud.setEnabled(false);
        btn_editarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btn_editarSolicitudActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout panel_solicitudesLayout = new javax.swing.GroupLayout(panel_solicitudes);
        panel_solicitudes.setLayout(panel_solicitudesLayout);
        panel_solicitudesLayout.setHorizontalGroup(
            panel_solicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_solicitudesLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(btn_crearSolicitud)
                .addGap(59, 59, 59)
                .addComponent(btn_editarSolicitud)
                .addGap(71, 71, 71)
                .addComponent(Actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Atras)
                .addGap(32, 32, 32))
            .addGroup(panel_solicitudesLayout.createSequentialGroup()
                .addGroup(panel_solicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_solicitudesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(panel_solicitudesLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(tf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_solicitudesLayout.setVerticalGroup(
            panel_solicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_solicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_solicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscarSolicitud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(panel_solicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crearSolicitud)
                    .addComponent(Actualizar)
                    .addComponent(btn_Atras)
                    .addComponent(btn_editarSolicitud))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panel_bg.add(panel_solicitudes, "card2");

        jMenu1.setText("Opciones");

        btnMenu_G_solicitudes.setText("Gestionar solicitudes");
        btnMenu_G_solicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnMenu_G_solicitudesActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jMenu1.add(btnMenu_G_solicitudes);

        btnMenu_G_taxis.setText("Gestionar taxis");
        btnMenu_G_taxis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu_G_taxisActionPerformed(evt);
            }
        });
        jMenu1.add(btnMenu_G_taxis);

        btnMenu_G_servicios.setText("Gestionar servicios ");
        btnMenu_G_servicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu_G_serviciosActionPerformed(evt);
            }
        });
        jMenu1.add(btnMenu_G_servicios);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearSolicitudActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btn_crearSolicitudActionPerformed
        CrearSolicitudForm csf = new CrearSolicitudForm(this, true, new Solicitud());
    }//GEN-LAST:event_btn_crearSolicitudActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_ActualizarActionPerformed
        llenarTabla(services.mostrarSolicitudes());
    }//GEN-LAST:event_ActualizarActionPerformed

    private void btnMenu_G_solicitudesActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnMenu_G_solicitudesActionPerformed
        Views.change_panel(panel_solicitudes, panel_home);
        llenarTabla(services.mostrarSolicitudes());
    }//GEN-LAST:event_btnMenu_G_solicitudesActionPerformed

    private void btnMenu_G_taxisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu_G_taxisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu_G_taxisActionPerformed

    private void btnMenu_G_serviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu_G_serviciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu_G_serviciosActionPerformed

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        Views.change_panel(panel_home, panel_solicitudes);
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void tf_buscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_buscarFocusGained
        tf_buscar.setText("");
    }//GEN-LAST:event_tf_buscarFocusGained

    private void tf_buscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_buscarFocusLost
//        tf_buscar.setText("Buscar...");
    }//GEN-LAST:event_tf_buscarFocusLost

    private void btn_buscarSolicitudActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btn_buscarSolicitudActionPerformed
        int id = Integer.parseInt(tf_buscar.getText());
        llenarTabla(services.mostrarSolicitud(id));
        tf_buscar.setText("Buscar...");
    }//GEN-LAST:event_btn_buscarSolicitudActionPerformed

    private void btn_editarSolicitudActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btn_editarSolicitudActionPerformed
        CrearSolicitudForm csf = new CrearSolicitudForm(this, true, services.mostrarSolicitudes().getIndex(row));
        row = -1;
        btn_editarSolicitud.setEnabled(false);
    }//GEN-LAST:event_btn_editarSolicitudActionPerformed

    private void tabla_solicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_solicitudesMouseClicked
        if (evt.getClickCount() == 1) {  //Si se hizo un click
            target = (JTable) evt.getSource();
            row    = target.getSelectedRow(); // Obtener la fila

            btn_editarSolicitud.setEnabled(true);
        }
    }//GEN-LAST:event_tabla_solicitudesMouseClicked

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
            java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JMenuItem btnMenu_G_servicios;
    private javax.swing.JMenuItem btnMenu_G_solicitudes;
    private javax.swing.JMenuItem btnMenu_G_taxis;
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_buscarSolicitud;
    private javax.swing.JButton btn_crearSolicitud;
    private javax.swing.JButton btn_editarSolicitud;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_bg;
    private javax.swing.JPanel panel_home;
    private javax.swing.JPanel panel_solicitudes;
    private javax.swing.JTable tabla_solicitudes;
    private javax.swing.JTextField tf_buscar;
    // End of variables declaration//GEN-END:variables
}