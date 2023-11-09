package christmas.promotion.byorder;

import christmas.menu.Price;
import christmas.promotion.Discount;
import java.util.function.Predicate;

public class FreeGift implements OrderDiscount {

    @Override
    public boolean check(Price price) {
        return isEnough.test(price);
    }

    @Override
    public Discount calculateDiscount(Price price) {
        return null;
    }

    Predicate<Price> isEnough = price -> price.price() >= 120000;
}