package com.mycompany.proyectoestructura;

/**
 *
 * @author orozc
 */
public class NodoDiagnostico {
    
    private String diagnostico;
    private int contador;
    private NodoDiagnostico siguiente;

    // Metodo Constructor
    public NodoDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
        this.contador = 1;
        this.siguiente = null;
    }

    // Getter y Setters
    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public NodoDiagnostico getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDiagnostico siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
