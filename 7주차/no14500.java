package BojAlgorithms;

/*
 * 검색 해서 참고해서 풀어봤습니다.. 어렵..
 *
 * */
import java.util.*;
import java.io.*;

public class no14500 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                visited[i][j] = false;
                another(i, j);
            }
        }

        System.out.println(max);
    }

    // dfs로 깊이가 최대 4인 경우가 테트로미노, 단 ㅗ 모양은 없음
    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    // ㅗ 모양을 찾는다. 가운데 있는 좌표를 기준으로 세 방향을 탐색한다.
    static void another(int x, int y) {
        // 1. 맵의 꼭지점일때는 ㅗ 모양 불가능
        if ((x == 0 || x == n - 1) && (y == 0 || y == m - 1)) return;

        int sum = map[x][y];

        // 2. 맵의 테두리일때는 모양이 하나
        if (x == 0)
            sum += map[x][y - 1] + map[x][y + 1] + map[x + 1][y];
        else if (x == n - 1)
            sum += map[x][y - 1] + map[x][y + 1] + map[x - 1][y];
        else if (y == 0)
            sum += map[x - 1][y] + map[x + 1][y] + map[x][y + 1];
        else if (y == m - 1)
            sum += map[x - 1][y] + map[x + 1][y] + map[x][y - 1];
        else {
            // 3. 맵의 테두리가 아닐 때는 4 개의 모양을 비교
            sum = Math.max(sum, map[x][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1]);
            sum = Math.max(sum, map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x][y + 1]);
            sum = Math.max(sum, map[x][y] + map[x][y + 1] + map[x - 1][y] + map[x + 1][y]);
            sum = Math.max(sum, map[x][y] + map[x][y - 1] + map[x - 1][y] + map[x + 1][y]);
        }

        max = Math.max(max, sum);
    }
}