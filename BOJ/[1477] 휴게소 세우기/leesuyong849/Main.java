import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력 처리 (N, M, L)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] positions;

        // 두 번째 줄 입력 처리 (N != 0 인 경우)
        if (N != 0) {
            positions = new int[N + 2];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                positions[i] = Integer.parseInt(st.nextToken());
            }
        } else {
            positions = new int[2];  // 시작점(0)과 끝점(L)만 존재
        }

        positions[0] = 0;
        positions[positions.length - 1] = L;

        Arrays.sort(positions);

        int left = 1;
        int right = L;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            // 구간을 나누며 필요한 휴게소 개수 계산
            for (int i = 1; i < positions.length; i++) {
                int distance = positions[i] - positions[i - 1];
                if (distance > mid) {
                    count += (distance - 1) / mid;  // 소수점 올림 처리
                }
            }

            if (count > M) {
                left = mid + 1;  // 더 많이 지어야 하니까 구간을 늘린다.
            } else {
                answer = mid;  // 조건 만족, 더 최적화 될 수 있으니 줄인다.
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
