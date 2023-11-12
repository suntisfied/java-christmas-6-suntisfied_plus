package christmas.view.integration.promotionformat;

import christmas.promotion.Discount;
import christmas.promotion.Promotions;
import christmas.promotion.TotalBenefit;
import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

public class PromotionList implements PromotionFormat {
    NumberFormat numberFormatter;

    public PromotionList() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(Date date, Order order) {
        StringBuilder stringBuilder = new StringBuilder();

        TotalBenefit totalBenefit = new TotalBenefit();
        HashMap<Promotions, Discount> benefits = totalBenefit.createBenefits(date, order);

        if (benefits.get(Promotions.D_DAY).amount() > 0) {
            stringBuilder.append(Promotions.D_DAY.getText());
            stringBuilder.append(Messages.MINUS.getMessage());
            stringBuilder.append(numberFormatter.format(benefits.get(Promotions.D_DAY).amount()));
            stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());
            stringBuilder.append("\r\n");
        }

        if (benefits.get(Promotions.WEEKDAY).amount() > 0) {
            stringBuilder.append(Promotions.WEEKDAY.getText());
            stringBuilder.append(Messages.MINUS.getMessage());
            stringBuilder.append(numberFormatter.format(benefits.get(Promotions.WEEKDAY).amount()));
            stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());
            stringBuilder.append("\r\n");
        }

        if (benefits.get(Promotions.WEEKEND).amount() > 0) {
            stringBuilder.append(Promotions.WEEKEND.getText());
            stringBuilder.append(Messages.MINUS.getMessage());
            stringBuilder.append(numberFormatter.format(benefits.get(Promotions.WEEKEND).amount()));
            stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());
            stringBuilder.append("\r\n");
        }

        if (benefits.get(Promotions.SPECIAL).amount() > 0) {
            stringBuilder.append(Promotions.SPECIAL.getText());
            stringBuilder.append(Messages.MINUS.getMessage());
            stringBuilder.append(numberFormatter.format(benefits.get(Promotions.SPECIAL).amount()));
            stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());
            stringBuilder.append("\r\n");
        }

        if (benefits.get(Promotions.FREE_GIFT).amount() > 0) {
            stringBuilder.append(Promotions.FREE_GIFT.getText());
            stringBuilder.append(Messages.MINUS.getMessage());
            stringBuilder.append(numberFormatter.format(benefits.get(Promotions.FREE_GIFT).amount()));
            stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());
        }

        if (stringBuilder.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Promotions.NONE.getText());
        }

        return stringBuilder.toString();
    }
}
