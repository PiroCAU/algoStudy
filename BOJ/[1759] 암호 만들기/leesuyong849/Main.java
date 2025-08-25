import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;
    static char[] letters;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        letters = new char[C];
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letters);

        dfs(0, 0, new char[L]);

        System.out.print(sb.toString());
    }

    static void dfs(int start, int depth, char[] result) {
        if (depth == L) {
            // 모음 자음 조건 체크
            if (isValid(result)) {
                sb.append(new String(result)).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            result[depth] = letters[i];
            dfs(i + 1, depth + 1, result);
        }
    }

    static boolean isValid(char[] result) {
        int vowel = 0, consonant = 0;
        for (char ch : result) {
            if ("aeiou".indexOf(ch) >= 0) vowel++;
            else consonant++;
        }
        return vowel >= 1 && consonant >= 2;
    }

}
