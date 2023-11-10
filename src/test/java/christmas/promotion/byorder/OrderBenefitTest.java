package christmas.promotion.byorder;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.order.menu.Price;
import christmas.promotion.Discount;
import org.junit.jupiter.api.Test;

class OrderBenefitTest {
    @Test
    public void calculateTotalBenefitByOrder() {
        OrderBenefit orderBenefit = new OrderBenefit();

        assertThat(orderBenefit.calculateTotalOrderBenefit(new Price(120000))).isEqualTo(new Discount(25000));
    }
}