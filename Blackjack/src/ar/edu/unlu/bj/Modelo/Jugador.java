package ar.edu.unlu.bj.Modelo;

import java.util.ArrayList;

public class Jugador {
    private int puntajeJugador = 0;
    private ArrayList<Carta> mazoJugador;

    public Jugador(Mazo mazo){
        this.mazoJugador = new ArrayList<Carta>();
        for (int i = 0; i < 2; i++){
            recibirCarta(mazo);
        }
    }

    public ArrayList<Carta> getMazoJugador() {
        return mazoJugador;
    }

    public void recibirCarta(Mazo mazo){
        Carta carta = mazo.darCarta();
        int valorPost = this.puntajeJugador + carta.obtenerValorCarta();
        if (carta.getNumero().equals("A") && valorPost > 21){
            this.puntajeJugador += 1;
            this.mazoJugador.add(carta);
            return;
        }
        this.puntajeJugador += carta.obtenerValorCarta();
        this.mazoJugador.add(carta);
    }


    public int getPuntajeJugador() {
        return puntajeJugador;
    }

}
