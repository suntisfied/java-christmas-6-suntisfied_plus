package christmas.promotion.byorder;

import christmas.menu.Price;
import christmas.promotion.Discount;

public interface OrderDiscount {
    boolean check(Price price);

    Discount calculateDiscount(Price price);
}
