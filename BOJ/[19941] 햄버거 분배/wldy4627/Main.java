package boj.b19941.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");

        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);


        String line = br.readLine();
        char[] table = new char[N];
        table = line.toCharArray();

        boolean[] eaten = new boolean[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (table[i] != 'P') continue;

            int left = Math.max(0, i - K);
            int right = Math.min(N - 1, i + K);

            for (int j = left; j <= right; j++) {
                if (table[j] == 'H' && !eaten[j]) {
                    eaten[j] = true;
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
