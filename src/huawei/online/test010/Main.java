package test010;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    /**
     * 疫情计算：
     *
     * N*N的矩阵表示一片区域，0表示该点未感染，1表示已感染
     * 如果初始都是 0 或 都是 1 就直接输出 -1
     * 如果有1也有0，计算需要多久就都被感染为 1
     * （1感染周围需要1天）
     *
     * 输入：
     * N*N个数，只有0和1，用逗号拼接(,)
     * eg： 1,0,0,0
     *
     * 输出：天数
     * eg: 2
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){

            // 拆分成数组
            String[] strs = sc.nextLine().split(",");

            // 字符串数组转数值数组
            int N = (int)Math.sqrt(strs.length);
            int[][] nums = new int[N][N];
            long sum = 0L;
            for(int i = 0;i<N;i++){
                for(int j= 0;j<N;j++){
                    nums[i][j] = Integer.parseInt(strs[i*N+j]);
                    sum += nums[i][j];
                }
            }

            // 判断是否全感染 或 全未感染
            if(sum == 0 || sum == N*N){
                System.out.println("-1");
                continue;
            }

            int[][] newNums = new int[N][N];
            int days = 0;
            while(sum < N*N){
                days ++;
                for(int i=0;i<N;i++){
                    newNums[i] = Arrays.copyOf(nums[i],nums[i].length);
                }
                for(int i = 0;i<N;i++){
                    for(int j= 0;j<N;j++){
                        if(nums[i][j]==1){
                            if(i>0 && newNums[i-1][j] == 0){
                                newNums[i-1][j] = 1;
                            }

                            if(i<N-1 && newNums[i+1][j] == 0){
                                newNums[i+1][j] = 1;
                            }

                            if(j>0 && newNums[i][j-1] == 0){
                                newNums[i][j-1] = 1;
                            }

                            if(j<N-1 && newNums[i][j+1] == 0){
                                newNums[i][j+1] = 1;
                            }
                        }

                    }
                }
                sum = 0L;
                nums = newNums;
                for(int i = 0;i<N;i++){
                    for(int j= 0;j<N;j++){
                        sum += newNums[i][j];
                    }
                }
            }

            System.out.println(days);
        }
    }
}
