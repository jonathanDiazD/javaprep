package com.enroutesystems.yugioh;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;


@Data
@NoArgsConstructor
@ToString
@Slf4j
public abstract class Carta extends Thread implements Serializable ,Comparable<Carta> {

    private static final long serialVersionUID = -4888527811665559915L;
    protected  String nombre;
    protected transient Long ataque;
    protected transient Long defensa;
    protected transient byte imagen;
    protected transient int nivel;
    protected transient ModoPelea modo;
    protected transient char firstEdition;
    protected short precioDlls;
    protected AtomicLong ataqueAtomic;
    protected  boolean edicionPrimera;
    private Lock lock  = new ReentrantLock();

    public Long getAtaque() {
        synchronized (this) {
            return ataque;
        }
    }

    @Override
    public void run() {
      log.info("running Thread...");
    }


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

    public void incrementarAtaque(){
        synchronized (this) {
            ataque++;
        }
    }

    public void incrementarAtaqueLock(){
        try {
            lock.lock();
            ataque++;
        }finally {
            lock.unlock();
        }
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
