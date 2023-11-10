package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Promotion;
import christmas.promotion.byorder.FreeGift;
import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class SpecialTest {
    Promotion promotion = new Promotion(new Dday(), new FreeGift());

    @Test
    public void checkSpecialDay() {
        assertThat(promotion.checkDate(new Date(17))).isTrue();
    }

    @Test
    public void checkNonSpecialDay() {
        assertThat(promotion.checkDate(new Date(18))).isFalse();
    }
}