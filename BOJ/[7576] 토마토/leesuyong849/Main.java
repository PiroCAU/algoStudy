import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        private int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int cols = Integer.parseInt(st.nextToken());
        int rows = Integer.parseInt(st.nextToken());
        int[][] ints = new int[rows][cols];
        ArrayDeque<Node> nodes = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < cols; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());

                if (ints[i][j] == 1) {
                    nodes.add(new Node(i, j));
                }
            }
        }

        // BFS 탐색 시작
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!nodes.isEmpty()) {
            Node next = nodes.poll();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if (ints[nx][ny] == 0) {
                        ints[nx][ny] = ints[next.x][next.y] + 1;        //값은 몇번째에 들어온 값인지를 저장한다.
                        nodes.add(new Node(nx, ny));
                    }
                }
            }
        }

        // 최댓값 계산
        int max = 0;
        boolean flag = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (ints[i][j] == 0) {
                    flag = true;
                }
                max = Math.max(max, ints[i][j]);
            }
        }

        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(max - 1);
        }
    }
}