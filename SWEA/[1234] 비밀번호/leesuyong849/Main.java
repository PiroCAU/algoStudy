import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int amount = sc.nextInt();
            String input = sc.next();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < amount; i++) {
                char ch = input.charAt(i);
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }

            System.out.println("#" + test_case + " " + sb);
        }
        sc.close();
    }
}