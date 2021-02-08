package BojAlgorithms;

import java.util.Scanner;

public class no2798 {
    static int N;
    static int R = 3;
    static int M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getMax(0,  0, 0));
    }
    static int getMax(int tot, int cnt, int start){
        if(cnt == R){
            return tot > M ? 0 : tot;
        }
        if (start == N) {
            return 0;
        }
        int max = 0;
        for(int i = start; i < N; i++){
            max = Math.max(max, getMax(tot + arr[i], cnt + 1, i  + 1));
        }
        return max;
    }
}
