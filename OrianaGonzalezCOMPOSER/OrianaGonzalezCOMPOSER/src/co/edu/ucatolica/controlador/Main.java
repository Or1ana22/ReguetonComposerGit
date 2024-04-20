package co.edu.ucatolica.controlador;
import co.edu.ucatolica.modelo.Lyric;
import co.edu.ucatolica.vista.SongView;

import javax.swing.SwingUtilities;

//En tu clase principal
public class Main {

 public static void main(String[] args) {
     Lyric lyricModel = new Lyric();
     SongView view = new SongView();
     SongController controller = new SongController(lyricModel, view);

     // Usa SwingUtilities para asegurar que la interfaz gráfica se maneje
     SwingUtilities.invokeLater(new Runnable() {
         public void run() {
             view.mostrarMenuPrincipal(controller);
         }
     });
 }
}


