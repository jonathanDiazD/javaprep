package com.enroutesystems.yugioh;

public class NativeTableroJuego {

    public native boolean booleanMethod(boolean bol);

    public static void main(String[] args) {
        System.loadLibrary("Sample1");
        NativeTableroJuego sample = new NativeTableroJuego();
        boolean bool = sample.booleanMethod(true);
        System.out.println("booleanMethod: " + bool);

    }
}
