package com.enroutesystems.yugioh;

import java.util.ArrayList;
import java.util.List;

public final class TableroJuego {

    public static final String nombreJuego = "Yu-Gi-Oh!";



    private Duelista primerDuelista;

    private Duelista segundoDuelista;

    private List<Carta> cartasPrimerDuelista = new ArrayList<>(10);

    private List<Carta> cartasSegundoDuelista = new ArrayList<>(10);

    private List<Carta> cementerio = new ArrayList<>(10);

    private volatile float tiempoDuelo;


    public synchronized void  enviarCementerio(Carta carta){
        try{
            Thread.sleep(1000);
            cementerio.add(carta);
        }catch(Exception e){

        }
    }


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

    public List<Carta> getCementerio() {
        return cementerio;
    }

    public void setCementerio(List<Carta> cementerio) {
        this.cementerio = cementerio;
    }

    public float getTiempoDuelo() {
        return tiempoDuelo;
    }

    public void setTiempoDuelo(float tiempoDuelo) {
        this.tiempoDuelo = tiempoDuelo;
    }
}
