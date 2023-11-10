package christmas.promotion.byorder;

import christmas.order.Price;
import christmas.promotion.Discount;
import christmas.promotion.Promotion;
import christmas.promotion.bydate.Dday;

public class OrderBenefit {
    public Discount calculateTotalOrderBenefit(Price price) {
        Promotion promotion = new Promotion(new Dday(), new FreeGift(), new Badge());

        int totalOrderBenefit = promotion.determineGift(price).getPrice().price();

        return new Discount(totalOrderBenefit);
    }
}
