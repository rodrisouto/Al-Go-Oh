package algo3.fiuba;

import algo3.fiuba.jugador.Jugador;

public class Juego {

    private static Juego INSTANCIA;

    private Jugador jugador1;
    private Jugador jugador2;

    private Juego() {

    }

    public static Juego getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new Juego();

        return INSTANCIA;
    }

    public void inicializar(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);
    }

    public boolean terminoPartida(){
        return !(jugador1.estaEnJuego() && jugador2.estaEnJuego());
    }

    public Jugador ganadorPartida() {
        if (terminoPartida()) return jugador1.estaEnJuego() ? jugador1 : jugador2;
        return null;
    }
}
