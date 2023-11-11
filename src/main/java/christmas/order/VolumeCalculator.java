package christmas.order;

import christmas.order.converter.Converter;
import christmas.order.menu.Menu;
import christmas.view.input.Order;
import java.util.HashMap;
import java.util.List;

public class VolumeCalculator extends Converter {
    /**
     * Available Categories: appetizer, maindish, dessert, drink
     */
    public OrderVolume calculateOrderVolumeByCategory(Order order, String category) {
        List<Menu> orderedMenuNameList = createOrderedMenuNameList(order);
        HashMap<Menu, OrderVolume> rawOrderedMenuTotal = createOrderedMenuTotal(order).orderedMenuTotal();

        int orderedDessertVolume = 0;
        for (Menu menu : orderedMenuNameList) {
            if (menu.getCategory().equals(category)) {
                orderedDessertVolume += rawOrderedMenuTotal.get(menu).volume();
            }
        }

        return new OrderVolume(orderedDessertVolume);
    }

    public OrderVolume calculateTotalOrderVolume(Order order) {
        List<Menu> orderedMenuNameList = createOrderedMenuNameList(order);
        HashMap<Menu, OrderVolume> rawOrderedMenuTotal = createOrderedMenuTotal(order).orderedMenuTotal();

        int orderedDessertVolume = 0;
        for (Menu menu : orderedMenuNameList) {
            orderedDessertVolume += rawOrderedMenuTotal.get(menu).volume();
        }
        System.out.println(orderedDessertVolume);

        return new OrderVolume(orderedDessertVolume);
    }
}
