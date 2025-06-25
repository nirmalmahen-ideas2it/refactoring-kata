package com.gildedrose;

/**
 * Enum representing item types in the Gilded Rose inventory.
 */
public enum ItemType {
    NORMAL,
    AGED_BRIE,
    BACKSTAGE_PASS,
    SULFURAS;

    /**
     * Maps an item name to its ItemType.
     * 
     * @param name the item name
     * @return the ItemType
     */
    public static ItemType fromName(String name) {
        if ("Aged Brie".equals(name)) {
            return AGED_BRIE;
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(name)) {
            return BACKSTAGE_PASS;
        } else if ("Sulfuras, Hand of Ragnaros".equals(name)) {
            return SULFURAS;
        } else {
            return NORMAL;
        }
    }
}