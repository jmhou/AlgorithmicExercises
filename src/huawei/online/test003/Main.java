package test003;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * HJ3 明明的随机数
     * 输入：有多组
     * 1.每组第一行输入正整数N，表示要输入的整数的个数
     * 2.接下来 N行对应N个整数（0<1000  的随机整数，可能重复）
     * 需要对这N个整数 排序并去重
     *
     * 输出：去重排序后的 序列
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            Integer count = Integer.parseInt(sc.nextLine());

            int[] nums = new int[count];
            for(int i = 0; i< count;i++){
                nums[i] = Integer.parseInt(sc.nextLine());
            }
            Arrays.sort(nums);
            int temp=nums[0];
            System.out.println(temp);
            for(int i=1 ;i<count;i++){
                if(nums[i] != nums[i-1]){
                    System.out.println(nums[i]);
                }
            }
        }
    }
}
