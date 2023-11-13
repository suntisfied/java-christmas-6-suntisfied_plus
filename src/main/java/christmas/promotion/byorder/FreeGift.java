package christmas.promotion.byorder;

import static christmas.promotion.Defaults.MINIMUM_ORDER_FOR_FREE_GIFT;
import static christmas.promotion.Defaults.NUMBER_OF_FREE_GIFT;

import christmas.order.TotalOrder;
import christmas.order.Volume;
import christmas.order.menu.Menu;
import christmas.view.input.Order;
import java.util.HashMap;
import java.util.function.Predicate;

public class FreeGift implements OrderGift {

    @Override
    public boolean check(Order order) {
        boolean validity = false;
        if (isEnough.test(order) && isEnoughTotalOrder.test(order)) {
            validity = true;
        }
        return validity;
    }

    @Override
    public FreeGifts determineGift(Order order) {
        HashMap<Menu, Volume> freeGifts = new HashMap<>();
        if (check(order)) {
            int freeGiftAmount = determineFreeGiftAmount(order);
            freeGifts.put(Menu.CHAMPAGNE, new Volume(freeGiftAmount));
        }
        return new FreeGifts(freeGifts);
    }

    private int determineFreeGiftAmount(Order order) {
        TotalOrder totalOrder = new TotalOrder(order);

        int freeGiftAmount = 0;
        if (totalOrder.calculateTotalOrderCost().price() >= MINIMUM_ORDER_FOR_FREE_GIFT.getNumber()) {
            freeGiftAmount = NUMBER_OF_FREE_GIFT.getNumber();
        }
        return freeGiftAmount;
    }

    private final Predicate<Order> isEnough = order -> {
        TotalOrder totalOrder = new TotalOrder(order);
        return totalOrder.calculateTotalOrderCost().price() >= MINIMUM_ORDER_FOR_FREE_GIFT.getNumber();
    };
}
