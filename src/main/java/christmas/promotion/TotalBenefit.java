package christmas.promotion;

import christmas.order.Volume;
import christmas.promotion.datepromotion.DateBenefit;
import christmas.promotion.datepromotion.DateDiscount;
import christmas.promotion.datepromotion.Dday;
import christmas.promotion.datepromotion.Special;
import christmas.promotion.datepromotion.Weekday;
import christmas.promotion.datepromotion.Weekend;
import christmas.promotion.orderpromotion.FreeGift;
import christmas.promotion.orderpromotion.FreeGifts;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalBenefit {
    public Map<Promotions, Discount> createBenefits(Date date, Order order) {
        Map<Promotions, Discount> benefits = createPromotionBenefits(date, order);
        benefits.putAll(createOrderBenefits(order));

        return benefits;
    }

    private Map<Promotions, Discount> createPromotionBenefits(Date date, Order order) {
        List<Promotions> promotions =
                Arrays.asList(Promotions.D_DAY, Promotions.WEEKDAY, Promotions.WEEKEND, Promotions.SPECIAL);

        List<DateDiscount> dateDiscounts =
                Arrays.asList(new Dday(), new Weekday(order), new Weekend(order), new Special());
        Map<Promotions, Discount> promotionBenefits = new HashMap<>();
        for (int i = 0; i < promotions.size(); i++) {
            DateBenefit dateBenefit = new DateBenefit(dateDiscounts.get(i));
            promotionBenefits.put(promotions.get(i), dateBenefit.calculateDiscount(date, order));
        }
        return promotionBenefits;
    }

    private Map<Promotions, Discount> createOrderBenefits(Order order) {
        FreeGift freeGift = new FreeGift();
        Map<FreeGifts, Volume> freeGiftWithVolume = freeGift.determineGift(order);
        Map<Promotions, Discount> orderBenefits = new HashMap<>();
        for (FreeGifts currentFreeGift : freeGiftWithVolume.keySet()) {
            orderBenefits.put(Promotions.FREE_GIFT, new Discount(currentFreeGift.getPrice().price()));
        }
        orderBenefits.put(Promotions.BADGE, new Discount(0));
        return orderBenefits;
    }

    public Discount calculateTotalBenefit(Date date, Order order) {
        Map<Promotions, Discount> benefits = createBenefits(date, order);

        int totalBenefit = benefits.values().stream().mapToInt(Discount::amount).sum();

        return new Discount(totalBenefit);
    }
}
