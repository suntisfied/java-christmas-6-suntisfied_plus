package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.view.input.Date;
import christmas.view.input.Order;
import org.junit.jupiter.api.Test;

class SpecialTest {
    Order order = new Order("티본스테이크-2,양송이수프-1,아이스크림-1,레드와인-2");
    DateBenefit dateBenefit = new DateBenefit(new Special());

    @Test
    public void checkSpecialDay() {
        assertThat(dateBenefit.check(new Date(17), order)).isTrue();
    }

    @Test
    public void checkEnoughTotalOrderAmount() {
        order = new Order("타파스-1,제로콜라-1");

        assertThat(dateBenefit.check(new Date(17), order)).isFalse();
    }

    @Test
    public void checkNonSpecialDay() {
        assertThat(dateBenefit.check(new Date(18), order)).isFalse();
    }
}