package boj.b2467.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] liquids = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquids[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        long minSum = Long.MAX_VALUE;
        long ansLeft = 0;
        long ansRight = 0;

        while (left < right) {
            long sum = liquids[left] + liquids[right];

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ansLeft = liquids[left];
                ansRight = liquids[right];
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(ansLeft + " "+ ansRight);
    }
}
