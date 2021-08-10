package com.enroutesystems.yugioh;

public class CartaMagia extends Carta{

    private String efecto;

    public CartaMagia(String nombre, long ataque, long defensa, String efecto) {
        super(nombre, ataque, defensa);
        this.efecto = efecto;
    }
}
