package baekjoon;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Baekjoon_1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2007, sc.nextInt() - 1, sc.nextInt());

        System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.ENGLISH).toUpperCase());

        sc.close();
    }
}