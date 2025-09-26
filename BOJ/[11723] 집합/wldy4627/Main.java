package boj.b11723.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            String[] tokens = br.readLine().split(" ");
            String action = tokens[0];

            if (action.equals("add")) {
                set.add(Integer.parseInt(tokens[1]));
            } else if (action.equals("remove")) {
                set.remove(Integer.parseInt(tokens[1]));
            } else if (action.equals("check")) {
                sb.append(set.contains(Integer.parseInt(tokens[1])) ? 1 : 0).append("\n");
            } else if (action.equals("toggle")) {
                int num = Integer.parseInt(tokens[1]);
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            } else if (action.equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (action.equals("empty")) {
                set.clear();
            }
        }

        System.out.println(sb.toString());
    }
}
