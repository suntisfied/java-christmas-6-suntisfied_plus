package christmas.order;

import christmas.order.menu.Menu;
import java.util.HashMap;

public record OrderedMenuTotal(HashMap<Menu, OrderVolume> orderedMenuTotal) {
}
