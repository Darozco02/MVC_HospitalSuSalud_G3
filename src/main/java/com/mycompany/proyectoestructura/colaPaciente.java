package com.mycompany.proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author orozc
 */
public class colaPaciente {

    // Referencias a los nodos
    private nodoPaciente primero;
    private nodoPaciente ultimo;

    // Constructor con las referencias null
    public colaPaciente() {
        // La null es para indicar que la cola esta vacia
        this.primero = null;
        this.ultimo = null;
    }

    // Getter y Setters
    public nodoPaciente getPrimero() {
        return primero;
    }

    public void setPrimero(nodoPaciente primero) {
        this.primero = primero;
    }

    public nodoPaciente getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoPaciente ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Este metodo inserta un nuevo paciente a la cola.
     *
     * @param nuevoPaciente este parametro es un nuevoPaciente que se genera a
     * partir de la clase Paciente.
     *
     * @author Daniel Orozco
     */
    public void enqueue(Paciente nuevoPaciente) {
        nodoPaciente nuevoNodo = new nodoPaciente(nuevoPaciente);

        // Pregunta si la cola no esta vacia
        if (ultimo != null) {
            ultimo.setReferencia(nuevoNodo);
        }
        // Actualiza la referencia al ultimo nodo
        ultimo = nuevoNodo;
        if (primero == null) {
            primero = nuevoNodo;
        }
    }

    /**
     * Este metodo atiende al paciente que esta en espera en la cola.
     *
     *
     * @author Adrian Varela
     * @return paciente atendido
     */
    public Paciente dequeue() {
        //1. si la cola está vacía
        if (primero == null) {
            System.out.println("No hay elementos");
            return null;
        } else {//si hay elementos
            Paciente temp = primero.getPaciente(); //asigno una variable temporal
            primero = primero.getReferencia();
            // cambia el puntero al segundo
            // si la cola solo tiene un elemento debo reestablecer el ultimo
            if (primero == null) {
                ultimo = null;
            }
            return temp;
        }
    }

    /**
     * Metodo que elimina pacientes segun su numero de ficha. Esto recorre la
     * cola hasta encontrar la ficha que quiere abandonar.
     *
     * @author Daniel Orozco
     *
     * @param fichaAbandono
     *
     * @return Paciente retorna un tipo de dato Paciente, indicando que es el
     * paciente que desea abandonar la cola.
     *
     */
    public Paciente eliminarPaciente(String fichaAbandono) {

        nodoPaciente actual = primero;
        nodoPaciente anterior = null;

        while (actual != null) {
            if (actual.getPaciente().getNumFicha().equals(fichaAbandono)) {
                // Encontrar el nodo
                if (anterior == null) {
                    primero = actual.getReferencia();
                } else {
                    anterior.setReferencia(actual.getReferencia());
                }
                break;
            } else {
                anterior = actual;
                actual = actual.getReferencia();
            }
        }

        if (actual == null) {
            JOptionPane.showMessageDialog(null, "Ficha No Existente!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return actual.getPaciente();
    }

    /**
     * metodo que indica si la cola está vacía
     *
     * @author Adrian Varela
     *
     * @return true si la pila está vacía, false si tiene datos.
     *
     */
    public boolean isEmpty() {
        if (primero == null) {
            return true;
        } else {
            return false;
        }
    }



    /**
     * Metodo que imprime los pacientes almacenados en la cola
     *
     * @author Adrian Varela
     *
     */
    public void imprimeCola() {

        nodoPaciente temp = primero;
        while (temp != null) {
            JOptionPane.showMessageDialog(null, "Pacientes en espera: ficha: " + temp.getPaciente().getNumFicha() + " nombre: " + temp.getPaciente().getNombrePaciente());
            temp = temp.getReferencia();
        }
    }
}
