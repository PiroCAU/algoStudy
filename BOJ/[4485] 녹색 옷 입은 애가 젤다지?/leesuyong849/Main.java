package BOJ_4485_녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map, result;
    static int[] nextX = {1, -1, 0, 0};
    static int[] nextY = {0, 0, 1, -1};
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int cnt = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            map = new int[N][N];
            result = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    result[i][j] = Integer.MAX_VALUE;
                }
            }

            ArrayDeque<Integer> xque = new ArrayDeque<>();
            ArrayDeque<Integer> yque = new ArrayDeque<>();
            xque.add(0);
            yque.add(0);
            result[0][0] = map[0][0];

            while (!xque.isEmpty()) {
                Integer xpop = xque.poll();
                Integer ypop = yque.poll();
                int curCost = result[xpop][ypop];

                for (int i = 0; i < 4; i++) {
                    int nx = xpop + nextX[i];
                    int ny = ypop + nextY[i];

                    if ((nx >= 0 && nx < N && ny >= 0 && ny < N)) {
                        int targetresult = result[nx][ny];

                        if (targetresult > curCost + map[nx][ny]) {
                            result[nx][ny] = curCost + map[nx][ny];
                            xque.add(nx);
                            yque.add(ny);
                        }
                    }
                }
            }

            sb.append("Problem ").append(cnt++).append(": ").append(result[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
