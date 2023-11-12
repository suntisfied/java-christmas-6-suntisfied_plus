package christmas.promotion.byorder;

import christmas.order.OrderVolume;
import christmas.order.menu.Menu;
import java.util.HashMap;

public record FreeGifts(HashMap<Menu, OrderVolume> freeGifts) {
}
