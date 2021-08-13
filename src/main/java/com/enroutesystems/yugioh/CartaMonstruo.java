package com.enroutesystems.yugioh;


import com.enroutesystems.yugioh.annotatios.UltraRare;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@UltraRare
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class CartaMonstruo extends Carta implements EfectoEspecial {


    Set<CartaMagia> magias = new HashSet<>();


    public CartaMonstruo(String nombre,long ataque,long defensa) {
        super(nombre,ataque,defensa);
    }

    public CartaMonstruo(String nombre, AtomicLong ataque, long defensa) {
        super(nombre,ataque,defensa);
    }

    public CartaMonstruo(String nombre) {
        super(nombre);
    }

    public CartaMonstruo(String nombre, AtomicLong ataque, long defensa, boolean edicion) {
        super(nombre,ataque,defensa,edicion);
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


}
