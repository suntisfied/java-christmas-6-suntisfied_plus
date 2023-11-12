package christmas.view.integration.promotionformat;

import christmas.view.input.Date;
import christmas.view.input.Order;

public interface PromotionFormat {
    String format(Date date, Order order);
}
