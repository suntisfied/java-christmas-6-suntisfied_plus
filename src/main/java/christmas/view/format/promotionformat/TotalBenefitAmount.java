package christmas.view.format.promotionformat;

import christmas.converter.Converter;
import christmas.promotion.TotalBenefit;
import christmas.view.Messages;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;
import java.text.NumberFormat;
import java.util.Locale;

public class TotalBenefitAmount implements PromotionFormat {
    private final NumberFormat numberFormatter;

    public TotalBenefitAmount() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(VisitDate visitDate, MenuOrder menuOrder) {
        TotalBenefit totalBenefit = new Converter().convertToTotalBenefit(visitDate, menuOrder);
        int totalBenefitAmount = totalBenefit.calculateTotalBenefit().amount();

        StringBuilder totalBenefitTextBuilder = new StringBuilder();
        if (totalBenefitAmount > 0) {
            totalBenefitTextBuilder.append(Messages.MINUS.getMessage());
        }
        totalBenefitTextBuilder.append(numberFormatter.format(totalBenefitAmount));
        totalBenefitTextBuilder.append(Messages.UNIT_CURRENCY.getMessage());

        return totalBenefitTextBuilder.toString();
    }
}
