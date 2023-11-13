package christmas.promotion.byorder;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Discount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({"0, 없음", "5000, 스타",  "10000, 트리", "20000, 산타"})
    public void checkCorrectBadge(int discountAmount, String badgeName) {
        assertThat(orderBenefit.determineBadge(new Discount(discountAmount)).getName()).isEqualTo(badgeName);
    }
}