package com.mycompany.proyectoestructura;

import javax.swing.JOptionPane;
import java.sql.Timestamp;

/**
 *
 * @author AMD
 */
public class gestionPaciente {

    // Clase submodulo para gestionar la llegada de los pacientes
    private String numFicha;
    // Contadores para generar fichas
    private int contadorRegular;
    private int contadorPreferencial;
    // Colas de pacientes
    private colaPaciente colaRegular = new colaPaciente();
    private colaPaciente colaPreferencial = new colaPaciente();
    // Pila de Quejas
    private pilaQueja pilaQuejas = new pilaQueja();
    
    /**
     * Este metodo genera un menu para el modulo de gestion de pacientes
     *
     * @author Daniel Orozco y Adrian Varela
     */
    public void menuGestionPacientes() {
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "Bienvenido al sistema de gestion de pacientes!" + "\n"
                    + "1.Seleccionar Ficha" + "\n"
                    + "2.Atender Paciente" + "\n"
                    + "3.Abandonar Cola de Pacientes" + "\n"
                    + "4.Mostrar Fichas Pendientes" + "\n"
                    + "5.Mostrar Quejas Recibidas" + "\n"
                    + "6.Regresar al menu principal"));
            switch (opc) {
                case 1:
                    // Metodo para Seleccionar la ficha
                    seleccionFicha();
                    break;
                case 2:
                    atenderPaciente();
                    break;
                // Metodo para Atender Paciente
                case 3:
                    // Metodo para Abandonar la cola
                    abandonoColaPaciente();
                    break;
                case 4:
                    mostrarFichasPendientes();
                    break;
                // Metodo para mostrar las fichas pendientes
                case 5:
                    // Metodo para mostrar las quejas recibidas
                    pilaQuejas.mostrarQuejas();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Regresando al menu principal");
                    break;
            }
        } while (opc != 6);
    }

    /**
     * Genera una ficha y la asigna al paciente ya sea regular o preferencial,
     * igualmente agrega el paciente a la cola.
     *
     * @author Daniel Orozco
     */
    public void seleccionFicha() {
        // Preguntar al usuario que tipo de paciente es
        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo de paciente: " + "\n1. Regular" + "\n2. Preferencial"));
        switch (tipo) {
            case 1:
                // Contador para generar fichas de paciente regular
                contadorRegular++;
                numFicha = "R" + contadorRegular;
                // Solicitar informacion al usuario
                Paciente ingresoPacienteReg = solicitarInformacion(numFicha);
                // Agregar el paciente a la cola Regular
                colaRegular.enqueue(ingresoPacienteReg);
                // Mostrar numero de ficha al usuario
                JOptionPane.showMessageDialog(null, "Su numero de ficha es la: " + numFicha);
                break;
            case 2:
                // Contador para generar fichas de paciente preferencial
                contadorPreferencial++;
                numFicha = "P" + contadorPreferencial;
                // Solicitar informacion al usuario
                Paciente ingresoPacientePref = solicitarInformacion(numFicha);
                // Agregar paciente a la cola Preferencial
                colaPreferencial.enqueue(ingresoPacientePref);
                // Mostrar numero de ficha al usuario
                JOptionPane.showMessageDialog(null, "Su numero de ficha es la: " + numFicha);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion Invalida!!!");
                break;
        }
    }

    /**
     * Solicita la informacion basica al paciente
     *
     * @author Daniel Orozco
     *
     * @param numFicha este parametro es el numero de ficha generado en el
     * metodo seleccionFicha()
     *
     * @return Paciente esto retorna un tipo de dato de la clase Paciente que es
     * un nuevo paciente con la informacion requerida
     */
    public Paciente solicitarInformacion(String numFicha) {
        // Pedir la informacion al paciente
        String cedula = JOptionPane.showInputDialog("Por favor ingrese su numero de cedula: ");
        String nombre = JOptionPane.showInputDialog("Por favor ingrese su nombre: ");
        // Generar la fecha timestamp
        Timestamp fecha = new Timestamp(System.currentTimeMillis());
        // Nuevo Paciente creado
        Paciente nuevoPaciente = new Paciente(numFicha, cedula, nombre, fecha);
        return nuevoPaciente;
    }

    /**
     * Metodo que solicita la ficha y motivo al usuario para abandonar la cola
     * de pacientes segun el tipo. este verifica primero cual es el tipo de
     * paciente para ir a buscarlo en la cola correspondiente.
     *
     * @author Daniel Orozco
     *
     */
    public void abandonoColaPaciente() {
        // Solicitar numero de ficha al usuario
        String fichaAbandono = JOptionPane.showInputDialog("Por favor digite su # de ficha: ");
        String motivo = JOptionPane.showInputDialog("Por favor indique el motivo de su abandono: ");

        // Verificar en que cola esta el paciente
        if (fichaAbandono.startsWith("R")) { // Si la ficha empieza con R es regular
            Paciente pacienteAbandonoReg = colaRegular.eliminarPaciente(fichaAbandono);
            if (pacienteAbandonoReg != null) {
                JOptionPane.showMessageDialog(null, "Ficha #" + pacienteAbandonoReg.getNumFicha()
                        + " con cédula " + pacienteAbandonoReg.getCedula() + " abandona la cola sin ser atendido(a).");
                // Crear una nueva queja
                Queja nuevaQueja = new Queja(pacienteAbandonoReg, motivo, new Timestamp(System.currentTimeMillis()));
                // Ingresar esa nueva queja en la pila Queja
                pilaQuejas.ingresoQueja(nuevaQueja);
            }
        } else if (fichaAbandono.startsWith("P")) { // Si la ficha empieza con P es preferencial
            Paciente pacienteAbandonoPref = colaPreferencial.eliminarPaciente(fichaAbandono);
            if (pacienteAbandonoPref != null) {
                JOptionPane.showMessageDialog(null, "Ficha #" + pacienteAbandonoPref.getNumFicha()
                        + " con cédula " + pacienteAbandonoPref.getCedula() + " abandona la cola sin ser atendido(a).");
                // Crear una nueva queja
                Queja nuevaQuejaPref = new Queja(pacienteAbandonoPref, motivo, new Timestamp(System.currentTimeMillis()));
                // Ingresar nueva queja en la pila queja
                pilaQuejas.ingresoQueja(nuevaQuejaPref);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La ficha # " + fichaAbandono + " no esta en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo que gestiona las colas, asignando 2 pacientes preferenciales por 1
     * regular, se tiene un contador el cual se inicializa en 0 y a la hora de
     * llegar a 2 preferenciales vuelve a iniciar y gestiona uno regular
     *
     * @author Cristal Dilana Oviedo
     *
     * Nota: no recibe parametros
     */
    public void atenderPaciente() {

        if (colaPreferencial.isEmpty() && colaRegular.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes en espera.");
        }
        //inicializamos contador de pacientes temporales
        int contadorPreferencial = 0;

        // se establece que las dos clases no sean nulas (sin datos)
        while (colaPreferencial.isEmpty() == false || colaRegular.isEmpty() == false) {

            // Si hay preferenciales y no hemos atendido 2 seguidos
            if (colaPreferencial.isEmpty() == false && contadorPreferencial < 2) {

                Paciente p = colaPreferencial.dequeue();
                JOptionPane.showMessageDialog(null, "Atendiendo ficha " + p.getNumFicha() + " paciente preferencial: cedula: " + p.getCedula() + " nombre: " + p.getNombrePaciente());
                contadorPreferencial++;

            } // Si ya atendimos 2 preferenciales, toca regular
            else if (!colaRegular.isEmpty()) {

                Paciente r = colaRegular.dequeue();
                JOptionPane.showMessageDialog(null, "Atendiendo ficha " + r.getNumFicha() + "paciente preferencial: cedula: " + r.getCedula() + " nombre: " + r.getNombrePaciente());
                contadorPreferencial = 0; // reiniciamos el contador

            } // Si ya no hay regulares, seguir con preferenciales
            else if (!colaPreferencial.isEmpty()) {

                Paciente p = colaPreferencial.dequeue();
                JOptionPane.showMessageDialog(null, "Atendiendo ficha " + p.getNumFicha() + "paciente preferencial: cedula: " + p.getCedula() + " nombre: " + p.getNombrePaciente());
            }
        }
    }

    /**
     * Metodo que imprime las fichas pendientes por cada cola de manera
     * respectiva
     *
     * @author Adrian Varela
     *
     * Nota: no recibe parametros
     * @param p
     * @param r
     */
    public void mostrarFichasPendientes() {

        JOptionPane.showMessageDialog(null, "<html>Fichas pendientes:</html>", "Fichas", JOptionPane.PLAIN_MESSAGE);

        // Se muestran las Fichas Preferenciales en color naranja
        JOptionPane.showMessageDialog(null,
                "<html><font color='orange'><b>Fichas Preferenciales pendientes</b></font></html>",
                "Preferenciales", JOptionPane.PLAIN_MESSAGE);
        colaPreferencial.imprimeCola();

        // Se muestran las fichas regulares en color Verde
        JOptionPane.showMessageDialog(null,
                "<html><font color='green'><b>Fichas Regulares pendientes</b></font></html>",
                "Regulares", JOptionPane.PLAIN_MESSAGE);
        colaRegular.imprimeCola();

    }
}
