package christmas.view.format.promotionformat;

import static christmas.promotion.Promotions.D_DAY;
import static christmas.promotion.Promotions.FREE_GIFT;
import static christmas.promotion.Promotions.SPECIAL;
import static christmas.promotion.Promotions.WEEKDAY;
import static christmas.promotion.Promotions.WEEKEND;

import christmas.converter.Converter;
import christmas.promotion.Promotions;
import christmas.promotion.TotalBenefit;
import christmas.view.Messages;
import christmas.view.format.BlankLineRemover;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class BenefitDetails implements PromotionFormat {
    private final NumberFormat numberFormatter;

    public BenefitDetails() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(VisitDate visitDate, MenuOrder menuOrder) {
        String promotionTexts = buildPromotions(visitDate, menuOrder);

        if (promotionTexts.isEmpty()) {
            promotionTexts = Promotions.NONE.getText();
        }

        return promotionTexts;
    }

    private String buildPromotions(VisitDate visitDate, MenuOrder menuOrder) {
        TotalBenefit totalBenefit = new Converter().convertToTotalBenefit(visitDate, menuOrder);
        List<Promotions> promotions = Arrays.asList(D_DAY, WEEKDAY, WEEKEND, SPECIAL, FREE_GIFT);

        return formatPromotions(totalBenefit, promotions);
    }

    private String formatPromotions(TotalBenefit totalBenefit, List<Promotions> promotions) {
        StringBuilder promotionTextBuilder = new StringBuilder();
        for (Promotions currentPromotion : promotions) {
            if (totalBenefit.getDiscountByPromotion(currentPromotion).amount() > 0) {
                promotionTextBuilder.append(currentPromotion.getText());
                promotionTextBuilder.append(Messages.MINUS.getMessage());
                promotionTextBuilder.append(numberFormatter.format(
                        totalBenefit.getDiscountByPromotion(currentPromotion).amount()));
                promotionTextBuilder.append(Messages.UNIT_CURRENCY.getMessage());
                promotionTextBuilder.append(System.lineSeparator());
            }
        }
        promotionTextBuilder = new BlankLineRemover().remove(promotionTextBuilder, 1);
        return promotionTextBuilder.toString();
    }
}
