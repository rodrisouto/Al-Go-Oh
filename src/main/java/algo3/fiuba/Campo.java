package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.NoMonstruo;

import java.util.LinkedList;
import java.util.List;

public class Campo {

    private List<Monstruo> zonaMonstruos;
    private List<NoMonstruo> zonaNoMonstruos;
    private CartaCampo cartaCampo;

    private static final Integer LIMITE_CARTAS_EN_ZONA = 5;

    public Campo() {
        zonaMonstruos = new LinkedList<>();
        zonaNoMonstruos = new LinkedList<>();
        cartaCampo = null;
    }

    public boolean estaVacio() {
        return (zonaMonstruos.isEmpty() && zonaNoMonstruos.isEmpty());
    }

    public Integer cantidadMonstruos() {
        return (zonaMonstruos.size());
    }

    public Integer cantidadNoMonstruos() {
        return (zonaNoMonstruos.size());
    }

    public void colocarCarta(Carta carta, EnJuego enJuego, Monstruo... sacrificios) {
        carta.colocarEnCampo(this, enJuego, sacrificios);
    }

    public void colocarCarta(Monstruo carta, EnJuego enJuego, Monstruo... sacrificios) {
        if (zonaMonstruos.size() >= LIMITE_CARTAS_EN_ZONA)
            throw new RuntimeException("No se puede tener más de 5 monstruos en el tablero.");


        carta.setEstado(enJuego);
        zonaMonstruos.add(carta);
    }

    public void colocarCarta(NoMonstruo carta, EnJuego enJuego, Monstruo... sacrificios) {
        if (zonaNoMonstruos.size() >= LIMITE_CARTAS_EN_ZONA)
            throw new RuntimeException("No se puede tener más de 5 no monstruos en el tablero.");


        carta.setEstado(enJuego);
        zonaNoMonstruos.add(carta);
    }

    public void colocarCarta(CartaCampo carta, EnJuego enJuego, Monstruo... sacrificios) {
        // Debería de verificar si ya había otra carta de campo.
        carta.setEstado(enJuego);
        cartaCampo = carta;
    }

    public boolean cartaEstaEnCampo(Carta carta) {
        return carta.estaEnTablero(this);
    }

    public boolean cartaEstaEnCampo(Monstruo carta) {
        return zonaMonstruos.contains(carta);
    }

    public boolean cartaEstaEnCampo(NoMonstruo carta) {
        return zonaNoMonstruos.contains(carta);
    }

    // Eh..... ?
    public boolean cartaEstaEnCampo(CartaCampo cartaCampo) {
        return this.cartaCampo == cartaCampo;
    }


    public void activarEfectoSobreElementos(EfectoCarta efecto) {
        // sin funcionalidad por el momento.
    }

    public void removerCarta(Monstruo carta) {
        zonaMonstruos.remove(carta);
    }

    public void removerCarta(NoMonstruo carta) {
        zonaNoMonstruos.remove(carta);
    }

    @Override
    public String toString() {
        return "Campo{" +
                "zonaMonstruos=" + zonaMonstruos +
                ", zonaNoMonstruos=" + zonaNoMonstruos +
                ", cartaCampo=" + cartaCampo +
                '}';
    }

    public void reiniciar() {
        zonaMonstruos = new LinkedList<>();
        zonaNoMonstruos = new LinkedList<>();
        cartaCampo = null;
    }

    public void matarMonstruos() {
        for(Monstruo monstruo: zonaMonstruos) {
           monstruo.descartar();
           zonaMonstruos.remove(monstruo);
        }
    }

    public List<Monstruo> getMonstruos() {
        return zonaMonstruos;
    }


    public List<NoMonstruo> getNoMonstruos() {
        return zonaNoMonstruos;
    }

    public void destruirCartaMenorAtaque(Jugador jugador) {
        if (zonaMonstruos.isEmpty())
            return;
        Monstruo monstruo = zonaMonstruos.stream().reduce(zonaMonstruos.get(0), (x, acc) -> {
            if (x.getAtaque() < acc.getAtaque())
                return x;
            return acc;
        });

        jugador.mandarCartaDelTableroAlCementerio(monstruo);
    }

    public CartaCampo getCartaCampo() {
        return cartaCampo;
    }

}
