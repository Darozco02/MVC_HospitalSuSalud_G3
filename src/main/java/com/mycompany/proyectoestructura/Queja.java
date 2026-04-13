package com.mycompany.proyectoestructura;

import java.sql.Timestamp;

/**
 *
 * @author orozc
 */
public class Queja {
    
    private Paciente pacienteQueja;
    private String motivo;
    private Timestamp fechaAbandono;

    // Constructor
    public Queja(Paciente pacienteQueja, String motivo, Timestamp fechaAbandono) {
        this.pacienteQueja = pacienteQueja;
        this.motivo = motivo;
        this.fechaAbandono = fechaAbandono;
    }

    // Getter y Setters
    public Paciente getPacienteQueja() {
        return pacienteQueja;
    }

    public void setPacienteQueja(Paciente pacienteQueja) {
        this.pacienteQueja = pacienteQueja;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Timestamp getFechaAbandono() {
        return fechaAbandono;
    }

    public void setFechaAbandono(Timestamp fechaAbandono) {
        this.fechaAbandono = fechaAbandono;
    }

    
    
    
}
