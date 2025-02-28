import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] xy = new int[y][4];
        int[][] ints = new int[x + 1][x + 1];

        /**
         * 	1.	sumTable[i][j]는 (1,1)부터 (i,j)까지의 모든 값을 더한 결과.
         * 	2.	sumTable[i-1][j]는 (1,1)부터 (i-1,j)까지의 값을 더한 결과.
         * 	3.	sumTable[i][j-1]는 (1,1)부터 (i,j-1)까지의 값을 더한 결과.
         */
        int[][] sumTable = new int[x + 1][x + 1];

        for (int i = 1; i <= x; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= x; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
                sumTable[i][j] = ints[i][j] + sumTable[i -1][j] + sumTable[i][j - 1] - sumTable[i - 1][j - 1];
            }
        }

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 4; j++) {
                xy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < y; i++) {
            int x1 = xy[i][0];
            int y1 = xy[i][1];
            int x2 = xy[i][2];
            int y2 = xy[i][3];

            int result = sumTable[x2][y2] - sumTable[x1 - 1][y2] - sumTable[x2][y1 - 1] + sumTable[x1 - 1][y1 - 1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
