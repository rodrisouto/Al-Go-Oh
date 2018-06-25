package algo3.fiuba.cartas.modo_monstruo;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;
import algo3.fiuba.cartas.resultado_combate.GanaContraModoDeDefensa;
import algo3.fiuba.cartas.resultado_combate.PierdeContraModoDeDefensa;
import algo3.fiuba.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

public class ModoDeDefensa extends ModoMonstruo {

    @Override
    public ModoMonstruo cambiarModoMonstruo() {
        return new ModoDeAtaque();
    }

    @Override
    public ResultadoCombate atacar(Monstruo monstruoAtacante, Monstruo otraCarta, Integer puntosAtaque) {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("No puede atacar estando en Modo de Defensa.");
    }

    @Override
    public Integer puntosDefensivos(Integer ataqueDefensor, Integer defensaDefensor) {
        return defensaDefensor;
    }

    @Override
    public ResultadoCombate ganoAtacante(Integer diferenciaPuntos) {
        return new GanaContraModoDeDefensa();
    }

    @Override
    public ResultadoCombate perdioAtacante(Integer diferenciaPuntos) {
        return new PierdeContraModoDeDefensa(diferenciaPuntos);
    }

    @Override
    public ResultadoCombate empataron() {
        return new PierdeContraModoDeDefensa(0);
    }
}
