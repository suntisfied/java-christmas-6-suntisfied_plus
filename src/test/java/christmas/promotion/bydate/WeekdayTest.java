package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class WeekdayTest {
    DateBenefit dateBenefit = new DateBenefit(new Weekday());

    @Test
    public void checkWeekday() {
        assertThat(dateBenefit.checkDate(new Date(7))).isTrue();
    }

    @Test
    public void checkNonWeekday() {
        assertThat(dateBenefit.checkDate(new Date(8))).isFalse();
    }
}