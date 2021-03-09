package BojAlgorithms;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class no7569 {
    static int M, N, H;
    static int[][][] map;
    static boolean[][][] v;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int day;
    static Queue<Integer> qx = new LinkedList<>();
    static Queue<Integer> qy = new LinkedList<>();
    static Queue<Integer> qz = new LinkedList<>();

    static void bfs(){
        int x, y, z;
        while (!qx.isEmpty()) {
            x = qx.poll(); y = qy.poll(); z = qz.poll();
            v[z][y][x] = true;

            for(int d = 0; d < 6; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nz = z + dz[d];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H) continue;
                if(v[nz][ny][nx]) continue;
                if(map[nz][ny][nx] == 0){
                    qx.add(nx);
                    qy.add(ny);
                    qz.add(nz);
                    v[nz][ny][nx] = true;
                    day = map[z][y][x];
                    map[nz][ny][nx] = map[z][y][x] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        map = new int[H][N][M];
        v = new boolean[H][N][M];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    map[i][j][k] = sc.nextInt();
                    if(map[i][j][k] == 1){
                        qx.add(k);
                        qy.add(j);
                        qz.add(i);
                    }
                }
            }
        }
        if (qx.isEmpty()) {
            day = -1;
        }
        else if(qx.size() == M * N * H){
            day = 0;
        } else {
            bfs();
            for(int i = 0; i < H; i++){
                for(int j = 0; j < N; j++){
                    for(int k = 0; k < M; k++){
                        if(map[i][j][k] == 0){
                            day = -1;
                        }
                    }
                }
            }
        }
        System.out.println(day);
    }
}
