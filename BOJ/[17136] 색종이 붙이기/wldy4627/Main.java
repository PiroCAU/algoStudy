package boj.b17136.wldy4627;

import java.util.Scanner;

public class Main {
    static int[][] paper = new int[10][10];
    static int[] colorPaper = {0, 5, 5, 5, 5, 5};  // 색종이 사이즈 별 개수
    static int min = -1;

    static boolean isCovered(int x, int y, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // 만약 색종이를 덮을 수 없는 칸이라면
                if (paper[x + i][y + j] == 0) {
                    return false;
                }
            }
        }
        // size 크기의 색종이를 덮을 수 있다면
        return true;
    }

    static void cover(int x, int y, int size, int useColorPaper) {
        if (useColorPaper == 1) colorPaper[size]++;
        else colorPaper[size]--;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                paper[x + i][y + j] = useColorPaper;
            }
        }
    }

    static void backtracking(int x, int y, int cnt) {
        // 한 칸의 위치 -> (x, y) paper[x, y]
        // 가로 방향으로 끝까지 돌았으면 한 줄 밑에서 다시 실행
        if (y > 9) {
            backtracking(x + 1, 0, cnt);
            return;
        }

        // 세로 방향으로 끝까지 돌았으면 가장 최소의 값을 출력할 수 있도록
        if (x > 9) {
            if (min == -1) {
                min = cnt;
            } else if (min > cnt) {
                min = cnt;
            }
            return;
        }

        // 현재 칸에 색종이를 놓을 수 없다면 다음 칸으로 이동
        if (paper[x][y] == 0) {
            backtracking(x, y + 1, cnt);
            return;
        }

        // 현재 칸에 색종이를 놓을 수 있다면
        // 큰 색종이부터 덮을 수 있는지 확인 -> 색종이를 가장 최소로 이용할 수 있도록
        for (int i = 5; i > 0; i--) {
            if (colorPaper[i] != 0 && (y + i) <= 10 && (x + i) <= 10) {
                // 해당 크기의 색종이를 덮을 수 있다면
                if (isCovered(x, y, i)) {
                    // 색종이로 덮기
                    cover(x, y, i, 0);
                    // 다른 경우의 수 찾기
                    backtracking(x, y + i, cnt + 1);
                    // 색종이로 덮은 것 없애고 다른 경우의 수 진행
                    cover(x, y, i, 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        sc.close();

        backtracking(0, 0, 0);
        System.out.println(min);
    }
}