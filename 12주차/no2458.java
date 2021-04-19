package BojAlgorithms;
/*
BOJ_2458 키순서
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2458 {
    static int N, M, res;
    static boolean[][] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = 0;

        adj = new boolean[N + 1][N + 1]; // 인접 정보를 담을 배열
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = true;
        }
        // 경찰도 !!!
        for(int k = 1; k <= N; k++){ // 경유지
            for(int i = 1; i <= N; i++){ // 출발지
                for(int j = 1; j <= N; j++){ // 도착지
                    if(adj[i][k] && adj[k][j]) // 저번 스터디때 들은대로, 경유지 목적지 같거나 출발지가 목적지일때 패스해주던거 생략해도 되네..?
                        adj[i][j] = true;
                }
            }
        }
        for(int i = 0; i <= N; i++){
            int cnt = 0;
            for(int j = 1; j <= N; j++){
                if(i == j) continue; // 자기자신으로의 비교는 x
                if(adj[i][j] || adj[j][i]) cnt++;
            }
            if(cnt == N - 1) res++;
        }
        System.out.println(res);
    }
}
