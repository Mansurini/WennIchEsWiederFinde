package Beispiel_3;

import java.util.ArrayList;
import java.util.List;

public class JavaStreamsTester {
    static int leereAnzahl;
    static int dreiLengthAnzahl;
    static String merged;
    static int max;
    static int min;
    static int sum;

    public static void main(String[] args) {
           List<String> strings = new ArrayList<>();
           strings.add("sdf");
           strings.add("srtht");
           strings.add("");
           strings.add("erhastg");

           List<Integer> numbers = new ArrayList<>();
           numbers.add(1);
           numbers.add(2);
           numbers.add(3);
           numbers.add(4);

           System.out.println(getCountEmptyString(strings));
           System.out.println(getCountLength3(strings));
           deleteEmptyStrings(strings).forEach(System.out::println);
           System.out.println(getMergedString(strings, "|"));
           getSquares(numbers).forEach(System.out::println);
           System.out.println(getMax(numbers));
           System.out.println(getMin(numbers));
           System.out.println(getSum(numbers));
           System.out.println(getAverage(numbers));

    }




    private static int getCountEmptyString(List<String> strings) {
        leereAnzahl = 0;
        strings.forEach(str -> {
            if (str == null || strings.equals(""))
            leereAnzahl++;
        });
        return leereAnzahl;
    }

    private static int getCountLength3(List<String> strings) {
        dreiLengthAnzahl = 0;
        strings.forEach(str -> {
            if (str.length() == 3)
                dreiLengthAnzahl++;
        });
        return dreiLengthAnzahl;
    }

    private static List<String> deleteEmptyStrings(List<String> strings) {
        List<String> l = new ArrayList<>();
        strings.forEach(str -> {
            if (str != null && !str.equals(""))
                l.add(str);
        });
        return  l;
    }

    private static String getMergedString(List<String> strings, String separator) {
        merged = "";
        strings.forEach(str -> merged = merged + str + separator);
        return merged;
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> quad = new ArrayList<>();
        numbers.forEach(integer -> quad.add(integer*integer));
        return quad;
    }

    private static int getMax(List<Integer> numbers) {
        max = 0;
        numbers.forEach(integer -> {
            if (integer>max)
                max = integer;
        });
        return max;
    }

    private static int getMin(List<Integer> numbers) {
        min = 999999999;
        numbers.forEach(integer -> {
            if (integer<min)
                min = integer;
        });
        return min;
    }

    private static int getSum(List<Integer> numbers) {
        sum = 0;
        numbers.forEach(integer -> sum = sum + integer);
        return sum;
    }

    private static int getAverage(List<Integer> numbers) {
        int su = getSum(numbers);

        return su / numbers.size();
    }
}
