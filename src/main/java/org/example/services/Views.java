package org.example.services;

import javax.swing.*;

public class Views {

    public static void change_panel(JPanel panel, JPanel... paneles){
        for (JPanel p: paneles) {
            p.setVisible(false);
        }
        panel.setVisible(true);
    }

    public static void vaciarTf(JTextField... tfs){
        for (JTextField tf: tfs) {
            tf.setText("");
        }
    }

    public static boolean validarCamposVacios(JTextField... tfs){
        for (JTextField tf: tfs) {
            if (tf.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
                return false;
            }
        }
        return true;
    }
}
