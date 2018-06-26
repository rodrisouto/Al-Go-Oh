package algo3.fiuba.modelo;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.modelo.jugador.TurnoDelOponente;

public class Juego {

    private static Juego INSTANCIA;

    private Jugador jugador1;
    private Jugador jugador2;
    private Turno turno;

    private Juego() {
        turno = Turno.getInstancia();
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

        turno.addObserver(jugador1);
        turno.addObserver(jugador2);

        jugador1.setEstadoJugador(new PreInvocacion());
        jugador2.setEstadoJugador(new TurnoDelOponente());
    }

    public boolean terminoPartida(){
        return !(jugador1.estaEnJuego() && jugador2.estaEnJuego());
    }

    public Jugador ganadorPartida() {
        if (terminoPartida()) return jugador1.estaEnJuego() ? jugador1 : jugador2;
        return null;
    }
}