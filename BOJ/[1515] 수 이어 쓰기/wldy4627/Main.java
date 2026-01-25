package boj.b1515.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String after = br.readLine();

        int N = 0;
        int index = 0;

        while (true) {
            N++;
            String base = String.valueOf(N);

            for (int i = 0; i < base.length(); i++) {
                if (base.charAt(i) == after.charAt(index)) {
                    index++;
                }

                if (index == after.length()) {
                    System.out.println(N);
                    return;
                }
            }
        }
    }
}
