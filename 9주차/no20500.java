package BojAlgorithms;

import java.util.Scanner;

public class no20500 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp = new int[N + 1][15];
        dp[1][1] = dp[1][5] = 1;

        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < 15; ++j) {
                dp[i + 1][(j * 10 + 1) % 15] = (dp[i + 1][(j * 10 + 1) % 15] + dp[i][j]) % 1000000007;
                dp[i + 1][(j * 10 + 5) % 15] = (dp[i + 1][(j * 10 + 5) % 15] + dp[i][j]) % 1000000007;
            }
        }

        System.out.println(dp[N][0]);
    }
}