package com.enroutesystems.yugioh;


import com.enroutesystems.yugioh.annotatios.UltraRare;


import java.util.HashSet;
import java.util.Set;

@UltraRare
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

    public int consultarPrecio(){
        Class c = this.getClass();
        UltraRare annotation =(UltraRare) c.getAnnotation(UltraRare.class);
        return annotation.precio();
    }

    @Override
    public void activarEfecto() {
        super.ataque = super.ataque+100l;
    }

    public void atacar(){


    }


}
