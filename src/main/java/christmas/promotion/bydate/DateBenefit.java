package christmas.promotion.bydate;

import christmas.promotion.Discount;
import christmas.promotion.Promotion;
import christmas.promotion.byorder.Badge;
import christmas.promotion.byorder.FreeGift;
import christmas.view.input.Date;
import java.util.Arrays;
import java.util.List;

public class DateBenefit {
    public Discount calculateTotalDateBenefit(Date date) {
        List<DateDiscount> dateDiscounts = Arrays.asList(new Dday(), new Weekday(), new Weekend(), new Special());

        int totalDateBenefit = 0;
        for (DateDiscount dateDiscount : dateDiscounts) {
            Promotion promotion = new Promotion(dateDiscount, new FreeGift(), new Badge());
            if (promotion.checkDate(date)) {
                totalDateBenefit += promotion.calculateDiscount(date).amount();
            }
        }

        return new Discount(totalDateBenefit);
    }
}
