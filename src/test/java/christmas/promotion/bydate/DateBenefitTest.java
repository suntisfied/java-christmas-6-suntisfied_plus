package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.promotion.Discount;
import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class DateBenefitTest {
    @Test
    public void calculateTotalBenefitByDate() {
        DateBenefit dateBenefit = new DateBenefit();

        assertThat(dateBenefit.calculateTotalDateBenefit(new Date(10))).isEqualTo(new Discount(4923));
    }
}