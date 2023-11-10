package christmas.menu;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.menu.menuitem.Appetizers;
import christmas.menu.menuitem.Desserts;
import christmas.menu.menuitem.Drinks;
import christmas.menu.menuitem.MainDishes;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class OrderedTotalTest {
    String input = "티본스테이크-2,양송이수프-1,아이스크림-1,레드와인-2";
    OrderedTotal orderedTotal = new OrderedTotal(input);

    @Test
    public void produceOrderedItemList() {
        assertThat(orderedTotal.produceOrderedMenu().orderedMenus())
                .containsExactlyInAnyOrderElementsOf(new OrderedMenus(Arrays.asList(
                        MainDishes.T_BONE_STEAK,
                        Appetizers.MUSHROOM_CREAM_SOUP,
                        Desserts.ICE_CREAM,
                        Drinks.RED_WINE)).orderedMenus());
    }
}