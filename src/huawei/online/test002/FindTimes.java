package test002;

import java.util.Scanner;

public class FindTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine().toLowerCase();
        String chr = sc.nextLine().toLowerCase();
        System.out.println(strs.length() - strs.replaceAll(chr,"").length());
    }
}
