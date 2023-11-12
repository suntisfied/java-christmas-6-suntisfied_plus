package christmas.promotion.byorder;

import christmas.order.Volume;
import christmas.order.menu.Menu;
import java.util.HashMap;

public record FreeGifts(HashMap<Menu, Volume> freeGifts) {
}
