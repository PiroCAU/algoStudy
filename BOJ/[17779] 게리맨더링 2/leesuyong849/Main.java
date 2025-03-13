import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int totalN = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[][] ints = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
                totalN += ints[i][j];
            }
        }

        //최소값을 저장할 곳을 위해 큰 수 입력
        int diff = 20000000;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        //라인이 영역 밖으로 나가는 경우
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;

                        //해당 케이스에서 각 영역별 값 구하기
                        int[] cnt = counting(x, y, d1, d2, ints, N);
                        int maxInt = Arrays.stream(cnt).max().getAsInt();
                        int minInt = Arrays.stream(cnt).min().getAsInt();
                        diff = Math.min(diff, maxInt - minInt);
                    }
                }
            }
        }

        System.out.println(diff);
    }

    private static int[] counting(int x, int y, int d1, int d2, int[][] ints, int N) {
        int[] cnt = new int[5];     //각 구역별로 결과 값을 저장한다.
        int[][] line = new int[N][N];       //5구역의 경계선과 내부

        //5 구역 경계선 설정
        for (int i = 0; i <= d1; i++) {
            line[x + i][y - i] = 5;
            line[x + d2 + i][y + d2 - i] = 5;
        }
        for (int i = 0; i <= d2; i++) {
            line[x + i][y + i] = 5;
            line[x + d1 + i][y - d1 + i] = 5;
        }

        // 1 구역 인구수
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (line[i][j] == 5) break;
                cnt[0] += ints[i][j];
            }
        }

        // 2 구역 인구수
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (line[i][j] == 5) break;
                cnt[1] += ints[i][j];
            }
        }

        // 3 구역 인구수
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (line[i][j] == 5) break;
                cnt[2] += ints[i][j];
            }
        }

        // 4 구역 인구수
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (line[i][j] == 5) break;
                cnt[3] += ints[i][j];
            }
        }

        cnt[4] = totalN - cnt[0] - cnt[1] - cnt[2] - cnt[3];
        return cnt;
    }
}
