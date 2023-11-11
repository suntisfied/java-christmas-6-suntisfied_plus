package christmas.promotion.bydate;

import christmas.promotion.Discount;
import christmas.view.input.Date;
import java.util.Arrays;
import java.util.List;

public class DateBenefit implements DateDiscount {
    private final DateDiscount dateDiscount;

    public DateBenefit() {
        this.dateDiscount = new Dday();
    }

    public DateBenefit(DateDiscount dateDiscount) {
        this.dateDiscount = dateDiscount;
    }

    @Override
    public boolean checkDate(Date date) {
        return dateDiscount.checkDate(date);
    }

    @Override
    public Discount calculateDiscount(Date date) {
        return dateDiscount.calculateDiscount(date);
    }

    public Discount calculateTotalDateBenefit(Date date) {
        List<DateDiscount> dateDiscounts =
                Arrays.asList(new Dday(), new Weekday(), new Weekend(), new Special());

        int totalDateBenefit = 0;
        for (DateDiscount dateDiscount : dateDiscounts) {
            DateBenefit dateBenefit = new DateBenefit(dateDiscount);
            if (dateBenefit.checkDate(date)) {
                totalDateBenefit += dateBenefit.calculateDiscount(date).amount();
            }
        }

        return new Discount(totalDateBenefit);
    }
}
