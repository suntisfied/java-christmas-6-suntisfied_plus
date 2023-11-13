package christmas.order.converter;

import christmas.order.menu.Menu;
import java.util.HashMap;
import java.util.Map;

public class MenuTableCreator {
    MenuTable createMenuTable() {
        Map<String, Menu> menuTable = new HashMap<>();
        menuTable.put(Menu.MUSHROOM_CREAM_SOUP.getName(), Menu.MUSHROOM_CREAM_SOUP);
        menuTable.put(Menu.TAPAS.getName(), Menu.TAPAS);
        menuTable.put(Menu.CAESAR_SALAD.getName(), Menu.CAESAR_SALAD);
        menuTable.put(Menu.T_BONE_STEAK.getName(), Menu.T_BONE_STEAK);
        menuTable.put(Menu.BARBECUE_RIBS.getName(), Menu.BARBECUE_RIBS);
        menuTable.put(Menu.SEAFOOD_PASTA.getName(), Menu.SEAFOOD_PASTA);
        menuTable.put(Menu.CHRISTMAS_PASTA.getName(), Menu.CHRISTMAS_PASTA);
        menuTable.put(Menu.CHOCOLATE_CAKE.getName(), Menu.CHOCOLATE_CAKE);
        menuTable.put(Menu.ICE_CREAM.getName(), Menu.ICE_CREAM);
        menuTable.put(Menu.ZERO_COLA.getName(), Menu.ZERO_COLA);
        menuTable.put(Menu.RED_WINE.getName(), Menu.RED_WINE);
        menuTable.put(Menu.CHAMPAGNE.getName(), Menu.CHAMPAGNE);
        return new MenuTable(menuTable);
    }
}
