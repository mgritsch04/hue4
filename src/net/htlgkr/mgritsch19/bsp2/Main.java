/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch19.bsp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxim
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte Obergrenze eingeben.");
        int obergrenze = Integer.parseInt(sc.nextLine());

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        int sum = 0;
        List<Integer> listSum = new ArrayList<>();
        for (int i = 1; i < obergrenze; i += 100) {
            Task t = null;
            if (i + 100 < obergrenze) {
                t = new Task(i, i + 100);
                System.out.print("Summe der Zahlen " + i + " - " + (i + 100) + ": ");
            } else {
                int remainingNumbers = obergrenze - i + 1;
                t = new Task(i, i + remainingNumbers);
                System.out.print("Summe der Zahlen " + i + " - " + (i + remainingNumbers) + ": ");
            }
            Future<Integer> submit = executor.submit(t);
            try {
                int erg = submit.get().intValue();
                sum += erg;
                System.out.print(erg);
                System.out.println("");
                listSum.add(sum);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.print("Gesamtsumme: " + sum);

        System.out.println("");
        System.out.println("Summe laut gaußsche Summenformel: " + (((obergrenze * obergrenze) + obergrenze) / 2));
        executor.shutdown();
    }
}
