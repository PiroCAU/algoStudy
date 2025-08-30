package boj.b17406.wldy4627;

import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int min = Integer.MAX_VALUE;
    static int[][] A;
    static int[][] rotate;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        A = new int[N][M];
        rotate = new int[K][3];
        used = new boolean[K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 3; j++) {
                rotate[i][j] = sc.nextInt();
            }
        }

        backtrack(0, A);
        System.out.println(min);
    }

    static void backtrack(int idx, int[][] arr) {
        if (idx == K) {
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += arr[i][j];
                }
                result = Math.min(result, sum);
            }
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!used[i]) {
                used[i] = true;

                int[][] copied = new int[N][M];
                for (int j = 0; j < N; j++) {
                    copied[j] = arr[j].clone();
                }
                rotate(copied, rotate[i][0] - 1, rotate[i][1] - 1, rotate[i][2]);

                backtrack(idx + 1, copied);
                used[i] = false;
            }
        }
    }

    static void rotate(int[][] arr, int r, int c, int s) {
        for (int i = 1; i <= s; i++) {
            int top = r - i;
            int left = c - i;
            int bottom = r + i;
            int right = c + i;

            int temp = arr[top][left];

            // 왼쪽 -> 위
            for (int j = top; j < bottom; j++) {
                arr[j][left] = arr[j + 1][left];
            }
            // 아래 -> 왼쪽
            for (int j = left; j < right; j++) {
                arr[bottom][j] = arr[bottom][j + 1];
            }
            // 오른쪽 -> 아래
            for (int j = bottom; j > top; j--) {
                arr[j][right] = arr[j - 1][right];
            }
            // 위 -> 오른쪽
            for (int j = right; j > left + 1; j--) {
                arr[top][j] = arr[top][j - 1];
            }

            arr[top][left + 1] = temp;
        }
    }
}
