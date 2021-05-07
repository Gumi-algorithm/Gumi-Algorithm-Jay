package BOJ;
/*
BOJ_14225 부분수열의 합
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14225 {
    static int N;
    static boolean[] nums;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr= new int[N];
        int sum = 0;

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        nums = new boolean[sum+2];

        dfs(arr, 0, 0);

        for(int i=1; i<nums.length;i++) { // 1부터 합 까지.
            if(!nums[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void dfs(int[] arr, int idx, int sum) {
        if(idx>=1) {
            nums[sum] = true;
        }

        if(idx==N) return;

        for(int i=idx; i<N; i++) {
            dfs(arr, i+1, sum+arr[i]);
        }
    }
}