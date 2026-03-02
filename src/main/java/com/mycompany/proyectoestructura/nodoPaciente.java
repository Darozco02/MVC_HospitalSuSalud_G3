package com.mycompany.proyectoestructura;

/**
 *
 * @author orozc
 */
public class nodoPaciente {
    
    private Paciente paciente;
    private nodoPaciente referencia;

    public nodoPaciente() {
    }

    public nodoPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.referencia = null; // Indica que la cola empieza vacia.
    }

    // Getter y Setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public nodoPaciente getReferencia() {
        return referencia;
    }

    public void setReferencia(nodoPaciente referencia) {
        this.referencia = referencia;
    }
}
