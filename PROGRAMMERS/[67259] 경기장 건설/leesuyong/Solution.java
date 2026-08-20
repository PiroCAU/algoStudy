package BOJ_67259_경주로건설;

import java.util.PriorityQueue;

class Solution {

    // 0:상, 1:하, 2:좌, 3:우
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int n = board.length;

        // dist[x][y][dir] = (x,y)에 dir 방향으로 진입했을 때의 최소 비용
        int[][][] dist = new int[n][n][4];
        for (int[][] plane : dist) {
            for (int[] row : plane) {
                java.util.Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        // PriorityQueue에 저장할 상태: {비용, x, y, 방향}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 시작점 (0,0)에서는 아직 진입 방향이 없으므로 dir = -1 로 표시
        pq.offer(new int[]{0, 0, 0, -1});

        int answer = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], x = cur[1], y = cur[2], dir = cur[3];

            // 도착점이면 답 후보로 기록 (더 줄어들 수 없으므로 바로 반환해도 됨)
            if (x == n - 1 && y == n - 1) {
                answer = Math.min(answer, cost);
                continue;
            }

            // 이미 더 저렴한 비용으로 이 상태를 처리한 적이 있으면 skip
            if (dir != -1 && cost > dist[x][y][dir]) {
                continue;
            }

            for (int newDir = 0; newDir < 4; newDir++) {
                int nx = x + dx[newDir];
                int ny = y + dy[newDir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] == 1) continue;

                int addCost;
                if (dir == -1) {
                    // 시작점에서의 첫 이동은 무조건 직선 취급 (코너 비용 없음)
                    addCost = 100;
                } else if (isOpposite(dir, newDir) || dir == newDir) {
                    // 같은 방향이거나 정반대 방향(직선 축이 같음) -> 직선
                    addCost = 100;
                } else {
                    // 축이 바뀜 -> 코너
                    addCost = 600;
                }

                int newCost = cost + addCost;

                if (newCost < dist[nx][ny][newDir]) {
                    dist[nx][ny][newDir] = newCost;
                    pq.offer(new int[]{newCost, nx, ny, newDir});
                }
            }
        }

        return answer;
    }

    // 같은 축(상하 <-> 상하, 좌우 <-> 좌우)인지 확인
    private boolean isOpposite(int dirA, int dirB) {
        // 0,1 = 상하축 / 2,3 = 좌우축
        return (dirA / 2) == (dirB / 2);
    }
}
