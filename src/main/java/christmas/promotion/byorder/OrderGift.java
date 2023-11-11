package christmas.promotion.byorder;

import christmas.order.menu.Price;
import christmas.order.menu.Drinks;

public interface OrderGift {
    boolean check(Price price);

    Drinks determineGift(Price price);
}
