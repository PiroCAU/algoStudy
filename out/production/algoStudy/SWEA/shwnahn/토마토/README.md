# 알고리즘

    // 상하좌우 이동을 위한 방향 배열 (dx, dy)
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    // (3) 토마토 익는 과정 BFS
    while (!queue.isEmpty()) {
        int[] start = queue.poll();
        int x = start[0];
        int y = start[1];

        for (int i = 0; i < 4; i++) { //4방향 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크 및 익지 않은 토마토(0) 확인
            if (nx >= 0 && nx < N
                    && ny >= 0 && ny < M
                    && matrix[nx][ny] == 0) {
                matrix[nx][ny] = matrix[x][y] + 1; // 익음 처리 (기존 날짜에 +1 해서 날짜 넣기)
                queue.offer(new int[] {nx, ny}); // 새로 start 지점에 추가
            }
        }
    }

# 어려운 점

- BFS 잘 몰라요.. 찾아보면서 했음. dx, dy 개념이 생소했다.
- BFS 돌리고 나서 최대날짜를 어떻게 계산하지? 라는 고민이 많았다. 탐색 한 번 할 때마다 하루가 아니기 때문에 애매했음. -> 1에다가 더하는 식으로 해결
- 가로, 세로 헷갈림