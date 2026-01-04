package boj.b2607.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String target = br.readLine();
        int[] targetAlphabet = getAlphabetCnt(target);

        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            String word = br.readLine();
            int[] wordAlphabet = getAlphabetCnt(word);

            int sameCount = 0;
            for (int j = 0; j < 26; j++) {
                sameCount += Math.min(targetAlphabet[j], wordAlphabet[j]);
            }

            if (target.length() == word.length()) {
                if (target.length() == sameCount || target.length() - 1 == sameCount) {
                    result++;
                }
            } else if (target.length() == word.length() - 1 && sameCount == target.length()) {
                result++;
            } else if (target.length() == word.length() + 1 && sameCount == word.length()) {
                result++;
            }
        }

        System.out.println(result);
    }

    static int[] getAlphabetCnt(String target) {
        int[] counts = new int[26];

        for (char c : target.toCharArray()) {
            counts[c - 'A']++;
        }

        return counts;
    }
}
