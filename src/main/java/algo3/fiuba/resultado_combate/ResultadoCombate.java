package algo3.fiuba.resultado_combate;

import algo3.fiuba.cartas.Monstruo;

public interface ResultadoCombate {

    void afectarDefensor(Monstruo defensor);

    void afectarAtacante(Monstruo atacante);
}