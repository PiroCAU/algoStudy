import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, S;
    private static int[] numbers;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        int cnt = 1;

        int sum = numbers[0];
        while (left < N) {
            if (sum < S) {
                if (right + 1 > N)
                    break;
                sum += numbers[right++];
                cnt++;
            } else {
                min = Math.min(min, cnt);
                sum -= numbers[left++];
                cnt--;
            }
        }
        System.out.println(min < Integer.MAX_VALUE ? min : 0);
    }
}
