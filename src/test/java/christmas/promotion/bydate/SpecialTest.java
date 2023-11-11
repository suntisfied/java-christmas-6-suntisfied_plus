package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class SpecialTest {
    DateBenefit dateBenefit = new DateBenefit(new Special());

    @Test
    public void checkSpecialDay() {
        assertThat(dateBenefit.checkDate(new Date(17))).isTrue();
    }

    @Test
    public void checkNonSpecialDay() {
        assertThat(dateBenefit.checkDate(new Date(18))).isFalse();
    }
}