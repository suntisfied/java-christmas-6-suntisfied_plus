package christmas.promotion;

import static christmas.promotion.Defaults.MINIMUM_ORDER_FOR_FREE_GIFT;
import static christmas.promotion.Defaults.NUMBER_OF_FREE_GIFT;

import christmas.order.TotalOrder;
import christmas.order.Volume;
import christmas.converter.Converter;
import christmas.view.input.MenuOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class FreeGift extends Benefit {
    public Map<FreeGifts, Volume> determineGift(MenuOrder menuOrder) {
        Map<FreeGifts, Volume> freeGiftWithVolume = new HashMap<>();
        freeGiftWithVolume.put(FreeGifts.NONE, new Volume(0));
        if (check(menuOrder)) {
            freeGiftWithVolume = new HashMap<>();
            freeGiftWithVolume.put(FreeGifts.FREE_GIFT, new Volume(NUMBER_OF_FREE_GIFT.getNumber()));
        }
        return freeGiftWithVolume;
    }

    protected boolean check(MenuOrder menuOrder) {
        return isEnough.test(menuOrder) && isEnoughTotalOrder.test(menuOrder);
    }

    private final Predicate<MenuOrder> isEnough = order -> {
        TotalOrder totalOrder = new Converter().convertToTotalOrder(order);
        return totalOrder.calculateTotalCost().amount() >= MINIMUM_ORDER_FOR_FREE_GIFT.getNumber();
    };
}
