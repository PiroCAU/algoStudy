import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 건물 수
        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        // 보이는 건물 수
        int[] visible = new int[N];

        for (int i = 0; i < N; i++) {
            // i번째 건물에서 오른쪽 건물 -> 가장 큰 기울기
            double maxSlope = Double.NEGATIVE_INFINITY;

            for (int j = i + 1; j < N; j++) {
                double slope = (double) (h[j] - h[i]) / (j - i);

                if (slope > maxSlope) {
                    maxSlope = slope;
                    visible[i]++;
                    visible[j]++;
                }
            }
        }

        int answer = 0;
        for (int v : visible) {
            answer = Math.max(answer, v);
        }

        System.out.println(answer);
    }
}

/*
 * 보임: 두 지붕을 잇는 선분이 A와 B를 제외한 다른 건물을 지나거나 접하지 않음
 * -> 빌딩-빌딩 기울기 > 기울기
 * 
 * 
 * 
 */
