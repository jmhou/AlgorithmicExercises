package test17;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class BaseMove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character,Integer> base = new HashMap<>();
        int x,y;
        while(sc.hasNextLine()){
            String[] positions = sc.nextLine().split(";");
            String reg = "^[AWDS]\\d{1}\\d?$";
            for(int i = 0; i<positions.length;i++){
                if(positions[i].matches(reg)){
                    base.put(positions[i].charAt(0),base.getOrDefault(positions[i].charAt(0),0) +
                            Integer.valueOf(positions[i].substring(1)));
                }
            }
            x = 0 + base.get('A') - base.get('D');
            y = 0 + base.get('S') - base.get('W');
            base.clear();
            System.out.println(x+"," +y);
        }
        sc.close();
    }
}
