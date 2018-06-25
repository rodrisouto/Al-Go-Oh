package algo3.fiuba.jugador;

import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.excepciones.JugadorInhabilitadoParaColocarCartasExcepcion;

public class TurnoDelOponente implements EstadoJugador {

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Monstruo carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        throw new JugadorInhabilitadoParaColocarCartasExcepcion("No puede colocar cartas en el turno del oponente.");
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, NoMonstruo carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        throw new JugadorInhabilitadoParaColocarCartasExcepcion("No puede colocar cartas en el turno del oponente.");
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, CartaCampo carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        throw new JugadorInhabilitadoParaColocarCartasExcepcion("No puede colocar cartas en el turno del oponente.");
    }

    @Override
    public EstadoJugador cambioDeTurno() {
        return new PreInvocacion();
    }
}