package BojAlgorithms;
/*
BOJ_9079 동전 게임
검색해서 참고했습니다..
 */
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no9079 {
    static int[] next;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            next = new int[8];
            v = new boolean[512]; // 2^9
            int idx = 0;
            int res = 0;

            for(int i = 0; i < 3; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 3; j++){
                    idx *= 2;
                   
                    if(st.nextToken().equals("H")) idx++;
                }
            }
            v[idx] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(idx);

            boolean end = false;

            while (!q.isEmpty()) {
                Queue<Integer> tmp = new LinkedList<>();
                while (!q.isEmpty()) {
                    tmp.add(q.poll());
                }
                while (!tmp.isEmpty()) {
                    int current = tmp.peek();
                    if (current == 511 || current == 0) {
                        end = true;
                        break;
                    }
                    tmp.poll();
                    find(current);

                    for(int i = 0; i < 8; i++){
                        if (!v[next[i]]) {
                            v[next[i]] = true;
                            q.add(next[i]);
                        }
                    }
                }
                if(end) break;
                res++;
            }
            if(!end) res = -1;
            sb.append(res).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void find(int idx){
        next[0] = change(idx, 0, 1, 2); // 1행
        next[1] = change(idx, 3, 4, 5); // 2행
        next[2] = change(idx, 6, 7, 8); // 3행
        next[3] = change(idx, 0, 3, 6); // 1열
        next[4] = change(idx, 1, 4, 7); // 2열
        next[5] = change(idx, 2, 5, 8); // 3열
        next[6] = change(idx, 0, 4, 8); // 좌상 -> 우하
        next[7] = change(idx, 2, 4, 6); // 우상 -> 좌하
    }

    static int change(int n, int idx1, int idx2, int idx3) { // 왜.. ?
        n = n ^ (1 << idx1);
        n = n ^ (1 << idx2);
        n = n ^ (1 << idx3);
        return n;
    }
}
