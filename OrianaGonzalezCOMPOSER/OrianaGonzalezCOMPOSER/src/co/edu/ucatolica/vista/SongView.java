package co.edu.ucatolica.vista;

import co.edu.ucatolica.controlador.SongController;
import javax.swing.JOptionPane;

// Vista que gestiona la interacción del usuario a través de interfaces gráficas.
public class SongView {

    public void mostrarMenuPrincipal(SongController controller) {
        boolean continuar = true;
        while (continuar) {
            String[] opciones = {"Definir parámetros", "Crear canción", "Mostrar canción", "Salir"};
            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción",
                    "Generador de Canciones de Reggaetón",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            if (opcion == JOptionPane.CLOSED_OPTION || opcion == 3) {
                continuar = false;  // Manejo del cierre del diálogo o salida
            } else {
                try {
                    switch (opcion) {
                        case 0: // "Definir parámetros"
                            int numEstrofas = solicitarNumero("Ingrese el número de estrofas:");
                            int numFrases = solicitarNumero("Ingrese el número de frases por estrofa:");
                            if (numEstrofas > 0 && numFrases > 0) {
                                controller.definirParametros(numEstrofas, numFrases);
                            } else {
                                JOptionPane.showMessageDialog(null, "Por favor ingrese valores mayores a cero.");
                            }
                            break;
                        case 1: // "Crear canción"
                            controller.crearCancion();
                            break;
                        case 2: // "Mostrar canción"
                            controller.mostrarCancion();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese números válidos.");
                }
            }
        }
    }

    private int solicitarNumero(String mensaje) throws NumberFormatException {
        String input = JOptionPane.showInputDialog(mensaje);
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ingresó ningún número.");
            throw new NumberFormatException("Cancelado por el usuario o entrada vacía");
        }
        return Integer.parseInt(input);
    }

    public void mostrarCancion(String cancion) {
        JOptionPane.showMessageDialog(null, cancion);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
