package Beispiel_1;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class main1Test {


    @Test
    void sortierenDamage() {
        main1.einlesen();
        main1.sortierenNachDamage();
        Stream mainsorted = main1.sortedWeapons;
        Stream testsorted = main1.unsortedWeapons.sorted();

        assertArrayEquals(mainsorted.toArray(), testsorted.toArray());
    }

    @Test
    void sortierenCombatType() {
        main1.einlesen();
        main1.sortierenNachCombatType();
        Stream mainsorted = main1.sortedWeapons;
        Stream testsorted = main1.unsortedWeapons.sorted((weapon a, weapon b) -> String.valueOf(a.getCombatType()).compareTo(String.valueOf(b.getCombatType())));

        assertArrayEquals(mainsorted.toArray(), testsorted.toArray());
    }

    @Test
    void sortierenDamageType() {
        main1.einlesen();
        main1.sortierenNachDamageType();
        Stream mainsorted = main1.sortedWeapons;
        Stream testsorted = main1.unsortedWeapons.sorted((weapon a, weapon b) -> String.valueOf(a.getDamageType()).compareTo(String.valueOf(b.getDamageType())));

        assertArrayEquals(mainsorted.toArray(), testsorted.toArray());
    }

    @Test
    void sortierenName() {
        main1.einlesen();
        main1.sortierenNachName();
        Stream mainsorted = main1.sortedWeapons;
        Stream testsorted = main1.unsortedWeapons.sorted((weapon a, weapon b) -> a.getName().compareTo(b.getName()));

        assertArrayEquals(mainsorted.toArray(), testsorted.toArray());
    }
}