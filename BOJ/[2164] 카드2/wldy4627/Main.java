package boj.b2164.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> card = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            card.add(i + 1);
        }

        while (card.size() > 1) {
            card.poll();

            int next = card.poll();
            card.add(next);
        }

        System.out.println(card.poll());
    }
}
