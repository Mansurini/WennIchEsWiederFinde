package net.htlgrieskirchen.pos3.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    static Weapon smallestDamage = null;
    static Weapon highestStrength = null;
    static Weapon longestName = null;
    static int sumValue = 0;
    static long sumHash = 0L;

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
        if (weapons.size() == 0)
            return null;
        if (weapons.size() < 2)
            return weapons.get(0);
        smallestDamage = null;
        smallestDamage = weapons.get(0);
        Stream<Weapon> s = weapons.stream();
        s.forEach((Weapon w) -> {
            if(smallestDamage.getDamage() > w.getDamage()) {
                smallestDamage = w;}});
        return smallestDamage;
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        if (weapons.size() == 0)
            return null;
        if (weapons.size() < 2)
        return weapons.get(0);

        highestStrength = weapons.get(0);
        Stream<Weapon> s = weapons.stream();
        s.forEach((Weapon w) -> {
            if(w != null && highestStrength.getMinStrength() < w.getMinStrength()) {
                highestStrength = w;}});
        return highestStrength;
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        List<Weapon> missilelist = new ArrayList<>();
        Stream<Weapon> s = weapons.stream();
        s.forEach((Weapon w) -> {
            if(w.getDamageType().equals(DamageType.MISSILE)) {
                missilelist.add(w);}});
        return missilelist;
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        if (weapons.size() == 0)
            return null;
        if (weapons.size() < 2)
            return weapons.get(0);
        longestName = weapons.get(0);
        Stream<Weapon> s = weapons.stream();
        s.forEach(w -> {
            if(w != null && w.getName() != null && longestName.getName().length() < w.getName().length()) {
                longestName = w;
            }});
        return longestName;
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        List<String> names = new ArrayList<>();
        weapons.forEach(weapon -> names.add(weapon.getName()));
        return names;
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
        int[] speeds = new int[weapons.size()];
        for (int i = 0; i < speeds.length; i++) {
            speeds[i] = weapons.get(i).getSpeed();
        }
        return speeds;
    }
    
    public int sumUpValues(List<Weapon> weapons) {
        sumValue = 0;
        weapons.forEach(weapon -> sumValue = sumValue + weapon.getValue());
        return sumValue;
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        sumHash = 0L;
        weapons.forEach(weapon -> sumHash = sumHash + weapon.hashCode());
        return sumHash;
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        List<Weapon> noDubikates = new ArrayList<>();
        weapons.forEach(weapon -> {
            if(noDubikates.contains(weapon) != true)
                noDubikates.add(weapon);
        });
        return noDubikates;
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.forEach(weapon -> weapon.setValue((int) (weapon.getValue()*1.1)));
    }
}
