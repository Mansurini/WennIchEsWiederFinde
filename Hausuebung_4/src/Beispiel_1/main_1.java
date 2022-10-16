package Beispiel_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main_1 {

    public static void main(String[] args) {
        List<Integer> allNumbers = numbersEinlesen();
        List<List<Integer>> chunks = turntToChunks(allNumbers);
        treadsErstellen(chunks);
    }

    public static ArrayList<Integer> numbersEinlesen()
    {
        List<String> ungefiltert = new ArrayList<>();
        ArrayList<Integer> gefiltert = new ArrayList<>();

        try{
            List<List<String>> splitedlines = new ArrayList<>();
            Files.readAllLines(Path.of("src/Beispiel_1/numbers.csv")).forEach(line -> splitedlines.add(List.of(line.split(":"))));
            splitedlines.forEach(list -> list.forEach(string -> ungefiltert.add(string)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ungefiltert.forEach(string -> {
            if (string != null && !string.isEmpty() && string.matches("[+-]?\\d*(\\.\\d+)?"))
                gefiltert.add(Integer.valueOf(string));
        });
        return gefiltert;
    }

    public static ArrayList<List<Integer>> turntToChunks(List<Integer> allNumbers)
    {
        ArrayList<List<Integer>> allChunks = new ArrayList<>();
        List<Integer> chunk = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("size of the chunks: ");
        int chunksize = Integer.parseInt(scanner.nextLine());
        int addchunk = chunksize;

        for (int i = 0; i < allNumbers.size(); i++)
        {
            if (i < chunksize)
            {
                chunk.add(allNumbers.get(i));
            }else
            {
                chunk.add(allNumbers.get(i));
                allChunks.add(chunk);
                chunk = new ArrayList<>();
                chunksize += addchunk;
            }
        }

        return allChunks;
    }

    public static void treadsErstellen(List<List<Integer>> allChunks)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("divider: ");
        int divider = Integer.parseInt(scanner.nextLine());

        allChunks.forEach(chunk -> {
            new MyThread(chunk, divider).run();
        });
    }
}
