package BOJ;
/*
BOJ_1806 부분합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE; // 길이

        while (true) {
            if(sum >= S){
                sum -= nums[start++];
                length = Math.min(length, end - start + 1);
            } else if (end == N) {
                break;
            }else {
                sum += nums[end++];
            }
        }
        if (length == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(length);
        }

//        while (!q.isEmpty()) {
//            System.out.println(q.poll());
//        }

    }
}
