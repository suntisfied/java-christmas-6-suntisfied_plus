package christmas.promotion.bydate;

import christmas.order.OrderVolume;
import christmas.order.OrderedTotal;
import christmas.order.converter.Converter;
import christmas.order.menu.Desserts;
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

public class Weekday implements DateDiscount {
    @Override
    public boolean check(Date date, Order order) {
        boolean validity = false;

        OrderedTotal orderedTotal = new OrderedTotal(order);
        Price totalOrderCost = orderedTotal.calculateTotalOrderCost();

        if (isWeekday.test(date) && isDessertOrdered.test(order) && isEnoughTotalOrder.test(totalOrderCost)) {
            validity = true;
        }

        return validity;
    }

    @Override
    public Discount calculateDiscount(Date date, Order order) {
        int totalDiscount = 0;
        if (check(date, order)) {
            OrderVolume dessertOrderVolume = calculateDessertOrderVolume(order);
            totalDiscount = 2023 * dessertOrderVolume.volume();
        }
        return new Discount(totalDiscount);
    }

    Predicate<Date> isWeekday = date -> {
        List<Integer> weekdays = Days.WEEKDAYS.getDays();
        return weekdays.contains(date.date());
    };

    Predicate<Order> isDessertOrdered = order -> {
        OrderVolume dessertOrderVolume = calculateDessertOrderVolume(order);
        return dessertOrderVolume.volume() > 0;
    };

    public OrderVolume calculateDessertOrderVolume(Order order) {
        Converter converter = new Converter();
        List<Menu> orderedMenuNameList = converter.createOrderedMenuNameList(order);
        List<Menu> dessertMenuNameList = EnumSet.allOf(Desserts.class).stream()
                .map(dessert -> (Menu) dessert)
                .toList();

        List<Menu> commonMenuNameList = new ArrayList<>(orderedMenuNameList);
        commonMenuNameList.retainAll(dessertMenuNameList);

        HashMap<Menu, OrderVolume> rawOrderedMenuTotal = converter.createOrderedMenuTotal(order).orderedMenuTotal();

        int orderedDessertVolume = 0;
        for (Menu menu : commonMenuNameList) {
            if (dessertMenuNameList.stream().anyMatch(orderedMenuNameList::contains)) {
                orderedDessertVolume += rawOrderedMenuTotal.get(menu).volume();
            }
        }

        return new OrderVolume(orderedDessertVolume);
    }
}
