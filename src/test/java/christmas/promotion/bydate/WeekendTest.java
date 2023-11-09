package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Promotion;
import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class WeekendTest {
    Promotion promotion = new Promotion(new Weekend());

    @Test
    public void checkWeekend() {
        assertThat(promotion.check(new Date(8))).isTrue();
    }

    @Test
    public void checkNonWeekend() {
        assertThat(promotion.check(new Date(7))).isFalse();
    }
}