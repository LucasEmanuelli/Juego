import ar.edu.unlu.bj.Controlador.Controlador;
import ar.edu.unlu.bj.Modelo.ModeloBlackjack;
import ar.edu.unlu.bj.Vista.VistaConsola;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Main {
    public static void main(String[] args) {
        ModeloBlackjack modelo = new ModeloBlackjack();
        Controlador controlador = new Controlador(modelo);
        VistaConsola vista = new VistaConsola(controlador);
        controlador.setVista(vista);
        modelo.agregarObservable(vista);

        vista.iniciar();
    }
}
