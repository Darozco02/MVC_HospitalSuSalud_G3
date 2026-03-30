package com.mycompany.proyectoestructura;

import java.sql.Timestamp;

/**
 *
 * @author Adrian Varela
 */
public class ExpedienteUnicoPaciente {

    private int cedula;
    private String nombre, genero;
    private int edad;
   // private listaCircularCitas historicoCitas;

    // Constructor
    public ExpedienteUnicoPaciente(int cedula, String nombre, String genero, int edad//, listaCircularCitas historicoCitas
    ) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
      //  this.historicoCitas = historicoCitas;
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



   // public listaCircularCitas getHistoricoCitas() {
    //    return historicoCitas;
    //}

    //public void setHistoricoCitas(listaCircularCitas historicoCitas) {
     //   this.historicoCitas = historicoCitas;
   // }
    
    


}
