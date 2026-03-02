package com.mycompany.proyectoestructura;

import java.sql.Timestamp;

/**
 *
 * @author orozc
 */
public class Paciente {
    
    private String numFicha;
    private String cedula;
    private String nombrePaciente;
    private Timestamp fecha; // formato TIMESTAMP con fecha y hora

    // Constructor
    public Paciente(String numFicha, String cedula, String nombrePaciente, Timestamp fecha) {
        this.numFicha = numFicha;
        this.cedula = cedula;
        this.nombrePaciente = nombrePaciente;
        this.fecha = fecha;
    }

    public Paciente() {
    }
    
    
    
    // Getter y Setters
    public String getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(String numFicha) {
        this.numFicha = numFicha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    

}
