package christmas.promotion.bydate;

import christmas.order.OrderVolume;
import christmas.order.OrderedTotal;
import christmas.order.converter.Converter;
import christmas.order.menu.MainDishes;
import christmas.order.menu.Menu;
import christmas.order.menu.Price;
import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Weekend implements DateDiscount {
    @Override
    public boolean check(Date date, Order order) {
        boolean validity = false;

        OrderedTotal orderedTotal = new OrderedTotal(order);
        Price totalOrderCost = orderedTotal.calculateTotalOrderCost();

        if (isWeekend.test(date) && isMainOrdered.test(order) && isEnoughTotalOrder.test(totalOrderCost)) {
            validity = true;
        }
        return validity;
    }

    @Override
    public Discount calculateDiscount(Date date, Order order) {
        int totalDiscount = 0;
        if (check(date, order)) {
            OrderVolume mainOrderVolume = calculateMainOrderVolume(order);
            totalDiscount = 2023 * mainOrderVolume.volume();
        }
        return new Discount(totalDiscount);
    }

    Predicate<Date> isWeekend = date -> {
        List<Integer> weekends = Days.WEEKENDS.getDays();
        return weekends.contains(date.date());
    };

    Predicate<Order> isMainOrdered = order -> {
        OrderVolume mainOrderVolume = calculateMainOrderVolume(order);
        return mainOrderVolume.volume() > 0;
    };

    public OrderVolume calculateMainOrderVolume(Order order) {
        Converter converter = new Converter();
        List<Menu> orderedMenuNameList = converter.createOrderedMenuNameList(order);
        List<MainDishes> mainMenuNameList = EnumSet.allOf(MainDishes.class).stream().toList();

        List<Menu> commonMenuNameList = new ArrayList<>(orderedMenuNameList);
        commonMenuNameList.retainAll(mainMenuNameList);

        HashMap<Menu, OrderVolume> rawOrderedMenuTotal = converter.createOrderedMenuTotal(order).orderedMenuTotal();

        int orderedMainVolume = 0;
        for (Menu menu : commonMenuNameList) {
            if (mainMenuNameList.stream().anyMatch(orderedMenuNameList::contains)) {
                orderedMainVolume += rawOrderedMenuTotal.get(menu).volume();
            }
        }

        return new OrderVolume(orderedMainVolume);
    }
}
