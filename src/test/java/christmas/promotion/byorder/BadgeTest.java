package christmas.promotion.byorder;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Discount;
import org.junit.jupiter.api.Test;

class BadgeTest {
    OrderBenefit orderBenefit = new OrderBenefit(new FreeGift(), new Badge());

    @Test
    public void checkEnoughDiscount() {
        assertThat(orderBenefit.check(new Discount(5000))).isTrue();
    }

    @Test
    public void checkNotEnoughDiscount() {
        assertThat(orderBenefit.check(new Discount(4999))).isFalse();
    }

    @Test
    public void checkCorrectBadge() {
        assertThat(orderBenefit.determineBadge(new Discount(10000))).isEqualTo(Badges.TREE);
    }
}