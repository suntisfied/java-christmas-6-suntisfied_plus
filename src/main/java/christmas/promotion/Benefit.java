package christmas.promotion;

import static christmas.promotion.Defaults.MINIMUM_ORDER_FOR_PROMOTION;

import christmas.order.menu.Price;
import java.util.function.Predicate;

public interface Benefit {
    Predicate<Price> isEnoughTotalOrder = orderAmount ->
            orderAmount.price() >= MINIMUM_ORDER_FOR_PROMOTION.getNumber();
}
