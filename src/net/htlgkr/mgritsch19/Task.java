/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch19;

import java.util.List;

/**
 *
 * @author maxim
 */
public class Task implements Runnable {

    private List<Integer> list;
    int teiler;

    public Task(List l, int teiler) {
        this.list = l;
        this.teiler = teiler;
    }

    @Override
    public void run() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % teiler == 0) {
                System.out.println(list.get(i));
            }

        }
    }

}
