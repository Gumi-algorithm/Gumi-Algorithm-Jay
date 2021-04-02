package BOJ;
/*
BOJ_1823 수확
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class no1823 {
    static int N;
    static int[] v;
    static int[][] dp;
    static int rst;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        v = new int[N+1];
        dp = new int[N+1][N+1];
        rst = 0;

        for(int i = 1; i <= N; i++)
        {
            v[i] = Integer.parseInt(br.readLine());
        }

        rst = solve(1, N, 1);
        sb.append(rst);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    static int solve(int left, int right, int num) {
        if(left>right)
            return 0;

        if(dp[left][right]!=0)
            return dp[left][right];

        int first = solve(left + 1, right, num + 1) + num * v[left];
        int last = solve(left, right - 1, num + 1) + num * v[right];

        dp[left][right] = Math.max(first, last);

        return dp[left][right];
    }
}