package com.mycompany.proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author Adrian Varela
 */
public class ProyectoEstructura {

    /**Este metodo invoca al main principal en el cual se pueden seleccionar las distintas opciones
     *
     * Autor Adrian Varela
     * @param args
     */
    public static void main(String[] args) {

        // Mensaje de Bienvenida
        JOptionPane.showMessageDialog(null, "Bienvenido al Hospital Su Salud!");

        // Menu principal
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Por favor ingrese una opcion:" + "\n"
                    + "1.Gestionar Llegada de Pacientes" + "\n"
                    + "2.Ayuda" + "\n"
                    + "3.Salir"));
            switch (opcion) {
                case 1:
                    gestionPaciente llegadaPacientes = new gestionPaciente();
                    llegadaPacientes.menuGestionPacientes();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Avance 1 - Version 1.0.0 \nIntegrantes: \n"
                            + "OROZCO PEREZ DANIEL\n"
                            + "OVIEDO SOTO CRISTAL DILANA\n"
                            + "VARELA MENDEZ ADRIAN\n");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del Sistema...");
                    break;
            }
        } while (opcion != 3);

    }
}
