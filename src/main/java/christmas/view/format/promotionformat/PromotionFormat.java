package christmas.view.format.promotionformat;

import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;

public interface PromotionFormat {
    String format(VisitDate visitDate, MenuOrder menuOrder);
}
