package ar.edu.unlu.bj.Modelo;
import java.util.ArrayList;
public class Dealer {
    private Carta cartaSinMostrar;
    private ArrayList<Carta> mazoDealer;
    private int puntajeDealer = 0;


    public Dealer(Mazo mazo){
        this.mazoDealer = new ArrayList<Carta>();

        this.cartaSinMostrar = mazo.darCarta();
        this.puntajeDealer += this.cartaSinMostrar.obtenerValorCarta();

        Carta carta = mazo.darCarta();
        this.puntajeDealer += carta.obtenerValorCarta();
        this.mazoDealer.add(carta);
        if (this.puntajeDealer == 22){
            this.puntajeDealer -= 10;
        }

    }

    public ArrayList<Carta> getMazoDealer() {
        return mazoDealer;
    }

    public int getPuntajeDealer() {
        return puntajeDealer;
    }

    public Carta getCartaSinMostrar() {
        return cartaSinMostrar;
    }
    public void recibirCarta(Mazo mazo) {
        Carta carta = mazo.darCarta();
        int valorPost = this.puntajeDealer + carta.obtenerValorCarta();
        if (carta.getNumero().equals("A") && this.puntajeDealer < 17 && valorPost <= 21){
            this.puntajeDealer += carta.obtenerValorCarta();
        } else if (carta.getNumero().equals("A") && this.puntajeDealer < 17 && valorPost > 21) {
            this.puntajeDealer += 1;
        }else{
            this.puntajeDealer += carta.obtenerValorCarta();
        }
        this.mazoDealer.add(carta);
    }
    }
