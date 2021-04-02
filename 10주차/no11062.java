package BOJ;
/*
BOJ_11062 카드 게임
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class no11062 {
    static int N;
    static int[] v;
    static int[][] dp;
    static int res;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());
            v = new int[N+1];
            dp = new int[N+1][N+1];
            res = 0;
            st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= N; i++)
            {
                v[i] = Integer.parseInt(st.nextToken());
            }
            res = dfs(1, N, 1);
            sb.append(res).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static int dfs(int left, int right, int num){
        if(num > N){
            return 0;
        }
        if(dp[left][right] != 0)
            return dp[left][right];

        int first = dfs(left + 1, right, num + 1) + v[left];
        int last = dfs(left, right - 1, num + 1) + v[right];

        if(num % 2 == 1){
            dp[left][right] = Math.max(first, last);
        }else{
            dp[left][right] = Math.min(first - v[left], last - v[right]);
        }

        return dp[left][right];
    }

}