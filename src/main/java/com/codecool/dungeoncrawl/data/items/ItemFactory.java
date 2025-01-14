package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Healers.Crown;
import com.codecool.dungeoncrawl.data.items.Healers.Helmet;
import com.codecool.dungeoncrawl.data.items.Healers.Shield;
import com.codecool.dungeoncrawl.data.items.attacking.BigSword;
import com.codecool.dungeoncrawl.data.items.attacking.Mace;
import com.codecool.dungeoncrawl.data.items.shopkeeper.Bomb;
import com.codecool.dungeoncrawl.data.items.shopkeeper.Necklace;
import com.codecool.dungeoncrawl.data.items.shopkeeper.SuperPotion;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ItemFactory {

    private static final Map<String, Function<Cell, Item>> itemMap = new HashMap<>();

    static {
        itemMap.put("key", Key::new);
        itemMap.put("superSword", BigSword::new);
        itemMap.put("mace", Mace::new);
        itemMap.put("helmet", Helmet::new);
        itemMap.put("shield", Shield::new);
        itemMap.put("crown", Crown::new);
        itemMap.put("1000 gold", Money::new);
        itemMap.put("bomb press K to use", Bomb::new);
        itemMap.put("necklace press N to use", Necklace::new);
        itemMap.put("superPotion", SuperPotion::new);


    }

    public static Item createItem(String itemName, Cell cell) {
        if (itemMap.containsKey(itemName)) {
            return itemMap.get(itemName).apply(cell);
        }
        throw new IllegalArgumentException("Unknown item: " + itemName);
    }

}
