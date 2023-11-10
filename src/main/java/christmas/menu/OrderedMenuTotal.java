package christmas.menu;

import christmas.menu.menuitem.Menu;
import java.util.HashMap;

public record OrderedMenuTotal(HashMap<Menu, MenuAmount> orderedMenuTotal) {
}
