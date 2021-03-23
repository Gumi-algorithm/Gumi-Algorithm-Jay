package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2661 {
    static int N;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        dfs(1, "1"); // 수의 길이와 처음 숫자는 1부터 시작하니까.
    }
    static void dfs(int size, String str){
        if (flag) {
            return;
        }
        if(size == N){
            System.out.println(str);
            flag = true;
        }else{
            for(int i = 1; i <= 3; i++){
                if (isOkay(str + i)) {
                    dfs(size + 1, str + i);
                }
            }
        }

    }
    static boolean isOkay(String str){ // 좋은 수열인지 판단하는 함수
        int size = str.length();
        int start = size - 1; //
        int middle = size / 2;
        int end = size;

        for(int i = 1; i <= middle; i++){
            if (str.substring(start - i, end - i).equals(str.substring(start, end))) {
                return false;
            }
            start = start - 1;
        }
        return true;

    }
}
