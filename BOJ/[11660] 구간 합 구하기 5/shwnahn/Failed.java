package shwnahn;

import java.util.Scanner;

public class Failed {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // (1) N, M 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // nextInt 때문에 \n 남게 됨. 버퍼값 비우기

        // (2) matrix에 값 삽입
        int[][] matrix = new int[N][N];
        // N개의 줄에서 값 가져와서 넣기
        for (int i = 0; i < N; i++) {
            String[] values = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }

        // (3) x1,y1,x2,y2 합 구하기
        for (int i = 0; i < M; i++) {
            int sum = 0;
            String[] values = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(values[0]);
            int y1 = Integer.parseInt(values[1]);
            int x2 = Integer.parseInt(values[2]);
            int y2 = Integer.parseInt(values[3]);

//            System.out.println("좌표: " + x1 + y1 + x2 + y2);
            for (int x = x1 - 1; x < x2; x++) {
                for (int y = y1 - 1; y < y2; y++) {
                    sum += matrix[x][y];
                }
            }
            System.out.println(sum);
        }

        sc.close();
    }
}
