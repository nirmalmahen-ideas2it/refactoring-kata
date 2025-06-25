package com.gildedrose;

/**
 * Represents an item in the Gilded Rose inventory.
 */
public class Item {
    private String name;
    private int sellIn;
    private int quality;

    /**
     * Constructs an Item with the specified name, sellIn, and quality.
     * 
     * @param name    the name of the item
     * @param sellIn  the number of days to sell the item (must be >= 0)
     * @param quality the quality of the item (must be between 0 and 50)
     * @throws IllegalArgumentException if sellIn or quality are out of bounds
     */
    public Item(String name, int sellIn, int quality) {
        if (sellIn < 0) {
            throw new IllegalArgumentException("sellIn must be >= 0");
        }
        if (quality < 0 || quality > 50) {
            throw new IllegalArgumentException("quality must be between 0 and 50");
        }
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    /**
     * Gets the name of the item.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the sellIn value.
     * 
     * @return the sellIn
     */
    public int getSellIn() {
        return sellIn;
    }

    /**
     * Sets the sellIn value.
     * 
     * @param sellIn the new sellIn value (must be >= 0)
     * @throws IllegalArgumentException if sellIn is negative
     */
    public void setSellIn(int sellIn) {
        if (sellIn < 0) {
            throw new IllegalArgumentException("sellIn must be >= 0");
        }
        this.sellIn = sellIn;
    }

    /**
     * Gets the quality value.
     * 
     * @return the quality
     */
    public int getQuality() {
        return quality;
    }

    /**
     * Sets the quality value.
     * 
     * @param quality the new quality value (must be between 0 and 50)
     * @throws IllegalArgumentException if quality is out of bounds
     */
    public void setQuality(int quality) {
        if (quality < 0 || quality > 50) {
            throw new IllegalArgumentException("quality must be between 0 and 50");
        }
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
