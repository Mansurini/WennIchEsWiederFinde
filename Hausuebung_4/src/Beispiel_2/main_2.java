package Beispiel_2;

import Beispiel_1.MyThread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main_2 {
    static int summe = 0;
    public static void main(String[] args) {
        List<Integer> allNumbers = bisNumber();
        List<List<Integer>> chunks = turntToChunks(allNumbers);


        MyThread2 m = treadsErstellen(chunks);

        while(m.needWait){
            try {
                m.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(summe);

    }

    public static List<Integer> bisNumber()
    {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zahlen zusammenzaehlen bis: ");
        int bis = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i<=bis ; i++)
        {
            list.add(i);
        }

        return list;
    }

    static MyThread2 n = null;
    public static MyThread2 treadsErstellen(List<List<Integer>> allChunks)
    {
        allChunks.forEach(chunk -> {
            n = new MyThread2(chunk);
            n.run();
        });

        return n;


    }

    public static ArrayList<List<Integer>> turntToChunks(List<Integer> allNumbers)
    {
        ArrayList<List<Integer>> allChunks = new ArrayList<>();
        List<Integer> chunk = new ArrayList<>();
        int chunksize = 100;
        int addchunk = chunksize;

        for (int i = 0; i < allNumbers.size(); i++)
        {
            if (i < chunksize)
            {
                chunk.add(allNumbers.get(i));
            }else{
                chunk
            .add(allNumbers.get(i));
                allChunks.add(chunk);
                chunk = new ArrayList<>();
                chunksize += addchunk;
            }
        }
        allChunks.add(chunk);

        return allChunks;
    }

    public static void addsum(int add){
        summe =+ add;
    }
}
