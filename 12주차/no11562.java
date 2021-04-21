package BojAlgorithms;

import java.io.*;
import java.util.StringTokenizer;

public class no11562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];

        int INF = 9999999;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i != j) map[i][j] = INF;
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int ahead = Integer.parseInt(st.nextToken());

            // 여기서 상당히 고민했었음, 어떤식으로 단/양 방향 비용처리 해줄지..
            map[v1][v2] = 0; // 일단 갈수있는 지역이니 비용은 0
            if(ahead == 1) map[v2][v1] = 0; // 양방향일 경우 따로 추가비용은 엄슴
            else map[v2][v1] = 1; // 단방향일 경우 양방향으로 바꿔줘야하니깐
        }

        // 플로이드 와샬 (경찰도... )
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(map[s][e]).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
