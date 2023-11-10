package christmas.order.converter;

import christmas.order.menuitem.Appetizers;
import christmas.order.menuitem.Desserts;
import christmas.order.menuitem.Drinks;
import christmas.order.menuitem.MainDishes;
import christmas.order.menuitem.Menu;
import christmas.order.MenuTable;
import java.util.HashMap;

public class MenuTableCreator {
    MenuTable createMenuTable() {
        HashMap<String, Menu> menuTable = new HashMap<>();

        menuTable.put("양송이수프", Appetizers.MUSHROOM_CREAM_SOUP);
        menuTable.put("타바스", Appetizers.TAPAS);
        menuTable.put("시저샐러드", Appetizers.CAESAR_SALAD);
        menuTable.put("티본스테이크", MainDishes.T_BONE_STEAK);
        menuTable.put("바비큐립", MainDishes.BARBECUE_RIBS);
        menuTable.put("해산물파스타", MainDishes.SEAFOOD_PASTA);
        menuTable.put("크리스마스파스타", MainDishes.CHRISTMAS_PASTA);
        menuTable.put("초코케이크", Desserts.CHOCOLATE_CAKE);
        menuTable.put("아이스크림", Desserts.ICE_CREAM);
        menuTable.put("제로콜라", Drinks.ZERO_COLA);
        menuTable.put("레드와인", Drinks.RED_WINE);
        menuTable.put("샴페인", Drinks.CHAMPAGNE);

        return new MenuTable(menuTable);
    }
}
