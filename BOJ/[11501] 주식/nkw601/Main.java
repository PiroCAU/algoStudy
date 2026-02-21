import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        // 뒤에서부터 보면서
        // 최고가보다 낮으면 구매
        // 최고가보다 높으면 판매 -> 수익
        int[] prices;
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            prices = new int[N];
            long profit = 0;
            int maxPrice = 0;

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            maxPrice = prices[N - 1];
            for (int i = N - 1; i >= 0; i--) {
                if (maxPrice > prices[i]) {
                    profit += maxPrice - prices[i];
                } else {
                    maxPrice = prices[i];
                }
            }

            sb.append(profit).append('\n');
        }

        System.out.print(sb);
    }
}