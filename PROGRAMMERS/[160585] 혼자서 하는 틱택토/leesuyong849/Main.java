public class pro_160585 {
}

class Solution {
    public int solution(String[] board) {

        String[][] input = new String[3][3];
        Boolean isBlank = false;
        int cntO = 0;       //O의 수
        int cntX = 0;       //X의 수

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                input[i][j] = String.valueOf(board[i].charAt(j));
                if (input[i][j].equals(".")) {
                    isBlank = true;
                } else if (input[i][j].equals("O")) {
                    cntO++;
                } else if (input[i][j].equals("X")) {
                    cntX++;
                }
            }
        }

        //누가 이기는가
        boolean oWin = isWin(input, "O");
        boolean xWin = isWin(input, "X");

        // O와 X가 동시에 이기는 경우는 불가능
        if (oWin && xWin) return 0;

        // O가 이겼는데 X 개수와 같으면 잘못된 게임
        if (oWin && cntO != cntX + 1) return 0;

        // X가 이겼는데 O와 X 개수가 같지 않으면 잘못된 게임
        if (xWin && cntO != cntX) return 0;

        //o ,x 가 번갈아 가면 나와야 하는데 그렇지 못한 경우
        if (cntX > cntO) return 0;
        if (cntO - cntX > 1) return 0;


        return 1;
    }

    private boolean isWin(String[][] b, String player) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (b[i][0].equals(player) && b[i][1].equals(player) && b[i][2].equals(player)) {
                return true;
            }
        }
        // 세로
        for (int j = 0; j < 3; j++) {
            if (b[0][j].equals(player) && b[1][j].equals(player) && b[2][j].equals(player)) {
                return true;
            }
        }
        // 대각선
        if (b[0][0].equals(player) && b[1][1].equals(player) && b[2][2].equals(player)) return true;
        if (b[0][2].equals(player) && b[1][1].equals(player) && b[2][0].equals(player)) return true;

        return false;
    }
}
