package christmas.order;

import christmas.order.menu.Menu;
import christmas.order.menu.OrderAmount;
import java.util.HashMap;

public record OrderedMenuTotal(HashMap<Menu, OrderAmount> orderedMenuTotal) {
}
