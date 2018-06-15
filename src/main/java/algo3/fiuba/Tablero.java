package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.efectos.EfectoAgujeroNegro;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;

public class Tablero {

    private static Tablero INSTANCIA;

    private TableroJugador tableroJugador1;
    private TableroJugador tableroJugador2;

    public Tablero() {
        this.tableroJugador1 = new TableroJugador();
        this.tableroJugador2 = new TableroJugador();
    }

    public static Tablero getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new Tablero();

        return INSTANCIA;
    }

    public void empezarDuelo(Jugador jugador1, Jugador jugador2) {
        jugador1.setTableroJugador(tableroJugador1);
        jugador2.setTableroJugador(tableroJugador2);
    }

    public Integer monstruosEnJuego() {
        return (tableroJugador1.monstruosEnJuego() + tableroJugador2.monstruosEnJuego());
    }

    public void activarEfectoSobreElementos(EfectoCarta efecto) {
        tableroJugador1.activarEfectoSobreElementos(efecto);
        tableroJugador2.activarEfectoSobreElementos(efecto);
    }
}
