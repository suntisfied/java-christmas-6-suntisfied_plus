package christmas.promotion.byorder;

import christmas.order.TotalOrder;
import christmas.order.menu.Menu;
import christmas.view.input.Order;
import java.util.function.Predicate;

public class FreeGift implements OrderGift {

    @Override
    public boolean check(Order order) {
        return isEnough.test(order);
    }

    @Override
    public Menu determineGift(Order order) {
        Menu freeGift = null;
        if (check(order)) {
            freeGift = Menu.CHAMPAGNE;
        }
        return freeGift;
    }

    Predicate<Order> isEnough = order -> {
        TotalOrder totalOrder = new TotalOrder(order);
        return totalOrder.calculateTotalOrderCost().price() >= 120000;
    };
}
