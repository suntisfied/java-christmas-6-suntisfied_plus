package christmas.menu;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.menu.converter.MenuConverter;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class MenuConverterTest {
    MenuConverter menuConverter = new MenuConverter();

    @Test
    public void convertInputToMenus() {
        Ordered orderedMenus = menuConverter.createOrderedMenus("해산물파스타-2,레드와인-1,초코케이크-1");
        HashMap<Menu, MenuAmount> rawOrderedMenus = orderedMenus.menus();

        assertThat(rawOrderedMenus.get(MainDishes.SEAFOOD_PASTA)).isEqualTo(new MenuAmount(2));
        assertThat(rawOrderedMenus.get(Drinks.RED_WINE)).isEqualTo(new MenuAmount(1));
        assertThat(rawOrderedMenus.get(Desserts.CHOCOLATE_CAKE)).isEqualTo(new MenuAmount(1));
    }
}