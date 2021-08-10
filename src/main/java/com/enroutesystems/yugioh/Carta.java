package com.enroutesystems.yugioh;


import java.io.Serializable;
import java.util.Objects;

public abstract class Carta implements Serializable ,Comparable<Carta>{

    protected String nombre;
    protected Long ataque;
    protected Long defensa;
    protected byte imagen;
    protected int nivel;
    protected transient ModoPelea modo;
    protected char firstEdition;
    protected short precioDlls;

    public Carta(String nombre, long ataque, long defensa) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public Carta() {
    }

    @Override
    public int compareTo(Carta o) {
        return this.ataque.compareTo(o.getAtaque());
    }


    public long getAtaque() {
        return ataque;
    }

    public void setAtaque(long ataque) {
        this.ataque = ataque;
    }

    public long getDefensa() {
        return defensa;
    }

    public void setDefensa(long defensa) {
        this.defensa = defensa;
    }

    public byte getImagen() {
        return imagen;
    }

    public void setImagen(byte imagen) {
        this.imagen = imagen;
    }

    public ModoPelea getModo() {
        return modo;
    }

    public void setModo(ModoPelea modo) {
        this.modo = modo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public char getFirstEdition() {
        return firstEdition;
    }

    public void setFirstEdition(char firstEdition) {
        this.firstEdition = firstEdition;
    }

    public short getPrecioDlls() {
        return precioDlls;
    }

    public void setPrecioDlls(short precioDlls) {
        this.precioDlls = precioDlls;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}