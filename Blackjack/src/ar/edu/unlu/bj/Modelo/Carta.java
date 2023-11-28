package ar.edu.unlu.bj.Modelo;

public class Carta {
    private final String numero;
    private final String palo;

    public Carta(String numero, String palo){
        this.numero = numero;
        this.palo = palo;
    }

    public String getNumero() {
        return numero;
    }

    public String getPalo() {
        return palo;
    }

    public int obtenerValorCarta(){
        if ("AJQK".contains(this.numero)){
            if (this.numero.equals("A")){
                return 11;
            }else{
                return 10;
            }
        }
        return (Integer.parseInt(this.numero));
    }


    public String toString(){
        return numero + "-" + palo;
    }
}
