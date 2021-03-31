package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class no3190{

    static int[] dx = {-1 ,0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;
        public Point(int x, int y){this.x = x; this.y = y;}
    }

    private static int changeDir(int dir, char instruct){
        int next;
        if(instruct == 'D')
            next = (dir==3) ? 0 : ++dir;
        else
            next = (dir==0)? 3 : --dir;

        return next;
    }

    private static Point getNextPos(Point p, int dir){
        Point np = new Point(p.x, p.y);
        switch (dir){
            case 0: --np.x; break;
            case 1: ++np.y; break;
            case 2: ++np.x; break;
            case 3: --np.y; break;
        }
        return np;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 보드 크기 (N x N)
        int K = sc.nextInt();   // 사과 개수
        int L;                  // 명령어 개수
        int time = 0;           // 시간초
        int dir = 1;            // 이동 방향 (북-0, 동-1, 남-2, 서-3)

        Queue<Point> snake = new LinkedList<>();   // 뱀의 몸 좌표를 넣을 큐
        int[][] map = new int[N+2][N+2];        // 보드 (0-빈칸, 1-사과, 2-벽)
        char[] cmd = new char[100001];     // 명령

        // 벽 세팅
        for(int i=0; i<N+2; i++)
            for(int j=0; j<N+2; j++)
                if(i==0 || j==0 || i==N+1 || j==N+1)
                    map[i][j] = 2;
        // 사과 세팅
        for(int i=0; i<K; i++)
            map[sc.nextInt()][sc.nextInt()] = 1;

        L = sc.nextInt();
        // 명령어 저장
        for(int i=0; i<L; i++)
            cmd[sc.nextInt()] = sc.next().charAt(0);

        Point cur = new Point(1, 1);
        snake.offer(cur);
        map[cur.x][cur.y] = 2;

        while(true){
            ++time;
            // 뱀의 머리 위치 이동
            cur.x += dx[dir];
            cur.y += dy[dir];
            //cur = getNextPos(cur, dir);

            // 벽이나 뱀의 몸을 만났을 경우 게임 종료
            if(map[cur.x][cur.y] == 2 ){
                break;
            }

            // 빈칸인 경우 마지막 칸 꼬리를 비워줌
            if(map[cur.x][cur.y] == 0){
                Point tail = snake.poll();
                map[tail.x][tail.y] = 0;
            }
            // 머리를 큐에 넣고 맵의 변수 변경
            snake.offer(cur);
            map[cur.x][cur.y] = 2;

            // 방향전환
            if(cmd[time] == 'D' || cmd[time] == 'L')
                dir = changeDir(dir, cmd[time]);
        }

        System.out.println(time);
    }
}