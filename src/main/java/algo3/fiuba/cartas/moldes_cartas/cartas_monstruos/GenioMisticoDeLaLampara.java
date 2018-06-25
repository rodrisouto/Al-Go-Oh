package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class GenioMisticoDeLaLampara extends Monstruo {

    public GenioMisticoDeLaLampara(Jugador jugador) {

        super("Genio mistico de la lámpara", 1800, 1000, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
