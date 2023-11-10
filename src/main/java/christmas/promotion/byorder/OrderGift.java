package christmas.promotion.byorder;

import christmas.menu.Price;
import christmas.menu.MenuItems;

public interface OrderGift {
    boolean checkPrice(Price price);

    MenuItems determineGift(Price price);
}
