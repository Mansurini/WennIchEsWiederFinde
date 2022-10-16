package Beispiel_2;

import java.util.List;

public class MyThread2 implements Runnable{

    List<Integer> summeBis;
    int summe;
    public boolean needWait;

    MyThread2(List<Integer> summeBis)
    {
        needWait = true;
        this.summeBis = summeBis;
    }

    @Override
    public void run() {
        summe = summeBis.stream().reduce(0, (a, b) -> a+b);
        main_2.addsum(summe);

        synchronized (this) {
            this.needWait = false;
            this.notify();
        }
    }
}
