package BojAlgorithms;
/*
BOJ_17129 윌리암슨수액빨이딱따구리가 정보섬에 올라온 이유
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class no17129 {
    static int N, M;
    static int[][] map; // 정보섬 2층
    static int[][] dis; // 거리
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int resX, resY;
    static boolean found;
    static Queue<Point> queue = new LinkedList<>();


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        dis = new int[N][M];


        for (int i = 0; i < N; i++) {
            String ipt = br.readLine();

            for (int j = 0; j < M; j++) {
                // System.out.println(ipt.substring(j, j+1));
                map[i][j] = Integer.parseInt(ipt.substring(j, j + 1));
                if (map[i][j] == 2) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        bfs();
        if(found){
            System.out.println("TAK");
            System.out.println(dis[resX][resY]);
        }else System.out.println("NIE");

    }
    static void bfs () {

        while (!queue.isEmpty()) {
            Point cur = queue.poll(); // 현재위치
            if (map[cur.x][cur.y] == 3 || map[cur.x][cur.y] == 4 || map[cur.x][cur.y] == 5) { // 음식을 찾았다면 해당 좌표 저장하고 종료
                resX = cur.x;
                resY = cur.y;
                found = true; // 찾았다 !
                return;
            }

            for (int d = 0; d < 4; d++) { // 사방탐색
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 가지치기
                if(visited[nx][ny]) continue;
                if (map[nx][ny] != 1 && !visited[nx][ny]) { // 장애물이 아니고, 방문하지 않은 곳 즉, 갈 수 있는 곳이면
                    visited[nx][ny] = true; // 다음 갈곳 방문처리
                    queue.offer(new Point(nx, ny)); // 큐에 삽입
                    dis[nx][ny] = dis[cur.x][cur.y] + 1; // 거리 증가
                }
            }
        }
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}