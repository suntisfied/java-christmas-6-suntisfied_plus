package christmas.view.integration.promotionformat;

import christmas.promotion.Discount;
import christmas.promotion.TotalBenefit;
import christmas.promotion.byorder.OrderBenefit;
import christmas.view.input.Date;
import christmas.view.input.Order;

public class BadgePromotion implements PromotionFormat {
    @Override
    public String format(Date date, Order order) {
        OrderBenefit orderBenefit = new OrderBenefit();
        TotalBenefit totalBenefit = new TotalBenefit();

        Discount totalBenefitAmount = totalBenefit.calculateTotalBenefit(date, order);

        return orderBenefit.determineBadge(totalBenefitAmount).getName();
    }
}
