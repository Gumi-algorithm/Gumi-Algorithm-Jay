package BojAlgorithms;

import java.io.*;
import java.util.StringTokenizer;

public class no10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static char[][] map;
    static char[][] map2;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];   // 일반인 색깔표 선언
        map2 = new char[N][N];  // 색약인 색깔표 선언
        for(int row = 0; row < N; row++){
            String line = br.readLine();
            for(int col = 0; col < N; col++){
                map[row][col] = line.charAt(col);   // 일반인 색깔표 입력
                if(line.charAt(col) == 'R') // 색약인 빨 == 초 같이 느끼니까 입력값이 빨강이면 초록으로바꿔줌니다.
                    map2[row][col] = 'G';
                else map2[row][col] = line.charAt(col); // 파랑일 경우 그냥 입력받기
            }
        }
        int normalCnt = 0;  // 일반인들이 볼수있는 색상 구분된 수 카운트
        int blindCnt = 0;   // 색약인들이 볼수있는 색상 구별 카운트

        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){   // 일반인, 색약인 각각 나눠서 실행
                if (map[row][col] != '.') {
                    dfsNormal(row, col, map[row][col]);
                    normalCnt++;
                }
                if (map2[row][col] != '.') {
                    dfsBlind(row, col, map2[row][col]);
                    blindCnt++;
                }
            }
        }
        sb.append(normalCnt).append(" ").append(blindCnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }
    public static void dfsNormal(int x, int y, char color) {
        map[x][y] = '.';    // 방문체크용, 만약 방문했다면 .으로 업데이트

        for(int d = 0; d < 4; d++){ // 사방탐색
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;    // 가지치기를 이해해버렸다. (범위체크)
            if(map[nx][ny] == '.') continue;    // 가지치기 2 ( 방문된곳이면 패스 )
            if(map[nx][ny] != color) continue; // 가지치기 3 (만약 같은색이 아니면 패스)
            dfsNormal(nx, ny, map[nx][ny]); // 재귀
        }
    }
    public static void dfsBlind(int x, int y, char color){
        map2[x][y] = '.';

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(map2[nx][ny] == '.') continue;
            if(map2[nx][ny] != color) continue;
            dfsBlind(nx, ny, map2[nx][ny]);
        }

    }
}
