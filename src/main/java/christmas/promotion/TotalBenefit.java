package christmas.promotion;

import christmas.order.OrderedTotal;
import christmas.order.menu.Price;
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

public class TotalBenefit {
    public HashMap<Promotions, Discount> createBenefits(Date date, Order order) {
        List<Promotions> promotions =
                Arrays.asList(Promotions.D_DAY, Promotions.WEEKDAY, Promotions.WEEKEND, Promotions.SPECIAL);

        List<DateDiscount> dateDiscounts =
                Arrays.asList(new Dday(), new Weekday(), new Weekend(), new Special());

        HashMap<Promotions, Discount> benefits = new HashMap<>();
        for (int i = 0; i < promotions.size(); i++) {
            DateBenefit dateBenefit = new DateBenefit(dateDiscounts.get(i));
            benefits.put(promotions.get(i), dateBenefit.calculateDiscount(date, order));
        }

        OrderBenefit orderBenefit = new OrderBenefit(new FreeGift(), new Badge());

        OrderedTotal orderedTotal = new OrderedTotal(order);
        Price totalOrderCost = orderedTotal.calculateTotalOrderCost();

        int freeGiftPrice = orderBenefit.determineGift(totalOrderCost).getPrice().price();

        benefits.put(Promotions.FREE_GIFT, new Discount(freeGiftPrice));
        benefits.put(Promotions.BADGE, new Discount(0));

        return benefits;
    }

    public Discount calculateTotalBenefit(Date date, Order order) {
        HashMap<Promotions, Discount> benefits = createBenefits(date, order);

        int totalBenefit = benefits.values().stream().mapToInt(Discount::amount).sum();

        return new Discount(totalBenefit);
    }
}
