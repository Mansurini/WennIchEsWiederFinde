package Beispiel_1;

import java.util.List;

public class MyThread implements Runnable{
    List<Integer> chunk;
    int teilen;

    MyThread(List<Integer> chunk, int teilen)
    {
        this.chunk = chunk;
        this.teilen = teilen;
    }

    @Override
    public void run() {
        chunk.forEach(number -> {
            if (number != 0 && number%teilen == 0)
                System.out.println(number);
        });
    }
}
