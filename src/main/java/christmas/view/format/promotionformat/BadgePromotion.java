package christmas.view.format.promotionformat;

import christmas.promotion.Badge;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;

public class BadgePromotion implements PromotionFormat {
    @Override
    public String format(VisitDate visitDate, MenuOrder menuOrder) {
        Badge badge = new Badge();

        return badge.determineBadge(visitDate, menuOrder).getName();
    }
}
