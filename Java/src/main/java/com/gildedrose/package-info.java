/**
 * The com.gildedrose package contains the core classes for the Gilded Rose
 * inventory management system.
 * <p>
 * Main classes:
 * <ul>
 * <li>{@link com.gildedrose.GildedRose} - Inventory manager using the strategy
 * pattern for item updates.</li>
 * <li>{@link com.gildedrose.Item} - Represents an item in the inventory, with
 * encapsulated fields and validation.</li>
 * <li>{@link com.gildedrose.UpdateStrategy} - Interface for item update
 * strategies.</li>
 * <li>{@link com.gildedrose.NormalItemStrategy},
 * {@link com.gildedrose.AgedBrieStrategy},
 * {@link com.gildedrose.BackstagePassStrategy},
 * {@link com.gildedrose.SulfurasStrategy} - Implementations for each item
 * type.</li>
 * <li>{@link com.gildedrose.ItemType} - Enum for item types, mapping names to
 * types.</li>
 * </ul>
 * <p>
 * This package demonstrates clean code, refactoring, and design patterns in
 * Java.
 */
package com.gildedrose;