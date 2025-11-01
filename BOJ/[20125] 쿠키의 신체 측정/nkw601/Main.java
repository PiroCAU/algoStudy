import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] cookies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cookies = new char[N][N];
        for (int i = 0; i < N; i++) {
            cookies[i] = br.readLine().toCharArray();
        }

        int[] heart = findHeart();
        int r = heart[0], c = heart[1];

        int leftArm = 0, rightArm = 0, waist = 0, leftLeg = 0, rightLeg = 0;

        // 왼팔
        int j = c - 1;
        while (j >= 0 && cookies[r][j] == '*') {
            leftArm++;
            j--;
        }

        // 오른팔
        j = c + 1;
        while (j < N && cookies[r][j] == '*') {
            rightArm++;
            j++;
        }

        // 허리
        int i = r + 1;
        while (i < N && cookies[i][c] == '*') {
            waist++;
            i++;
        }
        
        int startR = i;
        // 왼다리
        int lc = c - 1;
        i = startR;
        if (lc >= 0) {
            while (i < N && cookies[i][lc] == '*') {
                leftLeg++;
                i++;
            }
        }

        // 오른다리
        int rc = c + 1;
        i = startR;
        if (rc < N) {
            while (i < N && cookies[i][rc] == '*') {
                rightLeg++;
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append((r + 1)).append(" ").append((c + 1)).append('\n')
          .append(leftArm).append(" ")
          .append(rightArm).append(" ")
          .append(waist).append(" ")
          .append(leftLeg).append(" ")
          .append(rightLeg);
        System.out.println(sb.toString());
    }

    private static int[] findHeart() {
        for (int i = 1; i <= N - 2; i++) {
            for (int j = 1; j <= N - 2; j++) {
                if (cookies[i][j] == '*'
                        && cookies[i - 1][j] == '*'
                        && cookies[i + 1][j] == '*'
                        && cookies[i][j - 1] == '*'
                        && cookies[i][j + 1] == '*') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

/*
 * 입력
 * - N
 * - N*N 판
 * 출력
 * - 심장x y
 * - 왼쪽팔 오른쪽팔 허리 왼쪽다리 오른쪽다리 길이
 * 
 * 이해
 * 1. 심장: 위아래양옆 다 있는 친구
 * 2. 심장부터 왼쪽 오른쪽 직진: 팔
 * 3. 심장부터 아래 직진: 허리
 * 4. 허리 마지막에서 왼쪽 오른쪽 한칸 대각선부터 쭊
 */
