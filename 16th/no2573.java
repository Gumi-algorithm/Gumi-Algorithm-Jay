package BojAlgorithms;
/*
BOJ_2573 빙산 
*/
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

    static class Ice { // 빙산 좌표
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
        visit = new boolean[N][M]; // 얼음 방문처리용 변수
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0; // 빙산이 나누어진 개수를 카운트 하는 변수
        boolean flag = false;
        while(!flag){
            cnt = checkSplit();
            if(cnt >= 2){ // 빙산 덩어리가 2개 이상으로 분리될 경우에 루프 멈춤
                flag = true;
            }
            else if(cnt == 0){ // cnt가 0일 경우, 빙산은 분리되지 않았으니까 결과값 = 0
                res = 0;
                break;
            }else{ // 그게 아닐 경우, bfs
                bfs();
                res++; // 한번 돌 때마다 결과값 증가
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

            int seaArea = 0; // 상하좌우 중 바다로 이루어 진 면 카운트하는 변수
            for(int d = 0; d < 4; d++){ // 상, 하, 좌, 우 탐색
                int nx = ice.x + dx[d];
                int ny = ice.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 범위 벗어날 경우 건너뛰고
                if (map[nx][ny] == 0 && !visit[nx][ny]) { // 다음 지역이 바다이고, 방문하지 않았다면 바다영역 증가
                    seaArea++;
                }
            }
            if(map[ice.x][ice.y] - seaArea <= 0) map[ice.x][ice.y] = 0; // 빙산의 좌표 - 바다영역 즉, 시간이 지나고 다 녹는다면 해당 좌표 0으로 업데이트
            else map[ice.x][ice.y] -= seaArea; // 그게 아닐경우엔 빙산 -= 바다지역
        }

    }

    static int checkSplit(){ // 나누어진 곳 확인하는 함수
        boolean[][] visited = new boolean[N][M]; // 방문확인용

        int land = 0; // 덩어리 개수 변수
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0 && !visited[i][j]){ // 전체 영역 돌면서 빙산인 지역이면서 방문하지 않았을 때,
                    dfs(i, j, visited); // dfs  탐색
                    land++; // 탐색 끝나고 덩어리 개수 증가.
                }
            }
        }
        return land;
    }
    static void dfs(int x, int y, boolean[][] v){  // dfs
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
