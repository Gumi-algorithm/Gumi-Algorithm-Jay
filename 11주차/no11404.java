package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no11404 {
    static int N, M;
    static int[][] map;
    static final int INF = 9999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1]; //1 <= M <= 100000 이라서, 배열 1행 1열부터 시작

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                if (i != j && map[i][j] == 0) { // 자기 자신으로 오게 되는 방법은 없고, i와 j가 연결된 곳이 아니면 (인접해있지 않다면) INF로 채움.
                    map[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], c); // 출발지, 도착지가 같은데 비용이 서로 다를 경우에, 비용이 더 적은값으로 만들어준다.
        }



//        for(int i = 1; i < N + 1; i++){
//            for(int j = 1; j < N + 1; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 경 -> 찰 -> 도 (경유지 -> 출발지 -> 목적지)
        for(int k = 1; k < N + 1; k++){
            for(int i = 1; i < N + 1; i++){
                if(i == k) continue; // 경유지와 출발지가 같다면, 넘기기
                for(int j = 1; j < N + 1; j++){
                    if(i == j || k == j) continue; // 출발지가 목적지이거나 경유지가 목적지이면 패스
                    if (map[i][j] > map[i][k] + map[k][j]) { // 출발지에서 경유지 + 경유지에서 목적지, 즉 총 경유한 비용의 합이 바로 가는것보다 작다면
                        map[i][j] = map[i][k] + map[k][j]; // 업데이트.
                    }
                }
            }

        }
        print();
    }

    private static void print() { // 이거슨 출력함수임니당.
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                if(map[i][j] == INF) // 문제 조건에서 배열의 값이 INF면, 즉 갈 수 없다면 0으로 출력하라해서 조건걸어줌.
                    map[i][j] = 0;
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
