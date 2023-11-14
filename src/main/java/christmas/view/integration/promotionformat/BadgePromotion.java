package christmas.view.integration.promotionformat;

import christmas.promotion.Discount;
import christmas.promotion.TotalBenefit;
import christmas.promotion.orderpromotion.Badge;
import christmas.view.input.Date;
import christmas.view.input.Order;

public class BadgePromotion implements PromotionFormat {
    @Override
    public String format(Date date, Order order) {
        Badge badge = new Badge();
        TotalBenefit totalBenefit = new TotalBenefit();

        Discount totalBenefitAmount = totalBenefit.calculateTotalBenefit(date, order);

        return badge.determineBadge(totalBenefitAmount).getName();
    }
}
