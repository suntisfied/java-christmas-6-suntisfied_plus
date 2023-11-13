package christmas.promotion.byorder;

import christmas.promotion.Benefit;
import christmas.view.input.Order;

public interface OrderGift extends Benefit {
    boolean check(Order order);

    FreeGifts determineGift(Order order);
}
