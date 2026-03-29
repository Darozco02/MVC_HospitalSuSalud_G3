package com.mycompany.proyectoestructura;

/**
 *
 * @author orozc
 */
public class nodoCita {
    
    private citaDia miCita;
    private nodoCita siguiente;

    // Constructor
    public nodoCita(citaDia miCita) {
        this.miCita = miCita;
        this.siguiente = null;
    }

    // Getter y Setter
    public citaDia getMiCita() {
        return miCita;
    }

    public void setMiCita(citaDia miCita) {
        this.miCita = miCita;
    }

    public nodoCita getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoCita siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
}
