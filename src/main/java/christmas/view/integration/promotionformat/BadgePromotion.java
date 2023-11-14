package christmas.view.integration.promotionformat;

import christmas.promotion.orderpromotion.Badge;
import christmas.view.input.Date;
import christmas.view.input.Order;

public class BadgePromotion implements PromotionFormat {
    @Override
    public String format(Date date, Order order) {
        Badge badge = new Badge();

        return badge.determineBadge(date, order).getName();
    }
}
