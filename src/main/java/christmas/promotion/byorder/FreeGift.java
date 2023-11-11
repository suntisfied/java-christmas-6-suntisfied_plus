package christmas.promotion.byorder;

import christmas.order.menu.Menu;
import christmas.order.menu.Price;
import java.util.function.Predicate;

public class FreeGift implements OrderGift {

    @Override
    public boolean check(Price price) {
        return isEnough.test(price);
    }

    @Override
    public Menu determineGift(Price price) {
        return Menu.CHAMPAGNE;
    }

    Predicate<Price> isEnough = price -> price.price() >= 120000;
}
