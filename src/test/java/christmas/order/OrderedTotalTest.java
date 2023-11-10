package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.order.menuitem.Appetizers;
import christmas.order.menuitem.Desserts;
import christmas.order.menuitem.Drinks;
import christmas.order.menuitem.MainDishes;
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

    @Test
    public void calculateTotalOrderCost() {
        assertThat(orderedTotal.calculateTotalOrderAmount()).isEqualTo(new OrderAmount(241000));
    }
}