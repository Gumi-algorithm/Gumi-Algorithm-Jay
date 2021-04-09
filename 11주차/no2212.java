package BOJ;
/*
BOJ_2212 센서
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2212 {
    static int N, K;
    static int res = 0;
    static int[] map;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new int[N];

        for(int i = 0; i < N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        dis = new int[N - 1]; // 센서 간 간격

        for(int i = 0; i < N - 1; i++){
            dis[i] = map[i + 1] - map[i];
        }
        Arrays.sort(dis); // 간격 오름차순으로,

        for(int i = 0; i < N - K; i++){ // 0번째부터 N - K - 1번째까지의 간격 총 합  / 나는 모르게따... 왜..
            res += dis[i];
        }

        System.out.println(res);
    }
}
