package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
BOJ_2262 토너먼트 만들기

1. 랭킹의 수가 높은 사람순으로 먼저 찾은후에
2. 해당 사람의 좌우비교 후, 랭킹 차이의 최솟값을 찾고서
3. 해당 사람은 제거

위의 1, 2, 3번 반복한다.
 */
public class no2262 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        int low = N; // 랭킹이 가장 낮은 사람.
        int lowIndex = 0; // 랭킹이 가장 낮은 사람의 리스트에서의 인덱스
        int res = 0; // 결과값 (랭킹 차의 총 합의 최소값 )

        for(int i = 0; i < N - 1; i++){ // N - 1까지인 이유는 경기수 = 사람 수 - 1
            lowIndex = list.indexOf(low); // 랭킹이 가장 낮은사람의 인덱스를 찾고
            if(lowIndex == 0) res += list.get(lowIndex) - list.get(lowIndex + 1); // 해당 사람의 인덱스가 0 즉 첫번째 순서면, 바로 옆 대진 사람과의 랭킹 차를 구함 .
            else if(lowIndex == list.size() - 1) res += list.get(lowIndex) - list.get(lowIndex - 1); // 해당 사람의 인덱스가 끝순서면, 바로 전 대진 사람의 랭킹 차를 구함.
            else res += Math.min(list.get(lowIndex) - list.get(lowIndex - 1), list.get(lowIndex) - list.get(lowIndex + 1)); // 그게 아닐 경우, 자신을 기준으로 전, 후의 차 중 최솟값 구함.

            list.remove(lowIndex); // 최솟값 구했으니 해당 인덱스의 랭킹을 빼줌.
            low--; // 랭킹이 가장 낮은사람 업데이트.
        }
        System.out.println(res);

    }
}
