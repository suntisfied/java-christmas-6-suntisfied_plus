package christmas.order;

import christmas.order.converter.Converter;
import christmas.order.menu.Menu;
import christmas.order.menu.Price;
import christmas.view.input.Order;
import java.util.HashMap;
import java.util.List;

public class TotalOrder {
    private final OrderWithVolume orderWithVolume;

    public TotalOrder(Order order) {
        this.orderWithVolume = new Converter().createOrderedMenuTotal(order);
    }

    public OrderedMenus produceOrderedMenu() {
        return new OrderedMenus(orderWithVolume.orderedMenuTotal().keySet().stream().toList());
    }

    public Price calculateTotalOrderCost() {
        HashMap<Menu, Volume> rawOrderedMenuTotal = orderWithVolume.orderedMenuTotal();
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
