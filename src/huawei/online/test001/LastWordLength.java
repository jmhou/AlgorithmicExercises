package test001;

import java.util.Scanner;

public class LastWordLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        System.out.println(words[words.length - 1].length());
    }
}
