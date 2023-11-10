package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.order.converter.MenuConverter;
import christmas.order.menuitem.Desserts;
import christmas.order.menuitem.Drinks;
import christmas.order.menuitem.MainDishes;
import christmas.order.menuitem.Menu;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class MenuConverterTest {
    MenuConverter menuConverter = new MenuConverter();

    @Test
    public void convertInputToMenus() {
        OrderedMenuTotal orderedMenuTotalMenus = menuConverter.createOrderedMenuTotal("해산물파스타-2,레드와인-1,초코케이크-1");
        HashMap<Menu, MenuAmount> rawOrderedMenus = orderedMenuTotalMenus.orderedMenuTotal();

        assertThat(rawOrderedMenus.get(MainDishes.SEAFOOD_PASTA)).isEqualTo(new MenuAmount(2));
        assertThat(rawOrderedMenus.get(Drinks.RED_WINE)).isEqualTo(new MenuAmount(1));
        assertThat(rawOrderedMenus.get(Desserts.CHOCOLATE_CAKE)).isEqualTo(new MenuAmount(1));
    }
}