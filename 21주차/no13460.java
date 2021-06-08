package BojAlgorithms;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
BOJ_13460 구슬 탈출2
. : 빈칸
# : 공이 이동할 수 없는 장애물 / 벽
0 : 구멍 위치
R : 빨간 구슬의 위치
B : 파란 구슬의 위치
 */
public class no13460 {
    static class Point{

        int x, y, m;

        public Point(int x, int y, int m) {
            this.x = x;
            this.y = y;
            this.m = m;
        }
    }
    static int N;
    static int M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        Point red = null;
        Point blue = null;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R'){
                    red = new Point(i, j, 0);
                }
                else if(map[i][j] == 'B'){
                    blue = new Point(i, j, 0);
                }
            }
        }

        int res = bfs(red, blue);

        sb.append(res).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();


//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

    }
    public static int bfs(Point red, Point blue){

        Queue<Point> redQ = new LinkedList<>();
        Queue<Point> blueQ = new LinkedList<>();

        boolean redEnd = false;
        boolean blueEnd = false;

        redQ.add(red);
        blueQ.add(blue);

        while (!redQ.isEmpty() && !blueQ.isEmpty()) {
            Point curR = redQ.poll();
            Point curB = blueQ.poll();

            // 횟수 10번 넘어가도 구슬 못빼내면 -1 출력해서 루프 끝
            if(curR.m >= 10) break;

            // 4방 탐색
            for(int i = 0; i < 4; i++){
                Point newR = new Point(curR.x, curR.y, curR.m + 1);
                Point newB = new Point(curB.x, curB.y, curB.m + 1);

                map[newR.x][newR.y] = 'R';
                map[newB.x][newB.y] = 'B';

                redEnd = false;
                blueEnd = false;

                // 이동구간은 쭉 이어져서 while문으로
                while(true){
                    // 빨간구슬이 구멍에 빠질 경우. (파란구슬이 구멍에 빠지는지 확인해야함)
                    if (map[newR.x + dx[i]][newR.y + dy[i]] == '0') {
                        redEnd = true;
                        map[newR.x][newR.y] = '.';
                        newR.x = newR.x + dx[i];
                        newR.y = newR.y + dy[i];
                    }

                    // 파란구슬이 구멍에 빠질 경우 멈추게됨.
                    if (map[newB.x + dx[i]][newB.y + dy[i]] == '0') {
                        blueEnd = true;
                        break;
                    }

                    // 모든 구슬이 움직일 수 없을 경우 멈추게 됨(파란구슬이 이동할 수 없게되고 빨간구슬이 이동불가거나 구멍에 빠졌을 때)
                    if((map[newR.x + dx[i]][newR.y + dy[i]] != '.' || redEnd)
                            && map[newB.x + dx[i]][newB.y + dy[i]] != '.')
                        break;

                    // 빨강이 이동할 수 있을 때
                    if (map[newR.x + dx[i]][newR.y + dy[i]] == '.' && !redEnd) {
                        map[newR.x][newR.y] = '.';
                        newR.x = newR.x + dx[i];
                        newR.y = newR.y + dy[i];
                        map[newR.x][newR.y] = 'R'; // 빨강구슬의 최종위치 업데이트
                    }

                    // 파랑구슬이 이동할 수 있을 때
                    if (map[newB.x + dx[i]][newB.y + dy[i]] == '.') {
                        map[newB.x][newB.y] = '.';
                        newB.x = newB.x + dx[i];
                        newB.y = newB.y + dy[i];
                        map[newB.x][newB.y] = 'B'; // 파랑구슬의 최종위치 업데이트
                    }
                }

                // 빨강구슬이 구멍에 빠지고 파랑구슬이 아직 맵에 존재하면 빨강구슬 이동횟수 리턴
                if(redEnd && !blueEnd) return newR.m;

                if (!blueEnd) {
                    redQ.add(newR);
                    blueQ.add(newB);
                }

                // 구슬 이동이 다 끝나고 이전위치 업데이트
                if(map[newR.x][newR.y] == 'R') map[newR.x][newR.y] = '.';
                if(map[newB.x][newB.y] == 'B') map[newB.x][newB.y] = '.';
            }
        }
        return -1;
    }
}
