package christmas.view.output;

import christmas.Integrator;
import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;

public class Preview extends Integrator {
    public void display(Date date, Order order) {
        System.out.println(buildPreview(date,order));
    }

    public String buildPreview(Date date, Order order) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Messages.HEAD_PREVIEW.getMessage())
                .append("\r\n")
                .append("\r\n")
                .append(Messages.HEAD_ORDER_LIST.getMessage())
                .append("\r\n")
                .append(formatOrderedMenu(order))
                .append("\r\n")
                .append("\r\n")
                .append(Messages.HEAD_ORDER_AMOUNT.getMessage())
                .append("\r\n")
                .append(formatTotalCostBeforePromotion(order))
                .append("\r\n")
                .append("\r\n")
                .append(Messages.HEAD_FREE_GIFT.getMessage())
                .append("\r\n")
                .append(formatFreeGift(order))
                .append("\r\n")
                .append("\r\n")
                .append(Messages.HEAD_PROMOTION_LIST.getMessage())
                .append("\r\n")
                .append(formatPromotionList(date, order))
                .append("\r\n")
                .append("\r\n")
                .append(Messages.HEAD_PROMOTION_AMOUNT.getMessage())
                .append("\r\n")
                .append(formatTotalBenefitAmount(date, order))
                .append("\r\n")
                .append("\r\n")
                .append(Messages.HEAD_EXPECTED_TOTAL_COST.getMessage())
                .append("\r\n")
                .append(formatExpectedTotalCostAfterPromotion(date, order))
                .append("\r\n")
                .append("\r\n")
                .append(Messages.HEAD_BADGE.getMessage())
                .append("\r\n")
                .append(formatBadge(date, order));

        return stringBuilder.toString();
    }
}
