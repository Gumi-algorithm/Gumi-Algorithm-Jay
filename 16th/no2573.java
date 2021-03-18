package BojAlgorithms;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no2573 {
    static int N, M, res;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;

    static class Ice {
        int x, y;

        public Ice(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        boolean flag = false;
        while(!flag){
            cnt = checkSplit();
            if(cnt >= 2){
                flag = true;
            }
            else if(cnt == 0){
                res = 0;
                break;
            }else{
                bfs();
                res++;
            }
        }
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<Ice> queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0){
                    queue.offer(new Ice(i, j));
                    visit[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            Ice ice = queue.poll();

            int seaArea = 0;
            for(int d = 0; d < 4; d++){
                int nx = ice.x + dx[d];
                int ny = ice.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 0 && !visit[nx][ny]) {
                    seaArea++;
                }
            }
            if(map[ice.x][ice.y] - seaArea <= 0) map[ice.x][ice.y] = 0;
            else map[ice.x][ice.y] -= seaArea;
        }

    }

    static int checkSplit(){
        boolean[][] visited = new boolean[N][M];

        int land = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    dfs(i, j, visited);
                    land++;
                }
            }
        }
        return land;
    }
    static void dfs(int x, int y, boolean[][] v){
        v[x][y] = true;

        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (map[nx][ny] != 0 && !v[nx][ny]) {
                dfs(nx, ny, v);
            }
        }
    }

}
