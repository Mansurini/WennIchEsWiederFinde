package Beispiel_1;

import java.util.Objects;

public class weapon implements Comparable<weapon> {
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

    @Override
    public String toString() {
        if(name.length() < 8)
        {return name + "\t\t\t\tDamagetype = " + damageType ;
        } else if (name.length() < 12) {
            return name + "\t\t\tDamagetype = " + damageType ;
        }else if (name.length() < 16)
        {
            return name + "\t\tDamagetype = " + damageType ;
        }else {
            return name + "\tDamagetype = " + damageType ;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        weapon weapon = (weapon) o;
        return damage == weapon.damage && speed == weapon.speed && strength == weapon.strength && value == weapon.value && Objects.equals(name, weapon.name) && combatType == weapon.combatType && damageType == weapon.damageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, combatType, damageType, damage, speed, strength, value);
    }
    @Override
    public int compareTo(weapon o) {
        return  o.damage - damage;
    }

    static public weapon deserilize(String line)
    {
        String[] geteilt = line.split(";");
        return new weapon(geteilt[0], combatTypes.valueOf(geteilt[1]), damageTypes.valueOf(geteilt[2]), Integer.parseInt(geteilt[3]), Integer.parseInt(geteilt[4]), Integer.parseInt(geteilt[5]), Integer.parseInt(geteilt[6]));
    }
}
