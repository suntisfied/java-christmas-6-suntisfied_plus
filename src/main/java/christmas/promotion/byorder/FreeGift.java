package christmas.promotion.byorder;

import christmas.menu.Price;
import christmas.menu.MenuItems;
import java.util.function.Predicate;

public class FreeGift implements OrderGift {

    @Override
    public boolean checkPrice(Price price) {
        return isEnough.test(price);
    }

    @Override
    public MenuItems determineGift(Price price) {
        return MenuItems.CHAMPAGNE;
    }

    Predicate<Price> isEnough = price -> price.price() >= 120000;
}
