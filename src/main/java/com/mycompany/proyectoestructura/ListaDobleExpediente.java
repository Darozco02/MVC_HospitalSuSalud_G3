/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructura;

/**
 *
 * @author Adrian Varela
 */
public class ListaDobleExpediente {
  
    //variables
    
    private NodoExpediente primero;
    private NodoExpediente ultimo;

    /**
     *@author Adrian Varela
     * Constructor
     */
    public ListaDobleExpediente() {
    }

    //getters y setters
    /**
     *
     * @return
     */
    public NodoExpediente getPrimero() {
        return primero;
    }

    /**
     *
     * @param primero
     */
    public void setPrimero(NodoExpediente primero) {
        this.primero = primero;
    }

    /**
     *
     * @return
     */
    public NodoExpediente getUltimo() {
        return ultimo;
    }

    /**
     *
     * @param ultimo
     */
    public void setUltimo(NodoExpediente ultimo) {
        this.ultimo = ultimo;
    }
    
    /** Este metodo inserta ordenado en la el expediente
     *@author Adrian Varela
     * 
     * 
     * @param valor el parametro valor se va a solicitar al doctor a la hora de revisar el paciente (hace referencia a la ced del paciente)
     */
    public void insertaOrdenado(ExpedienteUnicoPaciente valor){
    
        NodoExpediente nuevoNodo =new NodoExpediente(valor);
//caso 1 lista vacia
    if(this.getPrimero()==null){
        primero=nuevoNodo;
    ultimo=primero;
    ultimo.setSiguiente(primero);
    primero.setAnterior(ultimo);
    
    }
    //caso 2 elemento a insertar es menor al primero
    else
        if(valor.getCedula()<=primero.getPaciente().getCedula()){
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevoNodo);
            primero=nuevoNodo;
        
        }
    //caso 3 inserta a la derecha
        else 
        if(ultimo.getPaciente().getCedula()<=valor.getCedula()){
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(primero);
            nuevoNodo.setAnterior(ultimo);
            primero.setAnterior(nuevoNodo);
            ultimo=nuevoNodo;
        }
        else
        {
            NodoExpediente temp=primero;
        while(temp.getPaciente().getCedula()<valor.getCedula()){
            temp=temp.getSiguiente();
        }
                nuevoNodo.setSiguiente(temp.getSiguiente());
        nuevoNodo.setAnterior(temp);
        nuevoNodo.getSiguiente().setAnterior(nuevoNodo);
        temp.setSiguiente(nuevoNodo);} 
        
        }    

    /** Este metodo muestra el expediente del paciente por su cédula
     *@author Adrian Varela
     * @param cedulaPaciente
     * @return null
     */
    public ExpedienteUnicoPaciente mostrarExpediente(int cedulaPaciente, ExpedienteUnicoPaciente valor ) {
        
        if (expedienteRegistrado(cedulaPaciente)==false)
        {insertaOrdenado(valor);
        }
        
        
        else{    
    
    NodoExpediente actual = primero;

    while (actual != primero) {
        if (actual.getPaciente().getCedula() == cedulaPaciente) {
            return actual.getPaciente();
        }
    }
    
 
}
        return null;
    }   

    /**Este metodo devuelve si el paciente no está creado
     *
     * @param cedulaPaciente
     * @return true -> en caso que exista | false -> en caso que no exista
     */
    public boolean expedienteRegistrado (int cedulaPaciente) {

    NodoExpediente actual = primero;

    while (actual != primero) {
        if (actual.getPaciente().getCedula() == cedulaPaciente) {
            return true;
        }
        actual = actual.getSiguiente();
    }
    
    return false;
}

}
