package com.mycompany.proyectoestructura;

import java.sql.Timestamp;

/**
 *
 * @author Adrian Varela
 */
public class ExpedienteUnicoPaciente {
    
private int cedula;
private String  nombre , genero;
private int edad;

private bitacoraCita historicoCita;

    // Constructor

    public ExpedienteUnicoPaciente(int cedula, String nombre, String genero, int edad, bitacoraCita historicoCita) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.historicoCita = historicoCita;
    }

  

    public ExpedienteUnicoPaciente() {
    }
    
    
    
    // Getter y Setters

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public bitacoraCita getHistoricoCita() {
        return historicoCita;
    }

    public void setHistoricoCita(bitacoraCita historicoCita) {
        this.historicoCita = historicoCita;
    }




}
