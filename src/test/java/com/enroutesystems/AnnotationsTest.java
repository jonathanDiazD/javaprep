package com.enroutesystems;


import com.enroutesystems.yugioh.CartaMagia;
import com.enroutesystems.yugioh.CartaMonstruo;
import com.enroutesystems.yugioh.annotatios.Magia;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;



@Slf4j
public class AnnotationsTest {


    @Test
    public void customAnnotationUltraRare() {
        CartaMonstruo magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        log.info("precio:" + magoOscuro.consultarPrecio());
    }

    @Test
    public void customAnnotationRare() {
        CartaMagia monstruoRenacido = new CartaMagia("","Permite renacer un monstruo del cementerio");
        assertThat(new Predicate<CartaMagia>() {
            @Override
            public boolean test(CartaMagia o) {
                return o.consultarPrecio()>1500;
            }
        });
    }


    @Test
    public void customAnnotationMagia(){
        Class<CartaMagia> cartaMagia = CartaMagia.class;
        for(Method method :cartaMagia.getMethods()){
            if (method.isAnnotationPresent(Magia.class)){
                Magia magia =  method.getAnnotation(Magia.class);
                try {
                    log.info("Executing method:"+method.getName());
                    String result = (String) method.invoke(cartaMagia.newInstance());
                    log.info("Carta:" + result);
                }catch(Exception e){
                    log.info("Error executing method:"+method.getName());
                }
            }
        }
    }
}
