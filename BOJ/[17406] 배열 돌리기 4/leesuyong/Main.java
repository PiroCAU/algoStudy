import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[][] ops;
    static boolean[] used;
    static int[] order;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: N, M, K
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 배열  입력
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전 연산 입력
        ops = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            ops[i][0] = r;
            ops[i][1] = c;
            ops[i][2] = s;
        }

        used = new boolean[K];
        order = new int[K];

        perm(0);
        System.out.println(answer);
    }

    // 아떤 순환을 먼저할 것인지 모든 경우의 수를 파악
    static void perm(int depth) {
        if (depth == K) {
            int[][] arr = copy(map);
            for (int i = 0; i < K; i++) {
                int[] op = ops[order[i]];
                rotate(arr, op[0], op[1], op[2]);
            }
            answer = Math.min(answer, rowMin(arr));
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!used[i]) {
                used[i] = true;
                order[depth] = i;
                perm(depth + 1);
                used[i] = false;
            }
        }
    }

    // 회전 연산
    static void rotate(int[][] arr, int r, int c, int s) {
        for (int layer = 1; layer <= s; layer++) {
            int top = r - layer, left = c - layer;
            int bottom = r + layer, right = c + layer;

            int temp = arr[top][left];

            // 왼쪽 열 위로
            for (int i = top; i < bottom; i++)
                arr[i][left] = arr[i + 1][left];
            // 아래 행 왼쪽으로
            for (int j = left; j < right; j++)
                arr[bottom][j] = arr[bottom][j + 1];
            // 오른쪽 열 아래로
            for (int i = bottom; i > top; i--)
                arr[i][right] = arr[i - 1][right];
            // 위 행 오른쪽으로
            for (int j = right; j > left + 1; j--)
                arr[top][j] = arr[top][j - 1];
            arr[top][left + 1] = temp;
        }
    }

    // 각 행의 합 중 최솟값 계산
    static int rowMin(int[][] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) sum += arr[i][j];
            min = Math.min(min, sum);
        }
        return min;
    }

    static int[][] copy(int[][] src) {
        int[][] copied = new int[N][M];
        for (int i = 0; i < N; i++) {
            copied[i] = src[i].clone();
        }

        return copied;
    }
}
