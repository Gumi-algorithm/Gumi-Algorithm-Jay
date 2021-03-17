package forImTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class no3709 {
 
    static int N, R, finX, finY;
    static boolean[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            finX = 0;
            finY = 0;
            
            st = new StringTokenizer(br.readLine());
        
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            map = new boolean[N + 2][N + 2];
 
            
            
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                map[x][y] = true; 
            }
            
            for(int i = 0; i < map.length; i++) {
            	for(int j = 0; j < map.length; j++) {
            		System.out.print(map[i][j] + " ");
            	}
            	System.out.println();
            }
            // 레이저 배치
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            
            int dir = 0;
            
            if(lx == 0) 
            	dir = 3;
            else if(lx == N + 1) 
            	dir = 2;
            else if(ly == 0) 
            	dir = 0;
            else if(ly == N + 1) 
            	dir = 1; 
            
            dfs(lx, ly, dir);
            
            System.out.println(finX + " " + finY);
        }
 
    }
 
    private static boolean dfs(int x, int y, int d) {
        
        int nx = x + dx[d];
        int ny = y + dy[d];
        // 레이저가 보드를 벗어날 경우
        if(nx < 1 || nx > N || ny < 1 || ny > N) {
            finX = nx;
            finY = ny;
            return true;
        }
        
        if(!map[nx][ny]) dfs(nx, ny, d); // 레이저 진행방향에 거울 없을 때
        
        else dfs(nx, ny, (d + 1) % 4); // 거울이 있을 때 우회전
        return false;
    }
}

