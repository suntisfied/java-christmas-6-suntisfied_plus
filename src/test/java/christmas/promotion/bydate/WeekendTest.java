package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;
import org.junit.jupiter.api.Test;

class WeekendTest {
    Order order = new Order("티본스테이크-2,양송이수프-1,아이스크림-1,레드와인-2");
    DateBenefit dateBenefit = new DateBenefit(new Weekend());

    @Test
    public void checkWeekend() {
        assertThat(dateBenefit.check(new Date(8), order)).isTrue();
    }

    @Test
    public void checkEnoughTotalOrderAmount() {
        order = new Order("타바스-1,제로콜라-1");

        assertThat(dateBenefit.check(new Date(8), order)).isFalse();
    }

    @Test
    public void checkNonWeekend() {
        assertThat(dateBenefit.check(new Date(7), order)).isFalse();
    }

    @Test
    public void calculateDiscountBasedOnMainDishOrder() {
        Order order = new Order("티본스테이크-2,양송이수프-1,아이스크림-3,레드와인-2");

        assertThat(dateBenefit.calculateDiscount(new Date(8), order)).isEqualTo(new Discount(4046));
    }
}