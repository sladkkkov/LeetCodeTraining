package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Banjo {

    public static String playBanjo(String name) {
        return name.toLowerCase(Locale.ROOT).startsWith("r") ? name + " play banjo" : name + " does not play banjo";
    }

    public static String bmi(double weight, double height) {
        double a = weight / (height * height);
        if (a >= 30.0) {
            return "Obese";
        } else if (a <= 30.0 && a >= 25.0) {
            return "Overweight";
        } else {
            return a >= 18.5 ? "Normal" : "Underweight";
        }
    }

    public static String oddOrEven(int[] array) {
        return Arrays.stream(array).sum() % 2 == 1 ? "odd" : "even";
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        listA.removeAll(listB);
        return listA.stream().mapToInt(e -> e).toArray();
    }

    public static boolean isAnagram(String test, String original) {
        List<Character> testChars = test.toLowerCase(Locale.ROOT).chars().mapToObj(e -> (char) e).sorted().toList();
        List<Character> originalChars = original.toLowerCase(Locale.ROOT).chars().mapToObj(e -> (char) e).sorted().toList();
        if (originalChars.containsAll(testChars) && testChars.size() == originalChars.size()) {
            return true;
        }
        return false;
    }

    public static boolean smallEnough(int[] a, int limit) {
        if (Arrays.stream(a).allMatch(value -> value <= limit)) {
            return true;
        }
        return false;
    }

    public static int[] flattenAndSort(int[][] array) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(array).flatMapToInt(a -> Arrays.stream(a)).forEach(list::add);
        return list.stream().sorted().mapToInt(value -> value).toArray();
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i : nums) {
            if (Arrays.stream(nums).anyMatch(value -> value + i == target)) {
                List<Integer> helpN = Arrays.stream(nums).boxed().collect(Collectors.toList());
                if (helpN.indexOf(i) != helpN.lastIndexOf(target-i)) {
                    return new int[]{helpN.indexOf(i), helpN.lastIndexOf(target - i)};
                }
            }
        }
        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

}

