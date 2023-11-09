package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Promotion;
import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class SpecialTest {
    Promotion promotion = new Promotion(new Special());

    @Test
    public void checkSpecialDay() {
        assertThat(promotion.check(new Date(17))).isTrue();
    }

    @Test
    public void checkNonSpecialDay() {
        assertThat(promotion.check(new Date(18))).isFalse();
    }
}