package com.mycompany.proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author orozc
 */
public class ListaDiagnostico {

    private NodoDiagnostico cabeza;

    // Constructor
    public ListaDiagnostico() {
        this.cabeza = null;
    }

    // Getter y Setters
    public NodoDiagnostico getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDiagnostico cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Metodo que agrega diagnosticos segun los diagnosticos que vaya
     * encontrando. recorre los diagnosticos y cuando encuentra iguales los
     * agrega
     *
     * @author Daniel Orozco
     *
     * @param diagnostico diagnostico que sera agregado
     */
    public void incrementar(String diagnostico) {
        NodoDiagnostico temp = cabeza;
        while (temp != null) {
            if (temp.getDiagnostico().equalsIgnoreCase(diagnostico)) {
                temp.setContador(temp.getContador() + 1);
                return;
            }
            temp = temp.getSiguiente();
        }

        NodoDiagnostico nuevoDiagnostico = new NodoDiagnostico(diagnostico);
        nuevoDiagnostico.setSiguiente(cabeza);
        cabeza = nuevoDiagnostico;
    }

    /**
     * Metodo que imprime los diagnosticos que fueron agregados 
     * en el metodo incrementar y muestra un mensaje con los mismos.
     * 
     * @author Daniel Orozco
     */
    public void imprimirDiagnosticos() {
        NodoDiagnostico temp = cabeza;
        String resultado = "";
        while (temp != null) {
            resultado += temp.getDiagnostico() + ": " 
                    + temp.getContador() 
                    + " casos" + "\n";
            temp = temp.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, resultado, "Enfermedades frecuentes"
                , JOptionPane.INFORMATION_MESSAGE);
    }

}
