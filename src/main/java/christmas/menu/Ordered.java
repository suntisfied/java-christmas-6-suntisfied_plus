package christmas.menu;

import java.util.HashMap;

public record Ordered(HashMap<Menu, MenuAmount> menus) {
}
