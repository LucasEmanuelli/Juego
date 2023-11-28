package ar.edu.unlu.bj.Controlador;
import ar.edu.unlu.bj.Modelo.Carta;
import ar.edu.unlu.bj.Modelo.ModeloBlackjack;
import ar.edu.unlu.bj.Vista.VistaConsola;

import java.util.ArrayList;

public class Controlador {
    private VistaConsola vista;
    private ModeloBlackjack modelo;

    public Controlador(ModeloBlackjack modelo){
        this.modelo = modelo;
    }

    public void setVista(VistaConsola vista){
        this.vista = vista;
    }

    public void reiniciarJuego() {
        modelo.reiniciarJuego();
        vista.reiniciarJuego();
        vista.actualizar("Juego reiniciado");
    }
    public void movimiento(String opcion){
        if (Integer.parseInt(opcion) == 1){
            this.modelo.pedirCarta();
        }else if(Integer.parseInt(opcion) == 2){
            this.modelo.plantarse();
        }

    }
    public void iniciarJuego(){

    }

    public String mostrarCartasDealer(){
        return modelo.devolverMazoDealer().toString();
    }

    public String mostrarCartaOcultaDealer(){
        return modelo.devolverCartaOculta().toString();
    }
    public String mostrarCartasJugador(){
        return modelo.devolverMazoJugador().toString();
    }

    public String obtenerPuntajeDealer(){
        return Integer.toString(modelo.devolverPuntajeDealer());
    }
    public String obtenerPuntajeJugador(){
        return Integer.toString(modelo.devolverPuntajeJugador());
    }

    public boolean esBlackjackJugador(){
        return modelo.esBlackjackJugador();
    }

    public boolean esBlackJackDealer(){
        return modelo.esBlackjackDealer();
    }

    public String dealerVsJugador(){
        return modelo.dealerVsJugador();
    }
}
