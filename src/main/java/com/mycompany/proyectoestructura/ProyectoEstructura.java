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

        gestionPaciente llegadaPacientes = new gestionPaciente();
        ListaDobleExpediente expediente = new ListaDobleExpediente();
        ListaMedicamentos recetas = new ListaMedicamentos();
        ArbolExpediente arbol = new ArbolExpediente();
        ModuloBI moduloBI = new ModuloBI(arbol);
        // Menu principal
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Por favor ingrese una opcion:" + "\n"
                    + "1.Gestionar Llegada de Pacientes" + "\n"
                    + "2.Consultar Bitacoras de Citas del dia" + "\n"
                    + "3.Consulta de Expediente unico de Pacientes" + "\n"
                    + "4.Consulta de Expedientes cargados" + "\n"
                    + "5.Consulta de recetas" + "\n"
                    + "6.Cargar Expediente desde Archivo JSON" + "\n"
                    + "7.Modulo de inteligencia Empresarial (BI)" + "\n"
                    + "8.Ayuda" + "\n"
                    + "9.Salir"));

            switch (opcion) {
                case 1:
                    llegadaPacientes.menuGestionPacientes();
                    break;
                case 2:
                    llegadaPacientes.getBitacoraDia().imprimirBitacora();
                    break;
                case 3:
                    llegadaPacientes.getListaExpedientes().mostrarExpediente();
                    break;
                case 4:
                    arbol.verArchivoJSON();
                    break;
                case 5:
                    // Pedir la cedula para buscar los medicamentos por cedula
                    int cedulaReceta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su cedula para mostrar sus medicamentos: "));
                    ExpedienteUnicoPaciente expReceta = llegadaPacientes.getListaExpedientes().buscarExpediente(cedulaReceta);
                    if (expReceta == null) {
                        JOptionPane.showMessageDialog(null, "La cedula ingresada no registra medicamentos",
                                "Cedula No encontrada", JOptionPane.ERROR_MESSAGE);
                    } else {
                        expReceta.getHistoricoMedicamentos().mostrarReceta(cedulaReceta);
                    }
                    break;
                case 6:
                    arbol.cargarArchivoJSON();
                    break;
                case 7:
                    moduloBI.menuBI();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null,
                            "Avance 3 - Version 3.0.0 \nIntegrantes: \n"
                            + "OROZCO PEREZ DANIEL\n"
                            + "OVIEDO SOTO CRISTAL DILANA\n"
                            + "VARELA MENDEZ ADRIAN\n");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Saliendo del Sistema...");
                    break;
            }
        } while (opcion != 9);

    }
}
