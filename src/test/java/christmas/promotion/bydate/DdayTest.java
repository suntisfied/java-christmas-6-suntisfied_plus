package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Discount;
import christmas.promotion.Promotion;
import christmas.promotion.byorder.FreeGift;
import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class DdayTest {
    Promotion promotion = new Promotion(new Dday(), new FreeGift());

    @Test
    public void checkWithinDday() {
        assertThat(promotion.check(new Date(7))).isTrue();
    }

    @Test
    public void checkBeyondDday() {
        assertThat(promotion.check(new Date(26))).isFalse();
    }

    @Test
    public void calculateDdayDiscount() {
        assertThat(promotion.calculateDiscount(new Date(25))).isEqualTo(new Discount(3400));
    }
}