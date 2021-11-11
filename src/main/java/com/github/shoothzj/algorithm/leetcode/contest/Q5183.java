package com.github.shoothzj.algorithm.leetcode.contest;

import java.time.LocalDate;

public class Q5183 {

    private static final String[] auxArray = {"Dummy", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        int value = date.getDayOfWeek().getValue();
        return auxArray[value];
    }

}
