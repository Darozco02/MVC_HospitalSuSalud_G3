package com.mycompany.proyectoestructura;

import java.sql.Timestamp;

/**
 *
 * @author orozc
 */
public class historicoCita {
    
    private Timestamp fecha;
    private String nombreDoctor;
    private String diagnostico;

    // Constructor
    public historicoCita(Timestamp fecha, String nombreDoctor, String diagnostico) {
        this.fecha = fecha;
        this.nombreDoctor = nombreDoctor;
        this.diagnostico = diagnostico;
    }

    // Getter y Setters
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    
    
}
