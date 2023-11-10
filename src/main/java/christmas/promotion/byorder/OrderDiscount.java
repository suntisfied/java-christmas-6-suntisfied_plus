package christmas.promotion.byorder;

import christmas.menu.Price;
import christmas.menu.MenuItems;

public interface OrderDiscount {
    boolean check(Price price);

    MenuItems calculateDiscount(Price price);
}
