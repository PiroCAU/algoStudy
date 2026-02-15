package BOJ_1406_에디터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        M = Integer.parseInt(br.readLine());

        Stack<Character> stackLeft = new Stack<>();
        Stack<Character> stackRight = new Stack<>();
        for (int i = 0; i < len; i++) {
            stackLeft.push(s.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();

            if (command.equals("L")) {
                if (!stackLeft.isEmpty()) {
                    Character c = stackLeft.pop();
                    stackRight.push(c);
                }
            } else if (command.equals("D")) {
                if (!stackRight.isEmpty()) {
                    Character c = stackRight.pop();
                    stackLeft.push(c);
                }
            }  else if (command.equals("B")) {
                if (!stackLeft.isEmpty()) {
                    stackLeft.pop();
                }
            } else {
                char target = command.charAt(2);
                stackLeft.push(target);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stackLeft.isEmpty()) {
            sb.append(stackLeft.pop());
        }
        sb.reverse();
        while (!stackRight.isEmpty()) {
            sb.append(stackRight.pop());
        }

        System.out.println(sb);
    }
}
