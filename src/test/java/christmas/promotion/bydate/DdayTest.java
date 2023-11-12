package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;
import org.junit.jupiter.api.Test;

class DdayTest {
    Order order = new Order("티본스테이크-2,양송이수프-1,아이스크림-1,레드와인-2");
    DateBenefit dateBenefit = new DateBenefit(new Dday());

    @Test
    public void checkWithinDday() {
        assertThat(dateBenefit.check(new Date(7), order)).isTrue();
    }

    @Test
    public void checkEnoughTotalOrderAmount() {
        order = new Order("타파스-1,제로콜라-1");

        assertThat(dateBenefit.check(new Date(7), order)).isFalse();
    }

    @Test
    public void checkBeyondDday() {
        assertThat(dateBenefit.check(new Date(26), order)).isFalse();
    }

    @Test
    public void calculateDdayDiscount() {
        assertThat(dateBenefit.calculateDiscount(new Date(25), order)).isEqualTo(new Discount(3400));
    }
}