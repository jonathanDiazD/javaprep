package com.enroutesystems;

import com.enroutesystems.yugioh.Carta;
import com.enroutesystems.yugioh.CartaMonstruo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.*;
import java.util.spi.LocaleServiceProvider;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class FunctionalProgrammingTest {

    @Test
    public void fibonacciSupplier() {
        int[] fibs = {0, 1};
        Stream<Integer> fibonacci = Stream.generate(() -> {
            int temp = fibs[0]+fibs[1];
            fibs[0]=fibs[1];
            fibs[1] = temp;
            return  temp;
        });
        fibonacci.peek(number -> log.info(number.toString())).limit(50).count();
    }

    @Test
    public void operatorString() {
        List<String> names = Arrays.asList("Bob","Ricardo","Jose");
        UnaryOperator<String> unaryOperator = s -> s.toUpperCase();
        names.replaceAll(unaryOperator);
        log.info("{}",names);
    }

    @Test
    public void predicateConsumerTest() {
        List<Person> people = new ArrayList<>();
        Predicate<Person> personPredicate = p -> p.gender.equals(Gender.MALE);
        Consumer<Person> personConsumer = p -> log.info(p.getName());
        people.stream().filter(personPredicate).collect(Collectors.toList()).forEach(personConsumer);
    }

    @Test
    public void functionTest() {
        Function<Integer,Integer> incrementByFunction = number->number+1;
        Function<Integer,Integer> multiplyByTen = number->number*10;
        int result = incrementByFunction.andThen(multiplyByTen).apply(2);
        log.info("{}",result);
    }

    @Test
    public void functionandThenTest() {
        Function<Integer,Integer> incrementByFunction = number->number+1;
        Function<Integer,Integer> multiplyByTen = number->number*10;
        Function<Integer, Integer> integerIntegerFunction = incrementByFunction.andThen(multiplyByTen);
        int result = integerIntegerFunction.apply(1);
        log.info("{}",result);
    }

    @Test
    public void functionBi() {
        BiFunction<Integer,Integer,Integer> incrementAndMultiply = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return (integer+1)*integer2;
            }
        };
        int result = incrementAndMultiply.apply(1,5);
        log.info("{}",result);
    }

    @Test
    public void functionBiLambda() {
        BiFunction<Integer,Integer,Integer> incrementAndMultiply = (integer, integer2) -> (integer+1)*integer2;
        int result = incrementAndMultiply.apply(4,100);
        log.info("{}",result);
    }


    @Test
    public void consumerLambda() {
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        Consumer<Carta> consumer = new Consumer<Carta>() {
            @Override
            public void accept(Carta s) {
                s.setAtaque(3400l);
            }
        };

        consumer.accept(magoOscuro);
        log.info("{}",magoOscuro.getAtaque());
    }

    @Test
    public void consumerBiLambda() {
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        BiConsumer<Carta,Boolean> consumer = new BiConsumer<Carta, Boolean>() {
            @Override
            public void accept(Carta carta, Boolean aBoolean) {
               if(aBoolean)
                carta.setAtaque(3400l);
            }
        };
        consumer.accept(magoOscuro,false);
        log.info("{}",magoOscuro.getAtaque());
    }

    @Test
    public void predicate() {
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        Predicate<Carta> predicate = carta -> carta.getAtaque()>2000;
        Predicate<Carta> predicate2 = carta -> carta.getAtaque()>2500;
        Predicate<Carta> cartaPredicate = predicate.or(predicate2);
        log.info("{}",cartaPredicate.test(magoOscuro));
    }


    @Test
    public void supplier() {
        Supplier<Carta> supplier = (Supplier<Carta>) () -> new CartaMonstruo("Mago Oscuro", 2500, 2000);
        Carta magoOscuro = supplier.get();
        log.info("{}",magoOscuro);

        String example = "example";
        String example2 = "example2";

    }

    class Person{
        private final String name;
        private final Gender gender;
        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
        public String getName() {
            return name;
        }
        public Gender getGender() {
            return gender;
        }
    }

    enum Gender{
        MALE,
        FEMALE;
    }


}
