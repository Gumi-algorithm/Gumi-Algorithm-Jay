package BOJ;
/*
BOJ_2075 N번째 큰 수
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class no2075 {
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 PQ
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0; i<N-1; i++) { // 내림차순이므로, N-1번째까지 다 빼낸후에
            pq.poll();
        }
        System.out.println(pq.peek()); // pq를 들여다보면 N번째.
    }
    
}