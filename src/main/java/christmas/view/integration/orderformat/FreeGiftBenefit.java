package christmas.view.integration.orderformat;

import christmas.order.Volume;
import christmas.order.menu.Menu;
import christmas.promotion.Promotions;
import christmas.promotion.byorder.OrderBenefit;
import christmas.view.Messages;
import christmas.view.input.Order;
import java.util.HashMap;
import java.util.Set;

public class FreeGiftBenefit implements OrderFormat {
    @Override
    public String format(Order order) {
        OrderBenefit orderBenefit = new OrderBenefit();

        String freeGiftText = Promotions.NONE.getText();

        if (!orderBenefit.determineGift(order).freeGifts().isEmpty()) {
            HashMap<Menu, Volume> rawFreeGifts = orderBenefit.determineGift(order).freeGifts();
            Set<Menu> freeGiftNames = rawFreeGifts.keySet();
            StringBuilder stringBuilder = new StringBuilder();
            for (Menu menu : freeGiftNames) {
                stringBuilder.append(menu.getName())
                        .append(" ")
                        .append(rawFreeGifts.get(menu).volume())
                        .append(Messages.UNIT_COUNT.getMessage());
            }
            freeGiftText = stringBuilder.toString();
        }

        return freeGiftText;
    }
}
