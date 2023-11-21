package christmas.view.format.promotionformat;

import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;

public class PromotionFormatter implements PromotionFormat {
    private final PromotionFormat promotionFormat;

    public PromotionFormatter(PromotionFormat promotionFormat) {
        this.promotionFormat = promotionFormat;
    }

    @Override
    public String format(VisitDate visitDate, MenuOrder menuOrder) {
        return promotionFormat.format(visitDate, menuOrder);
    }
}
