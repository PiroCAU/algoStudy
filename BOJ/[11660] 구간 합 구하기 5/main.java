import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] nums = new int[n][n];
        int[][] prefix = new int[n + 1][n + 1];

        // nums 입력 배열
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // prefix 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = nums[i][j] 
                                      + prefix[i][j + 1] 
                                      + prefix[i + 1][j] 
                                      - prefix[i][j];
            }
        }

        // 구간 합 계산하기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int s = prefix[x2][y2]
                    - prefix[x1 - 1][y2]
                    - prefix[x2][y1 - 1]
                    + prefix[x1 - 1][y1 - 1];

            System.out.println(s);
        }
    }
}