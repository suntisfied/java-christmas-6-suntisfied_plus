package christmas.order;

import christmas.order.menuitem.Menu;
import java.util.HashMap;

public record OrderedMenuTotal(HashMap<Menu, MenuAmount> orderedMenuTotal) {
}
