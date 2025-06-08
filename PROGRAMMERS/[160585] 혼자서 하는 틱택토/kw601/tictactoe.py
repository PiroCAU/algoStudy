def solution(board):
    cnt_O = 0
    cnt_X = 0
    # boards = [list(map(str, board[i])) for i in range(3)]

    for i in range(3):
        cnt_O += board[i].count("O")
        cnt_X += board[i].count("X")

    # 1. 차례
    if cnt_O == 0 and cnt_X == 0:
        return 1

    if cnt_O != 0 or cnt_X != 0:
        if (cnt_O - cnt_X != 0) and (cnt_O - cnt_X != 1):
            return 0

    # 2. 승리 조건
    win_O, win_X = False, False

    # 2-1 가로
    for row in board:
        if row == "OOO":
            win_O = True
        elif row == "XXX":
            win_X = True

    # 2-2 세로
    for i in range(3):
        col = set([board[j][i] for j in range(3)])
        if len(col) == 1:
            if "O" in col:
                win_O = True
            elif "X" in col:
                win_X = True

    # 2-3 대각선
    diagdown = "".join([board[0][0], board[1][1], board[2][2]])
    diagup = "".join([board[2][0], board[1][1], board[0][2]])
    if diagdown == "OOO" or diagup == "OOO":
        win_O = True
    elif diagdown == "XXX" or diagup == "XXX":
        win_X = True

    if win_O and win_X:
        return 0

    # 승리 후 차례 검증
    if win_O and (cnt_O - cnt_X == 0):
        return 0

    if win_X and (cnt_O - cnt_X == 1):
        return 0

    return 1
