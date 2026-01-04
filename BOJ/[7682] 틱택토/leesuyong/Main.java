package BOJ_7682_틱택토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;

            map = new char[3][3];
            int xCnt = 0, oCnt = 0, dotCnt = 0;

            for (int i = 0; i < 9; i++) {
                char c = s.charAt(i);
                map[i / 3][i % 3] = c;
                if (c == 'X') xCnt++;
                else if (c == 'O') oCnt++;
                else dotCnt++;
            }

            boolean xWin = win('X');
            boolean oWin = win('O');

            boolean valid = false;

            //개수 기본 규칙: X는 O와 같거나 1개 많아야 함
            if (xCnt == oCnt || xCnt == oCnt + 1) {

                //둘 다 이기는 경우는 불가능
                if (!(xWin && oWin)) {

                    //X가 이겼으면 X가 1개 더 많아야 함
                    if (xWin) {
                        valid = (xCnt == oCnt + 1);

                        //O가 이겼으면 개수가 같아야 함
                    } else if (oWin) {
                        valid = (xCnt == oCnt);

                        //아무도 안 이겼으면 판이 꽉 차 있어야 함
                    } else {
                        valid = (dotCnt == 0);
                    }
                }
            }

            System.out.println(valid ? "valid" : "invalid");
        }
    }

    static boolean win(char p) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == p && map[i][1] == p && map[i][2] == p) return true;
        }
        for (int j = 0; j < 3; j++) {
            if (map[0][j] == p && map[1][j] == p && map[2][j] == p) return true;
        }
        // 대각선
        if (map[0][0] == p && map[1][1] == p && map[2][2] == p) return true;
        if (map[0][2] == p && map[1][1] == p && map[2][0] == p) return true;

        return false;
    }
}
