package com.mycompany.proyectoestructura;

/**
 *
 * @author orozc
 */
public class nodoHistoricoCita {
    
    private historicoCita miCita;
    private nodoHistoricoCita siguiente;

    // Constructor con la referencia vacia
    public nodoHistoricoCita(historicoCita miCita) {
        this.miCita = miCita;
        this.siguiente = null;
    }

    // Getter y Setters
    public historicoCita getMiCita() {
        return miCita;
    }

    public void setMiCita(historicoCita miCita) {
        this.miCita = miCita;
    }

    public nodoHistoricoCita getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoHistoricoCita siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
}
