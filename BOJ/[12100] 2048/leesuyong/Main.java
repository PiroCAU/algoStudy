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

        for (int dir = 0; dir < 4; dir++) { // 0: up, 1: down, 2: left, 3: right
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
            case 0 -> moveUp(map);
            case 1 -> movedown(map);
            case 2 -> moveleft(map);
            case 3 -> moveRight(map);
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
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] != 0 && map[i][j + 1] == map[i][j]) {
                    map[i][j] = map[i][j] * 2;
                    map[i][j+1] = 0;
                }
            }
            int[] ints = Arrays.stream(map[i]).filter(o -> o != 0).toArray();

            //더해진 값이 저장하거나 0을 저장하거나
            for (int j = 0; j < N; j++) {
                if (ints.length > j) {
                    map[i][j] = ints[j];
                } else {
                    map[i][j] = 0;
                }
            }
        }

        return map;
    }

    public static int[][] movedown(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] != 0 && map[i][j + 1] == map[i][j]) {
                    map[i][j] = map[i][j] * 2;
                    map[i][j+1] = 0;
                }
            }
            int[] ints = Arrays.stream(map[i]).filter(o -> o != 0).toArray();

            //더해진 값이 저장하거나 0을 저장하거나
            for (int j = 0; j < N; j++) {
                if (ints.length > j) {
                    map[i][N - j - 1] = ints[j];
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
