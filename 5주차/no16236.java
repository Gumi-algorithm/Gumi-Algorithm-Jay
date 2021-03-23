package BojAlgorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class no16236 {
    static int N;
    static int[][] map;
    static int res;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Shark{
        int x, y;
        int size = 2;
        int cnt = 0;
    }
    static Shark s;

    static class Fish{
        int x, y;
        int dist;

        public Fish(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        s = new Shark();
        res = 0; // 최대값, 최소값.
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();

                if (map[i][j] == 9) {
                    s.x = i;
                    s.y = j;
                }
            }
        }
    }

    static void bfs(){
        Queue<Fish> queue = new LinkedList<>();

        int[][] v = new int[N][N]; //  방문체크용 배열

    }
}
