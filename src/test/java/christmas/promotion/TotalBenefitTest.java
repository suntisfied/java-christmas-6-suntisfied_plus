package christmas.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.view.input.Date;
import christmas.view.input.Order;
import org.junit.jupiter.api.Test;

class TotalBenefitTest {
    Order order = new Order("티본스테이크-3,양송이수프-1,아이스크림-2,레드와인-2");

    @Test
    public void calculateTotalBenefit() {
        TotalBenefit totalBenefit = new TotalBenefit();

        assertThat(totalBenefit.calculateTotalBenefit(new Date(10), order))
                .isEqualTo(new Discount(31946));
    }
}