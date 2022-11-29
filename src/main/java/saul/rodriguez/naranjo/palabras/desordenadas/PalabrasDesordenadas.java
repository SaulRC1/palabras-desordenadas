package saul.rodriguez.naranjo.palabras.desordenadas;

import java.util.Scanner;

/**
 *
 * @author Saul Rodriguez Naranjo
 */
public class PalabrasDesordenadas {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("#######################################");
        System.out.println("JUEGO DE LAS PALABRAS DESORDENADAS");
        System.out.println("#######################################");
        
        Jugador jugador1;
        
        Jugador jugador2;
        
        System.out.println("Indica nombre del jugador 1:");
        
        String nombreJugador1 = sc.nextLine();
        
        jugador1 = new Jugador(nombreJugador1);
        
        System.out.println("Indica nombre del jugador 2:");
        
        String nombreJugador2 = sc.nextLine();
        
        jugador2 = new Jugador(nombreJugador2);
        
        JuegoPalabrasDesordenadas juego = new JuegoPalabrasDesordenadas(jugador1, jugador2);
        
        juego.comenzarPartida();
        
        
    }
}
