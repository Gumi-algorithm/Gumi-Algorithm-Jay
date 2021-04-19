package BojAlgorithms;
/*
BOJ_7662 이중 우선순위 큐
 */
import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no7662 { // 시간초과 무야호.. 
    static PriorityQueue<Integer> maxPQ;
    static PriorityQueue<Integer> minPQ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            maxPQ = new PriorityQueue<>(Collections.reverseOrder()); // 최댓값 뽑기 위한 pq (내림차순)
            minPQ = new PriorityQueue<>(); // 최솟값 뽑기 위한 pq (오름차순)
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                switch (cmd) {
                    case 'I': // insert는 동일하게 둘다 offer 해주고
                        maxPQ.offer(n);
                        minPQ.offer(n);
                        break;
                    case 'D': // delete일 때,
                        if (maxPQ.isEmpty() || minPQ.isEmpty()) { // 최대 또는 최소 우선순위 큐 둘 중 하나라도 비면 break
                            break;
                        }
                        if (n == 1) { // D 1 -> 최댓값 삭제하는 연산이니까, 최대값 우선순위 큐의 가장앞의 아이를 꺼내면서 최소값 우선순위 큐의 해당 원소 지움
                            minPQ.remove(maxPQ.poll());
                        } else { // D -1 -> 최솟값 삭제하는 연산이니, 최댓값 삭제랑 반대로.
                            maxPQ.remove(minPQ.poll());
                        }
                        break;
                }
            }

            // 큐가 비지 않았다면 남아있는 최대 최솟값 출력
            if (!maxPQ.isEmpty() || !minPQ.isEmpty()) sb.append(maxPQ.peek()).append(" ").append(minPQ.peek()).append("\n");
            // 비었다면 EMPTY
            else sb.append("EMPTY").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
