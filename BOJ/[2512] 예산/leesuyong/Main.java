import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = 1;
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, map[i]);
        }

        M = Integer.parseInt(br.readLine());


        //만약 전체를 커버할 수 있는 경우
        if (Arrays.stream(map).sum() <= M) {
            System.out.println(max);
            return;
        }


        int ans = 0;
        while (min <= max) {
            int center = (max + min) / 2;
            int cal = 0;
            for (int n : map) {
                cal += Math.min(n, center);
            }

            if (cal <= M) {
                ans = center;
                min = center + 1;
            } else {
                max = center - 1;
            }
        }
        System.out.println(ans);
    }
}
