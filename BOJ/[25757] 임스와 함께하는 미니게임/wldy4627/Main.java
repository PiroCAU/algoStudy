package boj.b25757.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] tokens = s.split(" ");
        int N = Integer.parseInt(tokens[0]);
        String game = tokens[1];

        Set<String> gamers = new HashSet<>();
        for (int i = 0; i < N; i++) {
            gamers.add(br.readLine());
        }

        if (game.equals("Y")) {
            System.out.println(gamers.size());
        } else if (game.equals("F")) {
            System.out.println(gamers.size() / 2);
        } else {
            System.out.println(gamers.size() / 3);
        }
    }
}
