package christmas.view.output;

import static christmas.view.Messages.HEAD_BADGE;
import static christmas.view.Messages.HEAD_EXPECTED_TOTAL_COST;
import static christmas.view.Messages.HEAD_PROMOTION_AMOUNT;
import static christmas.view.Messages.HEAD_PROMOTION_LIST;

import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;
import christmas.view.integration.promotionformat.BadgePromotion;
import christmas.view.integration.promotionformat.ExpectedTotalCost;
import christmas.view.integration.promotionformat.PromotionFormat;
import christmas.view.integration.promotionformat.PromotionFormatter;
import christmas.view.integration.promotionformat.PromotionList;
import christmas.view.integration.promotionformat.TotalBenefitAmount;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PromotionPreview {
    Map<String, String> build(Date date, Order order) {
        Map<String, String> promotionPreviews = new LinkedHashMap<>();

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
