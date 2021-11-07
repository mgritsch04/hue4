/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch19.bsp2.bsp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author maxim
 */
public class JavaStreamsTester {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("asd");
        list.add("");
        list.add("abc");
        list.add("string");

        List<Integer> listInt = new ArrayList<>();
        listInt.add(5);
        listInt.add(1);
        listInt.add(3);
        listInt.add(4);
        listInt.add(2);

        System.out.println("getCountEmptyString -> (2): " + getCountEmptyString(list));

        System.out.println("getCountLength3 -> (2): " + getCountLength3(list));

        List<String> listnoEmptyStrings = deleteEmptyStrings(list);
        System.out.println("deleteEmptyStrings -> (0): " + getCountEmptyString(listnoEmptyStrings) + " empty Strings in new List");

        System.out.println("getMergedString -> (;asd;;abc;string): " + getMergedString(list, ";"));

        List<Integer> squares = getSquares(listInt);
        System.out.println("getSquares -> (25,1,9,16,4): " + squares);

        System.out.println("getMax -> (5): " + getMax(listInt));

        System.out.println("getMin -> (1): " + getMin(listInt));

        System.out.println("getSum -> (15): " + getSum(listInt));

        System.out.println("getAverage -> (3): " + getAverage(listInt));
    }

    private static int getCountEmptyString(List<String> strings) {
        return strings.stream().filter(string -> string.isEmpty()).collect(Collectors.toList()).size();
    }

    private static int getCountLength3(List<String> strings) {
        return strings.stream().filter(string -> string.length() == 3).collect(Collectors.toList()).size();
    }

    private static List<String> deleteEmptyStrings(List<String> strings) {
        return strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String separator) {
        return strings.stream().collect(Collectors.joining(separator));
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        return numbers.stream().map(i -> (int) Math.pow(i, 2)).collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).get();
    }

    private static int getMin(List<Integer> numbers) {
        return numbers.stream().min(Integer::compareTo).get();
    }

    private static int getSum(List<Integer> numbers) {
        return numbers.stream().reduce((t, u) -> t + u).get();
    }

    private static int getAverage(List<Integer> numbers) {
        return (int) Arrays.stream(numbers.stream().mapToInt(Integer::intValue).toArray()).average().getAsDouble();
    }
}
