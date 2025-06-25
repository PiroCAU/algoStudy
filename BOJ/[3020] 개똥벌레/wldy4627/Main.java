package boj.b3020.wldy4627;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int H = sc.nextInt();
        int[] down = new int[N/2];
        int[] up = new int[N/2];

        for (int i = 0; i < N; i++) {
            int h = sc.nextInt();
            if (i % 2 == 0) down[i/2] = h;
            else up[i/2] = h;
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int min = Integer.MAX_VALUE;
        int minCnt = 0;

        for (int i = 1; i <= H; i++) {
            int destroyCnt = destroy(down, i) + destroy(up, H - i + 1);
            if (destroyCnt < min) {
                min = destroyCnt;
                minCnt = 1;
            } else if (destroyCnt == min) {
                minCnt++;
            }
        }

        System.out.println(min + " " + minCnt);
    }

    private static int destroy(int[] array, int h) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < h) {
                left = mid + 1;
            } else right = mid;
        }
        return array.length - left;
    }
}
