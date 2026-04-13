package com.mycompany.proyectoestructura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    //lista doble expedientes
    private ListaDobleExpediente listaExpedientes = new ListaDobleExpediente();
    // Instanciar la clase bitacoraCita
    private bitacoraCita bitacoraDia = new bitacoraCita();

    public bitacoraCita getBitacoraDia() {
        return bitacoraDia;
    }

    public ListaDobleExpediente getListaExpedientes() {
        return listaExpedientes;
    }

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
        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese su numero de cedula: "));
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
     * El siguiente metodo atiende los paciente e ingresa diferentes datos a los
     * expedientes y bitacoras. De igual manera informa al usuario sobre el
     * paciente atentido, solicita informacion adicional y confirma que el
     * paciente fue atendido
     *
     * @author Daniel Orozco
     */
    public void atenderPaciente() {

        if (colaPreferencial.isEmpty() && colaRegular.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes en espera",
                    "Sin pacientes", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Paciente pacienteAtendido = null;

        /* Condicional para atender pacientes y sacarlos de la cola,
        se cumple con lo requerido de atender de 2 en 2.
         */
        if (!colaPreferencial.isEmpty() && contadorPreferencial < 2) {
            pacienteAtendido = colaPreferencial.dequeue();
            contadorPreferencial++;
        } else if (!colaRegular.isEmpty()) {
            pacienteAtendido = colaRegular.dequeue();
            contadorPreferencial = 0;
        } else {
            pacienteAtendido = colaPreferencial.dequeue();
            contadorPreferencial++;
        }

        // Mostrar paciente atendido
        JOptionPane.showMessageDialog(null,
                "Ficha: " + pacienteAtendido.getNumFicha() + "\n"
                + "Cedula: " + pacienteAtendido.getCedula() + "\n"
                + "Nombre: " + pacienteAtendido.getNombrePaciente(),
                "Paciente Atendido", JOptionPane.INFORMATION_MESSAGE);

        int edad = 0;
        String genero = "";

        // Verificar si el paciente esta en el expediente
        if (!listaExpedientes.expedienteRegistrado(pacienteAtendido.getCedula())) {
            JOptionPane.showMessageDialog(null, "Paciente: "
                    + pacienteAtendido.getNombrePaciente()
                    + " asiste a consulta por primera vez.");
            // Solicitar datos del paciente
            edad = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese la edad del nuevo paciente: "));
            genero = JOptionPane.showInputDialog(null,
                    "Ingrese el genero del paciente: ");
        } else {
            // llama al metodo de la clase Expediente de paciente que busca el paciente en el expediente
            ExpedienteUnicoPaciente expediente = listaExpedientes.buscarExpediente(pacienteAtendido.getCedula());
            // Mostrar datos del expediente
            JOptionPane.showMessageDialog(null,
                    "Cedula: " + expediente.getCedula() + "\n"
                    + "Nombre: " + expediente.getNombre() + "\n"
                    + "Edad: " + expediente.getEdad() + "\n"
                    + "Genero: " + expediente.getGenero(),
                    "Expediente", JOptionPane.INFORMATION_MESSAGE);
        }

        // Pedir los datos de la cita
        String nombreDoctor = JOptionPane.showInputDialog(null, "Ingrese el nombre del doctor: ");
        String diagnostico = JOptionPane.showInputDialog(null, "Ingrese el diagnostico realizado: ");
        String medicamentos = JOptionPane.showInputDialog(null, "Ingrese los medicamentos enviados: ");
        Timestamp fechaAtencion = new Timestamp(System.currentTimeMillis());

        // Almacenar pacientes atendidos en el expediente
        ExpedienteUnicoPaciente expedienteActualizado;

        if (!listaExpedientes.expedienteRegistrado(pacienteAtendido.getCedula())) {
            expedienteActualizado = new ExpedienteUnicoPaciente(pacienteAtendido.getCedula(), pacienteAtendido.getNombrePaciente(),
                    genero, edad);
            listaExpedientes.insertaOrdenado(expedienteActualizado);
        } else {
            // "recupera el expediente existente"
            expedienteActualizado = listaExpedientes.buscarExpediente(pacienteAtendido.getCedula());
        }

        // Guardar cita en el historial de citas
        historicoCita citaNueva = new historicoCita(fechaAtencion, nombreDoctor, diagnostico);
        expedienteActualizado.getHistoricoCitas().insertarOrdenado(citaNueva);

        // Guardar el historico de medicamentos
        HistoricoMedicamentos medicamentoNuevo = new HistoricoMedicamentos(pacienteAtendido.getCedula(), fechaAtencion, medicamentos, pacienteAtendido.getCedula());
        /*En la instancia se pone en el primer campo la cedula del paciente
        para que el usuario pueda identifiacr los medicamentos por numero
        de cedula*/
        expedienteActualizado.getHistoricoMedicamentos().insertarOrdenado(medicamentoNuevo);

        agregarPacienteCSV(expedienteActualizado, diagnostico, medicamentos);
        // Agregar datos a la bitacora diaria
        citaDia citaDiaria = new citaDia(pacienteAtendido, pacienteAtendido.getFecha(), fechaAtencion);
        bitacoraDia.insertarOrdenado(citaDiaria);

        // INdicar al usuario que la cita termino
        JOptionPane.showMessageDialog(null,
                "Paciente: " + pacienteAtendido.getNombrePaciente()
                + " su cita ha concluido!",
                "Cita Finalizada", JOptionPane.INFORMATION_MESSAGE);
    }

    /**Metodo que guarda los datos ingresados por el doctor que atendió al usuario en un archivo CSV
     *
     * @author Adrian Varela
     * @param paciente
     * @param diagnostico
     * @param medicamento
     */
    public void agregarPacienteCSV(ExpedienteUnicoPaciente paciente, String diagnostico, String medicamento) {
    String ruta = System.getProperty("user.home") + "/Desktop/pacientes.csv";
    java.io.File archivo = new java.io.File(ruta);

    // Usamos el constructor de FileWriter(archivo, append)
    // El 'true' es vital para que NO borre lo anterior
    try (FileWriter fw = new FileWriter(archivo, true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter writer = new PrintWriter(bw)) {

        // Escribir encabezado solo si el archivo es nuevo o está vacío
        if (archivo.length() == 0) {
            writer.println("Nombre,Edad,Genero,Diagnostico,Medicamento");
        }

        // Escribir los datos
        writer.println(
                paciente.getNombre() + "," +
                paciente.getEdad() + "," +
                paciente.getGenero() + "," +
                diagnostico + "," +
                medicamento
        );
        
        // Forzamos que los datos se escriban físicamente en el disco
        writer.flush();

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error: Asegúrate de que el archivo CSV no esté abierto en Excel.\n" + e.getMessage(),
                "Error de Escritura", JOptionPane.ERROR_MESSAGE);
    }
}
/**
     * Metodo que imprime las fichas pendientes por cada cola de manera
     * respectiva
     *
     * @author Adrian Varela
     *
     * Nota: no recibe parametros
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
