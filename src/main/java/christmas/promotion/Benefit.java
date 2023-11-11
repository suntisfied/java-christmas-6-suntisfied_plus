package christmas.promotion;

import christmas.order.menu.Price;
import java.util.function.Predicate;

public interface Benefit {
    Predicate<Price> isEnoughTotalOrder = orderAmount -> orderAmount.price() >= 10000;
}
