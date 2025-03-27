package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Main {


    public static void main(String[] args) {
        ArrayList<Date> dates = new ArrayList<Date>();
        dates.add(new Date(25, 3, 2025));
        dates.add(new Date(32, 12, 2025));
        dates.add(new Date(9, 13, 2025));
        dates.add(new Date(31, 12, -2024));

        // Checking isValidDate and printDate functions
        for (Date d: dates){
            System.out.println(d.isValidDate(d.date, d.month, d.year));
            d.printDate();
        }

        // Checking updateDate method
        dates.get(2).updateDate(30, 3, 2025);
        dates.get(1).updateDate(12, 3, 2025);

        // Checking compareTo method
        Collections.sort(dates);
        System.out.println("Sorted");
        for(Date d: dates){
            d.printDate();
        }

        dates.add(new Date(26, 3, 2025));
        dates.add(new Date(14, 5, 2020));
        dates.add(new Date(30, 5, 2022));

        // Checking getDayOfWeek method
        for (Date date : dates) {
            System.out.println("getDayOfWeek method");
            System.out.println(date.getDayOfWeek());
        }

        // Cheaking calculateDifference method
        for (int i = 0; i < dates.size()-1; i++) {
            System.out.println("calculateDifference method");
            System.out.println(dates.get(i).calculateDifference(dates.get(i+1)));
        }

    }
}

class Date implements Comparable<Date>{
    int date;
    int month;
    int year;

    Date(int date, int month, int year){
        this.date = date;
        this.month = month;
        this.year = year;
    }

    boolean isValidDate(int date, int month, int year){
        boolean isValidMonth;
        boolean isValidDay = false;
        boolean isValidYear = false;
        boolean isLeapYear;
        int howManyDays = 0;

        if (year > 0){
            isValidYear = true;
        }

        if ((year%4 == 0 && year%100 != 0) || year %400 == 0){
            isLeapYear = true;
        }
        else {
            isLeapYear = false;
        }

        ArrayList<Integer> monthDays = new ArrayList<Integer>();
        monthDays.add(31);
        monthDays.add(28); // 29 for leap years
        monthDays.add(31);
        monthDays.add(30);
        monthDays.add(31);
        monthDays.add(30);
        monthDays.add(31);
        monthDays.add(31);
        monthDays.add(30);
        monthDays.add(31);
        monthDays.add(30);
        monthDays.add(31);


        if (month <= 12 && month > 0){
            howManyDays = monthDays.get(month-1);
            isValidMonth = true;
        }
        else {
            isValidMonth = false;
        }

        if (date <= howManyDays && date > 0 && month != 2){
            isValidDay = true;
        }
        else if (date <= howManyDays+1 && date > 0 && month == 2 && isLeapYear){
            howManyDays = 29;
            isValidDay = true;
        }

        if (isValidDay && isValidMonth && isValidYear){
            this.year = year;
            this.month = month;
            this.date = date;
            return true;
        }
        else {
            return false;
        }
    }

    void updateDate(int d, int m, int y){
        boolean isValid = isValidDate(d, m, y);

        if (isValid) {
            System.out.println("The date is updated");
            printDate();
        }
        else {
            System.out.println("The input date is not valid");
        }

    }

    void printDate(){
        boolean isValid = isValidDate(date, month, year);
        ArrayList<String> months = new ArrayList<String>();
        months.add("January");
        months.add("February"); // 29 for leap years
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        if (isValid){
            System.out.println(months.get(month-1) + " " + date + ", " + year);
        }
        else {
            System.out.println("The date is not valid");
        }

    }

    public int compareTo(Date date){
        if (this.year == date.year){
            if (this.month == date.month){
                return this.date - date.date;
            }
            else {
                return this.month - date.month;
            }
        }
        else {
            return this.year - date.year;
        }
    }

    String getDayOfWeek(){
        Calendar calendar = new GregorianCalendar(year, month - 1, date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        return days[dayOfWeek - 1];
    }

    String calculateDifference(Date subtrahend){
        int y = this.year;
        int m = this.month;
        int d = this.date;
        boolean isValid = isValidDate(subtrahend.date, subtrahend.month, subtrahend.year);
        if(!isValid) {
            return "Date is not valid";
        }
        this.year = y;
        this.month = m;
        this.date = d;
        ArrayList<Integer> monthDays = new ArrayList<Integer>();
        monthDays.add(31);
        monthDays.add(28); // 29 for leap years
        monthDays.add(31);
        monthDays.add(30);
        monthDays.add(31);
        monthDays.add(30);
        monthDays.add(31);
        monthDays.add(31);
        monthDays.add(30);
        monthDays.add(31);
        monthDays.add(30);
        monthDays.add(31);
        long sum1 = 0;
        long sum2 = 0;
        for (int i=this.year; i>0; i--){
            if((i%4==0 && i%100!=0) || i%400==0){
                sum1+=366;
            }
            else {
                sum1+=365;
            }
        }
        for(int i=this.month; i>0; i--){
            sum1+=monthDays.get(i-1);
        }
        sum1+=this.date;

        for (int i=subtrahend.year; i>0; i--){
            if((i%4==0 && i%100!=0) || i%400==0){
                sum2+=366;
            }
            else {
                sum2+=365;
            }
        }
        for(int i=subtrahend.month; i>0; i--){
            sum2+=monthDays.get(i-1);
        }
        sum2+=subtrahend.date;
        long ans = Math.abs(sum1-sum2);
        return "Difference is : "+ans;
    }



}

