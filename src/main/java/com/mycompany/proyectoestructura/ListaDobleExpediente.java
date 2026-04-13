package com.mycompany.proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author Adrian Varela
 */
public class ListaDobleExpediente {

    private NodoExpediente primero;
    private NodoExpediente ultimo;

    // Metodo Constructor
    public ListaDobleExpediente() {
    }

    // Getter y Setters
    public NodoExpediente getPrimero() {
        return primero;
    }

    public void setPrimero(NodoExpediente primero) {
        this.primero = primero;
    }

    public NodoExpediente getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoExpediente ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Este metodo inserta ordenado en la el expediente
     *
     * @author Adrian Varela
     *
     *
     * @param valor el parametro valor se va a solicitar al doctor a la hora de
     * revisar el paciente (hace referencia a la ced del paciente)
     */
    public void insertaOrdenado(ExpedienteUnicoPaciente valor) {

        NodoExpediente nuevoNodo = new NodoExpediente(valor);
        //caso 1 lista vacia
        if (this.getPrimero() == null) {
            primero = nuevoNodo;
            ultimo = primero;
            ultimo.setSiguiente(primero);
            primero.setAnterior(ultimo);

        } //caso 2 elemento a insertar es menor al primero
        else if (valor.getCedula() <= primero.getPaciente().getCedula()) {
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevoNodo);
            primero = nuevoNodo;

        } //caso 3 inserta a la derecha
        else if (ultimo.getPaciente().getCedula() <= valor.getCedula()) {
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(primero);
            nuevoNodo.setAnterior(ultimo);
            primero.setAnterior(nuevoNodo);
            ultimo = nuevoNodo;
        } else {
            NodoExpediente temp = primero;
            while (temp.getPaciente().getCedula() < valor.getCedula()) {
                temp = temp.getSiguiente();
            }
            nuevoNodo.setSiguiente(temp.getSiguiente());
            nuevoNodo.setAnterior(temp);
            nuevoNodo.getSiguiente().setAnterior(nuevoNodo);
            temp.setSiguiente(nuevoNodo);
        }

    }

    /**
     * El siguiente metodo muestra el expediente del paciente y luego muestra
     * una serie de opciones para navegar al siguiente paciente o al anterior.
     *
     * @author Daniel Orozco
     */
    public void mostrarExpediente() {

        NodoExpediente actual = primero;

        // Verificar si la lista esta vacia
        if (primero == null) {
            JOptionPane.showMessageDialog(null, "No se encuentran expedientes registrados", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        do {
            // Mostrar los datos del paciente actuakl
            JOptionPane.showMessageDialog(null, "Cedula: " + actual.getPaciente().getCedula() + "\n"
                    + "Nombre: " + actual.getPaciente().getNombre() + "\n"
                    + "Edad: " + actual.getPaciente().getEdad()+ "\n"
                    + "Genero: " + actual.getPaciente().getGenero());
            
            // Opciones de navegacion
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "--Eliga una opcion--" + "\n" 
                    + "1-Siguiente Paciente" + "\n"
                    + "2-Paciente Anterior" + "\n"
                    + "3-Salir"));
            if (opcion == 1) {
                actual = actual.getSiguiente();
            } else if (opcion == 2){
                actual = actual.getAnterior();
            } else {
                break;
            }
        } while (true);
    }

    /**
     * Este metodo devuelve si el paciente no está creado
     *
     * @author Daniel Orozco
     *
     * @param cedulaPaciente cedula del paciente.
     *
     * @return boolean: True en caso de que el expediente si exista False en
     * caso de que el expediente no exista
     */
    public boolean expedienteRegistrado(int cedulaPaciente) {

        NodoExpediente actual = primero;
        // Verificar que la lista este vacia
        if (primero == null) {
            return false;
        }

        do {
            if (actual.getPaciente().getCedula() == cedulaPaciente) {
                return true;
            }
            actual = actual.getSiguiente();
        } while (actual != primero);
        return false;
    }
    
    /**
     * Metodo que busca expediente por cedula del paciente
     * verifica si el expediente no este vacio con el primero if y si 
     * no esta vacio hace un do while en donde devuelve el paciente encontrado 
     * con la cedula indicada y si no devuelve un null
     * 
     * @author Daniel Orozco 
     * 
     * @param cedulaPaciente cedula del paciente que se buscara el expediente
     * 
     * @return devuelve el expediente de la cedula ingresada
     */
    public ExpedienteUnicoPaciente buscarExpediente(int cedulaPaciente){
        if (primero == null) {
            return null;
        }
        
        NodoExpediente actual = primero;
        do {            
            if (actual.getPaciente().getCedula() == cedulaPaciente) {
                return actual.getPaciente();
            }
            actual = actual.getSiguiente();
        } while (actual != primero);
        return null;
    }

}
