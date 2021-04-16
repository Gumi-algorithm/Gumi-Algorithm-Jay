package BOJ;
/*
BOJ_17298 오큰수 
 */
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no17298 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {

            // 스택이 비어있지 않으면서, 스택에 있는 애가 인덱스로 있는 배열 원소랑 현재 인덱스에 있는 애랑 비교해서
            // 스택의 가장 위에 애를 인덱스로 가지는 애가 작다면 해당 인덱스 값을 현재 인덱스의 값으로 바꿔준다.
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                nums[stack.pop()] = nums[i];
            }
            stack.push(i); // 현재 배열 인덱스 값이 작거나 스택이 비어있을 경우 그냥 push.
        }

        while(!stack.isEmpty()) { // 위의 과정이 끝났다면 스택에 있는 모든애들을 pop하면서 -1로 초기화시켜준다.
            nums[stack.pop()] = -1;
        }


        for(int i = 0; i < N; i++) {
            sb.append(nums[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
