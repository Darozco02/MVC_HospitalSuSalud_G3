package com.mycompany.proyectoestructura;

import java.sql.Timestamp;

/**
 *
 * @author orozc
 */
public class citaDia {
    
    private Paciente paciente;
    private Timestamp fechaLlegada;
    private Timestamp fechaAtencion;

    // Constructor
    public citaDia(Paciente paciente, Timestamp fechaLlegada, Timestamp fechaAtencion) {
        this.paciente = paciente;
        this.fechaLlegada = fechaLlegada;
        this.fechaAtencion = fechaAtencion;
    }

    // Getter y Setter
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Timestamp getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Timestamp fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Timestamp getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Timestamp fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
    
    
    
}
