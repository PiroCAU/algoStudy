package src.week4.직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            int maxR = Math.max(q1, q2);
            int maxC = Math.max(p1, p2);

            int[][] grid = new int[maxR + 1][maxC + 1];

            // grid에 직사각형 삽입
            for (int r = y1; r <= q1; r++) {
                for (int c = x1; c <= p1; c++) {
                    grid[r][c]++;
                }
            }
            for (int r = y2; r <= q2; r++) {
                for (int c = x2; c <= p2; c++) {
                    grid[r][c]++;
                }
            }

//        for (int[] row : grid) {
//            System.out.println(Arrays.toString(row));
//        }

            // set 2개 만들어서 row, column 개수 세기
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            for (int r = 0; r <= maxR; r++) {
                for (int c = 0; c <= maxC; c++) {
                    if (grid[r][c] == 2) { // 겹친 부분
                        rowSet.add(r);
                        colSet.add(c);
                    }
                }
            }

//        grid값이 모두 1이하면 공통부분 없는 것
//        grid값이 2인 게 있으면 겹친 것.
//                - 겹친 rowCount, colCount를 구하기
//                - 둘 다 1이면 점
//        - 둘 중 하나는 1, 나머지 2이상이면 선분
//        - 둘다 2 이상이면 직사각형
            if (rowSet.isEmpty() && colSet.isEmpty()) {
                System.out.println("d"); // 안 겹침
            } else if (rowSet.size() == 1 && colSet.size() == 1) {
                System.out.println("c"); // 점
            } else if (rowSet.size() == 1 || colSet.size() == 1) {
                System.out.println("b"); // 선분
            } else {
                System.out.println("a"); // 직사각형
            }

//            System.out.println(rowSet.size());
//            System.out.println(colSet.size());
        }
    }
}
