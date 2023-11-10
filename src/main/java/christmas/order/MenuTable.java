package christmas.order;

import christmas.order.menu.Menu;
import java.util.HashMap;

public record MenuTable(HashMap<String, Menu> menuTable) {
}
