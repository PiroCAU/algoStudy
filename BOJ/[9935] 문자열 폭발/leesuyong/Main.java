import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String bomb = br.readLine();

        int n = s.length();
        int m = bomb.length();
        char last = bomb.charAt(m - 1);

        char[] stack = new char[n];
        int top = 0; // stack의 현재 길이

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            stack[top++] = c;

            if (c == last && top >= m) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (stack[top - m + j] != bomb.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) top -= m; // 폭발
            }
        }

        if (top == 0) System.out.println("FRULA");
        else System.out.println(new String(stack, 0, top));
    }

}
