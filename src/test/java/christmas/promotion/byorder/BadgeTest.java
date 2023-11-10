package christmas.promotion.byorder;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Discount;
import christmas.promotion.Promotion;
import christmas.promotion.bydate.Dday;
import org.junit.jupiter.api.Test;

class BadgeTest {
    Promotion promotion = new Promotion(new Dday(), new FreeGift(), new Badge());

    @Test
    public void checkEnoughDiscount() {
        assertThat(promotion.checkDiscount(new Discount(5000))).isTrue();
    }

    @Test
    public void checkNotEnoughDiscount() {
        assertThat(promotion.checkDiscount(new Discount(4999))).isFalse();
    }
}