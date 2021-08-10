package com.enroutesystems.yugioh;

import java.util.*;

public class Duelista {

    private String nombre;
    private double lifePoints;
    private LinkedList<Carta> deck= new LinkedList<>();
    private List<Carta> mano = new ArrayList<>(5);
    private boolean turnoActual;

    public Duelista(String nombre, double lifePoints, LinkedList<Carta> deck) {
        this.nombre = nombre;
        this.lifePoints = lifePoints;
        this.deck = deck;
    }

    public Carta convocar(Carta carta) throws Exception{
        if(carta instanceof CartaMonstruo) {
            carta.setModo(ModoPelea.Ataque);
            mano.remove(carta);
        }
        else if(carta instanceof CartaMagia){
            carta.setModo(ModoPelea.BocaAbajo);
        }
        return carta;
    }

    public Long sumarizarPoderAtk(){
        Long ataque =0L;
        if(this.deck!=null&&!this.deck.isEmpty()){
            for(Carta carta:this.deck){
                if(carta instanceof CartaMagia){
                    continue;
                }
                switch (carta.nivel) {
                    case  4:
                        ataque+= carta.ataque;
                        break;

                    default:
                        ataque+=carta.ataque;
                        break;
                }
            }
        }
        Iterator<Carta> itCarta = this.mano.listIterator();

        do{
            Carta carta = itCarta.next();
           if(carta instanceof CartaMagia){
               continue;
           }
            ataque+=carta.ataque;
        }while(itCarta.hasNext());

        return ataque;
    }

    public void sacarCarta(){
        Carta carta = deck.removeFirst();
        this.mano.add(carta);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(double lifePoints) {
        this.lifePoints = lifePoints;
    }

    public LinkedList<Carta> getDeck() {
        return deck;
    }

    public void setDeck(LinkedList<Carta> deck) {
        this.deck = deck;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public void setMano(List<Carta> mano) {
        this.mano = mano;
    }

    public boolean isTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(boolean turnoActual) {
        this.turnoActual = turnoActual;
    }
}
