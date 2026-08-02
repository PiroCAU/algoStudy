//package BOJ_67259_경주로건설;
//
//import java.util.Arrays;
//import java.util.PriorityQueue;
//
//public class Solution2 {
//
//    private static final int[] dx = {-1, 1, 0, 0};
//    private static final int[] dy = {0, 0, -1, 1};
//
//    public int solution(int[][] board) {
//        int n = board.length;
//        int[][][] dist = new int[n][n][4];
//
//        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
//            }
//        }
//
//        que.add(new int[]{0, 0, 0, -1});
//        int answer = Integer.MAX_VALUE;
//
//        while(!que.isEmpty()) {
//            int[] poll = que.poll();
//
//            int x = poll[1];
//            int y = poll[2];
//            int w = poll[3];
//            int dir = poll[4];
//
//            //목적지에 도달
//            if (x == n -1 && y == n - 1) {
//                answer = Math.min(answer, w);
//                continue;
//            }
//
//            //이미 더 저렴한 비용으로 처리했었다면 패스
//            if (dir != -1 && w >= dist[x][y][dir]) continue;
//
//            //다음 위치 선정
//            for (int i = 0; i < 4; i++) {
//                int nx = poll[1] + dx[i];
//                int ny = poll[2] + dy[i];
//                int nw = poll[3];
//                int nd = poll[4];
//
//                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
//                if (board[nx][ny] == 1) continue;
//
//                int nextCost = 0;
//                if (nd == -1) nextCost = 100;
//                else if (nd == i || isOpposite(nd, i)) nextCost = 100;
//            }
//        }
//
//
//    }
//
//    private boolean isOpposite(int dirA, int dirB) {
//        // 0,1 = 상하축 / 2,3 = 좌우축
//        return (dirA / 2) == (dirB / 2);
//    }
//}
