package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class IncursorDelHacha extends Monstruo {

    public IncursorDelHacha(Jugador jugador) {

        super("Incursor del hacha", 1700, 1150, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
