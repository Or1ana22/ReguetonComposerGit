package co.edu.ucatolica.controlador;

import co.edu.ucatolica.modelo.Lyric;
import co.edu.ucatolica.modelo.Song;
import co.edu.ucatolica.vista.SongView;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class SongController {

    private Lyric model;
    private SongView view;

    public SongController(Lyric model, SongView view) {
        this.model = model;
        this.view = view;
    }

    public void definirParametros(int numEstrofas, int numFrases) {
        model.setNumEstrofas(numEstrofas);
        model.setNumFrases(numFrases);
        System.out.println("Parámetros establecidos: Estrofas - " + numEstrofas + ", Frases - " + numFrases);
    }


    public void crearCancion() {
        System.out.println("Generando canción con " + model.getNumEstrofas() + " estrofas y " + model.getNumFrases() + " frases por estrofa.");
        Song cancion = model.generarCancion();
        if (cancion.toString().trim().isEmpty()) {
            view.mostrarError("La canción generada está vacía. Verifique los parámetros.");
        } else {
            view.mostrarCancion(cancion.toString());
            guardarCancion(cancion);
        }
    }


    public void mostrarCancion() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Intentando abrir: " + selectedFile.getAbsolutePath());
            mostrarCancionDesdeArchivo(selectedFile);
        }
    }

    private void guardarCancion(Song cancion) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = chooser.getSelectedFile();
            if (!fileToSave.getAbsolutePath().endsWith(".txt")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
            }
            try (PrintWriter out = new PrintWriter(fileToSave)) {
                out.println(cancion.toString());
                System.out.println("Archivo guardado en: " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                view.mostrarError("Error al guardar la canción: " + e.getMessage());
            }
        }
    }


    private void mostrarCancionDesdeArchivo(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder lyrics = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                lyrics.append(line).append("\n");
            }
            view.mostrarCancion(lyrics.toString());
        } catch (IOException e) {
            view.mostrarError("Error al leer el archivo: " + e.getMessage());
        }
    }
}