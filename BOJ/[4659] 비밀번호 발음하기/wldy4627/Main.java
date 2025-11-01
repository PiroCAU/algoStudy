package boj.b4659.wldy4627;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        while (true) {
            String test = sc.nextLine();
            if (test.equals("end")) return;

            // 1. 모음 하나를 반드시 포함하기
            boolean hasVowel = false;
            for (char c : test.toCharArray()) {
                if (vowels.contains(c)) {
                    hasVowel = true;
                    break;
                }
            }
            if (!hasVowel) {
                System.out.println("<" + test + "> is not acceptable.");
                continue;
            }

            // 2. 모음이 3개 혹은 자음이 3개 연속 오면 안 됨
            int flag = 0;
            for (int i = 0; i < test.length() - 2; i++) {
                if (vowels.contains(test.charAt(i))) {
                    if (vowels.contains(test.charAt(i+1)) && vowels.contains(test.charAt(i+2))) {
                        System.out.println("<" + test + "> is not acceptable.");
                        flag = 1;
                        break;
                    }
                } else {
                    if (!vowels.contains(test.charAt(i+1)) && !vowels.contains(test.charAt(i+2))) {
                        System.out.println("<" + test + "> is not acceptable.");
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 1) continue;

            flag = 0;
            // 3. 같은 글자가 연속적으로 두 번 오면 안 되나, ee와 oo는 허용
            for (int i = 1; i < test.length(); i++) {
                if (test.charAt(i) == test.charAt(i-1)) {
                    if (test.charAt(i) == 'e' || test.charAt(i) == 'o') {
                        continue;
                    } else {
                        System.out.println("<" + test + "> is not acceptable.");
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 1) continue;

            System.out.println("<" + test + "> is acceptable.");
        }
    }
}
