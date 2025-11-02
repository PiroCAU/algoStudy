import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int level = 0;                              //몇 단계인지 저장

        map = new int[N * 2 + 1];
        map[0] = Integer.MAX_VALUE;
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N * 2; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] robots = new boolean[N + 1];


        while (true) {
            level++;

            //1
            int temp = map[2 * N];
            for (int i = 1; i < 2 * N; i++) {
                map[i + 1] = map[i];
            }
            map[1] = temp;

            for (int i = N; i >= 2; i--) {
                robots[i] = robots[i - 1];
            }
//            robots[1] = false;   // 올리는 칸은 비워둔다
            robots[N] = false;   // 내리는 칸 즉시 비우기


            //2.
            for (int i = N - 1; i >= 1; i--) {
                if (robots[i] && !robots[i + 1] && map[i + 1] > 0) {
                    robots[i + 1] = true;
                    robots[i] = false;
                    map[i+1]--;
                }
            }
            robots[N] = false;

            //3.
            if (!robots[1] && map[1] > 0) {
                robots[1] = true;
                map[1]--;
            }

            //4.
            int zeroCnt = 0;
            for (int i = 1; i <= 2 * N; i++) if (map[i] == 0) zeroCnt++;
            if (zeroCnt >= K) break;
        }

        System.out.println(level);
    }
}
