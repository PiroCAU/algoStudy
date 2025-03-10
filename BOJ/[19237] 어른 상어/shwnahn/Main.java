package src.week4.어른상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, k;
    static int[][][] smell;
    static int[][] sharks;
    static int[][][] movePriority;

    static int[] dr = {0, -1, 1, 0, 0}; // 1 위 2 아래
    static int[] dc = {0, 0, 0, -1, 1}; // 3 왼쪽 4 오른쪽

    public static void main(String[] args) throws IOException {

        // (1) 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫줄 N, M, k
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        smell = new int[N][N][2]; // x, y 좌표의 [0] 상어번호, [1] 냄새잔여기간
        sharks = new int[M + 1][3]; // i번 상어의 [0]현재위치 row, [1]현재위치 col, [2]방향 d

        // 상어별 위치 저장
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                int index = Integer.parseInt(st.nextToken());
                if (index != 0) {
                    sharks[index][0] = row;
                    sharks[index][1] = col;
                    smell[row][col][0] = index;
                    smell[row][col][1] = k;
                }
            }
        }
        // 상어별 방향 저장
        st = new StringTokenizer(br.readLine());
        for (int index = 1; index <= M; index++) {
            sharks[index][2] = Integer.parseInt(st.nextToken());
        }

        // 상어별 우선순위: 상어 당 4방향
        movePriority = new int[M + 1][5][5]; // i번 상어, 4방향, 우선순위
        for (int i = 1; i <= M; i++) {
            for (int direction = 1; direction <= 4; direction++) {
                st = new StringTokenizer(br.readLine());
                for (int priority = 1; priority <= 4; priority++) {
                    movePriority[i][direction][priority] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // (2) 알고리즘 구현
        boolean[] isAlive = new boolean[M + 1];
        for (int i = 1; i <= M; i++) {
            isAlive[i] = true;
        }

        int remainingSharks = M;
        int second = 0;

        // 반복
        while (remainingSharks > 1 && second <= 1000) {
            second++;

            // 1. 이동하기 - 각 상어마다 순회
            for (int index = 1; index <= M; index++) {
                if (!isAlive[index]) continue;

                int currentRow = sharks[index][0];
                int currentCol = sharks[index][1];
                int currentDir = sharks[index][2];

                boolean moved = false;
                // a. 냄새 없는 곳 먼저 가기
                for (int priority = 1; priority <= 4; priority++) {
                    int nextDir = movePriority[index][currentDir][priority];
                    int nextRow = currentRow + dr[nextDir];
                    int nextCol = currentCol + dc[nextDir];

                    if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                        continue;
                    }

                    if (smell[nextRow][nextCol][1] == 0) {
                        sharks[index][0] = nextRow;
                        sharks[index][1] = nextCol;
                        sharks[index][2] = nextDir;
                        moved = true;
                        break;
                    }
                }
                // b. 자신 냄새가 있는 장소로 가기
                if (!moved) {
                    for (int priority = 1; priority <= 4; priority++) {
                        int nextDir = movePriority[index][currentDir][priority];
                        int nextRow = currentRow + dr[nextDir];
                        int nextCol = currentCol + dc[nextDir];

                        if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && smell[nextRow][nextCol][0] == index) {
                            sharks[index][0] = nextRow;
                            sharks[index][1] = nextCol;
                            sharks[index][2] = nextDir;
                            break;
                        }
                    }
                }
            }

            // 2. 겹친 상어 삭제
            // index 작은 상어 j, index 큰 상어 i
            for (int i = 2; i <= M; i++) { // 삭제대상
                if (!isAlive[i]) continue;
                for (int j = 1; j < i; j++) { // 비교대상
                    if(!isAlive[j]) continue;

                    if (sharks[i][0] == sharks[j][0] && sharks[i][1] == sharks[j][1]) {
                        isAlive[i] = false;
                        remainingSharks--;
                        break; // 삭제대상 없어졌으니 다음 삭제대상으로..
                    }
                }
            }

            // 3. 냄새 지속시간 줄이기
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (smell[row][col][1] > 0) {  // 냄새 지속 시간이 1 이상일 경우
                        smell[row][col][1]--;  // 1을 빼기
                    }
                    if (smell[row][col][1] == 0 && smell[row][col][0] != 0) {  // 냄새 지속 시간이 0이 되면
                        smell[row][col][0] = 0;  // 냄새를 없애기
                    }
                }
            }


            // 4. 좌표마다 새 냄새(상어번호, 잔여기간) 저장하기
            for (int i = 1; i <= M; i++) {
                if (isAlive[i]) {
                    smell[sharks[i][0]][sharks[i][1]][0] = i;
                    smell[sharks[i][0]][sharks[i][1]][1] = k;
                }
            }
        }

        System.out.println(second <= 1000 ? second : -1);
    }
}
//
//    private static void addPotentialMoves(int row, int col, int index, List<int[]> potentialMoves, List<int[]> potentialToSelf) {
//        // 위
//        if (row != 0) {
//            if (smell[row - 1][col][0] == index) {
//                potentialToSelf.add(new int[]{row - 1, col, 1});
//            }
//            if (smell[row - 1][col][1] == 0) {
//                potentialMoves.add(new int[]{row - 1, col, 1});
//            }
//        }
//        // 아래
//        if (row != N - 1) {
//            if (smell[row + 1][col][0] == index) {
//                potentialToSelf.add(new int[]{row + 1, col, 2});
//            }
//            if (smell[row + 1][col][1] == 0) {
//                potentialMoves.add(new int[]{row + 1, col, 2});
//            }
//        }
//        // 왼쪽
//        if (col != 0) {
//            if (smell[row][col - 1][0] == index) {
//                potentialToSelf.add(new int[]{row, col - 1, 3});
//            }
//            if (smell[row][col - 1][1] == 0) {
//                potentialMoves.add(new int[]{row, col - 1, 3});
//            }
//        }
//        // 오른쪽
//        if (col != N - 1) {
//            if (smell[row][col + 1][0] == index) {
//                potentialToSelf.add(new int[]{row, col + 1, 4});
//            }
//            if (smell[row][col + 1][1] == 0) {
//                potentialMoves.add(new int[]{row, col + 1, 4});
//            }
//        }
//    }
