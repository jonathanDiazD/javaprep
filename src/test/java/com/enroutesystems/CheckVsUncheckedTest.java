package com.enroutesystems;

import com.enroutesystems.yugioh.DataSourceInitialization;
import com.enroutesystems.yugioh.Duelista;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

@SpringBootTest
@Slf4j
public class CheckVsUncheckedTest {

    @Test
    public void uncheckedException(){
        Duelista duelista = new Duelista("Yugi",8000,new LinkedList<>());
        try {
            duelista.sacarCarta();
        }catch (NoSuchElementException e){
            log.info("Unchecked",e);
        }
    }


    @Test
    public void checkedException(){
        Duelista duelista = new Duelista("Yugi",-1,new LinkedList<>());
        try {
            if(duelista.getLifePoints()<0){
                throw new Exception("Duelista ha perdido todos sus puntos de vida.");
            }
        } catch (Exception e) {
            log.info("Checked",e);
        }
    }

}
