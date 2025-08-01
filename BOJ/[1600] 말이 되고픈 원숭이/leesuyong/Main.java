import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1600 {

    static int[][] map;
    static int[] nx = {0, 0, 1, -1};
    static int[] ny = {-1, 1, 0, 0};
    static int[] nhx = {-1, 1, -2, -2, -1, 1, 2, 2};
    static int[] nhy = {2, 2, 1, -1, -2, -2, -1, 1};
    static boolean[][][] visited;
    static ArrayDeque<Node> nodes;

    static class Node {
        int x; int y; int hm; int cnt;

        public Node(int x, int y, int hm, int cnt) {
            this.x = x;
            this.y = y;
            this.hm = hm;
            this.cnt = cnt;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // K 입력
        int K = Integer.parseInt(br.readLine());

        // W, H 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken()); // 가로
        int H = Integer.parseInt(st.nextToken()); // 세로
        visited = new boolean[H][W][K + 1];

        if (W == 1 && H == 1) {
            System.out.println(0);
            return;
        }

        // 격자판 입력
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                map[i][j] = parseInt;
            }
        }

        nodes = new ArrayDeque<>();
        nodes.add(new Node(0, 0,0,0));
        visited[0][0][0] = true;

        int result = bfs(K, W, H);

        System.out.println(result);
    }

    static int bfs(int K, int W, int H) {
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();

            for (int i = 0; i < 4; i++) {
                int nextx = node.x + nx[i];
                int nexty = node.y + ny[i];

                //종착지이면 값을 출력하고 종료
                if (nextx == W - 1 && nexty == H - 1) {
                    return node.cnt + 1;
                }

                //아니면 다음 탐색 시작
                if (nextx >= 0 && nextx < W && nexty >= 0 && nexty < H) {
                    // 방문 전 체크 및 장애물 체크 (장애물은 1)
                    if (!visited[nexty][nextx][node.hm] && map[nexty][nextx] != 1) {
                        visited[nexty][nextx][node.hm] = true;
                        nodes.add(new Node(nextx, nexty, node.hm, node.cnt+1));
                    }
                }
            }
            if (node.hm < K) {
                for (int i = 0; i < 8; i++) {
                    int nextx = node.x + nhx[i];
                    int nexty = node.y + nhy[i];

                    //종착지이면 값을 출력하고 종료
                    if (nextx == W - 1 && nexty == H - 1) {
                        return node.cnt + 1;
                    }

                    if (nextx >= 0 && nextx < W && nexty >= 0 && nexty < H) {
                        if (!visited[nexty][nextx][node.hm + 1] && map[nexty][nextx] != 1) {
                            visited[nexty][nextx][node.hm + 1] = true;
                            nodes.add(new Node(nextx, nexty, node.hm+1, node.cnt+1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
