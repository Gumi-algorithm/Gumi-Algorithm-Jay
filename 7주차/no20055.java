package BojAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no20055 {

    static int N;
    static int K;
    static int[] belt;
    static int upper; // 위쪽 벨트 인덱스
    static int lower; // 아래쪽 벨트 인덱스
    static boolean[] isR; // 벨트에 로봇이 존재하는지

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2* N];
        isR = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2* N; i++)
            belt[i] = Integer.parseInt(st.nextToken());

        upper = 0;
        lower = N;

        int cnt = 0;
        while(K > 0) { // 내구도가 0 이상일 때.
            cnt++;
            moveIdx();
            moveRobot();
            settingRobot();
        }

        System.out.println(cnt);
    }

    public static void moveIdx() { // 위 아래 값 하나씩 감소시키고
        upper--;
        lower--;
        if(upper == -1) // 인덱스가 -1이라면 오른쪽으로 이동시킴.
            upper = 2* N -1;
        if(lower == -1)
            lower = 2* N -1;

        for(int i = N -2; i >= 0; i--) { // 로봇도 이동시킴.
            if(isR[i]) {
                isR[i] = false;
                if(i+1 < N -1)
                    isR[i+1] = true;
            }
        }
    }

    public static void moveRobot() { // 로봇이 오른쪽으로 이동할 수 있고 오른쪽에 내구도 있고 로봇 없으면 이동시켜주고,
        // 로봇 이동 후 내구도 --, 내구도가 0일경우 k--
        for(int i = N -2; i >= 0; i--) {
            if(isR[i]) { // 해당 인덱스에 로봇이 있다면
                int next = upper + i + 1; // 다음 인덱스 계산
                if(next >= 2* N) // 다음 인덱스가 범위를 벗어나면
                    next -= 2* N; // 배열의 크기만큼 빼주면 처음부터.
                if(!isR[i+1] && belt[next] >= 1) { //
                    isR[i] = false;
                    if(i+1 < N -1)
                        isR[i + 1] = true;
                    belt[next]--;
                    if(belt[next] == 0)
                        K--;
                }
            }
        }
    }

    public static void settingRobot() {
        if(!isR[0] && belt[upper] > 0) { // 벨트 첫 인덱스에 로봇이 없고, 처음 놓일 곳(위쪽 벨트)의 크기가 0이상일때.
            isR[0] = true; // 로봇을 놓고
            belt[upper]--; // 해당 인덱스칸 내구도 하나 빼주고
            if(belt[upper] == 0) // 내구도가 0이면
                K--;    // K 감소
        }
    }

}