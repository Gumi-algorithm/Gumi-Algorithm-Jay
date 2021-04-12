package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no17836 {
    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int res = 0;

    static class Point{
        int x, y, sword, t;

        public Point(int x, int y, int sword, int t) { // x, y, 칼, 시간
            this.x = x;
            this.y = y;
            this.sword = sword;
            this.t = t;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M]; // [1][n][m] -> 칼이 있을 때, [0][n][m] -> 없을 때
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

        if(res == 0)
            System.out.println("Fail");
        else
            System.out.println(res);
    }
    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Point current = q.poll();
            if (current.x == N - 1 && current.y == M - 1) {
                if(current.t <= T) res = current.t;
                break;
            }
            if(current.t > T) break;

            for(int d = 0; d < 4; d++){
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[current.sword][nx][ny]) continue;
                if(current.sword == 0){
                    if(map[nx][ny] == 0){
                        visited[0][nx][ny] = true;
                        q.offer(new Point(nx, ny, 0, current.t + 1));
                    } else if (map[nx][ny] == 2) {
                        visited[1][nx][ny] = true;
                        q.offer(new Point(nx, ny, 1, current.t + 1));
                    }
                }
                else{
                    if (map[nx][ny] == 1 || map[nx][ny] == 0) {
                        visited[1][nx][ny] = true;
                        q.offer(new Point(nx, ny, 1, current.t + 1));
                    }
                }
            }
        }
    }

}
