/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package saul.rodriguez.naranjo.palabras.desordenadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
public class JuegoPalabrasDesordenadas {

    public static final int NUMERO_MAXIMO_DE_PARTIDAS = 3;

    private List<String> palabras;

    private int indicePalabraEnJuego = -1;

    private String palabraEnJuego;

    private int partidaActual = 1;

    private Jugador jugador1;

    private Jugador jugador2;

    public JuegoPalabrasDesordenadas(Jugador jugador1, Jugador jugador2) {

        generarPalabras();

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    private void generarPalabras() {

        palabras = new ArrayList<>();

        palabras.add("CALEFACCION");
        palabras.add("ORDENADOR");
        palabras.add("PISCIFACTORIA");
        palabras.add("CUADRADO");
        palabras.add("TECLADO");
        palabras.add("TELEFONO");

    }

    public void siguientePalabra() {

        int indiceSiguientePalabra = this.indicePalabraEnJuego + 1;

        if (indiceSiguientePalabra <= this.palabras.size()) {

            palabraEnJuego = palabras.get(indiceSiguientePalabra);

            indicePalabraEnJuego = indiceSiguientePalabra;

        } else {

            palabraEnJuego = palabras.get(0);

            indicePalabraEnJuego = 0;

        }

    }

    private String desordenarPalabra() {

        char[] caracteresPalabra = palabraEnJuego.toCharArray();

        int tamanioPalabra = caracteresPalabra.length;

        String palabraDesordenada = "";

        int ultimoIndice = tamanioPalabra - 1;

        for (int i = 0; i < tamanioPalabra; i++) {

            palabraDesordenada += caracteresPalabra[ultimoIndice - i];

        }

        return palabraDesordenada;
    }

    public void comenzarPartida() {

        System.out.println("Bienvenidos jugador 1 [" + jugador1.getNombre() + "]"
                + " y jugador 2 [" + jugador2.getNombre() + "]");
        
        bucleDeJuego();

    }

    public void bucleDeJuego() {

        Scanner sc = new Scanner(System.in);

        while (!comprobarSiElJuegoAcaba()) {

            siguientePalabra();

            String palabraDesordenada = desordenarPalabra();

            System.out.println("Adivina cual es esta palabra: " + palabraDesordenada);

            String palabraEscogidaPorJugador = "";

            while (true) {

                System.out.println("¿Jugador 1 [" + jugador1.getNombre() + "] que palabra es?:");

                palabraEscogidaPorJugador = sc.nextLine();

                if (palabraEscogidaPorJugador.equalsIgnoreCase(palabraEnJuego)) {

                    System.out.println("Jugador 1 [" + jugador1.getNombre() + "] gana la partida!");
                    System.out.println("La palabra era: " + palabraEnJuego);
                    jugador1.incrementarPartidasGanadas();
                    break;

                } else {
                    System.out.println("¡Has fallado, que pena!");
                }

                System.out.println("¿Jugador 2 [" + jugador2.getNombre() + "] que palabra es?:");

                palabraEscogidaPorJugador = sc.nextLine();

                if (palabraEscogidaPorJugador.equalsIgnoreCase(palabraEnJuego)) {

                    System.out.println("Jugador 2 [" + jugador2.getNombre() + "] gana la partida!");
                    System.out.println("La palabra era: " + palabraEnJuego);
                    jugador2.incrementarPartidasGanadas();
                    break;

                } else {
                    System.out.println("¡Has fallado, que pena!");
                }

            }

            partidaActual++;

        }
        
        determinarGanadorDelJuego();

    }

    public boolean comprobarSiElJuegoAcaba() {

        if (partidaActual > NUMERO_MAXIMO_DE_PARTIDAS) {
            return true;
        }

        if (jugador1.getPartidasGanadas() == 2 || jugador2.getPartidasGanadas() == 2) {
            return true;
        }

        return false;
    }
    
    public void determinarGanadorDelJuego() {
        
        if (jugador1.getPartidasGanadas() == 2)
        {
            System.out.println("Jugador 1 [" + jugador1.getNombre() + "] gana el juego!");
        }
        
        if(jugador2.getPartidasGanadas() == 2) {
            System.out.println("Jugador 2 [" + jugador2.getNombre() + "] gana el juego!");
        }
        
    }

}
