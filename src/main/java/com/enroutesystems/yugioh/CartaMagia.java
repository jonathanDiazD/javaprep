package com.enroutesystems.yugioh;

import com.enroutesystems.yugioh.annotatios.Magia;
import com.enroutesystems.yugioh.annotatios.Rare;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Rare
@NoArgsConstructor
@ToString(callSuper = true)
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
