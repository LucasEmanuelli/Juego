package ar.edu.unlu.bj.Modelo;
import java.util.ArrayList;
import java.util.List;

public class ModeloBlackjack implements IObservable{
    private List<IObserver> observers = new ArrayList<>();
    private Jugador jugador;
    private Dealer dealer;
    private Mazo mazo;
     public ModeloBlackjack(){
         Mazo mazo = new Mazo();
         this.mazo = mazo;

         Dealer dealer = new Dealer(this.mazo);
         this.dealer = dealer;

         Jugador jugador = new Jugador(this.mazo);
         this.jugador = jugador;
         notificadorObservable("Los valores fueron inicializados");

     }
    public void reiniciarJuego() {
        mazo = new Mazo();
        dealer = new Dealer(mazo);
        jugador = new Jugador(mazo);

        notificadorObservable("Juego reiniciado");
    }
        public ArrayList<Carta> devolverMazoDealer(){
         return this.dealer.getMazoDealer();
     }
     public Carta devolverCartaOculta(){
         return this.dealer.getCartaSinMostrar();
     }

     public ArrayList<Carta> devolverMazoJugador(){
         return this.jugador.getMazoJugador();
    }

    public int devolverPuntajeDealer(){
         return this.dealer.getPuntajeDealer();
    }

    public int devolverPuntajeJugador(){
         return this.jugador.getPuntajeJugador();
    }
    public void plantarse(){
         while(this.dealer.getPuntajeDealer() < 17){
             this.dealer.recibirCarta(this.mazo);
         }
         notificadorObservable("El dealer recibio las cartas.");
    }
   public boolean esBlackjackJugador(){
     return (this.jugador.getPuntajeJugador() == 21);
   }

   public boolean esBlackjackDealer(){
         return (this.dealer.getPuntajeDealer() == 21);
   }
   public void pedirCarta(){
        this.jugador.recibirCarta(this.mazo);
        notificadorObservable("El jugador recibio una carta");
   }

   public String dealerVsJugador(){
         String cadena = "";
         if (this.devolverPuntajeDealer() > this.devolverPuntajeJugador() && !masDeVeintiunoDealer()){
             cadena = "EL DEALER GANA";
         }else if (masDeVeintiunoDealer()){
             cadena = "GANASTE. EL DEALER SE PASA";
         }else if(this.devolverPuntajeDealer() < this.devolverPuntajeJugador() && !masDeVeintiunoJugador()){
             cadena = "GANASTE";
         }else if (this.devolverPuntajeDealer() == this.devolverPuntajeJugador()){
             cadena ="EMPATE";
         }
         return cadena;
       }

    public boolean masDeVeintiunoJugador(){
        return (this.jugador.getPuntajeJugador() > 21);
    }

    public boolean masDeVeintiunoDealer(){
        return (this.dealer.getPuntajeDealer() > 21);
    }
    @Override
    public void agregarObservable(IObserver observer) {
        observers.add(observer);
    }
    @Override
    public void removerObservable(IObserver observer) {
        observers.remove(observer);
    }
    @Override
    public void notificadorObservable(String message) {
        for (IObserver observer : observers) {
            observer.actualizar(message);
        }
    }
}
