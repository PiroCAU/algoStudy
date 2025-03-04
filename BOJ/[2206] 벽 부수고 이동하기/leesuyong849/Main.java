import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        private int x, y;
        int flag;

        public Node(int x, int y, int flag) {
            this.x = x;
            this.y = y;
            this.flag = flag;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][][] ints = new int[N][M][2];
        ArrayDeque<Node> nodes = new ArrayDeque<Node>();
        //시작점
        nodes.add(new Node(0, 0, 0));
        ints[0][0][0] = 1;
        ints[0][0][1] = 1;

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                int input = line.charAt(j) - '0';
                if (input == 1) {
                    ints[i][j][0] = -1;        //ints에 접근 횟수를 저장할 생각이기 때문에 1이 아닌 -1 저장
                    ints[i][j][1] = -1;        //ints에 접근 횟수를 저장할 생각이기 때문에 1이 아닌 -1 저장

                } else if (input == -1) {
                    ints[i][j][0] = input;     //0은 그대로 저장
                    ints[i][j][1] = input;     //0은 그대로 저장
                }
            }
        }

        while (!nodes.isEmpty()) {
            Node next = nodes.poll();

            if (next.x == N - 1 && next.y == M - 1) {
                break;
            }

            int[] nextX = {next.x - 1, next.x + 1, next.x, next.x};
            int[] nextY = {next.y, next.y, next.y -1, next.y + 1};

            for (int i = 0; i < 4; i++) {

                int x = nextX[i];
                int y = nextY[i];

                if (x >= 0 && x < N && y >= 0 && y < M) {

                    //아직 벽을 부수지 않은 경우
                    if (next.flag == 0) {
                        if (ints[x][y][0] == 0) {
                            ints[x][y][0] = ints[next.x][next.y][0] + 1;
                            nodes.add(new Node(x, y, next.flag));
                        }
                        if (ints[x][y][1] == -1) { // 벽을 부순 상태에서 처음 방문하는 경우만
                            ints[x][y][1] = ints[next.x][next.y][0] + 1;
                            nodes.add(new Node(x, y, 1));
                        }
                    }

                    //이미 한 번 벽을 부순 경우
                    if (next.flag == 1) {
                        if (ints[x][y][1] == 0) {
                            ints[x][y][1] = ints[next.x][next.y][1] + 1;
                            nodes.add(new Node(x, y, 1));
                        }
                    }

                }
            }
        }


        int ans = 0;
        if (ints[N - 1][M - 1][0] > 0 && ints[N - 1][M - 1][1] > 0) {
            ans = Math.min(ints[N - 1][M - 1][0], ints[N - 1][M - 1][1]);
        } else if (ints[N - 1][M - 1][0] > 0) {
            ans = ints[N - 1][M - 1][0];
        } else if (ints[N - 1][M - 1][1] > 0) {
            ans = ints[N - 1][M - 1][1];
        } else {
            ans = -1;
        }
        System.out.println(ans);
    }


}
