package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.VistaCarta;
import algo3.fiuba.vista.vista_tablero.VistaCartaCampo;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBocaArribaEnJuego implements EventHandler<ActionEvent> {

    private VistaCarta vistaCarta;
    private Jugador jugador;
    private Carta carta;
    private VistaMano vistaMano;
    private VistaZonaMonstruos vistaZonaMonstruos;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private VistaCartaCampo vistaCartaCampo;
    private ControladorTurnos controladorTurnos;

    public ControladorBocaArribaEnJuego(VistaCarta vistaCarta, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo) {
        this.vistaCarta = vistaCarta;
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaCartaCampo = vistaCartaCampo;
        controladorTurnos = ControladorTurnos.getInstancia();
    }

    @Override
    public void handle(ActionEvent event) {
        carta.girarCarta();
        vistaCarta.cambiarVision();
        //Actualizar vistas, falta lo logica si es comehombres etc..
    }
}
