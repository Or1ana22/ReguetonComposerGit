package co.edu.ucatolica.modelo;

public class Lyric {
    private String[] inicio = {"Mami", "Bebe", "Princesa", "Mami"};
    private String[] medio = {"yo quiero", "yo puedo", "yo vengo a", "voy a"};
    private String[] accion = {"encenderte", "amarte", "ligar", "jugar"};
    private String[] complemento = {"suave", "lento", "rápido", "fuerte"};
    private String[] finalFrase = {"hasta que salga el sol", "toda la noche", "hasta el amanecer", "todo el día"};
    private String[] cierre = {"sin anestesia", "sin compromiso", "feis to feis", "sin miedo"};

    private int numEstrofas;
    private int numFrases;

 // Getters y setters para numEstrofas y numFrases.
    public int getNumEstrofas() {
        return numEstrofas;
    }

    public void setNumEstrofas(int numEstrofas) {
        this.numEstrofas = numEstrofas;
    }

    public int getNumFrases() {
        return numFrases;
    }

    public void setNumFrases(int numFrases) {
        this.numFrases = numFrases;
    }

    public Song generarCancion() {
        Song song = new Song();
        for (int i = 0; i < numEstrofas; i++) {
            StringBuilder estrofa = new StringBuilder();
            for (int j = 0; j < numFrases; j++) {
                estrofa.append(elegirPalabraAleatoria(inicio)).append(" ");
                estrofa.append(elegirPalabraAleatoria(medio)).append(" ");
                estrofa.append(elegirPalabraAleatoria(accion)).append(" ");
                estrofa.append(elegirPalabraAleatoria(complemento)).append(" ");
                estrofa.append(elegirPalabraAleatoria(finalFrase));
                if (Math.random() < 0.5) { // Añade un final opcionalmente
                    estrofa.append(" ").append(elegirPalabraAleatoria(cierre));
                }
                estrofa.append("\n");
            }
            song.addEstrofa(estrofa.toString());
        }
        return song;
    }

    private String elegirPalabraAleatoria(String[] palabras) {
        return palabras[(int) (Math.random() * palabras.length)];
    }
}

