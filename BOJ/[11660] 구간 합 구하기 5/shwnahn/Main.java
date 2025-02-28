package shwnahn;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // (1) N, M 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // nextInt 때문에 \n 남게 됨. 버퍼값 비우기

        // (2) matrix에 값 삽입
        int[][] matrix = new int[N+1][N+1];
        // N개의 줄에서 값 가져와서 넣기
        for (int i = 1; i <= N; i++) {
            String[] values = sc.nextLine().split(" ");
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(values[j-1]);
            }
        }

        // (new) 구간합 매트릭스 만들기 : 1-indexed 로 생성 (코드 섹시하게 만들기 위해!)
        // matrix[0][0] == sumMatrix[1][1] 인 셈이다.. 였는데 그냥 둘다 통일하기로...
        int[][] sumMatrix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumMatrix[i][j] = matrix[i][j]
                        + sumMatrix[i - 1][j]
                        + sumMatrix[i][j - 1]
                        - sumMatrix[i - 1][j - 1];
            }
        }

        // (3) x1,y1,x2,y2 합 구하기
        for (int i = 1; i <= M; i++) {
            int sum = 0;
            String[] values = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(values[0]);
            int y1 = Integer.parseInt(values[1]);
            int x2 = Integer.parseInt(values[2]);
            int y2 = Integer.parseInt(values[3]);

            sum = sumMatrix[x2][y2]
                    - sumMatrix[x1 - 1][y2]
                    - sumMatrix[x2][y1 - 1]
                    + sumMatrix[x1 - 1][y1 - 1];

            System.out.println(sum);
        }

        sc.close();
    }
}

// N*N 수가 채워짐
// x1, y1 부터 x2, y2 까지의 합을 구하는 프로그램
// x1,y1 부터 x2,y2 의 값을 구하려면 어떻게 해야 할까?
// for문 두개로 순회하면서 값 더하면 될 것 같은데
// for (int i = x1 - 1; i < x2; i++) ... for(int i = y1 - 1; i < y2; i++)

// ISSUE
// 시간복잡도..! >> 서칭해보니 '구간합'을 미리 구해놓고 저장하는 식으로 한다고 함.
