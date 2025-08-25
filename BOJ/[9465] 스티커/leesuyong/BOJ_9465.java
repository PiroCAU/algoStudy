import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 수
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine().trim()); // 열 개수

            int[][] a = new int[2][n];



            // 첫 번째 줄(위 행)
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[0][i] = Integer.parseInt(st.nextToken());
            }

            // 두 번째 줄(아래 행)
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[1][i] = Integer.parseInt(st.nextToken());
            }

            if (n == 1) {
                System.out.println(Math.max(a[0][0], a[1][0]));
                continue;
            }

            int[][] result = new int[2][n];

            result[0][0] = a[0][0];
            result[1][0] = a[1][0];

            result[0][1] = a[1][0] + a[0][1];
            result[1][1] = a[0][0] + a[1][1];


            for (int i = 2; i < n; i++) {
                result[0][i] = Math.max(result[1][i - 1], result[1][i - 2]) + a[0][i];
                result[1][i] = Math.max(result[0][i - 1], result[0][i - 2]) + a[1][i];
            }

            System.out.println(Math.max(result[0][n-1], result[1][n-1]));
        }


    }
}
