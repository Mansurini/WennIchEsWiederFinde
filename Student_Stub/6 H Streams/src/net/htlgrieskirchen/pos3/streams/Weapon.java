package net.htlgrieskirchen.pos3.streams;

import java.util.Objects;

public class Weapon implements Comparable<Weapon>{
    
    private final String name;
    private final CombatType combatType;
    private final DamageType damageType;
    private final int damage;
    private final int speed;
    private final int minStrength;
    private int value;

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int minStrength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.minStrength = minStrength;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return damage == weapon.damage && speed == weapon.speed && minStrength == weapon.minStrength && value == weapon.value && Objects.equals(name, weapon.name) && combatType == weapon.combatType && damageType == weapon.damageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, combatType, damageType, damage, speed, minStrength, value);
    }

    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", combatType=" + combatType + ", damageType=" + damageType + ", damage=" + damage + ", speed=" + speed + ", minStrength=" + minStrength + ", value=" + value + '}';
    }

    @Override
    public int compareTo(Weapon o) {
        return  o.damage - damage;
    }

    static public Weapon deserilize(String line)
    {
        String[] geteilt = line.split(";");
        return new Weapon(geteilt[0], CombatType.valueOf(geteilt[1]), DamageType.valueOf(geteilt[2]), Integer.parseInt(geteilt[3]), Integer.parseInt(geteilt[4]), Integer.parseInt(geteilt[5]), Integer.parseInt(geteilt[6]));
    }

}
