package BOJ_14940_쉬운최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N, M, targetX, targetY;
    static int[][] map, result;
    static int[] nextX = {1, -1, 0, 0};
    static int[] nextY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;

                if (a == 2) {
                    targetX = i;
                    targetY = j;
                } else if (a == 0) {
                    result[i][j] = -1;
                }
            }
        }

        ArrayDeque<Integer> queX = new ArrayDeque<>();
        ArrayDeque<Integer> queY = new ArrayDeque<>();
        ArrayDeque<Integer> queResult = new ArrayDeque<>();
        queX.add(targetX);
        queY.add(targetY);
        queResult.add(0);
        result[targetX][targetY] = -2;

        while (!queY.isEmpty()) {
            Integer xpop = queX.pop();
            Integer ypop = queY.pop();
            Integer rpop = queResult.pop();

            if (result[xpop][ypop] != 0 && result[xpop][ypop] != -2) continue;
            else if (map[xpop][ypop] == 0) continue;

            int cur = rpop + 1;
            result[xpop][ypop] = cur;

            for (int i = 0; i < 4; i++) {
                int nx = nextX[i] + xpop;
                int ny = nextY[i] + ypop;

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    queX.add(nx);
                    queY.add(ny);
                    queResult.add(cur);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cur = result[i][j];

                if (cur == -2) sb.append("0 ");
                else if (cur == -1) sb.append("0 ");
                else sb.append(cur - 1).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
