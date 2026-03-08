import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int n = s.length();
        int cntA = 0;

        // 1. a의 개수를 셈
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a')
                cntA++;
        }

        // a가 0개이거나 전부 a면 교환 필요 없음
        if (cntA == 0 || cntA == n) {
            System.out.println(0);
            return;
        }

        int cntB = 0;
        // 2. B의 개수를 셈
        for (int i = 0; i < cntA; i++) {
            if (s.charAt(i) == 'b')
                cntB++;
        }

        int answer = cntB;
        // 3. 똥그랗게 돌려서 가장 적은 수 찾기
        for (int i = 1; i < n; i++) {
            int outIdx = i - 1;
            int inIdx = (i + cntA - 1) % n;

            if (s.charAt(outIdx) == 'b')
                cntB--;
            if (s.charAt(inIdx) == 'b')
                cntB++;

            answer = Math.min(answer, cntB);
        }

        System.out.println(answer);
    }
}