package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14888 {
    static int N;
    static int[] nums;
    static int[] o = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            o[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 1);
        System.out.println(max);
        System.out.println(min);

    }
    static void dfs(int n, int idx){
        if(idx == N){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        for(int i = 0; i < 4; i++){
            if(o[i] > 0){
                o[i]--;

                switch(i){
                    case 0:
                        dfs(n + nums[idx], idx + 1);
                        break;
                    case 1:
                        dfs(n - nums[idx], idx + 1);
                        break;
                    case 2:
                        dfs(n * nums[idx], idx + 1);
                        break;
                    case 3:
                        dfs(n / nums[idx], idx + 1);
                        break;
                }
                o[i]++;
            }
        }
    }
}
