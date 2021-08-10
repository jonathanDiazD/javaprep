package com.enroutesystems.yugioh;

import java.util.ArrayList;
import java.util.List;

public final class TableroJuego {

    public static final String nombreJuego = "Yu-Gi-Oh!";

    private Duelista primerDuelista;

    private Duelista segundoDuelista;

    private List<Carta> cartasPrimerDuelista = new ArrayList<>(10);

    private List<Carta> cartasSegundoDuelista = new ArrayList<>(10);

    private List<Carta> cementerioPrimerDuelista = new ArrayList<>(10);

    private List<Carta> cementerioSegundoDuelista = new ArrayList<>(10);

    private float tiempoDuelo;

    public Duelista getPrimerDuelista() {
        return primerDuelista;
    }

    public void setPrimerDuelista(Duelista primerDuelista) {
        this.primerDuelista = primerDuelista;
    }

    public Duelista getSegundoDuelista() {
        return segundoDuelista;
    }

    public void setSegundoDuelista(Duelista segundoDuelista) {
        this.segundoDuelista = segundoDuelista;
    }

    public List<Carta> getCartasPrimerDuelista() {
        return cartasPrimerDuelista;
    }

    public void setCartasPrimerDuelista(List<Carta> cartasPrimerDuelista) {
        this.cartasPrimerDuelista = cartasPrimerDuelista;
    }

    public List<Carta> getCartasSegundoDuelista() {
        return cartasSegundoDuelista;
    }

    public void setCartasSegundoDuelista(List<Carta> cartasSegundoDuelista) {
        this.cartasSegundoDuelista = cartasSegundoDuelista;
    }

    public List<Carta> getCementerioPrimerDuelista() {
        return cementerioPrimerDuelista;
    }

    public void setCementerioPrimerDuelista(List<Carta> cementerioPrimerDuelista) {
        this.cementerioPrimerDuelista = cementerioPrimerDuelista;
    }

    public List<Carta> getCementerioSegundoDuelista() {
        return cementerioSegundoDuelista;
    }

    public void setCementerioSegundoDuelista(List<Carta> cementerioSegundoDuelista) {
        this.cementerioSegundoDuelista = cementerioSegundoDuelista;
    }

    public float getTiempoDuelo() {
        return tiempoDuelo;
    }

    public void setTiempoDuelo(float tiempoDuelo) {
        this.tiempoDuelo = tiempoDuelo;
    }
}
