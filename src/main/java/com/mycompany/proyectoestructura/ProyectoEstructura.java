package com.mycompany.proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author Adrian Varela
 */
public class ProyectoEstructura {

    /**
     * Este metodo invoca al main principal en el cual se pueden seleccionar las
     * distintas opciones
     *
     * Autor Adrian Varela
     *
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
                    + "2.Consultar Bitacoras de Citas del dia" + "\n"
                    + "3.Consulta de Expediente unico de Pacientes" + "\n"
                    + "4.Ayuda" + "\n"
                    + "5.Salir"));

            switch (opcion) {
                case 1:
                    gestionPaciente llegadaPacientes = new gestionPaciente();
                    llegadaPacientes.menuGestionPacientes();
                    break;
                case 2:
                    bitacoraCita nuevaBitacora = new bitacoraCita();
                    nuevaBitacora.imprimirBitacora();
                    break;
                case 3:
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Avance 2 - Version 2.0.0 \nIntegrantes: \n"
                            + "OROZCO PEREZ DANIEL\n"
                            + "OVIEDO SOTO CRISTAL DILANA\n"
                            + "VARELA MENDEZ ADRIAN\n");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del Sistema...");
                    break;
            }
        } while (opcion != 5);

    }
}
