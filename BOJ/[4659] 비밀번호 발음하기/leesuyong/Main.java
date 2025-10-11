import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            String str = br.readLine();

            if (str.equals("end")) {
                break;
            }

            int aeiou = 0;
            int a3 = 0;
            int b3 = 0;
            Character ch = null;
            boolean flag = false;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    aeiou = 1;
                    a3++;
                    b3 = 0;

                    if (a3 == 3) {
                        System.out.println("<" + str + "> is not acceptable.");
                        flag = true;
                        break;

                    }
                } else {
                    a3 = 0;
                    b3++;
                    if (b3 == 3) {
                        System.out.println("<" + str + "> is not acceptable.");
                        flag = true;
                        break;

                    }
                }

                if (ch != null &&ch == c) {
                    if (c == 'e' || c == 'o') {
                        continue;
                    } else {
                        System.out.println("<" + str + "> is not acceptable.");
                        flag = true;

                        break;
                    }
                }

                ch = c;
            }

            if (flag) {
                continue;
            } else if (aeiou == 1) {
                System.out.println("<" + str + "> is acceptable.");
            } else {
                System.out.println("<" + str + "> is not acceptable.");
            }
        }
    }
}
