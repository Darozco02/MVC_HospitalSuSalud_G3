package com.mycompany.proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author orozc
 */
public class listaCircularCitas {

    private nodoHistoricoCita primero;
    private nodoHistoricoCita ultimo;

    // Constructor con las referencias vacias
    public listaCircularCitas() {
        this.primero = null;
        this.ultimo = null;
    }

    // Getter y Setters
    public nodoHistoricoCita getPrimero() {
        return primero;
    }

    public void setPrimero(nodoHistoricoCita primero) {
        this.primero = primero;
    }

    public nodoHistoricoCita getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoHistoricoCita ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Este metodo inserta una cita que es ordenada por la fecha
     *
     * @author Daniel Orozco
     *
     * @param nuevaCita
     */
    public void insertarOrdenado(historicoCita nuevaCita) {
        nodoHistoricoCita nuevoNodo = new nodoHistoricoCita(nuevaCita);

        // Caso 1: Lista vacia
        if (this.getPrimero() == null) {
            primero = nuevoNodo;
            ultimo = primero;
            ultimo.setSiguiente(primero); // circular

            // Caso 2: La fecha es menor o igual a la del primero
        } else if (nuevaCita.getFecha().compareTo(primero.getMiCita().getFecha()) <= 0) {
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
            ultimo.setSiguiente(primero); // mantener circular

            // Caso 3: La fecha es mayor o igual al último
        } else if (ultimo.getMiCita().getFecha().compareTo(nuevaCita.getFecha()) <= 0) {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
            ultimo.setSiguiente(primero); // mantener circular

            // Caso 4: Va en una posicion interna
        } else {
            nodoHistoricoCita temp = primero;
            while (temp.getSiguiente().getMiCita().getFecha().compareTo(nuevaCita.getFecha()) < 0) {
                temp = temp.getSiguiente();
            }
            nuevoNodo.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(nuevoNodo);
        }
    }

    /**
     * Este metodo recorre el historico de citas y las imprime
     * 
     * @author Daniel Orozco
     * 
     */
    public void imprimirCitas() {
        if (primero == null) {
            JOptionPane.showMessageDialog(null, "No hay citas registradas!");
            return;
        }
        nodoHistoricoCita temp = primero;
        do {
            JOptionPane.showMessageDialog(null,
                      "Fecha: " + temp.getMiCita().getFecha() + "\n"
                    + "Nombre del doctor: " + temp.getMiCita().getNombreDoctor() + "\n"
                    + "Diagnostico: " + temp.getMiCita().getDiagnostico());
            temp = temp.getSiguiente();
        } while (temp != primero);
    }

    
    
    
}
