package christmas.view.integration.promotionformat;

import static christmas.promotion.Promotions.D_DAY;
import static christmas.promotion.Promotions.FREE_GIFT;
import static christmas.promotion.Promotions.SPECIAL;
import static christmas.promotion.Promotions.WEEKDAY;
import static christmas.promotion.Promotions.WEEKEND;

import christmas.order.converter.Converter;
import christmas.promotion.Promotions;
import christmas.promotion.TotalBenefit;
import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PromotionList implements PromotionFormat {
    private final NumberFormat numberFormatter;

    public PromotionList() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(Date date, Order order) {
        String promotionTexts = buildPromotions(date, order);

        if (promotionTexts.isEmpty()) {
            promotionTexts = Promotions.NONE.getText();
        }

        return promotionTexts;
    }

    private String buildPromotions(Date date, Order order) {
        TotalBenefit totalBenefit = new Converter().convertToTotalBenefit(date, order);
        List<Promotions> promotions = Arrays.asList(D_DAY, WEEKDAY, WEEKEND, SPECIAL, FREE_GIFT);

        return formatPromotions(totalBenefit, promotions);
    }

    private String formatPromotions(TotalBenefit totalBenefit, List<Promotions> promotions) {
        StringBuilder promotionTexts = new StringBuilder();
        for (Promotions currentPromotion : promotions) {
            if (totalBenefit.getDiscountByPromotion(currentPromotion).amount() > 0) {
                promotionTexts.append(currentPromotion.getText());
                promotionTexts.append(Messages.MINUS.getMessage());
                promotionTexts.append(numberFormatter.format(
                        totalBenefit.getDiscountByPromotion(currentPromotion).amount()));
                promotionTexts.append(Messages.UNIT_CURRENCY.getMessage());
                promotionTexts.append("\r\n");
            }
        }
        return promotionTexts.toString();
    }
}
