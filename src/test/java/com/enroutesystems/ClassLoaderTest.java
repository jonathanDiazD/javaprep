package com.enroutesystems;


import com.enroutesystems.yugioh.Duelista;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;


import java.util.ArrayList;


@Slf4j
public class ClassLoaderTest {

    @Test
    public void classLoaderBootstrap(){
        log.info("class loader{}",java.util.ArrayList.class.getClassLoader());
    }

    @Test
    public void classLoaderCurrent(){
        log.info("class loader{}",com.enroutesystems.yugioh.Carta.class.getClassLoader());
    }


    @Test
    public void classLoaderSpring(){
        log.info("class loader{}", SpringApplication.class.getClassLoader());
    }
}
