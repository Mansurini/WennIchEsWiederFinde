package net.htlgrieskirchen.pos3.streams;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class main {
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



}
