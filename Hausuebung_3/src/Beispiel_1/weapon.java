package Beispiel_1;

public class weapon {
    private String name;
    private combatTypes combatType;
    private damageTypes damageType;
    private int damage;
    private int speed;
    private int strength;
    private int value;

    public weapon(String name, combatTypes combatType, damageTypes damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public combatTypes getCombatType() {
        return combatType;
    }

    public void setCombatType(combatTypes combatType) {
        this.combatType = combatType;
    }

    public damageTypes getDamageType() {
        return damageType;
    }

    public void setDamageType(damageTypes damageType) {
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
