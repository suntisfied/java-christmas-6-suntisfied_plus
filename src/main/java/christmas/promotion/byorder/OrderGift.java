package christmas.promotion.byorder;

import christmas.view.input.Order;

public interface OrderGift {
    boolean check(Order order);

    FreeGifts determineGift(Order order);
}
