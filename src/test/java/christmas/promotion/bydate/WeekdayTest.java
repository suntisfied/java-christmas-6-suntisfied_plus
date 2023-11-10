package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Promotion;
import christmas.promotion.byorder.FreeGift;
import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class WeekdayTest {
    Promotion promotion = new Promotion(new Dday(), new FreeGift());

    @Test
    public void checkWeekday() {
        assertThat(promotion.checkDate(new Date(7))).isTrue();
    }

    @Test
    public void checkNonWeekday() {
        assertThat(promotion.checkDate(new Date(8))).isFalse();
    }
}