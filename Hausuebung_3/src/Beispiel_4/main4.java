package Beispiel_4;

import java.io.FilterOutputStream;
import java.util.stream.IntStream;

public class main4 {
    final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(i -> i%2 > 0).map(i -> i*i).reduce(0,(a, b) -> a + b);

    public static void main(String[] args) {
        main4 m = new main4();
        System.out.println(m.result);
    }}
