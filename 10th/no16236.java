package boj;
// 모르겠땅..
//1. 먹을 물고기 있는지 탐색
//2. 제일 가까운 물고기 탐색은 BFS로, 만약 먹을 물고기 같다면 -> 가장위 -> 가장 왼쪽
//3. 먹을 물고기 찾으면,먹고 나이증가 체크
//4. 큐에 있는 모든 포인트 날리고 현재 찾은 포인트만 add

import java.util.LinkedList;
import java.util.Scanner;
public class no16236 {

    static int sea[][];
    static int n = 0;
    static int dX[] = {-1,0,1,0};
    static int dY[] = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sea = new int[n][n];

        
        LinkedList<Shark> q = new LinkedList<>();
        int age = 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sea[i][j] = sc.nextInt();
                if(sea[i][j] == 9){
                    q.add(new Shark(i, j, age));
                    sea[i][j] = 0;
                }
            }
        }
        int eat = 0;
        int time = 0;
        while(true){
            Shark sShk = q.peek();
            LinkedList<Shark> fish = new LinkedList<>();
            int [][] dist = new int[n][n];// 거리

            while (!q.isEmpty()) {
                Shark s = q.poll();
                for(int i=0; i<4; i++){
                    int nX = s.x + dX[i];
                    int nY = s.y + dY[i];

                    if(-1<nX && nX<n && -1<nY && nY<n && dist[nX][nY]==0 && sea[nX][nY] <= age){
                        dist[nX][nY] = dist[s.x][s.y] + 1;
                        //먹잇감 찾기 
                        if(1<=sea[nX][nY] && sea[nX][nY]<=6 && sea[nX][nY] < age){
                            fish.add(new Shark(nX, nY, dist[nX][nY]));
                            q.add(new Shark(nX, nY, dist[nX][nY]));
                            continue;
                        }
                        //먹잇감 없을때, 지나가기는 할수있
                        q.add(new Shark(nX, nY, dist[nX][nY]));
                    }
                }
            }

            //제일 가까운거 찾기 
            if(fish.size() == 0){
                System.out.println(time);
                return;
            }
            int d = 5000;
            Shark eatingFish = fish.get(0);
            for(int i=1; i<fish.size(); i++){
                if(eatingFish.dist > fish.get(i).dist) {
                    eatingFish = fish.get(i);
                }

                if(eatingFish.dist == fish.get(i).dist) {
                    if(eatingFish.x > fish.get(i).x){
                        eatingFish = fish.get(i);
                        continue;
                    }else if(eatingFish.x == fish.get(i).x){
                        if(eatingFish.y > fish.get(i).y);
                        eatingFish = fish.get(i);
                    }
                }
            }

            time += eatingFish.dist;
            eat++;
            sea[eatingFish.x][eatingFish.y] = 0;
            if(eat == age) {
                age++;
                eat = 0;
            }
            q.add(new Shark(eatingFish.x, eatingFish.y, age));

        }
    }
}
class Shark{
    int x;
    int y;
    int dist;
    public Shark(int x, int y, int dist) {
        super();
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
