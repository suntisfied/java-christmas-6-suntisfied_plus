package christmas.order;

import christmas.order.menu.Menu;
import java.util.HashMap;

public record OrderWithVolume(HashMap<Menu, OrderVolume> orderedMenuTotal) {
}
