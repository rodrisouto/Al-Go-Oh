package algo3.fiuba.cartas.efectos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.modificadores.ModificadorSogenOponente;
import algo3.fiuba.cartas.modificadores.ModificadorSogenPropio;

public class EfectoSogen extends EfectoCarta{
    private Jugador oponente;
    private Jugador jugador;

    public EfectoSogen(Jugador jugador, Jugador oponente) {
        this.jugador = jugador;
        this.oponente = oponente;
    }

    @Override
    public void activar(Carta carta) {
        jugador.agregarModificador(new ModificadorSogenPropio());
        oponente.agregarModificador(new ModificadorSogenOponente());
    }
}
