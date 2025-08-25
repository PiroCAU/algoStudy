import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static char[] signs;
    static boolean[] used = new boolean[10];
    static String minAns = null;  // 최솟값
    static String maxAns = null;  // 최댓값
    static boolean foundMin = false, foundMax = false;      //해당값 찾았느지 확인 위해


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        signs = new char[k];
        for (int i = 0; i < k; i++) {
            signs[i] = st.nextToken().charAt(0); // '<' 또는 '>'
        }

        for (int d = 9; d >= 0; d--) {
            used[d] = true;
            dfsMax(1, "" +d);
            used[d] = false;
            if (foundMax) break;;
        }

        used = new boolean[10];

        for (int d = 0; d <= 9; d++) {
            used[d] = true;
            dfsMin(1, "" +d);
            used[d] = false;
            if (foundMin) break;
        }

        System.out.println(maxAns);
        System.out.println(minAns);
    }

    static void dfsMax(int depth, String formed) {
        if (foundMax) return;
        if (depth == k + 1) {
            maxAns = formed;
            foundMax = true;
            return;
        }

        char last = formed.charAt(formed.length() - 1);

        for (int d = 9; d >= 0; d--) {
            if (used[d]) continue;
            if (correct((char) ('0' +d), last, signs[depth - 1])) {
                used[d] = true;
                dfsMax(depth+ 1, formed + d);
                used[d] = false;
                if (foundMax) return;
            }
        }
    }

    static void dfsMin(int depth, String formed) {
        if (foundMin) return;
        if (depth == k + 1) {
            minAns = formed;
            foundMin = true;
            return;
        }

        char last = formed.charAt(formed.length() - 1);

        for (int d = 0; d <= 9; d++) {
            if (used[d]) continue;
            if (correct((char) ('0' +d), last, signs[depth - 1])) {
                used[d] = true;
                dfsMin(depth + 1, formed + d);
                used[d] = false;
                if (foundMin) return;
            }
        }
    }

    static boolean correct(char use, char last, char sign) {
        if (sign == '<') {
            return last < use;
        }
        else return last > use;
    }
}
