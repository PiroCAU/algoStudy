package src.week4.점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fail {
    static int N;
    static int[][] grid;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // (1) 입력 받기
        N = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // (2) 이동하기
        // 현재 위치 (r, c)
        int[] current = {0, 0};
        move(grid[0][0], current);
        System.out.println(count);

    }
    // 이동하기 함수
    public static void move(int step, int[] current) {

        // i. 아래쪽 이동
        int down = current[0] + step;
        if (down < N) { // 아래쪽 이동 가능한 경우

            if (down == N - 1 && current[1] == N - 1) { // 도착점에 도착한 경우
                count++;
                return;
            }
            if (grid[down][current[1]] == 0) return;
            move(grid[down][current[1]], new int[]{down, current[1]});
        }

        // ii. 오른쪽 이동
        int right = current[1] + step;
        if (right < N) { // 아래쪽 이동 가능한 경우

            if (current[0] == N - 1 && right == N - 1) { // 도착점에 도착한 경우
                count++;
                return;
            }
            if (grid[current[0]][right] == 0) return;
            move(grid[current[0]][right], new int[]{current[0], right});
        }
    }
}
