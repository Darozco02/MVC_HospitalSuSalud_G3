/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructura;

/**
 *
 * @author AMD
 */
public class NodoLista {

private HistoricoMedicamentos dato;
private NodoLista siguiente;

    public NodoLista() {
    }

    public NodoLista(HistoricoMedicamentos dato) {
        this.dato = dato;
    }

    public HistoricoMedicamentos getDato() {
        return dato;
    }

    public void setDato(HistoricoMedicamentos dato) {
        this.dato = dato;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }


}
