package boj.b1406.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int N = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();  // left stack
        Stack<Character> right = new Stack<>(); // right stack

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));   // left stack 초기화
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alphabet = st.nextToken().charAt(0);
            switch (alphabet) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case 'P':
                    char newChar = st.nextToken().charAt(0);
                    left.push(newChar);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            sb.append(left.pop());
        }
        sb.reverse();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb.toString());
    }
}
