package com.enroutesystems.yugioh;


import java.util.Objects;

public class Carta {
    
    private long ataque;
    private long defensa;
    private String tipo;
    private byte imagen;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte getImagen() {
        return imagen;
    }

    public void setImagen(byte imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return ataque == carta.ataque && defensa == carta.defensa && tipo.equals(carta.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ataque, defensa, tipo);
    }
}
