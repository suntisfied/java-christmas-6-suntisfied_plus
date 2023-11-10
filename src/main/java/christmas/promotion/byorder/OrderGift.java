package christmas.promotion.byorder;

import christmas.menu.Price;
import christmas.menu.MenuItems;

public interface OrderGift {
    boolean check(Price price);

    MenuItems calculateDiscount(Price price);
}
