package boj.b14719.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int H = Integer.parseInt(tokens[0]);
        int W = Integer.parseInt(tokens[1]);

        int[] block = new int[W];
        tokens = br.readLine().split(" ");
        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(tokens[i]);
        }

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        leftMax[0] = block[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], block[i]);
        }

        rightMax[W - 1] = block[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], block[i]);
        }

        int water = 0;
        for (int i = 0; i < W; i++) {
            water += Math.max(0, Math.min(leftMax[i], rightMax[i]) - block[i]);
        }

        System.out.println(water);
    }
}
