import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N;
    private static char[] balls;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        balls = br.readLine().toCharArray();

        int rCnt = 0, bCnt = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i] == 'R')
                rCnt++;
            else
                bCnt++;
        }

        // 1. 빨간걸 움직여서
        // 빨간걸 왼쪽
        int rLeft = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i] == 'R')
                rLeft++;
            else
                break;
        }

        int ans = rCnt - rLeft;
        // 빨간걸 오른쪽
        int rRight = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls[i] == 'R')
                rRight++;
            else
                break;
            ;
        }

        ans = Math.min(ans, rCnt - rRight);
        // 2. 파란걸 움직여서
        // 파란걸 왼쪽
        int bLeft = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i] == 'B')
                bLeft++;
            else
                break;
        }

        ans = Math.min(ans, bCnt - bLeft);
        // 파란걸 오른쪽
        int bRight = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls[i] == 'B')
                bRight++;
            else
                break;
            ;
        }

        ans = Math.min(ans, bCnt - bRight);

        System.out.println(ans);
    }
}

// 1. 바로 옆에 다른 색의 볼이 있으면 그 볼을 모두 뛰어넘음
// 2. 옮길 수 있는 볼의 색은 한가지
// 최소 이동 횟수
// 맨 마지막거의 색을 그쪽으로 통일
// 땡!