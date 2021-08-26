package com.enroutesystems;

import com.enroutesystems.yugioh.Carta;
import com.enroutesystems.yugioh.CartaMonstruo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.*;


@Slf4j
public class ObjectOutInTest {

    @Test
    public void objectInputOutStream() {
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        //serialize("Duelo",magoOscuro);
        deserialize("Duelo");
    }

    @Test
    public void serialize(String fileName, Carta carta) {
        File file = new File(fileName);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(carta);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void deserialize(String fileName) {
        File file = new File(fileName);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Carta magoRead = (Carta) objectInputStream.readObject();
            log.info("{}", magoRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
