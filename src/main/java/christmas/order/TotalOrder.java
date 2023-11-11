package christmas.order;

import christmas.order.converter.Converter;
import christmas.order.menu.Menu;
import christmas.order.menu.Price;
import christmas.view.input.Order;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class TotalOrder {
    private final OrderWithVolume orderWithVolume;

    public TotalOrder(Order order) {
        this.orderWithVolume = new Converter().createOrderedMenuTotal(order);
        validate(order);
    }

    private void validate(Order order) {
        if (!isWithinOrderLimit.test(order) || isOnlyDrinkOrder.test(order)) {
            throw new IllegalArgumentException();
        }
    }

    private final Predicate<Order> isWithinOrderLimit = order -> {
        VolumeCalculator volumeCalculator = new VolumeCalculator();
        return volumeCalculator.calculateTotalOrderVolume(order).volume() <= 20;
    };

    private final Predicate<Order> isOnlyDrinkOrder = order -> {
        VolumeCalculator volumeCalculator = new VolumeCalculator();
        OrderVolume totalVolume = volumeCalculator.calculateTotalOrderVolume(order);
        OrderVolume drinkVolume = volumeCalculator.calculateOrderVolumeByCategory(order, "drink");
        return totalVolume.equals(drinkVolume);
    };

    public OrderedMenus produceOrderedMenu() {
        return new OrderedMenus(orderWithVolume.orderedMenuTotal().keySet().stream().toList());
    }

    public Price calculateTotalOrderCost() {
        HashMap<Menu, OrderVolume> rawOrderedMenuTotal = orderWithVolume.orderedMenuTotal();
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
