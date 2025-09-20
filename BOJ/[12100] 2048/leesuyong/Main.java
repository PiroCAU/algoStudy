import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int max = -1;
    static int[][] board;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 보드 크기
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(max);

    }

    static void dfs(int depth, int[][] map) {
        if (depth == 5) {
            updateMax(map);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] moved = move(dir, map);
            dfs(depth + 1, moved);
        }
    }

    static void updateMax(int[][] map) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (map[i][j] > max) max = map[i][j];
    }

    static int[][] move(int dir, int[][] ints) {
        int[][] map = copy(ints);
        switch (dir) {
            case 0:
                moveUp(map);
                break;
            case 1:
                movedown(map);
                break;
            case 2:
                moveleft(map);
                break;
            case 3:
                moveRight(map);
                break;
            default:
                throw new IllegalArgumentException("invalid dir: " + dir);
        }
        return map;
    }

    static int[][] copy(int[][] src) {
        int[][] dst = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, N);
        }
        return dst;
    }



    public static int[][] moveUp(int[][] map) {

        for (int i = 0; i < N; i++) {

            //일단 값을 전부 한쪽으로 모은다.
            int[] ints = Arrays.stream(map[i]).filter(o -> o != 0).toArray();
            for (int j = 0; j < ints.length - 1 ; j++) {
                if (ints[j] != 0 && ints[j + 1] == ints[j]) {
                    ints[j] = ints[j] * 2;
                    ints[j+1] = 0;
                }
            }
            int[] ints2 = Arrays.stream(map[i]).filter(o -> o != 0).toArray();

            //더해진 값이 저장하거나 0을 저장하거나
            for (int j = 0; j < N; j++) {
                if (ints2.length > j) {
                    map[i][j] = ints2[j];
                } else {
                    map[i][j] = 0;
                }
            }
        }

        return map;
    }

    public static int[][] movedown(int[][] map) {
        for (int i = 0; i < N; i++) {

            //일단 값을 전부 한쪽으로 모은다.
            int[] ints = Arrays.stream(map[i]).filter(o -> o != 0).toArray();
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] != 0 && ints[j + 1] == ints[j]) {
                    ints[j] = ints[j] * 2;
                    ints[j+1] = 0;
                }
            }
            int[] ints2 = Arrays.stream(map[i]).filter(o -> o != 0).toArray();

            //더해진 값이 저장하거나 0을 저장하거나
            for (int j = 0; j < N; j++) {
                if (ints2.length > j) {
                    map[i][N - j - 1] = ints2[j];
                } else {
                    map[i][N - j - 1] = 0;
                }
            }
        }

        return map;
    }

    public static int[][] turn(int[][] map) {
        int[][] newMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMap[i][j] = map[j][i];
            }
        }
        return newMap;
    }

    public static int[][] moveleft(int[][] maps) {
        int[][] map = turn(maps);

        int[][] ints = moveUp(map);
        return turn(ints);
    }

    public static int[][] moveRight(int[][] maps) {
        int[][] map = turn(maps);

        int[][] ints = movedown(map);
        return turn(ints);
    }
}
