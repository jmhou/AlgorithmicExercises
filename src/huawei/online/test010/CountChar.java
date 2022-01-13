package test010;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        HashSet<Character> hs = new HashSet();
        for(int i = 0 ; i<str.length();i++){
            hs.add(Character.valueOf(str.charAt(i)));
        }
        System.out.println(hs.size());
        System.out.println(Arrays.toString(hs.toArray() ));
    }
}
