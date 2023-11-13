package christmas.promotion;

import christmas.order.Volume;
import christmas.order.menu.Menu;
import christmas.promotion.bydate.DateBenefit;
import christmas.promotion.bydate.DateDiscount;
import christmas.promotion.bydate.Dday;
import christmas.promotion.bydate.Special;
import christmas.promotion.bydate.Weekday;
import christmas.promotion.bydate.Weekend;
import christmas.promotion.byorder.Badge;
import christmas.promotion.byorder.FreeGift;
import christmas.promotion.byorder.OrderBenefit;
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
        OrderBenefit orderBenefit = new OrderBenefit(new FreeGift(), new Badge());
        int freeGiftPrice = 0;
        if (!orderBenefit.determineGift(order).freeGifts().isEmpty()) {
            Map<Menu, Volume> rawFreeGift = orderBenefit.determineGift(order).freeGifts();
            for (Menu menu : rawFreeGift.keySet()) {
                freeGiftPrice += menu.getPrice().price();
            }
        }
        Map<Promotions, Discount> orderBenefits = new HashMap<>();
        orderBenefits.put(Promotions.FREE_GIFT, new Discount(freeGiftPrice));
        orderBenefits.put(Promotions.BADGE, new Discount(0));
        return orderBenefits;
    }

    public Discount calculateTotalBenefit(Date date, Order order) {
        Map<Promotions, Discount> benefits = createBenefits(date, order);

        int totalBenefit = benefits.values().stream().mapToInt(Discount::amount).sum();

        return new Discount(totalBenefit);
    }
}
