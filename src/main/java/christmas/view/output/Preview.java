package christmas.view.output;

import static christmas.view.Messages.HEAD_BADGE;
import static christmas.view.Messages.HEAD_EXPECTED_TOTAL_COST;
import static christmas.view.Messages.HEAD_FREE_GIFT;
import static christmas.view.Messages.HEAD_ORDER_AMOUNT;
import static christmas.view.Messages.HEAD_ORDER_LIST;
import static christmas.view.Messages.HEAD_PROMOTION_AMOUNT;
import static christmas.view.Messages.HEAD_PROMOTION_LIST;

import christmas.view.integration.promotionformat.BadgePromotion;
import christmas.view.integration.promotionformat.ExpectedTotalCost;
import christmas.view.integration.orderformat.FreeGiftBenefit;
import christmas.view.integration.orderformat.OrderFormatter;
import christmas.view.integration.orderformat.OrderFormat;
import christmas.view.integration.orderformat.OrderedMenu;
import christmas.view.integration.promotionformat.PromotionFormat;
import christmas.view.integration.promotionformat.PromotionFormatter;
import christmas.view.integration.promotionformat.PromotionList;
import christmas.view.integration.promotionformat.TotalBenefitAmount;
import christmas.view.integration.orderformat.InitialTotalCost;
import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Preview {
    public void display(Date date, Order order) {
        System.out.println(buildPreview(date, order));
    }

    public String buildPreview(Date date, Order order) {
        LinkedHashMap<String, String> previews = new LinkedHashMap<>(buildOrderPreview(order));
        previews.putAll(buildPromotionPreview(date, order));

        String previewText = previews.entrySet().stream()
                .flatMap(entry -> Stream.of(entry.getKey() + "\r\n", entry.getValue() + "\r\n\r\n"))
                .collect(Collectors.joining());

        return Messages.HEAD_PREVIEW.getMessage()
                + "\r\n"
                + "\r\n"
                + previewText;
    }

    private LinkedHashMap<String, String> buildOrderPreview(Order order) {
        LinkedHashMap<String, String> orderPreviews = new LinkedHashMap<>();

        List<Messages> orderHeadTexts =
                Arrays.asList(HEAD_ORDER_LIST, HEAD_ORDER_AMOUNT, HEAD_FREE_GIFT);
        List<OrderFormat> orders =
                Arrays.asList(new OrderedMenu(),
                        new InitialTotalCost(),
                        new FreeGiftBenefit());

        for (int i = 0; i < orderHeadTexts.size(); i++) {
            OrderFormatter orderFormatter = new OrderFormatter(orders.get(i));
            orderPreviews.put(orderHeadTexts.get(i).getMessage(), orderFormatter.format(order));
        }
        return orderPreviews;
    }

    private LinkedHashMap<String, String> buildPromotionPreview(Date date, Order order) {
        LinkedHashMap<String, String> promotionPreviews = new LinkedHashMap<>();

        List<Messages> promotionHeadTexts =
                Arrays.asList(HEAD_PROMOTION_LIST, HEAD_PROMOTION_AMOUNT, HEAD_EXPECTED_TOTAL_COST, HEAD_BADGE);
        List<PromotionFormat> promotions =
                Arrays.asList(new PromotionList(),
                        new TotalBenefitAmount(),
                        new ExpectedTotalCost(),
                        new BadgePromotion());

        for (int i = 0; i < promotionHeadTexts.size(); i++) {
            PromotionFormatter promotionFormatter = new PromotionFormatter(promotions.get(i));
            promotionPreviews.put(promotionHeadTexts.get(i).getMessage(), promotionFormatter.format(date, order));
        }

        return promotionPreviews;
    }
}
