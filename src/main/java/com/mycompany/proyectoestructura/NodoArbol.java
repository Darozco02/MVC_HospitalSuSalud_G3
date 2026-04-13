package com.mycompany.proyectoestructura;

/**
 *
 * @author orozc
 */
public class NodoArbol {
    
    private ExpedienteUnicoPaciente paciente;
    private NodoArbol nodoIzq;
    private NodoArbol nodoDer;

    // Metodo Constructor
    public NodoArbol(ExpedienteUnicoPaciente paciente) {
        this.paciente = paciente;
        this.nodoIzq = this.nodoDer = null;
    }

    // Getter y Setter
    public ExpedienteUnicoPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(ExpedienteUnicoPaciente paciente) {
        this.paciente = paciente;
    }

    public NodoArbol getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(NodoArbol nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    public NodoArbol getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(NodoArbol nodoDer) {
        this.nodoDer = nodoDer;
    }

}
