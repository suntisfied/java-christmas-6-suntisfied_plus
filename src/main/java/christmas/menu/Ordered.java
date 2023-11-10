package christmas.menu;

import christmas.menu.menuitem.Menu;
import java.util.HashMap;

public record Ordered(HashMap<Menu, MenuAmount> menus) {
}
