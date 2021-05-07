package BOJ;

import java.util.*;
import java.io.*;
/*
BOJ_14719 빗물
 */
class no14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int H=Integer.parseInt(st.nextToken());
        int W=Integer.parseInt(st.nextToken());

        int[] map = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) { // 높이 저장
            map[i]=Integer.parseInt(st.nextToken());
        }

        int res=0;

        for(int i=0;i<W;i++) { // 가로축을 지나면서
            int left = i;

            for(int l = i; l >= 0; l--) { // i를 기준으로 왼쪽에서 가장 큰 높이
                if(map[l] > map[left])
                    left = l;
            }
            int right = i;

            for(int r = i; r < W; r++) { // i를 기준으로 오른쪽에서 가장 큰 높이
                if(map[r] > map[right])
                    right = r;
            }
            int size = Math.min(map[left], map[right]) - map[i]; // 좌, 우측 중 낮은 곳에서 기준위치인 i를 뺀 것이 그 때의 넓이.
            if(size > 0)
                res += size; // 0보다 클 경우, 즉 빗물이 고였을 경우에 더해준다.
        }

        System.out.println(res);
    }

}