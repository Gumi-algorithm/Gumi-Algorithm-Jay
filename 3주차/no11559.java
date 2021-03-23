package BojAlgorithms;
/*
 *
 *   1. 4개이상 연결될 경우 터지기 때문에 이걸 찾는다 bfs로
 *   2. 한번에 터진애들은 모두 . 로 바꾸고
 *   3. 공중에 뜬 뿌요들 바닥으로 내리기
 *   4. 위의 과정 반복, 만약 4개이상 연결된 뿌요가 없으면 종료
 *
 * */
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class no11559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char [][]map;
    static boolean [][] v;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int crashCnt;
    static int sum;

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        map = new char[12][6];
        for(int i = 0; i < map.length; i++){
            String ipt = br.readLine();
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = ipt.charAt(j);
            }
        }

        while(true){
            v = new boolean[12][6]; // 루프돌면서 방문초기화
            crashCnt = 0;   // 터진 횟수
            for (int i = 11; i >= 0; i--) {
                for (int j = 5; j >= 0; j--) {
                    if (map[i][j] != '.' && !v[i][j]) { // 아직 방문 안했고 블럭일 경우 bfs 시작
                        bfs(new Point(i, j));
                    }
                }
            }
            if (crashCnt == 0) {    // 터진 횟수 0이면 나옴
                break;
            }
            else{
                sum++; // 연쇄 카운팅
            }

            downPuyo(); // 매 루프 끝에, 즉 뿌요 다 터트리면 위에 뜬 애들 끌어내리기
        }
        System.out.println(sum);
//        for(int i = 0; i < map.length; i++){
//            for(int j = 0; j < map[0].length; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static void bfs(Point p) {
        char c = map[p.x][p.y];
        int cntLine = 0; // 각 뿌요들 같은 색 연결된 것 카운트
        Queue<Point> q = new LinkedList<Point>();
        ArrayList<Point> crushed = new ArrayList<Point>();  // 깰수있는 뿌요들 담아두는 어레이리스트
        v[p.x][p.y] = true; // 방문체크
        q.offer(p); // 큐에 삽입

        while (!q.isEmpty()) {
            Point idx = q.poll();
            crushed.add(idx);
            cntLine++;

            for(int d = 0; d < 4; d++){ // 4방 탐색
                int nx = idx.x + dx[d];
                int ny = idx.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && map[nx][ny] == c && !v[nx][ny]) {
                    v[nx][ny] = true; // 해당되면 방문체크
                    q.offer(new Point(nx, ny));
                }
            }
        }
        if (cntLine >= 4) { // 4개이상 연결됬을때 = 깰 수 있다.
            crashCnt++; // 펑 !  카운트
            for(int i = 0; i < crushed.size(); i++){
                Point tmp = crushed.get(i);
                map[tmp.x][tmp.y] = '.';
            }
        }
    }
    public static void downPuyo(){ // 끌어내리기
        for (int i = 11; i >= 0; i--) { // 아래에서부터 순회하면서
            for (int j = 5; j >= 0; j--) {
                if (map[i][j] != '.') { // 공중에 남아있는 뿌요일때
                    downToGround(i, j);
                }
            }
        }
    }

    public static void downToGround(int x, int y) { // 1열당 행 순회하면서 해당 열에 밑에부터 땅 있으면 그냥 땅 < - > 뿌요 스왑
        int a = 0;
        for (int i = 11; i > x; i--) {
            if (map[i][y] == '.') {
                a = i;
                break;
            }
        }
        if (a != 0) {
            char temp = map[x][y];
            map[x][y] = map[a][y];
            map[a][y] = temp;
        }
    }
}