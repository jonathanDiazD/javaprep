package com.enroutesystems.yugioh;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;


@Data
@NoArgsConstructor
@ToString
public abstract class Carta implements Serializable ,Comparable<Carta>{

    protected String nombre;
    protected Long ataque;
    protected Long defensa;
    protected byte imagen;
    protected int nivel;
    protected transient ModoPelea modo;
    protected char firstEdition;
    protected short precioDlls;
    protected AtomicLong ataqueAtomic;
    protected  boolean edicionPrimera;


    public Carta(String nombre, long ataque, long defensa) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
    }
    public Carta(String nombre, AtomicLong ataque, long defensa) {
        this.nombre = nombre;
        this.ataqueAtomic = ataque;
        this.defensa = defensa;
    }

    public Carta(String nombre, AtomicLong ataque, long defensa,boolean edicion) {
        this.nombre = nombre;
        this.ataqueAtomic = ataque;
        this.defensa = defensa;
        this.setEdicionPrimera(edicion);
    }

    public Carta(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public int compareTo(Carta o) {
        return this.ataque.compareTo(o.getAtaque());
    }


    public  void incrementarAtaqueAtomic(){
        ataqueAtomic.getAndIncrement();
    }
    public synchronized void incrementarAtaque(){
        ataque++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return nombre.equals(carta.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}
