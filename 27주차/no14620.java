package BojAlgorithms;
// BOJ_14620 꽃길

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14620 {
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int sum = Integer.MAX_VALUE;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        v = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(sum);
    }
    static void dfs(int cnt, int tot){
        if(cnt == 3){
            sum = Math.min(sum, tot);
            return;
        }
        for(int i = 1; i < N - 1; i++){
            for(int j = 1; j < N - 1; j++){
                if(v[i][j]) continue;
                if(!check(i, j)) continue;
                    v[i][j] = true;
                    int c = map[i][j];

                    for(int k = 0; k < 4; k++){
                        v[i + dx[k]][j + dy[k]] = true;
                        c += map[i + dx[k]][j + dy[k]];
                    }
                    dfs(cnt + 1, tot + c);
                    v[i][j] = false;
                    for(int k = 0; k < 4; k++){
                        v[i + dx[k]][j + dy[k]] = false;
                    }

                }
            }
        }

    static boolean check(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || v[nx][ny])
                return false;
        }
        return true;
    }
}
