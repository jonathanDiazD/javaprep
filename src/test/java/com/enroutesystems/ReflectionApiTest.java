package com.enroutesystems;

import com.enroutesystems.yugioh.CartaMonstruo;
import com.enroutesystems.yugioh.Duelista;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ReflectionApiTest {


    @Test
    public void reflectionTestClass() {
        Class<Duelista> duelistaClass = Duelista.class;
        log.info(duelistaClass.getName());
        int classModifier = duelistaClass.getModifiers();
        log.info(Modifier.isPublic(classModifier) + "");
        Method[] methods = duelistaClass.getDeclaredMethods();
        Arrays.stream(methods).filter(m -> m.getName().contains("set")).peek(m -> log.info(m.getName())).count();
    }


    @Test
    public void reflectionTestConstructor() {
        Class<CartaMonstruo> carta = CartaMonstruo.class;
        try {
            Constructor constructor = carta.getConstructor(new Class[]{String.class});
            CartaMonstruo magoOscuro = (CartaMonstruo) constructor.newInstance("Mago Oscuro");
            Arrays.stream(constructor.getParameters()).peek(m -> log.info(m.getName())).collect(Collectors.toList());
            log.info(magoOscuro.getNombre());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reflectionTestMethods() {
        Map<String, String> mapParameters = new HashMap<>();
        mapParameters.put("ataque", "2500");
        mapParameters.put("nombre", "Mago Oscuro");
        mapParameters.put("defensa", "2000");
        Class<CartaMonstruo> carta = CartaMonstruo.class;
        CartaMonstruo cartaMonstruo = null;
        try {
            cartaMonstruo = carta.newInstance();
            Method method = carta.getMethod("setNombre", String.class);
            method.invoke(cartaMonstruo, "Mago Oscuro");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        log.info(cartaMonstruo.getNombre());
    }

    @Test
    public void reflectionTestDynamicMethods() {
        Map<String, String> mapParameters = new HashMap<>();
        mapParameters.put("ataque", "2500");
        mapParameters.put("nombre", "Mago Oscuro");
        mapParameters.put("defensa", "2000");
        Class<CartaMonstruo> carta = CartaMonstruo.class;
        CartaMonstruo cartaMonstruo = null;
        try {
            cartaMonstruo = carta.newInstance();
            for (String key : mapParameters.keySet()) {
                String methodName = "set" + key.substring(0, 1).toUpperCase(Locale.ROOT) + key.substring(1);
                Field field = carta.getSuperclass().getDeclaredField(key);
                Method method = carta.getSuperclass().getMethod(methodName, field.getType());
                if (field.getType().equals(Long.class)) {
                    method.invoke(cartaMonstruo, Long.parseLong(mapParameters.get(key)));
                } else {
                    method.invoke(cartaMonstruo, mapParameters.get(key));
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        log.info("result:" + cartaMonstruo);
    }

}
