package christmas.promotion.byorder;

import christmas.order.menu.Menu;
import christmas.order.menu.Price;

public interface OrderGift {
    boolean check(Price price);

    Menu determineGift(Price price);
}
