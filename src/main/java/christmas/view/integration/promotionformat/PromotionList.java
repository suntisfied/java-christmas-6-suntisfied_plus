package christmas.view.integration.promotionformat;

import static christmas.promotion.Promotions.D_DAY;
import static christmas.promotion.Promotions.FREE_GIFT;
import static christmas.promotion.Promotions.SPECIAL;
import static christmas.promotion.Promotions.WEEKDAY;
import static christmas.promotion.Promotions.WEEKEND;

import christmas.promotion.Discount;
import christmas.promotion.Promotions;
import christmas.promotion.TotalBenefit;
import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class PromotionList implements PromotionFormat {
    private final NumberFormat numberFormatter;

    public PromotionList() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(Date date, Order order) {
        StringBuilder promotionTexts = new StringBuilder();

        TotalBenefit totalBenefit = new TotalBenefit();
        HashMap<Promotions, Discount> benefits = totalBenefit.createBenefits(date, order);

        List<Promotions> promotions = Arrays.asList(D_DAY, WEEKDAY, WEEKEND, SPECIAL, FREE_GIFT);

        for (Promotions promotion : promotions) {
            if (benefits.get(promotion).amount() > 0) {
                promotionTexts.append(promotion.getText());
                promotionTexts.append(Messages.MINUS.getMessage());
                promotionTexts.append(numberFormatter.format(benefits.get(promotion).amount()));
                promotionTexts.append(Messages.UNIT_CURRENCY.getMessage());
                promotionTexts.append("\r\n");
            }
        }

        if (promotionTexts.isEmpty()) {
            promotionTexts = new StringBuilder();
            promotionTexts.append(Promotions.NONE.getText());
        }

        return promotionTexts.toString();
    }
}
