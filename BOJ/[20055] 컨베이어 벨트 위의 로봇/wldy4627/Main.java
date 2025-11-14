package boj.b20055.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] containerBelt;
    static boolean[] isRobot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] tokens = line.split(" ");
        N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);

        containerBelt = new int[2 * N];
        isRobot = new boolean[N];
        line = br.readLine();
        tokens = line.split(" ");
        for (int i = 0; i < 2 * N; i++) {
            containerBelt[i] = Integer.parseInt(tokens[i]);
        }

        int step = 0;
        int zeroCnt = 0;
        while (true) {
            step++;
            // 벨트 회전
            rotateBeltAndRobots();
            // 로봇 이동
            moveRobots();
            // 로봇 올리기
            if (containerBelt[0] >= 1 && !isRobot[0]) {
                isRobot[0] = true;
                containerBelt[0]--;
            }
            // 종료 조건 확인
            zeroCnt = 0;
            for (int i = 0; i < 2 * N; i++) {
                if (containerBelt[i] == 0) {
                    zeroCnt++;
                }
            }
            if (zeroCnt >= K) break;
        }

        System.out.println(step);
    }

    static void rotateBeltAndRobots() {
        int last = containerBelt[2*N - 1];

        for (int i = 2 * N - 2; i >= 0; i--) {
            containerBelt[i + 1] = containerBelt[i];
        }
        containerBelt[0] = last;

        isRobot[N - 1] = false;
        for (int i = N - 2; i >= 0; i--) {
            isRobot[i + 1] = isRobot[i];
        }
        isRobot[0] = false;
        isRobot[N - 1] = false;
    }

    static void moveRobots() {
        for (int i = N - 2; i >= 0; i--) {
            if (isRobot[i]) {
                int next = i + 1;
                if (!isRobot[next] && containerBelt[next] >= 1) {
                    isRobot[next] = true;
                    isRobot[i] = false;
                    containerBelt[next]--;
                }
            }
        }
        isRobot[N - 1] = false;
    }
}
