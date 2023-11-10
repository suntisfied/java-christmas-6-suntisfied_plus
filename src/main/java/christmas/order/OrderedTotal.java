package christmas.order;

import christmas.order.converter.MenuConverter;
import christmas.order.menu.Menu;
import java.util.HashMap;
import java.util.List;

public class OrderedTotal {
    private final OrderedMenuTotal orderedMenuTotal;

    public OrderedTotal(String input) {
        this.orderedMenuTotal = new MenuConverter().createOrderedMenuTotal(input);
    }

    public OrderedMenus produceOrderedMenu() {
        return new OrderedMenus(orderedMenuTotal.orderedMenuTotal().keySet().stream().toList());
    }

    public OrderAmount calculateTotalOrderAmount() {
        HashMap<Menu, MenuAmount> rawOrderedMenuTotal = orderedMenuTotal.orderedMenuTotal();
        List<Menu> rawOrderedMenus = produceOrderedMenu().orderedMenus();

        int totalSum = 0;
        for (Menu currentOrderedMenu : rawOrderedMenus) {
            int currentMenuPrice = currentOrderedMenu.getPrice().price();
            int currentMenuAmount = rawOrderedMenuTotal.get(currentOrderedMenu).amount();

            totalSum += currentMenuPrice * currentMenuAmount;
        }

        return new OrderAmount(totalSum);
    }
}
