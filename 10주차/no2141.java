package BOJ;
/*
BOJ_2141 우체국
 */
import java.io.*;
import java.util.*;

public class no2141 {

    static int N;
    static long total = 0;
    static LinkedList<Point> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new LinkedList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            long X = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            total += A;
            list.add(new Point(X, A));
        }

        Collections.sort(list); // 마을, 인원 수 정렬시키고

        long res = 0;

        for(Point p : list) {
            res += p.mens;
            if(res >= (total + 1) / 2) { // 인원수 합이 (전체 총 인원 + 1) / 2 보다 크거나 같을 때 마을위치 출력.
                                         // 인원수가 되도록 많은 쪽에 우체국을 지어야한다.
                sb.append(p.length);
                bw.write(sb.toString());
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
// list를 정렬해주기 위해서 compareTo 메소드 사용,
// 거리를 기준으로 정렬, 만약 거리가 같을 경우, 인구 수 대로.
class Point implements Comparable<Point>{
    long length, mens;
    public Point(long length, long mens) {
        this.length = length;
        this.mens = mens;
    }

    @Override
    public int compareTo(Point o) {
        if(this.length == o.length){
            return (int) (this.mens - o.mens);
        }
        return (int) (this.length - o.length);
    }
}