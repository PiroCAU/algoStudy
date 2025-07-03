package boj.b16946.wldy4627;

import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static Map<Integer, Integer> movable;
    static boolean[][] visited;
    static Stack<int[]> stack;
    static int count;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M =  sc.nextInt();
        map = new int[N][M];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        stack = new Stack<>();
        visited = new boolean[N][M];
        movable = new HashMap<>();
        int flag = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    movable.put(--flag, count);
                    while(!stack.isEmpty()) {
                        int[] pos = stack.pop();
                        map[pos[0]][pos[1]] = flag;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int movableCnt = 0;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if (map[nx][ny] < 0) {
                                set.add(map[nx][ny]);
                            }
                        }
                    }
                    if (set.size() > 0) {
                        for (Integer key : set) {
                            movableCnt += movable.get(key);
                        }
                    }
                    map[i][j] = ++movableCnt % 10;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            String line = "";
            for (int j = 0; j < M; j++) {
                if (map[i][j] < 0) {
                    map[i][j] = 0;
                }
                line += map[i][j];
            }
            System.out.println(line);
        }
    }

    public static void dfs(int startX, int startY) {
        visited[startX][startY] = true;
        stack.push(new int[]{startX, startY});
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
