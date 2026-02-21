import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s.equals("end"))
                break;

            board = new char[3][3];

            board[0] = s.substring(0, 3).toCharArray();
            board[1] = s.substring(3, 6).toCharArray();
            board[2] = s.substring(6, 9).toCharArray();

            // 1. OOO XXX 확인
            boolean xWin = checkXWin();
            boolean oWin = checkOWin();

            // 2. . r개수
            int[] count = countLetter();
            int oCnt = count[1];
            int xCnt = count[2];
            // 3. x, o 개수
            // endCnt가 2 이상이거나
            // xCnt가 oCnt보다 적으면 invalid

            if (oCnt > xCnt || xCnt - oCnt > 1 || (xWin && xCnt != oCnt + 1) || (oWin && xCnt != oCnt)
                    || (!xWin && !oWin && count[0] != 0))
                sb.append("invalid\n");
            else
                sb.append("valid\n");
        }

        System.out.println(sb);
    }

    private static int[] countLetter() {
        int[] count = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.')
                    count[0]++;
                else if (board[i][j] == 'O')
                    count[1]++;
                else
                    count[2]++;
            }
        }
        return count;
    }

    private static boolean checkXWin() {
        boolean win = false;
        // ㅡ 방향
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == 'X')
                win = true;
        }

        // | 방향
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[2][j] == 'X')
                win = true;
        }

        // \ 방향
        if (board[0][0] == 'X' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            win = true;

        // / 방향
        if (board[0][2] == 'X' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            win = true;

        return win;
    }

    private static boolean checkOWin() {
        boolean win = false;
        // ㅡ 방향
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == 'O')
                win = true;
        }

        // | 방향
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[2][j] == 'O')
                win = true;
        }

        // \ 방향
        if (board[0][0] == 'O' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            win = true;

        // / 방향
        if (board[0][2] == 'O' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            win = true;

        return win;
    }
}
