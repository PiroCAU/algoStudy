package src.week4.색종이붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    static int[] paperCount = new int[6];
    static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        1. 1이 있는 위치 찾기 -> 리스트에 저장
        grid = new int[10][10];
        for (int r = 0; r < 10; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 10; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 5; i++) {
            paperCount[i] = 5;
        }

        dfs(0, 0, 0);
//        2. 해당 위치에서 가능한 모든 덮기 경우 구하기
//        3. 큰 색종이부터 덮기 실행(DFS)
//                - 최소 count 넘으면 그만찾기
//                - 덮었으면 다음 1로 이동해서 DFS
//                - 탐색 끝나면 원상복구
        if (minCount == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCount);
        }

    }

    public static void dfs(int r, int c, int count) {
        // 끝까지 갔을 때: minCount 와 count 비교
        if (r >= 10) {
            if (minCount > count) minCount = count;
            return;
        }

        // col 추가하면서 위치별로 순회하며 덮어보기
        // col 10이면 row+1
        if (c >= 10) {
            dfs(r + 1, 0, count); // 다음 row로 이동. col 초기화
            return;
        }
        // 최소 count 넘으면 그만찾기
        if (count >= minCount) {
            return;
        }

        // value 0이면 -> 다음 위치로 재귀호출
        if (grid[r][c] == 0) {
            dfs(r, c + 1, count);
            return;
        }
        // 1이면 -> 1~5 모두 덮어보기
        if (grid[r][c] == 1) {
            // 1~5 순회
            for (int size = 1; size <= 5; size++) {
                // 붙일 수 있으면 + 종이가 남아있으면
                if (paperCount[size] > 0 && isAttachable(r, c, size)) {
                    // 붙이고 다음으로 넘어가기 (dfs 재귀호출)
                    attach(r, c, size, 0);
                    paperCount[size]--;

                    count++;
                    dfs(r, c + 1, count);
                    count--;

                    // 떼고 돌아가기
                    attach(r, c, size, 1);
                    paperCount[size]++;
                }
            }
        }
    }

    private static void attach(int r, int c, int size, int value) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                grid[i][j] = value; // 0: 떼기, 1: 붙이기
            }
        }
    }

    private static boolean isAttachable(int r, int c, int size) {
        if (r + size - 1 >= 10 || c + size - 1 >= 10) return false;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (grid[i][j] == 0) return false;
            }
        }
        return true;
    }
}