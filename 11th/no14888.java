package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14888 {
    static int N;
    static int[] nums; // 숫자들 
    static int[] o = new int[4]; // 연산자 배열 
    static int max = Integer.MIN_VALUE; // 최대값 
    static int min = Integer.MAX_VALUE; // 최소값 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입려 
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            o[i] = Integer.parseInt(st.nextToken());
        }

        // dfs 실행 
        dfs(nums[0], 1);
        System.out.println(max);
        System.out.println(min);

    }
    static void dfs(int n, int idx){
        if(idx == N){ // 종료조건 : 매개변수이 인덱스가 N까지 갔다면 재귀 종료 
            max = Math.max(max, n); // 연산 최대값 
            min = Math.min(min, n); // 연산 최소값 
        }
        for(int i = 0; i < 4; i++){ 
            if(o[i] > 0){ // 연산자의 개수가 1보다 크다면 
                o[i]--; // 하나를 빼줌 

                switch(i){ // switch 문을 통해서 0 : 덧셈, 1 : 뺄셈, 2 : 곱셈, 3 : 나누기 수행하면서 재귀 반복 
                    case 0:
                        dfs(n + nums[idx], idx + 1);
                        break;
                    case 1:
                        dfs(n - nums[idx], idx + 1);
                        break;
                    case 2:
                        dfs(n * nums[idx], idx + 1);
                        break;
                    case 3:
                        dfs(n / nums[idx], idx + 1);
                        break;
                }
                o[i]++; // 빼줬더 연산자, 재귀 종료 시 초기화해주기. 여기서 시간많이잡음.. 
            }
        }
    }
}
