def solution(sizes):
    max_row = 0
    max_col = 0

    for size in sizes:
        # 더 긴 쪽이 row
        row = max(size)
        col = min(size)

        max_row = max(max_row, row)
        max_col = max(max_col, col)

    return max_row * max_col
