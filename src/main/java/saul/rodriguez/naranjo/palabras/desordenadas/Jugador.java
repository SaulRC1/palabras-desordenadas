package saul.rodriguez.naranjo.palabras.desordenadas;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
public class Jugador {
    
    private String nombre;
    
    private int partidasGanadas = 0;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }
    
    public void incrementarPartidasGanadas() {
        partidasGanadas++;
    }

}
