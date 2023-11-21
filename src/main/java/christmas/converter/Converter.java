package christmas.converter;

import static christmas.promotion.Promotions.D_DAY;
import static christmas.promotion.Promotions.FREE_GIFT;
import static christmas.promotion.Promotions.SPECIAL;
import static christmas.promotion.Promotions.WEEKDAY;
import static christmas.promotion.Promotions.WEEKEND;

import christmas.order.TotalOrder;
import christmas.order.Volume;
import christmas.order.menu.Menu;
import christmas.promotion.Discount;
import christmas.promotion.Promotions;
import christmas.promotion.TotalBenefit;
import christmas.promotion.datepromotion.DateBenefit;
import christmas.promotion.datepromotion.DateDiscount;
import christmas.promotion.datepromotion.Dday;
import christmas.promotion.datepromotion.Special;
import christmas.promotion.datepromotion.Weekday;
import christmas.promotion.datepromotion.Weekend;
import christmas.promotion.FreeGift;
import christmas.promotion.FreeGifts;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {
    public TotalOrder convertToTotalOrder(MenuOrder menuOrder) {
        List<String> menuNameAndVolumes = new Separator().createMenuNameAndVolumes(menuOrder);
        Map<Menu, Volume> orderedMenuTotal = new Extractor().createMenus(menuNameAndVolumes);

        return new TotalOrder(orderedMenuTotal);
    }

    public TotalBenefit convertToTotalBenefit(VisitDate visitDate, MenuOrder menuOrder) {
        Map<Promotions, Discount> benefits = createPromotionBenefits(visitDate, menuOrder);
        benefits.putAll(createFreeGiftBenefits(menuOrder));

        return new TotalBenefit(benefits);
    }

    private Map<Promotions, Discount> createPromotionBenefits(VisitDate visitDate, MenuOrder menuOrder) {
        List<Promotions> promotions = Arrays.asList(D_DAY, WEEKDAY, WEEKEND, SPECIAL);

        List<DateDiscount> dateDiscounts =
                Arrays.asList(new Dday(), new Weekday(menuOrder), new Weekend(menuOrder), new Special());

        Map<Promotions, Discount> promotionBenefits = new HashMap<>();
        for (int current = 0; current < promotions.size(); current++) {
            DateBenefit dateBenefit = new DateBenefit(dateDiscounts.get(current));
            promotionBenefits.put(promotions.get(current), dateBenefit.calculateDiscount(visitDate, menuOrder));
        }
        return promotionBenefits;
    }

    private Map<Promotions, Discount> createFreeGiftBenefits(MenuOrder menuOrder) {
        FreeGift freeGift = new FreeGift();
        Map<FreeGifts, Volume> freeGiftWithVolume = freeGift.determineGift(menuOrder);
        Map<Promotions, Discount> freeGiftBenefits = new HashMap<>();
        for (FreeGifts currentFreeGift : freeGiftWithVolume.keySet()) {
            freeGiftBenefits.put(FREE_GIFT, new Discount(currentFreeGift.getPrice().amount()));
        }
        return freeGiftBenefits;
    }
}
