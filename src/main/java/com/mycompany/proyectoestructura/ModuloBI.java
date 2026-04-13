package com.mycompany.proyectoestructura;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author orozc
 */
public class ModuloBI {

    private ArbolExpediente arbolBi;

    // Metodo constructor
    public ModuloBI(ArbolExpediente arbolBi) {
        this.arbolBi = arbolBi;
         
    }

    // Getter y Setter
    public ArbolExpediente getArbolBi() {
        return arbolBi;
       
    }

    public void setArbolBi(ArbolExpediente arbolBi) {
        this.arbolBi = arbolBi;
    }

    /**
     * Metodo que genera un menu con las opcoones del modulo BI
     *
     * @author Daniel Orozco
     */
    public void menuBI() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Módulo de Inteligencia Empresarial\n"
                    + "1. Analisis de las enfermedades mas frecuentes\n"
                    + "2. Segmentacion de pacientes\n"
                    + "3. Deteccion de patrones\n"
                    + "4. Propuesta de Valor\n"
                    + "5. Regresar al menu principal"));
            switch (opcion) {
                case 1:
                    analizarEnfermedades();
                    break;
                case 2:
                    segmentarPacientes();
                    break;
                case 3:
                    detectarPatrones();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "En construcción");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Regresando al menu principal");
                    break;
            }
        } while (opcion != 5);
    }

    /**
     * Metodo wrapper que llama al metodo recursivo e imprime los pacientes que
     * estan siendo guardados en los contadores segun su edad.
     *
     * @author Daniel Orozco
     *
     */
    public void segmentarPacientes() {
        int[] contadores = {0, 0, 0};
        segmentarPacientesRec(arbolBi.getRaiz(), contadores);
        JOptionPane.showMessageDialog(null, "Segmentacion Pacientes: "
                + "Menores de edad: " + contadores[0] + " pacientes" + "\n"
                + "Adultos: " + contadores[1] + " pacientes" + "\n"
                + "Adultos Mayores: " + contadores[2] + " pacientes");
    }

    /**
     * Metodo que recursivamente recorre el arbol y va segmentando los pacientes
     * de manera inOrden. De igual manera los vas almacenando en los contadores.
     *
     * @author Daniel Orozco
     *
     * @param contadores arreglos que almacenan los pacientes segun su edad.
     * @param nodoActual nodo que recorre el arbol.
     */
    public void segmentarPacientesRec(NodoArbol nodoActual, int[] contadores) {
        if (nodoActual != null) {
            segmentarPacientesRec(nodoActual.getNodoIzq(), contadores);
            // Verificar edad y almacenar en los arreglos
            int edad = nodoActual.getPaciente().getEdad();
            if (edad < 18) {
                contadores[0]++;
            } else if (edad < 65) {
                contadores[1]++;
            } else {
                contadores[2]++;
            }
            segmentarPacientesRec(nodoActual.getNodoDer(), contadores);
        }
    }

    /**
     * Metodo wrapper que llama al metodo recursivo
     *
     * @author Daniel Orozco
     */
    public void analizarEnfermedades() {
        ListaDiagnostico nuevaLista = new ListaDiagnostico();
        analizarEnfermedadesRec(arbolBi.getRaiz(), nuevaLista);
        nuevaLista.imprimirDiagnosticos();
    }

    /**
     * Metodo que recorre el arbol de manera inOrden.
     *
     * @author Daniel Orozco
     *
     * @param lista lista de diagnosticos
     * @param nodoActual nodo que recorre el arbol
     */
    private void analizarEnfermedadesRec(NodoArbol nodoActual, ListaDiagnostico lista) {
        if (nodoActual != null) {
            analizarEnfermedadesRec(nodoActual.getNodoIzq(), lista);
            nodoHistoricoCita temp = nodoActual.getPaciente().getHistoricoCitas().getPrimero();
            if (temp != null) {
                do {
                    lista.incrementar(temp.getMiCita().getDiagnostico());
                    temp = temp.getSiguiente();
                } while (temp != nodoActual.getPaciente().getHistoricoCitas().getPrimero());
            }
            analizarEnfermedadesRec(nodoActual.getNodoDer(), lista);
        }
    }

    /**
     * Metodo wrapper que llama al metod reecursivo y ademas solicita los datos
     * al usuario sobre la consulta que desea realizar. convierte las edades que
     * ingreso e imprime la informacion solicitada.
     *
     * @author Daniel Orozco
     */
    public void detectarPatrones() {
        // Pedir parametros
        String edadInicialStr = JOptionPane.showInputDialog(null, "Ingrese la edad inicial (si desea omitir deje en blanco): ");
        String edadFinalStr = JOptionPane.showInputDialog(null, "Ingrese edad final (si desea omitir deje en blanco): ");
        String diagnostico = JOptionPane.showInputDialog(null, "Ingrese el diagnostico (si desea omitir deje en blanco): ");
        String genero = JOptionPane.showInputDialog(null, "Ingrese el genero (si desea omitir deje en blanco): ");
        String medicamento = JOptionPane.showInputDialog(null, "Ingrese el medicamento (si desea omitir deje en blanco): ");

        // Verificar que al menos un campo no este vacio
        if (edadInicialStr.isEmpty() && edadFinalStr.isEmpty() && diagnostico.isEmpty() && genero.isEmpty() && medicamento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de ingresar minimo un dato", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convertir las edades ingresadas
        int edadInicial = 0;
        int edadFinal = 99;

        if (!edadInicialStr.isEmpty()) {
            edadInicial = Integer.parseInt(edadInicialStr);
        } else if (!edadFinalStr.isEmpty()) {
            edadFinal = Integer.parseInt(edadFinalStr);
        }

        // Llamar al recursivo
        int[] contador = {0};
        detectarPatronesRec(arbolBi.getRaiz(), edadInicial, edadFinal, diagnostico, genero, medicamento, contador);

        // Verificar si la informacion se dejo en blanco o no
        String mostrarEdadInicial = "-";
        if (!edadInicialStr.isEmpty()) {
            mostrarEdadInicial = edadInicialStr;
        }

        String mostrarEdadFinal = "-";
        if (!edadFinalStr.isEmpty()) {
            mostrarEdadFinal = edadFinalStr;
        }

        String mostrarDiagnostico = "-";
        if (!diagnostico.isEmpty()) {
            mostrarDiagnostico = diagnostico;
        }

        String mostrarGenero = "-";
        if (!genero.isEmpty()) {
            mostrarGenero = genero;
        }

        String mostrarMedicamento = "-";
        if (!medicamento.isEmpty()) {
            mostrarMedicamento = medicamento;
        }

        // Mensaje con la informacion solicitiada
        JOptionPane.showMessageDialog(null,
                "Busqueda Personalizada:\n"
                + "Edad: " + mostrarEdadInicial + " - " + mostrarEdadFinal + "\n"
                + "Diagnóstico: " + mostrarDiagnostico + "\n"
                + "Género: " + mostrarGenero + "\n"
                + "Medicamento: " + mostrarMedicamento + "\n"
                + "Pacientes encontrados: " + contador[0],
                "Consulta Personalizada", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Metodo recursivo que recorre el arbol de manera inOrden y verifica que
     * los parametros o datos que pide el usuario esrtan.
     *
     * @author Daniel Orozco
     *
     * @param contador contador que va almacenando los datos
     * @param diagnostico dato que verifica el diagnostico
     * @param edadFinal dato que verifica la edad final ingresada
     * @param edadInicial dato que verifica la edad uinicial ingresada
     * @param genero dato que verifica el genero
     * @param medicamento dato que verifica los medicamentps
     * @param nodoActual nodo que recorre el arbol
     */
    private void detectarPatronesRec(NodoArbol nodoActual, int edadInicial, int edadFinal, String diagnostico, String genero, String medicamento, int[] contador) {
        if (nodoActual != null) {
            detectarPatronesRec(nodoActual.getNodoIzq(), edadInicial, edadFinal, diagnostico, genero, medicamento, contador);

            ExpedienteUnicoPaciente paciente = nodoActual.getPaciente();
            boolean cumple = true;

            // Verificar las edades
            if (paciente.getEdad() < edadInicial || paciente.getEdad() > edadFinal) {
                cumple = false;
            }

            // Verificar el genero
            if (!genero.isEmpty() && !paciente.getGenero().equalsIgnoreCase(genero)) {
                cumple = false;
            }

            // Verificar el diagnostico y los medicamentos en las listas
            if (cumple && (!diagnostico.isEmpty() || !medicamento.isEmpty())) {
                boolean tieneDiagnostico = diagnostico.isEmpty();
                boolean tieneMedicamento = medicamento.isEmpty();

                // Revisar las citas
                nodoHistoricoCita tempCita = paciente.getHistoricoCitas().getPrimero();
                if (tempCita != null) {
                    do {
                        if (!diagnostico.isEmpty() && tempCita.getMiCita().getDiagnostico().equalsIgnoreCase(diagnostico)) {
                            tieneDiagnostico = true;
                        }
                        tempCita = tempCita.getSiguiente();
                    } while (tempCita != paciente.getHistoricoCitas().getPrimero());
                }

                // Revisar los medicamentos
                NodoLista tempMed = paciente.getHistoricoMedicamentos().getCabeza();
                while (tempMed != null) {
                    if (!medicamento.isEmpty() && tempMed.getDato().getMedicamentos().equalsIgnoreCase(medicamento)) {
                        tieneMedicamento = true;
                    }
                    tempMed = tempMed.getSiguiente();
                }
                if (!tieneDiagnostico || !tieneMedicamento) {
                    cumple = false;
                }
            }
            if (cumple) {
                contador[0]++;
            }
            detectarPatronesRec(nodoActual.getNodoDer(), edadInicial, edadFinal, diagnostico, genero, medicamento, contador);
        }
    }

}
