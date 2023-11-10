package christmas.order;

import christmas.order.menuitem.Menu;
import java.util.HashMap;

public record MenuTable(HashMap<String, Menu> menuTable) {
}
