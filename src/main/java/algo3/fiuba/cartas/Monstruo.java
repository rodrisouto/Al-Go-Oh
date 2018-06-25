package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estado_en_turno.NoUsadaEnTurno;
import algo3.fiuba.cartas.nivel.Nivel;
import algo3.fiuba.cartas.nivel.NivelFactoryFactory;
import algo3.fiuba.cartas.modificadores.Modificador;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;
import algo3.fiuba.cartas.modo_monstruo.ModoDeAtaque;
import algo3.fiuba.cartas.modo_monstruo.ModoDeDefensa;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.modo_monstruo.ModoMonstruo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombateNulo;
import algo3.fiuba.excepciones.SacrificiosIncorrectosExcepcion;
import algo3.fiuba.jugador.Jugador;

import java.util.HashSet;
import java.util.Set;

public class Monstruo extends Carta {

    private Integer ataqueBase;
    private Integer defensaBase;
    protected ModoMonstruo modoMonstruo;
    private Nivel nivel;
    private Set<Modificador> modificadores;

    public Monstruo(String nombre, Integer ataque, Integer defensa, Integer estrellas, EfectoCarta efecto) {

        super(nombre, efecto);
        this.ataqueBase = ataque;
        this.defensaBase = defensa;
        this.nivel = NivelFactoryFactory.obtenerEstrellas(estrellas);
        this.estadoEnTurno = new NoUsadaEnTurno(); // está solo para que pasen los tests
        this.modificadores = new HashSet<>();
        this.modoMonstruo = new ModoDeAtaque();
    }

    public void atacar(Monstruo otraCarta) {
        estadoCarta.verificarQuePuedeAtacar();
        estadoEnTurno = estadoEnTurno.verificarQueSePuedeUsar();
        ResultadoCombate resultadoCombate = modoMonstruo.atacar(this, otraCarta, this.getAtaque());
        resultadoCombate.afectarAtacante(this);
    }

    public ResultadoCombate recibirAtaque(Monstruo monstruoAtacante, Integer puntosAtaqueRival) {
        if (!jugador.recibirAtaque(monstruoAtacante, this)) {
            estadoCarta.recibirAtaque(this);
            ResultadoCombate resultadoCombate = modoMonstruo.recibirAtaque(puntosAtaqueRival, this.getAtaque(), this.getDefensa());
            resultadoCombate.afectarDefensor(this);
            return resultadoCombate;
        }
        return new ResultadoCombateNulo();

    }

    public void pasarAModoAtaque() {
        modoMonstruo = ModoDeAtaque.getInstancia();
    }

    public void pasarAModoDefensa() {
        modoMonstruo = ModoDeDefensa.getInstancia();
    }

    public void daniarJugador(Integer puntosDeDanio) {
        jugador.modificarPuntosDeVida(-puntosDeDanio);
    }

    public boolean estaEnCampo(Campo campo) {
        return campo.cartaEstaEnCampo(this);
    }

    @Override
    public void removerDelCampo(Campo campo) {
        campo.removerCarta(this);
    }

    @Override
    public void colocarEnCampo(Jugador jugador, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (!nivel.sacrificiosSuficientes(sacrificios))
            throw new SacrificiosIncorrectosExcepcion(String.format("Se necesitan estrictamente %d sacrificios para invocarlo.", nivel.sacrificiosRequeridos()));

        this.realizarSacrificios(sacrificios);
        modoMonstruo = ModoDeAtaque.getInstancia(); // !!! sacarg
        super.colocarEnCampo(jugador, tipoEnJuego, sacrificios);
        jugador.colocarCartaEnCampo(this, tipoEnJuego, sacrificios);
    }


    public void cambiarModo() {
        modoMonstruo = modoMonstruo.cambiarModoMonstruo();
    }

    protected void realizarSacrificios(Monstruo... sacrificios) {
        for (Monstruo sacrificio : sacrificios) {
            sacrificio.mandarDelCampoAlCementerio();
        }
    }

    public Integer getAtaque() {
        Integer ataqueModificado = ataqueBase;
        for (Modificador modificador : modificadores) {
            ataqueModificado = modificador.modificarAtaque(ataqueModificado);
        }

        return ataqueModificado > 0 ? ataqueModificado : 0;
    }

    public Integer getDefensa() {
        Integer defensaModificada = defensaBase;
        for (Modificador modificador : modificadores) {
            defensaModificada = modificador.modificarDefensa(defensaModificada);
        }

        return defensaModificada > 0 ? defensaModificada : 0;
    }

    public void agregarModificador(Modificador modificador) {
        modificadores.add(modificador);
    }

}
