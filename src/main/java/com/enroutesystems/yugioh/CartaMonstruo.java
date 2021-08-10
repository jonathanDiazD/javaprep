package com.enroutesystems.yugioh;


import java.util.HashSet;
import java.util.Set;

public class CartaMonstruo extends Carta implements EfectoEspecial {

    Set<CartaMagia> magias = new HashSet<>();

    public CartaMonstruo(String nombre,long ataque,long defensa) {
        super(nombre,ataque,defensa);
    }

    public void addMagia(CartaMagia cartaMagia){
        if(this.magias.add(cartaMagia)){
            this.setAtaque(this.getAtaque()+cartaMagia.getAtaque());
        }
    }

    @Override
    public void activarEfecto() {
        super.ataque = super.ataque+100l;
    }

    public void atacar(){


    }


}
