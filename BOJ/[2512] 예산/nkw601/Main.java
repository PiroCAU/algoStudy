import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] budgets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        budgets = new int[N];

        st = new StringTokenizer(br.readLine());
        int maxReq = 0;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            sum += budgets[i];
            if (budgets[i] > maxReq) maxReq = budgets[i];
        }

        M = Integer.parseInt(br.readLine());

        if (sum <= M) {
            System.out.println(maxReq);
            return;
        }

        int low = 0;
        int high = maxReq;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long s = 0;
            
            for (int b : budgets) {
                s += (b > mid) ? mid : b;
            }

            if (s <= M) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
