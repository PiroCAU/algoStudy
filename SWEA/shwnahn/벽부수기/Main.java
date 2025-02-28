package shwnahn.벽부수기;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] matrix = new int[N][M];

        for (int i = 1; i < N; i++) {
            String line = sc.next();

        }
    }
}


// N*M 행렬. 0은 이동가능. 1은 이동불가.
// 최단경로 구하는 법
// 벽은 한 개까지 부숴도 됨.

// 어떻게 하지...?
// 이것도 dfs인거 아닐까? 왜?

