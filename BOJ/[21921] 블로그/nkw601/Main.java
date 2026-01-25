import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, X;
    private static int[] visitors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visitors = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        // 1. X일 합
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += visitors[i];
        }

        int maxVisitor = sum;
        int cnt = 1;

        // 2. 슬라이딩 윈도우
        for (int i = X; i < N; i++) {
            sum += visitors[i] - visitors[i - X];

            if (sum == maxVisitor) {
                cnt++;
            } else if (sum > maxVisitor) {
                maxVisitor = sum;
                cnt = 1;
            }
        }

        if (maxVisitor == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitor);
            System.out.println(cnt);
        }
    }
}