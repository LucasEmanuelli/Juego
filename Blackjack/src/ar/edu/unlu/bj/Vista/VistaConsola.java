package ar.edu.unlu.bj.Vista;
import ar.edu.unlu.bj.Controlador.Controlador;
import ar.edu.unlu.bj.Modelo.Carta;
import ar.edu.unlu.bj.Modelo.IObserver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


import javax.swing.*;

public class VistaConsola extends JFrame implements IObserver {
    private final JFrame frame;
    private JPanel contentPane;
    private JButton btnEnter;
    private JTextField txtEntrada;
    private JTextArea txtSalidaConsola;
    private Controlador controlador;
    private boolean entradaRecibida;
    private String input;

    public VistaConsola(Controlador controlador){
        this.controlador = controlador;
        frame = new JFrame("<class name>");
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSalidaConsola.append(txtEntrada.getText() + "\n");
                input = txtEntrada.getText();
                entradaRecibida = true;
                if (input.equals("1") || input.equals("2")){
                    txtEntrada.setText("");
                    siguienteMovimiento();
                }else if(input.equals("3") || (input.equals("4"))){
                    txtEntrada.setText("");
                    preDecision();
                }
                txtEntrada.setText("");
            }
        });

    }
    public void reiniciarJuego() {
        entradaRecibida = false;
        input = null;
        txtEntrada.setText("");
        txtSalidaConsola.setText("");
    }
    private String procesarEntrada(String input) {
        input = input.trim();
        return input;
    }
    @Override
    public void actualizar(String message) {
        txtSalidaConsola.append(message + "\n");

        // Hacer que el scroll baje automáticamente
        int length = txtSalidaConsola.getDocument().getLength();
        txtSalidaConsola.setCaretPosition(length);
        System.out.println("Vista actualizada: " + message);
    }
    public void mostrar() {
        frame.setVisible(true);
    }

    public void iniciar(){
        mostrar();
        this.println("BIENVENIDO A BLACKJACK!");
        this.println("-----------------------");
        this.println("COMENZANDO....");
        this.println("-----------------------");
        darMano();

    }

    public void darMano(){
        this.println("CARTAS DEL DEALER:");
        this.println("-----------------------");
        this.println("CARTA BOCA ABAJO | " + controlador.mostrarCartasDealer());
        this.println("-----------------------");
        this.println("CARTAS DEL JUGADOR:");
        this.println("-----------------------");
        this.println(controlador.mostrarCartasJugador());
        this.println("-----------------------");
        this.println("PUNTAJE DEL JUGADOR:");
        this.println(controlador.obtenerPuntajeJugador());
        println("--------------------------------------------");
        println("1 - PEDIR | 2 - PLANTARSE");
        println("-----------------------");
        siguienteMovimiento();
    }

    public void siguienteMovimiento(){
        if (entradaRecibida && !controlador.esBlackjackJugador()) {
            println("Usted eligió la opción: " + input);
            controlador.movimiento(input);
            println("-----------------------");
            println(controlador.mostrarCartasJugador());
            println("-----------------------");
            println("PUNTAJE DEL JUGADOR:");
            println(controlador.obtenerPuntajeJugador());
            if (input.equals("1")){
                chequearEstado();
            }else if (input.equals("2")){
                println("TE PLANTASTE");
                println("-----------------------");
                chequearEstadoDealer();
            }
        }else if (controlador.esBlackjackJugador()){
            chequearEstadoDealer();
        }
    }
    public void println(String texto) {
        txtSalidaConsola.append(texto + "\n");
    }

    public void chequearEstado(){
        if (Integer.parseInt(controlador.obtenerPuntajeJugador()) > 21){
            println("TE PASASTE DE 21 : PERDISTE");
            preDecision();
        }else{
            darMano();
        }

    }

    public void preDecision(){
        println("--------------------------------------------");
        println("3 - REINICIAR | 4 - SALIR");
        println("-----------------------");
        if(entradaRecibida) {
            decision(input);
        }
    }
    public void decision(String input){
            if (input.equals("3")) {
                controlador.reiniciarJuego();
                iniciar();
            } else if (input.equals("4")) {
                System.exit(0);
            }
    }
    public void chequearEstadoDealer(){
        println("CARTAS DEL DEALER:");
        println(controlador.mostrarCartaOcultaDealer() + " | " + controlador.mostrarCartasDealer());
        println("-----------------------");

        println("PUNTAJE DEL DEALER");
        println(controlador.obtenerPuntajeDealer());
        println("-----------------------");
        println(controlador.dealerVsJugador());
        println("--------------------------------------------");
        println("3 - REINICIAR | 4 - SALIR");
        println("-----------------------");
        decision(input);
    }
}
