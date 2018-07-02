package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.moldes_cartas.CartaCampoNula;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.VistaCarta;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class VistaCartaCampo extends Label {

    private Carta carta;
    private double ANCHO_MAXIMO_CARTA = 95.0;
    private double ALTURA_MAXIMA_CARTA = 110.0;
    private Jugador jugador;
    ImageView cartaCampoFondo = new ImageView(new Image("/algo3/fiuba/resources/img/campo-atr.jpg",
            ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));

    private CartaVistaUtils cartaVistaUtils;

    public VistaCartaCampo(Jugador jugador) {
        this.jugador = jugador;
        this.carta = jugador.getCartaCampoActiva();
        cartaVistaUtils = new CartaVistaUtils();
    }

    public void dibujar() {
        Carta cartaCampoActiva = jugador.getCartaCampoActiva();
        if(!(cartaCampoActiva instanceof CartaCampoNula)) {
            String nombre = jugador.getCartaCampoActiva().getNombre();
            VistaCarta vistaCarta = new VistaCarta(cartaVistaUtils.getImagenDeCarta(nombre), jugador, carta);
            this.setGraphic(vistaCarta);
        } else {
            this.setGraphic(cartaCampoFondo);
        }
    }
}
