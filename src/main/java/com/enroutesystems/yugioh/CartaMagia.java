package com.enroutesystems.yugioh;

import com.enroutesystems.yugioh.annotatios.Magia;
import com.enroutesystems.yugioh.annotatios.Rare;

@Rare
public class CartaMagia extends Carta{

    private String efecto;

    public CartaMagia(String nombre, long ataque, long defensa, String efecto) {
        super(nombre, ataque, defensa);
        this.efecto = efecto;
    }

    public CartaMagia(String nombre,String efecto) {
        super(nombre);
        this.efecto = efecto;
    }

    public CartaMagia() {
    }

    public int consultarPrecio(){
        Class c = this.getClass();
        Rare annotation =(Rare) c.getAnnotation(Rare.class);
        return annotation.precio();
    }

    @Magia
    public String efecto(){
        return "Efecto magico activado.";
    }



}
