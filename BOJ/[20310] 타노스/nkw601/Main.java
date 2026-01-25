import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static String sent;
    private static int zeroCnt, oneCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        sent = br.readLine();

        // 몇 개 들어갈지 세기
        for (char c : sent.toCharArray()) {
            if (c == '0')
                zeroCnt++;
            else
                oneCnt++;
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        int idx = 0;
        while (oneCnt > 0) {
            if (sent.charAt(idx) == '1') {
                sent = sent.substring(0, idx) + sent.substring(idx + 1);
                idx--;
                oneCnt--;
            }
            idx++;
        }

        idx = sent.length() - 1;
        while (zeroCnt > 0) {
            if (sent.charAt(idx) == '0') {
                sent = sent.substring(0, idx) + sent.substring(idx + 1);
                idx = sent.length();
                zeroCnt--;
            }
            idx--;
        }
        System.out.print(sent);
    }
}