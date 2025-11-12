import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;
    private static int[] belt;
    private static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2 * N];
        robot = new boolean[2 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int stage = 0;
        while (true) {
            stage++;

            // 1. 한 칸씩 돌기
            rotate();

            // 로봇 내리기
            if (robot[N - 1]) {
                robot[N - 1] = false;
            }

            // 2. 로봇 움직이기
            moveRobots();

            // 로봇 내리기
            if (robot[N - 1]) {
                robot[N - 1] = false;
            }

            // 3. 로봇 올리기
            if (belt[0] > 0 && !robot[0]) {
                robot[0] = true;
                belt[0]--;
            }

            // 4. 내구도 0인 칸 개수 세기
            if (countZero() >= K) {
                break;
            }
        }

        System.out.println(stage);
    }

    private static void rotate() {
        // belt 돌기
        int temp = belt[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = temp;

        // robot도 돌기
        boolean tempR = robot[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = tempR;
    }

    private static void moveRobots() {
        for (int i = N - 2; i >= 0; i--) { 
            // i 로봇이 있고
            // i+1 로봇이 없고 내구도 1 이상
            if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                belt[i + 1]--;
            }
        }
    }

    // 내구도 0인 칸 세기
    private static int countZero() {
        int cnt = 0;
        for (int d : belt) {
            if (d == 0) cnt++;
        }
        return cnt;
    }
}
