package test013;

import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] words = sc.nextLine().split("\\s");
            for(int i = words.length - 1; i >= 0 ; i--){
                if (i== 0){
                    System.out.println(words[0]);
                }else{
                    System.out.print(words[i] + " ");
                }

            }
        }
    }
}
