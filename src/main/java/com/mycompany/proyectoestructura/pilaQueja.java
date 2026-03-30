package com.mycompany.proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author Adrian Varela
 */
public class pilaQueja {

    private nodoQueja cima; // referencia a todo el Nodo no solo al dato

    
    //getters & setters
    public pilaQueja() {
        cima = null; //se inicializa en null para corroborar que la pila está vacía
    }


    public nodoQueja getCima() {
        return cima;
    }


    public void setCima(nodoQueja cima) {
        this.cima = cima;
    }

    /**
     *Metodo que almacena una nueva queja
     * @param nuevaQueja
     * 
     * @author Adrian Varela
     */
    public void ingresoQueja(Queja nuevaQueja){
        // Creacion del nodo
        nodoQueja miNodo = new nodoQueja(nuevaQueja);
        
        if (cima == null) {
            cima = miNodo;
        } else {
            miNodo.setAbajo(cima);
            cima = miNodo;
        }
    }
    
    /**
     * Metodo que muestra todas las quejas recibidas. mostrando el # de ficha 
     * y cedula del paciente, ademas del motivo de su salida(queja)
     * 
     * @auhor Daniel Orozco
     * 
     */
    public void mostrarQuejas(){
        // Variable temporal que recorre la pila sin alterarla.
        nodoQueja temporal = cima;
        
        // Recorrer la pila
        while (temporal != null) {
            JOptionPane.showMessageDialog(null, "Ficha #" + temporal.getMiQueja().getPacienteQueja().getNumFicha()
                                            + " con cédula: " + temporal.getMiQueja().getPacienteQueja().getCedula() + ","
                                            + " abandona la cola sin ser atendido(a) a la fecha y hora: " + temporal.getMiQueja().getFechaAbandono()
                                            + "\n" + "Por el siguiente motivo: " + temporal.getMiQueja().getMotivo() + "\n");
            temporal = temporal.getAbajo();
        }
    }
    

}
