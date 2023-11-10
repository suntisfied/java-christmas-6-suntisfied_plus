package christmas.menu;

import christmas.menu.menuitem.Menu;
import java.util.HashMap;

public record MenuTable(HashMap<String, Menu> menuTable) {
}
