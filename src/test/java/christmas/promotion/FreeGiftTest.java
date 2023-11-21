package christmas.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.view.input.MenuOrder;
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
        MenuOrder menuOrder = new MenuOrder(orderList);
        FreeGift freeGift = new FreeGift();

        FreeGifts freeGifts = FreeGifts.NONE;
        if (freeGiftName.equals("샴페인")) {
            freeGifts = FreeGifts.FREE_GIFT;
        }

        assertThat(freeGift.determineGift(menuOrder).keySet()).containsExactly(freeGifts);
    }
}