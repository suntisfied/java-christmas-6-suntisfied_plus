package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.order.converter.Converter;
import christmas.order.menu.Desserts;
import christmas.order.menu.Drinks;
import christmas.order.menu.MainDishes;
import christmas.order.menu.Menu;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class ConverterTest {
    Converter converter = new Converter();

    @Test
    public void convertInputToMenus() {
        OrderedMenuTotal orderedMenuTotalMenus = converter.createOrderedMenuTotal("해산물파스타-2,레드와인-1,초코케이크-1");
        HashMap<Menu, OrderAmount> rawOrderedMenus = orderedMenuTotalMenus.orderedMenuTotal();

        assertThat(rawOrderedMenus.get(MainDishes.SEAFOOD_PASTA)).isEqualTo(new OrderAmount(2));
        assertThat(rawOrderedMenus.get(Drinks.RED_WINE)).isEqualTo(new OrderAmount(1));
        assertThat(rawOrderedMenus.get(Desserts.CHOCOLATE_CAKE)).isEqualTo(new OrderAmount(1));
    }
}