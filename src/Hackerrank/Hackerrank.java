package Hackerrank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Hackerrank {
/*Determine whether string is funny or not
* 1. Create reverse copy of string
* 2. Iterate and compare the difference between values in ascii at 0-1, 1-2...
* 3. If absDiff(S1) == absDiff(S2) then funny*/

    public static String reverse(String str){
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev.concat(String.valueOf(str.charAt(i)));
        }

        return rev;
    }
    public static String funnyString(String s) {
        ArrayList<Integer> s_ascii = new ArrayList<>(), r_ascii = new ArrayList<>(), s_diff = new ArrayList<>(),
        r_diff = new ArrayList<>();
        String r = reverse(s);

        for (int i = 0; i < s.length(); i++){
            s_ascii.add((int)(s.charAt(i)));
            r_ascii.add((int)(r.charAt(i)));
        }
        int i = 1;
        int j = 1;
        while (i < s_ascii.size()){
            s_diff.add(Math.abs((s_ascii.get(i) - s_ascii.get(i-1))));
            r_diff.add(Math.abs((r_ascii.get(j) - r_ascii.get(j-1))));

            i++;
            j++;
        }

        if (r_diff.equals(s_diff))
            return "Funny";
        else
            return "Not Funny";
    }

    public static int findDigits(int n) {
        // Write your code here
        String temp = Integer.toString(n);
        ArrayList<Integer> list = new ArrayList<>();
        int divide_count = 0;

        for (int i = 0; i < temp.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(temp.charAt(i))));
        }
        list.removeAll(Collections.singleton(0));

        for (int i : list){
            if (n % i == 0)
                divide_count++;
        }

        return divide_count;
    }

    public static long extraLongFactorials(int n) {
        long fact = 1;

        while (n != 0){
            fact *= n;
            n--;
        }

        return fact;
    }

    public static void main(String[] args) {
        System.out.println(extraLongFactorials(25));
    }
}
