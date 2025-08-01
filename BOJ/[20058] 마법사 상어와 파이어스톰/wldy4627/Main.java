package boj.b20058.wldy4627;

import java.util.Scanner;

public class Main {
    static int cnt;
    static int[][] ice;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        cnt = 1 << N;
        ice = new int[cnt][cnt];
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                ice[i][j] = sc.nextInt();
            }
        }

        int[] level = new int[Q];
        for (int i = 0; i < Q; i++) {
            level[i] = sc.nextInt();
        }

        for (int i = 0; i < Q; i++) {
            int size = 1 << level[i];
            for (int r = 0; r < cnt; r += size) {
                for (int c = 0; c < cnt; c += size) {
                    rotate(ice, r, c, size);
                }
            }
            deceive();
        }

        int iceSum = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                iceSum += ice[i][j];
            }
        }

        visited = new boolean[cnt][cnt];
        int maxSize = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                if (!visited[i][j] && ice[i][j] > 0) {
                    int size = dfs(i, j);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        System.out.println(iceSum);
        System.out.println(maxSize);
    }

    static void rotate(int[][] ice, int r, int c, int size) {
        int[][] temp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[j][size - 1 - i] = ice[r + i][c + j];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ice[r + i][c + j] = temp[i][j];
            }
        }
    }

    static void deceive() {
        int[][] temp = new int[cnt][cnt];
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                if (ice[i][j] == 0) {
                    temp[i][j] = 0;
                    continue;
                }

                int iceCnt = 0;
                for (int k = 0; k < 4; k++) {
                    if (i + dx[k] >=0 && i + dx[k] < cnt && j + dy[k] >=0 && j + dy[k] < cnt) {
                        if (ice[i + dx[k]][j + dy[k]] > 0) {
                            iceCnt++;
                        }
                    }
                }
                if (iceCnt < 3) {
                    temp[i][j] = ice[i][j] - 1;
                } else {
                    temp[i][j] = ice[i][j];
                }
            }
        }

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                ice[i][j] = temp[i][j];
            }
        }
    }

    static int dfs(int r, int c) {
        visited[r][c] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx >= 0 && nx < cnt && ny >= 0 && ny < cnt) {
                if (!visited[nx][ny] && ice[nx][ny] > 0) {
                    count += dfs(nx, ny);
                }
            }
        }

        return count;
    }
}
