package BOJ_20125_쿠키의신체측정;

import javax.swing.text.Position;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean map[][];
    static int leftArm, rightArm, leftLeg, rightLeg, body;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        map = new boolean[N][N];
        Point heart = new Point();
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            for (int j = 0; j < N; j++) {
                String token = String.valueOf(s.charAt(j));
                if (token.equals("*")) {
                    map[i][j] = true;
                    if (!flag) {
                        heart = new Point(i + 1, j);
                        flag = true;
                    }
                } else {
                    map[i][j] = false;
                }
            }
        }

        //왼 팔 찾기
        int x = heart.x;
        int y = heart.y;
        leftArm = 0;
        while (true) {
            y--;
            if (y >= 0 && map[x][y]) leftArm++;
            else break;
        }

        //오른 팔 찾기
        x = heart.x;
        y = heart.y;
        rightArm = 0;
        while (true) {
            y++;
            if (y < N && map[x][y]) rightArm++;
            else break;
        }

        //몸통 찾기
        x = heart.x;
        y = heart.y;
        body = 0;
        while (true) {
            x++;
            if (x < N && map[x][y]) body++;
            else break;
        }

        //몸통이 끝나는 곳을 저장한다.
        Point bodyEnd = new Point(x, y);

        //왼 다리 찾기
        x = bodyEnd.x;
        y = bodyEnd.y-1;
        leftLeg = 1;
        while (true) {
            x++;
            if (x < N && map[x][y]) leftLeg++;
            else break;
        }

        //오른 다리 찾기
        x = bodyEnd.x;
        y = bodyEnd.y+1;
        rightLeg = 1;
        while (true) {
            x++;
            if (x < N && map[x][y]) rightLeg++;
            else break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heart.x + 1).append(" ").append(heart.y + 1).append("\n");
        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(body).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.println(sb.toString());
    }
}
