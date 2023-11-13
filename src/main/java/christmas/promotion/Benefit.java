package christmas.promotion;

import static christmas.promotion.Defaults.MINIMUM_ORDER_FOR_PROMOTION;

import christmas.order.TotalOrder;
import christmas.order.converter.Converter;
import christmas.view.input.Order;
import java.util.function.Predicate;

public interface Benefit {
    Predicate<Order> isEnoughTotalOrder = order -> {
        TotalOrder totalOrder = new Converter().createTotalOrder(order);
        int totalOrderAmount = totalOrder.calculateTotalCost().price();
        return totalOrderAmount >= MINIMUM_ORDER_FOR_PROMOTION.getNumber();
    };
}
