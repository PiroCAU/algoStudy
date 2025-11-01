package boj.b20125.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Character[][] cookies = new Character[N][N];
        boolean headFlag = false;
        int headX = 0;
        int headY = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                cookies[i][j] = line.charAt(j);
                if (cookies[i][j] == '*' && !headFlag) {
                    headFlag = true;
                    headX = i;
                    headY = j;
                }
            }
        }

        int heartX = headX + 1;
        int heartY = headY;

        int leftArm = 0, rightArm = 0, back = 0, leftLeg = 0, rightLeg = 0;
        // 왼쪽 팔 & 오른쪽 팔
        for (int i = 0; i < N; i++) {
            if (cookies[heartX][i] == '*') {
                if (i < heartY) {
                    leftArm++;
                } else if (i > heartY) {
                    rightArm++;
                }
            }
        }
        // 허리
        int backX = 0;
        for (int i = heartX + 1; i < N; i++) {
            if (cookies[i][heartY] == '*') {
                back++;
            } else {
                backX = i - 1;
                break;
            }
        }
        // 왼쪽 다리 & 오른쪽 다리
        for (int i = backX + 1; i < N; i++) {
            if (cookies[i][heartY - 1] == '*') leftLeg++;
            if (cookies[i][heartY + 1] == '*') rightLeg++;
        }

        System.out.println((heartX+1) + " " + (heartY+1));
        System.out.println(leftArm + " " + rightArm + " " + back + " " + leftLeg + " " + rightLeg);
    }
}
