package com.NindyBun.watercanteens.items;

public enum CanteenTiers {
    LEATHER(6),
    COPPER(12),
    IRON(12),
    GOLD(36),
    DIAMOND(48),
    NETHERITE(64),
    DRAGON(64, 2),
    ;

    private final int maxUses;
    private final int purity;

    CanteenTiers(int maxUses) {
        this.maxUses = maxUses;
        this.purity = 0;
    }

    CanteenTiers(int maxUses, int purity) {
        this.maxUses = maxUses;
        this.purity = purity;
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public int getPurity() {
        return this.purity;
    }
}
