package boj.b13305.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] loadLen = new int[N - 1];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < N - 1; i++) {
            loadLen[i] = Integer.parseInt(tokens[i]);
        }

        int[] oilPrice = new int[N];
        tokens = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            oilPrice[i] = Integer.parseInt(tokens[i]);
        }

        long totalCost = 0;
        int minPrice = oilPrice[0];

        for (int i = 0; i < N - 1; i++) {
            if (oilPrice[i] < minPrice) {
                minPrice = oilPrice[i];
            }

            totalCost += (long) minPrice * loadLen[i];
        }

        System.out.println(totalCost);
    }
}
