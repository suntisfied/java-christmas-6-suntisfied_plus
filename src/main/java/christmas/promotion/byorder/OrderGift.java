package christmas.promotion.byorder;

import christmas.order.Price;
import christmas.order.menu.Drinks;

public interface OrderGift {
    boolean checkPrice(Price price);

    Drinks determineGift(Price price);
}
