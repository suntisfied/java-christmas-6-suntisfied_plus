package christmas.promotion;

import static christmas.promotion.Defaults.MINIMUM_ORDER_FOR_PROMOTION;

import christmas.order.TotalOrder;
import christmas.view.input.Order;
import java.util.function.Predicate;

public interface Benefit {
    Predicate<Order> isEnoughTotalOrder = order -> {
        TotalOrder totalOrder = new TotalOrder(order);
        int totalOrderAmount = totalOrder.calculateTotalOrderCost().price();
        return totalOrderAmount >= MINIMUM_ORDER_FOR_PROMOTION.getNumber();
    };
}
