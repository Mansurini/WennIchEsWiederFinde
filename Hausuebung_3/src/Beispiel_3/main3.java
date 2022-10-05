package Beispiel_3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class main3 {
    public static void main(String[] args) {
        final Predicate<Integer> isEven = (Integer i) -> {
            if (i == null)
                return false;
            if (i%2 == 0)
                return true;
        return false;};

        final IntPredicate isPositive = (int i) -> {
            if (i > 0)
                return true;
            return false;
                };

        Predicate<String> isShortWord = (String s) -> {
            if (s.length() < 4)
                return true;
            return false;
        };

        Predicate<Integer> isEvenAndPositive = isEven.and(integer -> isPositive.test(integer));
        Predicate<Integer> isntEvenAndPositive = isEven.negate().and(integer -> isPositive.test(integer));


    }
}
