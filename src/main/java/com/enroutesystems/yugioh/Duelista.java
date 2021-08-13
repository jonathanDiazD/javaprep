package com.enroutesystems.yugioh;

import lombok.Data;
import lombok.ToString;

import java.util.*;


@Data
@ToString
public class Duelista {

    private String nombre;
    private double lifePoints;
    private LinkedList<Carta> deck= new LinkedList<>();
    private List<Carta> mano = new ArrayList<>(5);
    private boolean turnoActual;
    private TableroJuego tablero;

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

    public Carta sacarCarta(){
        Carta carta = deck.removeFirst();
        this.mano.add(carta);
        return carta;
    }
}
