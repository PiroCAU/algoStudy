import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] ints = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j <= i; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                ints[i][j] = parseInt;
            }
        }

        int[][] result = new int[n][n];

        //초기설정
        result[0][0] = ints[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    result[i][j] = result[i-1][j] + ints[i][j];
                } else if (j == i) {
                    result[i][j] = result[i-1][j-1] + ints[i][j];
                } else {
                    result[i][j] = Math.max(result[i-1][j-1], result[i-1][j]) + ints[i][j];
                }
            }
        }
        System.out.println(Arrays.stream(result[n-1]).max().getAsInt());
    }
}

/**
 * git pull 잘못했다...
 */
