package net.htlgrieskirchen.pos3.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class main {
    static Stream<Weapon> unsortedWeapons = new ArrayList<Weapon>().stream();
    static Stream sortedWeapons = null;

    public static void main(String[] args) {       //Hab die tests bei Streamtest hinzugefügt
        int[] zufallszahlen = randomIntList();
        Streams streams = new Streams();
        System.out.println(streams.average(zufallszahlen));

        String[] randomStrings = randomStringList();
        List<String> list = streams.upperCase(randomStrings);
        System.out.println();
        list.forEach(System.out::println);
    }

    public static int[] randomIntList()
    {

        int[] zufallszahlen = new int[10000];
        for (int i = 0; i < zufallszahlen.length; i++) {
            Random zufall = new Random();
            zufallszahlen[i] = zufall.nextInt(100);
        }

        return zufallszahlen;
    }

    public static String[] randomStringList()
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int StringLength = 10;
        Random random = new Random();

        String[] strings = new String[10];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = random.ints(leftLimit, rightLimit + 1)
                    .limit(StringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }

        Arrays.stream(strings).forEach(System.out::println);

        return strings;
    }


    static void sortierenNachDamage()
    {
        sortedWeapons = unsortedWeapons.sorted();
    }

    static void sortierenNachCombatType()
    {
        sortedWeapons = unsortedWeapons.sorted((Weapon a, Weapon b) -> String.valueOf(a.getCombatType()).compareTo(String.valueOf(b.getCombatType())));
    }

    static void sortierenNachDamageType()
    {
        sortedWeapons = unsortedWeapons.sorted((Weapon a, Weapon b) -> String.valueOf(a.getDamageType()).compareTo(String.valueOf(b.getDamageType())));

    }

    static void sortierenNachName()
    {
        sortedWeapons = unsortedWeapons.sorted((Weapon a, Weapon b) -> a.getName().compareTo(b.getName()));
    }

    public static void einlesen()
    {
        try {
            List<Weapon> w = new ArrayList<>();
            Files.readAllLines(Path.of("src/Beispiel_1/weapons.csv")).forEach((String a) -> w.add(Weapon.deserilize(a)));

            unsortedWeapons = w.stream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static Printable setupPrintMethod()
    {
        Printable p = (List<Weapon> weapons) -> {weapons.forEach(System.out::println);};

        return p;
    }

    public static Printable setupPrintMethodTabelle()
    {
        Printable p = (List<Weapon> weapons) -> {

            weapons.forEach((Weapon w) -> {

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

                System.out.print("\t|" + w.getSpeed() + "\t|" + w.getMinStrength() + "\t|" + w.getValue());

                System.out.println();
                System.out.println("--------------------+-------+-----------+---+---+---+------");

            });

        };

        return p;
    }

}


