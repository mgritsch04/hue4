/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch19;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author maxim
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();

        Files.lines(new File("numbers.csv").toPath()).forEach(line -> Arrays.stream(line.split(":")).forEach(s -> {
            try {
                list.add(Integer.parseInt(s));
            } catch (Exception e) {
            }
        }));

        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte teiler eingeben:");
        int teiler = Integer.parseInt(sc.nextLine());

        System.out.println("In wie viele Teile soll die Liste zur berechnung geteilt werden?");
        int anzahlTeile = Integer.parseInt(sc.nextLine());
        int lengthOneList = list.size() / anzahlTeile;

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        int index = 0;

        while (index < list.size()) {
            Task task = new Task(list.subList(index, Math.min((int) (index + anzahlTeile), list.size())), teiler);
            executor.execute(task);
            if (index + lengthOneList > list.size()) {
                index += list.size() - index;
            } else {
                index += lengthOneList;
            }
        }
        executor.shutdown();
    }
}
