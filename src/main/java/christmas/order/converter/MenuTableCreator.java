package christmas.order.converter;

import christmas.order.menu.Menu;
import java.util.HashMap;

public class MenuTableCreator {
    MenuTable createMenuTable() {
        HashMap<String, Menu> menuTable = new HashMap<>();

        menuTable.put("양송이수프", Menu.MUSHROOM_CREAM_SOUP);
        menuTable.put("타바스", Menu.TAPAS);
        menuTable.put("시저샐러드", Menu.CAESAR_SALAD);
        menuTable.put("티본스테이크", Menu.T_BONE_STEAK);
        menuTable.put("바비큐립", Menu.BARBECUE_RIBS);
        menuTable.put("해산물파스타", Menu.SEAFOOD_PASTA);
        menuTable.put("크리스마스파스타", Menu.CHRISTMAS_PASTA);
        menuTable.put("초코케이크", Menu.CHOCOLATE_CAKE);
        menuTable.put("아이스크림", Menu.ICE_CREAM);
        menuTable.put("제로콜라", Menu.ZERO_COLA);
        menuTable.put("레드와인", Menu.RED_WINE);
        menuTable.put("샴페인", Menu.CHAMPAGNE);

        return new MenuTable(menuTable);
    }
}
