/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructura;

import java.sql.Timestamp;

/**
 *
 * @author AMD
 */
public class HistoricoMedicamentos {
    //se definen variables
    private int receta;
    private Timestamp fecha;
    private String medicamentos;
    private int cedula;

    // constructores
    public HistoricoMedicamentos() {
    }

    public HistoricoMedicamentos(int receta, Timestamp fecha, String medicamentos, int cedula) {
        this.receta = receta;
        this.fecha = fecha;
        this.medicamentos = medicamentos;
        this.cedula=cedula;
    }

    //getters y setter
    public int getReceta() {
        return receta;
    }

    public void setReceta(int receta) {
        this.receta = receta;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
 
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
 
    
    
}
