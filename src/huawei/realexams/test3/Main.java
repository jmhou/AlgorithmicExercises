package test3;

import java.util.Scanner;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(",");
        int length = (int) Math.sqrt(nums.length);
        int maxLength = 0,x,y;

        boolean zeroCount = false,oneCount =false;

        //int[][] numbers = new int[length][length];
        //int[0][0] = Integer.parseInt(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i].equals("0")){
                zeroCount = true;
            }
            if(nums[i].equals("1")){
                oneCount = true;
                // 0 1 2     3 4 5     6 7 8
                // 00 01 02  10 11 12  20 21 22
                //numbers[i/length][i%length] = Integer.parseInt(nums[i]);
                x=i/length;
                y=i%length;

                if(maxLength < x){
                    maxLength = x;
                }
                if(maxLength < length -1 - x){
                    maxLength =  length -1 - x;
                }
                if(maxLength < y){
                    maxLength = y;
                }
                if(maxLength < length -1 -y){
                    maxLength = length -1 -y;
                }
            }
        }
        if(zeroCount || oneCount){
            System.out.println("-1");
            return;
        }else{
            System.out.println(maxLength);
        }
    }
}
