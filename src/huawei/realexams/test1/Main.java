package test1;
import java.util.Scanner;

public class Main {
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
        }

        // A全在B的右边
        if(A[0]>B[n-1] || A[0] - B[n-1] > R){
            //System.out.println("");
            return;
        }else{
            for(int i=0;i<m;i++){
                if(A[i]>=B[0]-R){
                    for(int j=0;j<n;j++){
                        if(A[i]<=B[j] && B[j]-A[i] <= R){
                            System.out.println(A[i]+" "+B[j]);
                            break;
                        }
                    }
                }
            }
        }
    }
}
