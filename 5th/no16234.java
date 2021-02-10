package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16234 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N, L, R;
    static int[][] map;
    static boolean[][] v;
    static boolean[][] isOpen;
    static int canMove;
    static int moveCnt;
    static int totp = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = br.readLine();
        st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String ipt = br.readLine();
            st = new StringTokenizer(ipt, " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            v = new boolean[N][N];
            isOpen = new boolean[N][N];
            canMove = 0;
            if (canMove == 0) {
                break;
            }
            else {
                moveCnt++;
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < N; j++){
                        if(!v[i][j]){
                            dfs(i, j, isOpen, v);
                        }
                        int movedPeople = totp / n;
                        for(int a = 0; a < N; a++){
                            for(int b = 0; b < map[0].length; b++){
                                if (v[a][b] == isOpen[a][b]) {
                                    map[a][b] = movedPeople;
                                }
                            }
                        }
                        totp = 0;
                        n = 0;
                        isOpen[N][N] = false;
                    }
                }
            }
        }
        System.out.println(moveCnt);
    }

    static void dfs(int x, int y, boolean[][] isOpen, boolean[][] v) {
        v[x][y] = isOpen[x][y];
        totp += map[x][y];
        n++;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (Math.abs(map[x][y] - map[nx][ny]) >= L && Math.abs(map[x][y] - map[nx][ny]) <= R) {
                    canMove++;
                    dfs(nx, ny, isOpen, v);
                }
            }
        }
    }
}
