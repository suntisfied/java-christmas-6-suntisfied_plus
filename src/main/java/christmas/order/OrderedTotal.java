package christmas.order;

import christmas.order.converter.Converter;
import christmas.order.menu.Menu;
import christmas.order.menu.Price;
import christmas.view.input.Order;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class OrderedTotal {
    private final OrderedMenuTotal orderedMenuTotal;

    public OrderedTotal(Order order) {
        this.orderedMenuTotal = new Converter().createOrderedMenuTotal(order);
        validate(order);
    }

    private void validate(Order order) {
        if (!isWithinOrderLimit.test(order)) {
            throw new IllegalArgumentException();
        }
    }

    private final Predicate<Order> isWithinOrderLimit = order -> {
        VolumeCalculator volumeCalculator = new VolumeCalculator();
        return volumeCalculator.calculateTotalOrderVolume(order).volume() <= 20;
    };

    public OrderedMenus produceOrderedMenu() {
        return new OrderedMenus(orderedMenuTotal.orderedMenuTotal().keySet().stream().toList());
    }

    public Price calculateTotalOrderCost() {
        HashMap<Menu, OrderVolume> rawOrderedMenuTotal = orderedMenuTotal.orderedMenuTotal();
        List<Menu> rawOrderedMenus = produceOrderedMenu().orderedMenus();

        int totalSum = 0;
        for (Menu currentOrderedMenu : rawOrderedMenus) {
            int currentMenuPrice = currentOrderedMenu.getPrice().price();
            int currentMenuAmount = rawOrderedMenuTotal.get(currentOrderedMenu).volume();

            totalSum += currentMenuPrice * currentMenuAmount;
        }

        return new Price(totalSum);
    }
}
