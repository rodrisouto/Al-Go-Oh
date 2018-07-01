package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class DragonMilenario extends Monstruo {

    public DragonMilenario(Jugador jugador) {
        super("Dragon Milenario", 2400, 2000, 7, new EfectoNulo());
        setJugador(jugador);
    }
}
