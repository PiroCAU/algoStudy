import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] numbers = br.readLine().toCharArray();

        int N = 0;
        int idx = 0;
        int len = numbers.length;
        while (true) {
            if (idx == len)
                break;
            N++;

            char[] n = Integer.toString(N).toCharArray();
            for (char c : n) {
                if (c == numbers[idx]) {
                    idx++;
                    if (idx == len)
                        break;
                }
            }
        }

        System.out.println(N);
    }
}