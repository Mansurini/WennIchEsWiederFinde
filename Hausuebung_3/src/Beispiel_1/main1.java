package Beispiel_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class main1 {
    static Stream<weapon> unsortedWeapons = new ArrayList<weapon>().stream();
    static Stream sortedWeapons = null;

    public static void main(String[] args) {
        Printable printable = setupPrintMethod();
        Printable printableTabelle = setupPrintMethodTabelle();
        einlesen();
        sortierenNachDamage();
        sortierenNachCombatType();
        sortierenNachDamageType();
        sortierenNachName();

        List<weapon> list = sortedWeapons.toList();

        printable.print(list);
        System.out.println();
        printableTabelle.print(list);
    }



    static void sortierenNachDamage()
    {
        sortedWeapons = unsortedWeapons.sorted();
    }

    static void sortierenNachCombatType()
    {
        sortedWeapons = unsortedWeapons.sorted((weapon a, weapon b) -> String.valueOf(a.getCombatType()).compareTo(String.valueOf(b.getCombatType())));
    }

    static void sortierenNachDamageType()
    {
        sortedWeapons = unsortedWeapons.sorted((weapon a, weapon b) -> String.valueOf(a.getDamageType()).compareTo(String.valueOf(b.getDamageType())));

    }

    static void sortierenNachName()
    {
        sortedWeapons = unsortedWeapons.sorted((weapon a, weapon b) -> a.getName().compareTo(b.getName()));
    }

    public static void einlesen()
    {
        try {
            List<weapon> w = new ArrayList<>();
            Files.readAllLines(Path.of("src/Beispiel_1/weapons.csv")).forEach((String a) -> w.add(weapon.deserilize(a)));

            unsortedWeapons = w.stream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static Printable setupPrintMethod()
    {
        Printable p = (List<weapon> weapons) -> {weapons.forEach(System.out::println);};

        return p;
    }

    public static Printable setupPrintMethodTabelle()
    {
        Printable p = (List<weapon> weapons) -> {

            weapons.forEach((weapon w) -> {

                if(w.getName().length() < 8)
                {
                    System.out.print( w.getName() + "\t\t\t\t|" + w.getCombatType() );
                } else if (w.getName().length() < 12) {
                    System.out.print( w.getName() + "\t\t\t|" + w.getCombatType() );
                }else if (w.getName().length() < 16)
                {
                    System.out.print(w.getName() + "\t\t|" + w.getCombatType() );
                }else {
                    System.out.print(w.getName() + "\t|" + w.getCombatType());
                }

                System.out.print("\t|" + w.getDamageType());

                if (String.valueOf(w.getDamageType()).length() < 7)
                    System.out.print("\t\t|" + w.getDamage());
                else
                    System.out.print( "\t|" + w.getDamage());

                System.out.print("\t|" + w.getSpeed() + "\t|" + w.getStrength() + "\t|" + w.getValue());

                System.out.println();
                System.out.println("--------------------+-------+-----------+---+---+---+------");

            });

        };

        return p;
    }

}
