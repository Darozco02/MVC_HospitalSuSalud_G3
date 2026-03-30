package com.mycompany.proyectoestructura;

/**
 *
 * @author AMD
 */
public class nodoQueja {

    private Queja miQueja; //almacena en la pila una queja de la clase Queja.
    private nodoQueja abajo; // Se crea puntero o referencia al siguiente elemento

    // Constructor
    public nodoQueja(Queja miQueja) {
        this.miQueja = miQueja;
        this.abajo = null; //Nunca se pone el Nodo

    }

    // Getter y Setters
    public Queja getMiQueja() {
        return miQueja;
    }

    public void setMiQueja(Queja miQueja) {
        this.miQueja = miQueja;
    }

    public nodoQueja getAbajo() {
        return abajo;
    }

    public void setAbajo(nodoQueja abajo) {
        this.abajo = abajo;
    }

}
