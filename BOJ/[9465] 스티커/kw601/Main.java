import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][n + 1];
            for (int r = 0; r < 2; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= n; c++) {
                    sticker[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            // n=1인 경우 높은 거 하나만 떼기
            if (n == 1) {
                sb.append(Math.max(sticker[0][1], sticker[1][1])).append('\n');
                continue;
            }

            int[][] dp = new int[2][n + 1];
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }

            sb.append(Math.max(dp[0][n], dp[1][n])).append('\n');
        }

        System.out.print(sb.toString());
    }
}
// 입력
// test_case 개수
// N
// 스티커 정보 2줄

// 출력
// 스티커 점수의 최대

// 생각
// 오.. dp
// sticker[2][N+1]입력
// dp[2][N+1]
// 왼쪽 오른쪽 위/이래 안됨
// dp[0][i] = max(dp[1][i-1], dp[1][i-1], sticker[0][i])