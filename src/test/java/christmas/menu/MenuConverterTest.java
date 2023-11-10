package christmas.menu;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MenuConverterTest {
    MenuConverter menuConverter = new MenuConverter();

    @Test
    public void convertInputToMenu() {
        assertThat(menuConverter.convertInputToMenu("티본스테이크")).isEqualTo(MainDishes.T_BONE_STEAK);
    }

    @Test
    public void convertInputsToMenus() {
        assertThat(menuConverter.createOrderedMenus("티본스테이크,시저샐러드,아이스크림,레드와인"))
                .isEqualTo(new Ordered(Arrays.asList(
                        MainDishes.T_BONE_STEAK,
                        Appetizers.CAESAR_SALAD,
                        Desserts.ICE_CREAM,
                        Drinks.RED_WINE)));
    }
}