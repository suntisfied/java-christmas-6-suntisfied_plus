package christmas.promotion.byorder;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.order.menu.Menu;
import christmas.view.input.Order;
import org.junit.jupiter.api.Test;

class FreeGiftTest {
    Order order = new Order("티본스테이크-2,양송이수프-1,아이스크림-1,레드와인-2");
    OrderBenefit orderBenefit = new OrderBenefit(new FreeGift(), new Badge());

    @Test
    public void checkEnoughOrderAmount() {
        assertThat(orderBenefit.check(order)).isTrue();
    }

    @Test
    public void determineFreeGiftByOrder() {
        assertThat(orderBenefit.determineGift(order).freeGifts().keySet()).containsExactly(Menu.CHAMPAGNE);
    }
}