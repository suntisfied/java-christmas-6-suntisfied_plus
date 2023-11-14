package christmas.view.integration.promotionformat;

import christmas.converter.Converter;
import christmas.promotion.Discount;
import christmas.promotion.TotalBenefit;
import christmas.promotion.orderpromotion.Badge;
import christmas.view.input.Date;
import christmas.view.input.Order;

public class BadgePromotion implements PromotionFormat {
    @Override
    public String format(Date date, Order order) {
        Badge badge = new Badge();
        TotalBenefit totalBenefit = new Converter().convertToTotalBenefit(date, order);

        Discount totalBenefitAmount = totalBenefit.calculateTotalBenefit();

        return badge.determineBadge(totalBenefitAmount).getName();
    }
}
