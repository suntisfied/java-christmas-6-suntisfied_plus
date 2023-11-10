package christmas.promotion.byorder;

import christmas.menu.Price;
import christmas.menu.menuitem.Drinks;
import java.util.function.Predicate;

public class FreeGift implements OrderGift {

    @Override
    public boolean checkPrice(Price price) {
        return isEnough.test(price);
    }

    @Override
    public Drinks determineGift(Price price) {
        return Drinks.CHAMPAGNE;
    }

    Predicate<Price> isEnough = price -> price.price() >= 120000;
}
