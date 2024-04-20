package co.edu.ucatolica.modelo;

import java.util.ArrayList;
import java.util.List;

public class Song {
    private List<String> estrofas;  // Cambiamos a una lista para manejar múltiples estrofas

    public Song() {
        estrofas = new ArrayList<>();
    }

    public void addEstrofa(String estrofa) {
        estrofas.add(estrofa);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String stanza : estrofas) {
            sb.append(stanza).append("\n");
        }
        return sb.toString();
    }
}
