package net.lomeli.power.lib;

public class ArmorType {
    String unlocalized, texture;
    int durability, defense;

    public ArmorType(String unlocalized, String texture, int durability, int defense) {
        this.unlocalized = unlocalized;
        this.texture = texture;
        this.durability = durability;
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public String getTexture() {
        return texture;
    }

    public String getUnlocalized() {
        return unlocalized;
    }
}
