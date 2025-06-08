package pro.p160585.wldy4627;

public class Main {
    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        int firstCnt = 0;
        int secondCnt = 0;
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'O') firstCnt++;
                if (board[i].charAt(j) == 'X') secondCnt++;
            }
        }

        // 비정상 조건
        if (firstCnt < secondCnt || firstCnt - secondCnt >= 2) {
            return answer;
        }

        boolean oWin = win(board, 'O');
        boolean xWin = win(board, 'X');

        if (oWin && xWin) {
            return answer;
        }

        if ((oWin && firstCnt == secondCnt) || (xWin && firstCnt > secondCnt)) {
            return answer;
        }

        answer = 1;
        return answer;
    }

    public static boolean win(String[] board, char word) {
        // 가로 완성
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == word && board[i].charAt(1) == word && board[i].charAt(2) == word) {
                return true;
            }
        }

        // 세로 완성
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == word && board[1].charAt(i) == word && board[2].charAt(i) == word) {
                return true;
            }
        }

        // 좌 -> 우 대각선 완성
        if (board[0].charAt(0) == word && board[1].charAt(1) == word && board[2].charAt(2) == word) {
            return true;
        }

        // 우 -> 좌 대각선 완성
        if (board[0].charAt(2) == word && board[1].charAt(1) == word && board[2].charAt(0) == word) {
            return true;
        }

        return false;
    }
}
