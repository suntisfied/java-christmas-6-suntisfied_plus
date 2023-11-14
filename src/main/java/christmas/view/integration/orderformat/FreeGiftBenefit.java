package christmas.view.integration.orderformat;

import christmas.order.Volume;
import christmas.promotion.byorder.FreeGifts;
import christmas.promotion.byorder.OrderBenefit;
import christmas.view.Messages;
import christmas.view.input.Order;
import java.util.Map;

public class FreeGiftBenefit implements OrderFormat {
    @Override
    public String format(Order order) {
        OrderBenefit orderBenefit = new OrderBenefit();

        Map<FreeGifts, Volume> freeGiftWithVolume = orderBenefit.determineGift(order);
        FreeGifts freeGift = FreeGifts.NONE;
        String freeGiftText = freeGift.getName();
        if (!freeGiftWithVolume.containsKey(FreeGifts.NONE)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (FreeGifts currentFreeGift : freeGiftWithVolume.keySet()) {
                stringBuilder.append(currentFreeGift.getName())
                        .append(" ")
                        .append(freeGiftWithVolume.get(currentFreeGift))
                        .append(Messages.UNIT_COUNT.getMessage());
            }
            freeGiftText = stringBuilder.toString();
        }


        return freeGiftText;
    }
}
