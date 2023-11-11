package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class WeekendTest {
    DateBenefit dateBenefit = new DateBenefit(new Weekend());

    @Test
    public void checkWeekend() {
        assertThat(dateBenefit.check(new Date(8))).isTrue();
    }

    @Test
    public void checkNonWeekend() {
        assertThat(dateBenefit.check(new Date(7))).isFalse();
    }
}