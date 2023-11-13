package christmas.order.converter;

import christmas.order.menu.Menu;
import java.util.Map;

public record MenuTable(Map<String, Menu> menuTable) {
}
