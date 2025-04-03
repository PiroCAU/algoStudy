import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Node[] filter = new Node[2];

    static class Node {
        int x, y, point;

        public Node(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.point = p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R, C, T;

        int nodeIndex = 0;
        Queue<Node> que = new ArrayDeque<>();



        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());


        int[][] map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < C; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                map[i][j] = parseInt;

                if (parseInt == -1) {
                    filter[nodeIndex++] = new Node(i, j, 0);
                } else if (parseInt != 0) {
                    que.add(new Node(i, j, parseInt));
                }
            }
        }

        for (int t = 0; t < T; t++) {
            int[][] temp = new int[R][C];
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int x = 0; x < R; x++) {
                for (int y = 0; y < C; y++) {
                    if (map[x][y] > 0) {
                        int amount = map[x][y] / 5;
                        int cnt = 0;
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
                                temp[nx][ny] += amount;
                                cnt++;
                            }
                        }
                        map[x][y] -= amount * cnt;
                    }
                }
            }

            // temp값을 원래 map에 합치기
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] += temp[i][j];
                }
            }

            //공기청정기
            cleanAir(map, filter, R, C);
        }

        int total = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    total += map[i][j];
                }
            }
        }
        System.out.println(total);
    }

    public static boolean isNotFilter(int x, int y) {
        if (filter[0].x == x && filter[0].y == y) {
            return false;
        } else if (filter[1].x == x && filter[1].y == y) {
            return false;
        }
        return true;
    }

    static void cleanAir(int[][] map, Node[] filter, int R, int C) {
        int top = filter[0].x;
        int bottom = filter[1].x;

        // 위쪽 (반시계)
        for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i - 1];
        map[top][1] = 0;

        // 아래쪽 (시계)
        for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
        map[bottom][1] = 0;
    }
}
