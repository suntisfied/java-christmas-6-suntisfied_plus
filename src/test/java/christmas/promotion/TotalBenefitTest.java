package christmas.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.order.Price;
import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class TotalBenefitTest {
    @Test
    public void calculateTotalBenefit() {
        TotalBenefit totalBenefit = new TotalBenefit();

        assertThat(totalBenefit.calculateTotalBenefit(new Date(10), new Price(120000)))
                .isEqualTo(new Discount(29923));
    }
}