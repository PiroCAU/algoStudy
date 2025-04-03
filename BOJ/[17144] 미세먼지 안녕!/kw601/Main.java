import java.io.*;
import java.util.*;

public class Main {

    static int r, c, t;
    static int[][] maps;
    static int[] purifier = new int[2]; // 공청기 두 개 위치 (upper, lower)

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        maps = new int[r][c];
        int idx = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == -1) {
                    purifier[idx++] = i;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            dust();
            clean();
        }

        // 미세먼지 합 구하기
        int total = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (maps[i][j] > 0) {
                    total += maps[i][j];
                }
            }
        }

        System.out.println(total);
    }

    static void dust() {
        int[][] spread = new int[r][c];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                // 0보다 커야 미먼
                if (maps[x][y] > 0) {
                    int dusts = maps[x][y] / 5;
                    int cnt = 0;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        // maps 안에 있고, 공청기 없으면
                        if (0 <= nx && nx < r && 0 <= ny && ny < c && maps[nx][ny] != -1) {
                            spread[nx][ny] += dusts;
                            cnt++;
                        }
                    }
                    // 퍼뜨린 만큼 빼기
                    maps[x][y] -= cnt * dusts;
                }
            }
        }

        // 변한 값 더하기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                maps[i][j] += spread[i][j];
            }
        }
    }

    static void clean() {
        int upper = purifier[0];
        int lower = purifier[1];

        // 아래!
        // 왼쪽 세로
        for (int i = lower + 1; i < r - 1; i++) {
            maps[i][0] = maps[i + 1][0];
        }
        // 위
        for (int i = 0; i < c - 1; i++) {
            maps[r - 1][i] = maps[r - 1][i + 1];
        }
        // 오른쪽 세로
        for (int i = r - 1; i > lower; i--) {
            maps[i][c - 1] = maps[i - 1][c - 1];
        }
        // 아래
        for (int i = c - 1; i > 0; i--) {
            maps[lower][i] = maps[lower][i - 1];
        }
        maps[lower][1] = 0;

        // 위!
        // 왼쪽 세로
        for (int i = upper - 1; i > 0; i--) {
            maps[i][0] = maps[i - 1][0];
        }
        // 아래
        for (int i = 0; i < c - 1; i++) {
            maps[0][i] = maps[0][i + 1];
        }
        // 오른쪽 세로
        for (int i = 0; i < upper; i++) {
            maps[i][c - 1] = maps[i + 1][c - 1];
        }
        // 위
        for (int i = c - 1; i > 0; i--) {
            maps[upper][i] = maps[upper][i - 1];
        }
        maps[upper][1] = 0;
    }
}