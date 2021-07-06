package BojAlgorithms;

import java.io.*;

/*
BOJ_1212 8진수 2진수
Input : 314
Output : 11001100

3 -> 011
1 -> 001
4 -> 100
-> 011001100 이어야 하는데 맨앞의 수가 0일때는 짤리네 ?

 */
public class no1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String res = "";
        for(int i = 0; i < str.length(); i++){
            // 입력된 수 자릿수마다 잘라서 2진 문자열로 변환해줌. -> (Integer.toBinaryString)
            res = Integer.toBinaryString(str.charAt(i) - '0');
            // 첫번째 수가 아니고 나머지 수 일 때,
            if(i != 0){
                // 길이가 2이면 앞에 0을 붙이고
                if(res.length() == 2) res = "0" + res;
                // 길이가 1이면 앞에 00을 붙여주자.
                else if(res.length() == 1) res = "00" + res;
            }
            sb.append(res);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}
