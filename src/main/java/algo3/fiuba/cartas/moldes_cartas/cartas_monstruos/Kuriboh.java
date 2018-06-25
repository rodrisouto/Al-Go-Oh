package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class Kuriboh extends Monstruo {

    public Kuriboh(Jugador jugador) {
        super("Kuriboh", 300, 200, 1, new EfectoNulo());
        setJugador(jugador);
    }
}
