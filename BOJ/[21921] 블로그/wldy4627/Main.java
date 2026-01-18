package boj.b21921.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int X = Integer.parseInt(tokens[1]);

        tokens = br.readLine().split(" ");
        int[] visitors = new int[N];
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(tokens[i]);
        }

        int currentSum = 0;
        for (int i = 0; i < X; i++) {
            currentSum += visitors[i];
        }

        int maxSum = currentSum;
        int count = 1;

        for (int i = X; i < N; i++) {
            currentSum += visitors[i] - visitors[i - X];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                count = 1;
            } else if (currentSum == maxSum) {
                count++;
            }
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(count);
        }
    }
}
