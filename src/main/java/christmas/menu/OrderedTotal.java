package christmas.menu;

import christmas.menu.converter.MenuConverter;

public class OrderedTotal {
    private final OrderedMenuTotal orderedMenuTotal;

    public OrderedTotal(String input) {
        this.orderedMenuTotal = new MenuConverter().createOrderedMenuTotal(input);
    }

    public OrderedMenus produceOrderedMenu() {
        return new OrderedMenus(orderedMenuTotal.orderedMenuTotal().keySet().stream().toList());
    }
}
