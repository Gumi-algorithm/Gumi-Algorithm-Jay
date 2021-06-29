package BOJ;
/*
BOJ_14425 문자열 집합
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class no14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

//        ArrayList<String> list = new ArrayList<>();
//        for(int i = 0; i < N; i++){
//            list.add(br.readLine());
//        }
//
//        for(int i = 0; i < M; i++){
//            String str = br.readLine();
//            for(int j = 0; j < N; j++){
//                if (list.get(j).equals(str)) {
//                    cnt++;
//                }
//            }
//        }
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            map.put(br.readLine(), i);
        }

        for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(map.get(str) != null) cnt++;
        }

        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
