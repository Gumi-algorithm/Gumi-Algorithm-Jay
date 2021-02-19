package BojAlgorithms;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int delete = Integer.parseInt(st.nextToken());

        //삭제할 원소 카운팅
        int count = 0;
        String[] num = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            // 현재의 값이 스택 안의 값보다 크면 꺼내고 삭제
            while (!stack.isEmpty() && count < delete && Integer.parseInt(stack.peek()) < Integer.parseInt(num[i])) {
                stack.pop();
                count++; // 카운트 증가
            }
            // 현재 위치의 값 스택에 넣기
            stack.push(num[i]);
        }

        for(int i=0; i<stack.size(); i++){
            sb.append(stack.get(i));
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
