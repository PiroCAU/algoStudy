package boj.b15565.wldy4627;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0, end = 0;
        int lionCnt = 0;
        int minLen = Integer.MAX_VALUE;
        for (end = 0; end < N; end++) {
            if (arr[end] == 1) {
                lionCnt++;
            }

            while (lionCnt >= K) {
                minLen = Math.min(minLen, end - start + 1);
                if (arr[start++] == 1) lionCnt--;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(minLen);
        }
    }
}
