/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author AMD
 */
public class ListaMedicamentos {

    //variables
    private NodoLista cabeza;

    /**
     *constructores
     */
    public ListaMedicamentos() {
    }

    //getters y setters
    /**
     *
     * @return
     */
    public NodoLista getCabeza() {
        return cabeza;
    }

    /**
     *
     * @param cabeza
     */
    public void setCabeza(NodoLista cabeza) {
        this.cabeza = cabeza;
    }

    /**Insercción de los medicamentos en la lista
     *@author Adrian Varela
     * @param dato
     */
    public void insertarOrdenado(HistoricoMedicamentos dato) {
        NodoLista nuevoNodo = new NodoLista(dato);
//1. Cuando la lista esta vacía

        if (this.getCabeza() == null) {
            cabeza = nuevoNodo;
        } //2. Cuando el elemento es menor al primero (inserta a la izquierda)
        else if (cabeza.getDato().getReceta()>= dato.getReceta()) {
            nuevoNodo.setSiguiente(cabeza); //amarro la caja nueva con la lista
            cabeza = nuevoNodo;// se mueve la cabeza para que apunte al elemento
        } //3. Cuando el elemento es mayor al primero (inserta a la derecha)
        else {
            NodoLista temp = cabeza; //creo un nodo temporal para recorrer la lista
            while (temp.getSiguiente() != null
                    && temp.getSiguiente().getDato().getReceta()< dato.getReceta()) {
                temp.getSiguiente();

            
            nuevoNodo.setSiguiente(temp.getSiguiente());// enlaza el nuevo nodo con la referencia mas cercana hacia la derecha
            temp.setSiguiente(nuevoNodo);//enlaza el elemento de la izquierda de nuevo nodo con el nuevo nodo
        }
    }
    }
 
    /**Busca si la receta existe
     *@author Adrian Varela
     * @param recetaConsultada
     * @return true -> existe | false-> no existe
     */
    public boolean buscarReceta(int recetaConsultada) {
         NodoLista temp = cabeza;
        while (temp != null)
            
            if(temp.getDato().getReceta()== recetaConsultada){
            return true;
        }
        
        return false;
    }

    /**Devuelve la receta solicitada
     *@author Adrian Varela
     * @param recetaConsultada
     * @return
     */
    public HistoricoMedicamentos mostrarReceta(int recetaConsultada) {

    NodoLista temp = cabeza;

    while (temp != null) {

        if (temp.getDato().getReceta() == recetaConsultada) {

            // Mostrar información
            JOptionPane.showMessageDialog(null,
                    "Receta encontrada:\n" +
                    "ID Receta: " + temp.getDato().getReceta() +
                    "\nCédula: " + temp.getDato().getCedula() +
                    "\nMedicamentos: " + temp.getDato().getMedicamentos());

            return temp.getDato();
        }

        temp = temp.getSiguiente(); 
    }

    JOptionPane.showMessageDialog(null, "Receta no encontrada");
    return null;
}}
