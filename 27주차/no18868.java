package BojAlgorithms;
/*
BOJ_no18868 멀티버스 1
경우의 수
1 : A < B
2 : A = B
3 : A > B
 */
import java.io.*;
import java.util.StringTokenizer;

public class no18868 {
    static int M, N;
    static int [][]arr;

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = 0;
        for(int i = 0; i < M - 1; i++){
            for(int j = i + 1; j < M; j++){
                if (compare(arr[i], arr[j])) {
                    res++;
                }
            }
        }
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static boolean compare(int[] arr1, int[] arr2) {
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(arr1[i] > arr1[j]) {
                    if(arr2[i] <= arr2[j]) {
                        return false;
                    }
                }else if(arr1[i] < arr1[j]) {
                    if(arr2[i] >= arr2[j]) {
                        return false;
                    }
                }else {
                    if(arr2[i] != arr2[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
