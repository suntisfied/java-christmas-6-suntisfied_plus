package christmas.promotion.byorder;

import christmas.menu.Price;
import christmas.menu.Drinks;

public interface OrderGift {
    boolean checkPrice(Price price);

    Drinks determineGift(Price price);
}
