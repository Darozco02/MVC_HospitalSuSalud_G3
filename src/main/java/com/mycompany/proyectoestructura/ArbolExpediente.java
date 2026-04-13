package com.mycompany.proyectoestructura;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

/**
 *
 * @author orozc
 */
public class ArbolExpediente {

    private NodoArbol raiz;

    // Metodo Constructor
    public ArbolExpediente() {
        this.raiz = null;
    }

    // Getter y Setter
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    // Insertar datos al arbol
    /**
     * Metodo wrapper que llama el metodo recursivo
     *
     * @author Daniel Orozco
     *
     * @param paciente Expediente del paciente que va a ser ingresado.
     */
    public void insertar(ExpedienteUnicoPaciente paciente) {
        raiz = insertarRec(raiz, paciente);
    }

    /**
     * Metodo recursivo que inserta expedientes de pacientes al arbol, segun sea
     * el caso. El caso 1 es en caso de que el arbol este vacio, pondria al
     * paciente como la raiz. en caso 2 seria si el nodo va a la izquierda y el
     * caso 3 en donde el nodo vaya a la derecha.
     *
     * @author Daniel Orozco
     *
     * @param nodoActual nodo que almacena el expediente y sera ingresado.
     * @param paciente Expediente del paciente que va a ser ingresado.
     */
    public NodoArbol insertarRec(NodoArbol nodoActual, ExpedienteUnicoPaciente paciente) {
        // Caso en que el arbol este vacio
        if (nodoActual == null) {
            return new NodoArbol(paciente);
            // Caso en donde el nodo va a la izquierda
        } else if (paciente.getCedula() < nodoActual.getPaciente().getCedula()) {
            nodoActual.setNodoIzq(insertarRec(nodoActual.getNodoIzq(), paciente));
            // Caso en donde el nodo va a la derecha
        } else if (paciente.getCedula() > nodoActual.getPaciente().getCedula()) {
            nodoActual.setNodoDer(insertarRec(nodoActual.getNodoDer(), paciente));
        }
        return nodoActual;
    }

    /**
     * Metodo que carga un archivo JSON, lo lee y guarda la informacion dentro
     * del arbol. Cuenta con funcionalidad para abrir el archivo desde el
     * explorador de archivos
     *
     * Enlace para usar el import de JSON NOTA:
     * https://github.com/google/gson/blob/main/UserGuide.md
     *
     * Enlace de documentacion para abrir explorador de archivos NOTA:
     * https://docs.oracle.com/javase/8/docs/api/javax/swing/JFileChooser.html
     *
     * @author Daniel Orozco
     */
    public void cargarArchivoJSON() {
        try {
            // Abrir expliorador de archivos para elegir el archivo
            JFileChooser selector = new JFileChooser();
            int resultado = selector.showOpenDialog(null);
            if (resultado != JFileChooser.APPROVE_OPTION) {
                return;
            }
            FileReader lector = new FileReader(selector.getSelectedFile());
            JsonArray arreglo = JsonParser.parseReader(lector).getAsJsonArray();

            // Recorrer el archivo
            for (JsonElement elemento : arreglo) {
                JsonObject obj = elemento.getAsJsonObject();

                // Extraer datos del paciente
                int cedula = obj.get("CEDULA").getAsInt();
                String nombre = obj.get("NOMBRE").getAsString();
                int edad = obj.get("EDAD").getAsInt();
                String genero = obj.get("GENERO").getAsString();

                // Crear expediente
                ExpedienteUnicoPaciente expediente = new ExpedienteUnicoPaciente(cedula, nombre, genero, edad);

                // Citas
                JsonArray citas = obj.get("CITAS").getAsJsonArray();
                for (JsonElement citaElem : citas) {
                    JsonObject citaObj = citaElem.getAsJsonObject();
                    String fechaStr = citaObj.get("FECHA").getAsString();
                    String medico = citaObj.get("MEDICO").getAsString();
                    String diagnostico = citaObj.get("DIAGNOSTICO").getAsString();
                    Timestamp fecha = Timestamp.valueOf(fechaStr);
                    historicoCita cita = new historicoCita(fecha, medico, diagnostico);
                    expediente.getHistoricoCitas().insertarOrdenado(cita);
                }

                // Medicamentos
                JsonArray medicamentos = obj.get("MEDICAMENTOS").getAsJsonArray();
                for (JsonElement medElem : medicamentos) {
                    JsonObject medObj = medElem.getAsJsonObject();
                    String fechaStr = medObj.get("FECHA").getAsString();
                    String medicamento = medObj.get("MEDICAMENTO").getAsString();
                    Timestamp fecha = Timestamp.valueOf(fechaStr);
                    HistoricoMedicamentos med = new HistoricoMedicamentos(cedula, fecha, medicamento, cedula);
                    expediente.getHistoricoMedicamentos().insertarOrdenado(med);
                }

                // Insertar los datos en el arbol creado
                insertar(expediente);
            }
            JOptionPane.showMessageDialog(null, "Los expedientes fueron cargados correctamente",
                    "Confirmacion", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo JSON: " + e.getMessage());
        }
    }

    // Ver expedientes cargados
    public void verArchivoJSON() {
        verArchivoJSONRec(raiz);
    }

    private void verArchivoJSONRec(NodoArbol nodoActual) {
        if (nodoActual != null) {
            verArchivoJSONRec(nodoActual.getNodoIzq());
            JOptionPane.showMessageDialog(null,
                    "Cédula: " + nodoActual.getPaciente().getCedula() + "\n"
                    + "Nombre: " + nodoActual.getPaciente().getNombre() + "\n"
                    + "Edad: " + nodoActual.getPaciente().getEdad() + "\n"
                    + "Género: " + nodoActual.getPaciente().getGenero());
            verArchivoJSONRec(nodoActual.getNodoDer());
        }
    }

}
