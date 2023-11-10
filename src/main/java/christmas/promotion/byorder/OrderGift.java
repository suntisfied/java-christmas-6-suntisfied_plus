package christmas.promotion.byorder;

import christmas.menu.Price;
import christmas.menu.menuitem.Drinks;

public interface OrderGift {
    boolean checkPrice(Price price);

    Drinks determineGift(Price price);
}
