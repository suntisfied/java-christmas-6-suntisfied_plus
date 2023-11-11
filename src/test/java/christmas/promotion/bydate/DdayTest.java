package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Discount;
import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class DdayTest {
    DateBenefit dateBenefit = new DateBenefit(new Dday());

    @Test
    public void checkWithinDday() {
        assertThat(dateBenefit.checkDate(new Date(7))).isTrue();
    }

    @Test
    public void checkBeyondDday() {
        assertThat(dateBenefit.checkDate(new Date(26))).isFalse();
    }

    @Test
    public void calculateDdayDiscount() {
        assertThat(dateBenefit.calculateDiscount(new Date(25))).isEqualTo(new Discount(3400));
    }
}