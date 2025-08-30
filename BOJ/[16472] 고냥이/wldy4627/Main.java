package boj.b16472.wldy4627;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String str = sc.next();

        int start = 0;
        int end = 1;
        int length = 0;
        int[] alphabet = new int[26];
        int count = 0;

        alphabet[str.charAt(start) - 'a']++;
        count++;

        while (end < str.length()) {
            if (count <= N) {
                if (alphabet[str.charAt(end) - 'a'] == 0) {
                    count++;
                }
                alphabet[str.charAt(end) - 'a']++;
                end++;
            } else {
                alphabet[str.charAt(start) - 'a']--;
                if (alphabet[str.charAt(start) - 'a'] == 0) {
                    count--;
                }
                start++;
            }
            if (count <= N) {
                length = Math.max(length, end - start);
            }

        }

        System.out.println(length);
    }
}
