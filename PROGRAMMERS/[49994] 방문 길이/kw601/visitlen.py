def solution(dirs):
    move = {"U": (0, 1), "D": (0, -1), "R": (1, 0), "L": (-1, 0)}
    visited = set()
    cx, cy = 0, 0
    unique_move = 0

    for cmd in dirs:
        # URDL 체크
        dx, dy = move[cmd]

        # 다음 값 계산
        nx = cx + dx
        ny = cy + dy

        # 이동 가능 여부 확인
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            # 이동 경로 저장
            path = ((cx, cy), (nx, ny))
            path_rev = ((nx, ny), (cx, cy))
            if path not in visited and path_rev not in visited:
                visited.add(path)
                visited.add(path_rev)
                unique_move += 1
            # 이동
            cx = nx
            cy = ny
    return unique_move


def solution(dirs):
    move = {"U": (0, 1), "D": (0, -1), "R": (1, 0), "L": (-1, 0)}
    visited = set()
    cx, cy = 0, 0
    unique_move = 0

    for cmd in dirs:
        # URDL 체크
        dx, dy = move[cmd]

        # 다음 값 계산
        nx = cx + dx
        ny = cy + dy

        # 이동 가능 여부 확인
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            # 이동 경로 저장
            path = ((cx, cy), (nx, ny))
            path_rev = ((nx, ny), (cx, cy))
            if path not in visited and path_rev not in visited:
                visited.add(path)
                visited.add(path_rev)
                unique_move += 1
            # 이동
            cx = nx
            cy = ny
    return unique_move
