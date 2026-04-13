package com.mycompany.proyectoestructura;

/**
 *
 * @author Adrian Varela
 */
public class ExpedienteUnicoPaciente {

    private int cedula;
    private String nombre, genero;
    private int edad;
    private listaCircularCitas historicoCitas;
    private ListaMedicamentos historicoMedicamentos;

    // Constructor
    public ExpedienteUnicoPaciente(int cedula, String nombre, String genero, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.historicoCitas = new listaCircularCitas();
        this.historicoMedicamentos = new ListaMedicamentos();
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

    public listaCircularCitas getHistoricoCitas() {
        return historicoCitas;
    }

    public void setHistoricoCitas(listaCircularCitas historicoCitas) {
        this.historicoCitas = historicoCitas;
    }

    public ListaMedicamentos getHistoricoMedicamentos() {
        return historicoMedicamentos;
    }

    public void setHistoricoMedicamentos(ListaMedicamentos historicoMedicamentos) {
        this.historicoMedicamentos = historicoMedicamentos;
    }
    
    
}
