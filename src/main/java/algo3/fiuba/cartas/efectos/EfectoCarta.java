package algo3.fiuba.cartas.efectos;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;

public abstract class EfectoCarta {

    public void activar(Carta carta) {
        return;
    }

    public void activar(Carta carta, Monstruo otraCarta1, Monstruo otraCarta2) {
        return;
    }

    public void desactivar() {return;}
}
