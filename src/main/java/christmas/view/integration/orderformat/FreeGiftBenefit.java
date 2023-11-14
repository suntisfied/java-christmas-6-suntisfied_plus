package christmas.view.integration.orderformat;

import christmas.order.Volume;
import christmas.promotion.orderpromotion.FreeGift;
import christmas.promotion.orderpromotion.FreeGifts;
import christmas.view.Messages;
import christmas.view.input.Order;
import java.util.Map;

public class FreeGiftBenefit implements OrderFormat {
    @Override
    public String format(Order order) {
        FreeGift freeGift = new FreeGift();
        Map<FreeGifts, Volume> freeGiftWithVolume = freeGift.determineGift(order);

        FreeGifts freeGifts = FreeGifts.NONE;
        String freeGiftText = freeGifts.getName();
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
