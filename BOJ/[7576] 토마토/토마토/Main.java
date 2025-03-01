package 토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // (1) M, N 받기
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine(); // nextInt 때문에 \n 남게 됨. 버퍼값 비우기

        // (2) matrix에 값 삽입
        int[][] matrix = new int[N][M];

        // BFS 세팅...
        // 큐 초기화: BFS에 사용할 LinkedList 형태의 Queue
        Queue<int[]> queue = new LinkedList<>();

        // N개의 줄에서 값 가져와서 넣기
        for (int i = 0; i < N; i++) {
            String[] values = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
                if (matrix[i][j] == 1) {
                    queue.offer(new int[] {i, j}); // BFS 시작점 추가
                }
            }
        }

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

        // (4) 최대 날짜 구하기
        int maxDays = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 만약 아직 익지 않은 토마토가 있다면 -1을 출력하고 종료
                if (matrix[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                // 가장 큰 값(익은 날짜) 갱신
                maxDays = Math.max(maxDays, matrix[i][j]);
            }
        }
        System.out.println(maxDays - 1);
    }
}


// 이 문제도 DFS, BFS..
// 인접한 토마토가 익으니까 BFS가 적절할듯
// 모든 토마토가 익을때까지.. 전체 순환.. 얼마나 걸리는지
// BFS 사용법 잘 모르겠어..
// 익은 날짜 구하는 법.. 익은 토마토에 숫자 계속 더하기 해서 n일차에 익었다 표현