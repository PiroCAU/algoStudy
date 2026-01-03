package boj.b7682.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        char[][] board = new char[3][3];
        while (true) {
            String line = br.readLine();

            if (line.equals("end")) break;

            int xCnt = 0, oCnt = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = line.charAt(i * 3 + j);
                    if (board[i][j] == 'O') {
                        oCnt++;
                    } else if (board[i][j] == 'X') {
                        xCnt++;
                    }
                }
            }

            boolean xWin = isWin(board, 'X');
            boolean oWin = isWin(board, 'O');

            if (xWin && !oWin && xCnt == oCnt + 1) {
                System.out.println("valid");
            } else if (!xWin && oWin && xCnt == oCnt) {
                System.out.println("valid");
            } else if (!xWin && !oWin && xCnt == 5 && oCnt == 4) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

        }
    }

    static boolean isWin(char[][] board, char c) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) return true;
        }

        // 세로
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c) return true;
        }

        // 대각선
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) return true;
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) return true;

        return false;
    }
}
