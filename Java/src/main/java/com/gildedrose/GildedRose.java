package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

/**
 * The GildedRose class manages the inventory and updates item quality using
 * strategies.
 */
public class GildedRose {
    private Item[] items;
    private Map<ItemType, UpdateStrategy> strategies;

    public GildedRose(Item[] items) {
        this.items = items;
        this.strategies = new HashMap<>();
        strategies.put(ItemType.AGED_BRIE, new AgedBrieStrategy());
        strategies.put(ItemType.BACKSTAGE_PASS, new BackstagePassStrategy());
        strategies.put(ItemType.SULFURAS, new SulfurasStrategy());
        // Default strategy for normal items is handled below
    }

    /**
     * Updates the quality of all items in the inventory.
     */
    public void updateQuality() {
        for (Item item : items) {
            ItemType type = ItemType.fromName(item.getName());
            UpdateStrategy strategy = strategies.getOrDefault(type, new NormalItemStrategy());
            strategy.update(item);
        }
    }
}
