package com.enroutesystems;


import com.enroutesystems.yugioh.Duelista;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.function.Function;

@Slf4j
public class CombinatorPatternTest {

    @Test
    public void supplier() {
        Duelista kaiba = new Duelista("Kaiba", 0, null);

        DuelistaValidator duelistaValidator = new DuelistaValidator() {
            @Override
            public ValidationResult apply(Duelista duelista) {
                return null;
            }
        };

        ValidationResult validationResult = DuelistaValidator.isAttackValid()
                .combine(DuelistaValidator.isNombreCorrect()).apply(kaiba);

        log.info(validationResult.toString());
    }

    interface DuelistaValidator extends Function<Duelista, ValidationResult> {


        static DuelistaValidator isAttackValid() {
            return new DuelistaValidator() {
                @Override
                public ValidationResult apply(Duelista duelista) {
                    return duelista.getLifePoints() > 0d ? ValidationResult.SUCESS : ValidationResult.LIFE_POINTS_NO_VALID;
                }
            };
        }

        static DuelistaValidator isNombreCorrect() {
            return new DuelistaValidator() {
                @Override
                public ValidationResult apply(Duelista duelista) {
                    return !StringUtils.isEmpty(duelista.getNombre()) ? ValidationResult.SUCESS : ValidationResult.NAME_NOT_VALID;
                }
            };
        }

        default DuelistaValidator combine(DuelistaValidator other) {
            return customer -> {
                ValidationResult result = this.apply(customer);
                return result.equals(ValidationResult.SUCESS) ? other.apply(customer) : result;
            };
        }
    }

    enum ValidationResult {
        SUCESS,
        LIFE_POINTS_NO_VALID,
        NAME_NOT_VALID
    }
}
