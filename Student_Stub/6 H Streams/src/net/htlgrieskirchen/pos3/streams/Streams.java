package net.htlgrieskirchen.pos3.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Streams {

    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().getAsDouble();
    }
    
    public List<String> upperCase(String[] strings) {
        List<String> l = Arrays.stream(strings).toList();
        List<String> uperl = new ArrayList<>();
        l.forEach((String string) -> uperl.add(string.toUpperCase()));
        return uperl;
    }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return null;
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return null;
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return null;
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return null;
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        return null;
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
        return null;
    }
    
    public int sumUpValues(List<Weapon> weapons) {
        return 0;
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        return 0;
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return null;
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {

    }
}
