package test1;
import java.util.Scanner;

public class Main {
    /**
     * 两个正整数序列A[m],B[n]，都是从小到大排好序了
     * 1. 如果存在 A[i] < B[j]   ( 0<=i<=m, 0<=j<=n)
     * 2. R <= B[j]-A[i]
     * 同时满足 1和2，只需要输出 A[i] B[j]  只需要输出A[i]对应的最小的B[j]
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int R = sc.nextInt();
        int[] A = new int[m];
        int[] B = new int[n];
        for(int i=0;i<m;i++){
            A[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            B[i] = sc.nextInt();
            for(int j=0;j<m;j++){
                if(A[j]<B[i] && B[i]-A[j] <= R){
                    System.out.println(A[j]+" "+B[i]);
                    break;
                }
            }
        }
    }
}
