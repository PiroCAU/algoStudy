package BOJ_1987_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static Character[][] map;
    static boolean[] check;
    static int[] nx = {0,0,-1,1};
    static int[] ny = {1, -1, 0,0};
    static int maxCnt = 0;
    static int curCnt = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character[R][C];
        check = new boolean[26];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        cal(0,0);
        System.out.println(maxCnt);
    }

    public static void cal(int x, int y) {
        int car = map[x][y] - 'A';
        //만약 이미 사용한 글자라면 패스
        if (check[car]) return;

        visited[x][y] = true;
        check[car] = true;
        curCnt++;
        maxCnt = Math.max(curCnt, maxCnt);

        for (int i = 0; i < 4; i++) {
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C){
                if (!visited[nextX][nextY]) {
                    cal(nextX,nextY);

                }
            }
        }

        visited[x][y] = false;
        check[car] = false;
        curCnt--;
    }
}
