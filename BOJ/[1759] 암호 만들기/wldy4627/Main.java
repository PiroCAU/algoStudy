package boj.b1759.wldy4627;

import java.util.*;

public class Main {
    static int L, C;
    static char[] alphabet;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        alphabet = new char[C];
        for (int i = 0; i < C; i++) {
            alphabet[i] = sc.next().charAt(0);
        }

        Arrays.sort(alphabet);
        for (int i = 0; i < C; i++) {
            dfs(i, "", 0);
        }

        for (String s : set) {
            System.out.println(s);
        }
    }

    static void dfs(int idx, String pre, int vowel) {
        if (pre.length() == L) {
            if (vowel >= 1 && L - vowel >= 2) {
                set.add(pre);
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            int nextVowel = vowel;
            if ("aeiou".indexOf(alphabet[i]) >= 0) nextVowel++;
            dfs(i + 1, pre + alphabet[i], nextVowel);
        }
    }
}
