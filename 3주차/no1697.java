package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1697 {
    static int N, K;
    static int[] v = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        br.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(N);
        v[N] = 0;

        while (!q.isEmpty()) {
            N = q.poll();

            if (N == K) {
                break;
            }
            if (N + 1 <= 100000 && v[N + 1] == 0) {
                q.offer(N + 1);
                v[N + 1] = v[N] + 1;
            }
            if (N - 1 >= 0 && v[N - 1] == 0) {
                q.offer(N - 1);
                v[N - 1] = v[N] + 1;
            }
            if (N * 2 <= 100000 && v[N * 2] == 0) {
                q.offer(N * 2);
                v[N * 2] = v[N] + 1;
            }
        }
        System.out.println(v[N]);
    }
}
