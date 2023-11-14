package christmas.promotion.byorder;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.view.input.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FreeGiftTest {
    @ParameterizedTest
    @CsvSource({
            "'티본스테이크-1,레드와인-2', 샴페인",
            "'타파스-1,제로콜라-1', 없음",
            "'티본스테이크-1,레드와인-1', 없음",
    })
    public void determineFreeGiftByOrder(String orderList, String freeGiftName) {
        Order order = new Order(orderList);
        OrderBenefit orderBenefit = new OrderBenefit(new FreeGift(), new Badge());

        FreeGifts freeGift = FreeGifts.NONE;
        if (freeGiftName.equals("샴페인")) {
            freeGift = FreeGifts.FREE_GIFT;
        }

        assertThat(orderBenefit.determineGift(order).keySet()).containsExactly(freeGift);
    }
}