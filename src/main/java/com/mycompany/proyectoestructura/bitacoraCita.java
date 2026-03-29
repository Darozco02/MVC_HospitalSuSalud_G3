package com.mycompany.proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author orozc
 */
public class bitacoraCita {

    private nodoCita primero;

    // Constructor vacio
    public bitacoraCita() {
    }

    // Getter y Setter
    public nodoCita getPrimero() {
        return primero;
    }

    public void setPrimero(nodoCita primero) {
        this.primero = primero;
    }

    public void insertarOrdenado(citaDia dato) {
        nodoCita nuevoNodo = new nodoCita(dato);

        // Caso 1: Lista vacía
        if (primero == null) {
            primero = nuevoNodo;

            // Caso 2: La cédula es menor o igual a la del primero
        } else if (primero.getMiCita().getPaciente().getCedula().compareTo(dato.getPaciente().getCedula()) >= 0) {
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;

            // Caso 3: Buscar posición en medio o al final
        } else {
            nodoCita aux = primero;
            while (aux.getSiguiente() != null && aux.getSiguiente().getMiCita().getPaciente().getCedula().compareTo(dato.getPaciente().getCedula()) < 0) {
                aux = aux.getSiguiente();
            }
            nuevoNodo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevoNodo);
        }
    }

    public void imprimirBitacora() {
        nodoCita temp = primero;

        if (temp == null) {
            JOptionPane.showMessageDialog(null, "No hay citas registradas");
            return;
        }

        while (temp != null) {
            long diferencia = (temp.getMiCita().getFechaAtencion().getTime() - temp.getMiCita().getFechaLlegada().getTime()) / 1000;

            // Condicional para agregar color segun lo solicitado
            String color;
            if (diferencia <= 30) {
                color = "green";
            } else if (diferencia < 60) {
                color = "yellow";
            } else {
                color = "red";
            }

            JOptionPane.showMessageDialog(null, "<html><font color='" + color + "'>"
                    + "Ficha: #" + temp.getMiCita().getPaciente().getNumFicha() + "\n"
                    + "Cédula: " + temp.getMiCita().getPaciente().getCedula() + "\n"
                    + "Nombre: " + temp.getMiCita().getPaciente().getNombrePaciente() + "\n"
                    + "Fecha de llegada: " + temp.getMiCita().getFechaLlegada() + "\n"
                    + "Fecha de atención: " + temp.getMiCita().getFechaAtencion()
                    + "</font></html>");

            temp = temp.getSiguiente();
        }
    }

}
