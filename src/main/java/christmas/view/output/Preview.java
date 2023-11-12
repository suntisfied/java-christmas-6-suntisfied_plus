package christmas.view.output;

import christmas.Integrator;
import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Preview extends Integrator {
    public void display(Date date, Order order) {
        System.out.println(buildPreview(date,order));
    }

    public String buildPreview(Date date, Order order) {
        LinkedHashMap<String, String> texts = new LinkedHashMap<>();
        texts.put(Messages.HEAD_ORDER_LIST.getMessage(), formatOrderedMenu(order));
        texts.put(Messages.HEAD_ORDER_AMOUNT.getMessage(), formatTotalCostBeforePromotion(order));
        texts.put(Messages.HEAD_FREE_GIFT.getMessage(), formatFreeGift(order));
        texts.put(Messages.HEAD_PROMOTION_LIST.getMessage(), formatPromotionList(date, order));
        texts.put(Messages.HEAD_PROMOTION_AMOUNT.getMessage(), formatTotalBenefitAmount(date, order));
        texts.put(Messages.HEAD_EXPECTED_TOTAL_COST.getMessage(), formatExpectedTotalCostAfterPromotion(date, order));
        texts.put(Messages.HEAD_BADGE.getMessage(), formatBadge(date, order));

        String previewText = texts.entrySet().stream()
                .flatMap(entry -> Stream.of(entry.getKey() + "\r\n", entry.getValue() + "\r\n\r\n"))
                .collect(Collectors.joining());

        return Messages.HEAD_PREVIEW.getMessage()
                + "\r\n"
                + "\r\n"
                + previewText;
    }
}
