package christmas.order;

import christmas.order.menu.Menu;
import christmas.order.menu.MenuAmount;
import java.util.HashMap;

public record OrderedMenuTotal(HashMap<Menu, MenuAmount> orderedMenuTotal) {
}
