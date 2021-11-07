/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch19.bsp2;

import java.util.concurrent.Callable;

/**
 *
 * @author maxim
 */
public class Task implements Callable<Integer> {

    private int untergrenze;
    private int obergrenze;

    public Task(int untergrenze, int obergrenze) {
        this.untergrenze = untergrenze;
        this.obergrenze = obergrenze;
    }

    @Override
    public Integer call() {

        int erg = 0;
        for (int i = untergrenze; i < obergrenze; i++) {
            erg += i;
        }

        return erg;
    }

}
