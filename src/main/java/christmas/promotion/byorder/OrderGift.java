package christmas.promotion.byorder;

import christmas.order.Volume;
import christmas.promotion.Benefit;
import christmas.view.input.Order;
import java.util.Map;

public abstract class OrderGift extends Benefit {
    public abstract Map<FreeGifts, Volume> determineGift(Order order);

    protected abstract boolean check(Order order);
}
