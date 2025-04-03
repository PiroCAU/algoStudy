package boj.b17144.wldy4627;

import java.util.Scanner;

public class Main {
    public static int R, C, T;
    public static int[][] A;
    public static int freshTop, freshBottom;
    public static int[] dx = {-1, 0, 1, 0};  // x의 변위값
    public static int[] dy = {0, 1, 0, -1};  // x의 변위값

    public static void diffusion() {
        int[][] temp = new int[R][C];  // 임시 누적용 배열

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) {
                    int spread = A[i][j] / 5;
                    int cnt = 0;

                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x >= 0 && x < R && y >= 0 && y < C && A[x][y] != -1) {
                            temp[x][y] += spread;
                            cnt++;
                        }
                    }
                    temp[i][j] += A[i][j] - spread * cnt;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == -1) continue;
                A[i][j] = temp[i][j];
            }
        }
    }

    public static void freshAirTop() {
        // 왼쪽 열
        for (int i = freshTop - 1; i > 0; i--) {
            A[i][0] = A[i - 1][0];
        }
        // 위 행
        for (int j = 0; j < C - 1; j++) {
            A[0][j] = A[0][j + 1];
        }
        // 오른쪽 열
        for (int i = 0; i < freshTop; i++) {
            A[i][C - 1] = A[i + 1][C - 1];
        }
        // 아래 행
        for (int j = C - 1; j >= 2; j--) {
            A[freshTop][j] = A[freshTop][j - 1];
        }

        A[freshTop][1] = 0;
    }

    public static void freshAirBottom() {
        // 왼쪽 열
        for (int i = freshBottom + 1; i < R - 1; i++) {
            A[i][0] = A[i + 1][0];
        }
        // 아래 행
        for (int j = 0; j < C - 1; j++) {
            A[R - 1][j] = A[R - 1][j + 1];
        }
        // 오른쪽 열
        for (int i = R - 1; i > freshBottom; i--) {
            A[i][C - 1] = A[i - 1][C - 1];
        }
        // 위 행
        for (int j = C - 1; j > 1; j--) {
            A[freshBottom][j] = A[freshBottom][j - 1];
        }
        A[freshBottom][1] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        freshTop = -1;

        A = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] = sc.nextInt();

                if (A[i][j] == -1) {  // 공기 청정기 위치 초기화 -> 최종적으로 아래쪽의 위치가 저장됨
                    if (freshTop == -1) {
                        freshTop = i;
                    } else {
                        freshBottom = i;
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            diffusion();  // 미세먼지 확산
            freshAirTop();  // 위쪽 공기청정기 작동
            freshAirBottom();  // 아래쪽 공기청정기 작동
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) {
                    result += A[i][j];
                }
            }
        }

        System.out.println(result);
    }
}