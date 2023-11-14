package christmas.view.format.promotionformat;

import christmas.converter.Converter;
import christmas.promotion.TotalBenefit;
import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.text.NumberFormat;
import java.util.Locale;

public class TotalBenefitAmount implements PromotionFormat {
    private final NumberFormat numberFormatter;

    public TotalBenefitAmount() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(Date date, Order order) {
        TotalBenefit totalBenefit = new Converter().convertToTotalBenefit(date, order);
        int totalBenefitAmount = totalBenefit.calculateTotalBenefit().amount();

        StringBuilder stringBuilder = new StringBuilder();
        if (totalBenefitAmount > 0) {
            stringBuilder.append(Messages.MINUS.getMessage());
        }
        stringBuilder.append(numberFormatter.format(totalBenefitAmount));
        stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());

        return stringBuilder.toString();
    }
}
