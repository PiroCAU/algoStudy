import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] ints = new int[N][N];   //입력 데이터 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] result = new long[N][N];     //DP의 결과를 저장
        result[0][0] = 1;       //초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (result[i][j] == 0 || ints[i][j] == 0) {
                    continue; // 이동 불가능한 경우 건너뛰기
                }

                int move = ints[i][j];

                int right_x = i + move;
                int down_y = j + move;

                if (right_x < N) {
                    result[right_x][j] += result[i][j];
                }
                if (down_y < N) {
                    result[i][down_y] += result[i][j];
                }
            }
        }

        System.out.println(result[N-1][N-1]);
    }
}
