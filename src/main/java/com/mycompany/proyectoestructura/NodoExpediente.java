/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructura;

/**
 *
 * @author AMD
 */
public class NodoExpediente {
  private NodoExpediente anterior;
private NodoExpediente siguiente;
private ExpedienteUnicoPaciente paciente;

    /**
     *author Adrian Varela
     * 
     * Constructor sobrecargado
     * @param paciente
     */
    public NodoExpediente(ExpedienteUnicoPaciente paciente) {
        this.anterior = null;
        this.siguiente = null;
        this.paciente = paciente;
    }

    /**
     *author Adrian Varela
     * 
     * constructor
     */
    public NodoExpediente() {
    }

    //getters y setters
    /**
     *
     * @return
     */
    public NodoExpediente getAnterior() {
        return anterior;
    }

    /**
     *
     * @param anterior
     */
    public void setAnterior(NodoExpediente anterior) {
        this.anterior = anterior;
    }

    /**
     *
     * @return
     */
    public NodoExpediente getSiguiente() {
        return siguiente;
    }

    /**
     *
     * @param siguiente
     */
    public void setSiguiente(NodoExpediente siguiente) {
        this.siguiente = siguiente;
    }

    /**
     *
     * @return
     */
    public ExpedienteUnicoPaciente getPaciente() {
        return paciente;
    }

    /**
     *
     * @param paciente
     */
    public void setPaciente(ExpedienteUnicoPaciente paciente) {
        this.paciente = paciente;
    }

    


}
