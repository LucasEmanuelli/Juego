package ar.edu.unlu.bj.Modelo;
import java.util.ArrayList;
import java.util.Random;

public class Mazo {
    private ArrayList<Carta> mazo;
    private  String[] numero = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private  String[] palo = {"diamante", "trebol", "corazon", "picas"};

    public Mazo(){
        this.mazo = new ArrayList<Carta>();
        this.mazo = generarMazo();
    }

    private ArrayList<Carta> generarMazo(){
        for(int i = 0; i < this.palo.length; i++){
            for (int j = 0; j < this.numero.length; j++){;
                Carta carta = new Carta(numero[j], palo[i]);
                this.mazo.add(carta);
            }
        }

        for(int i = 0; i < this.mazo.size(); i++){
            Random random = new Random();
            int aleatorio = random.nextInt(mazo.size());
            Carta cartaUno = mazo.get(i);
            Carta cartaDos = mazo.get(aleatorio);
            mazo.set(i, cartaDos);
            mazo.set(aleatorio, cartaUno);
        }
        return mazo;
    }

    public Carta darCarta(){
        return mazo.removeFirst();
    }
}
