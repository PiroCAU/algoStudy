package src.week6.마법의엘리베이터;

import java.util.Scanner;

public class Solution {
    private int cnt;
    public int solution(int storey) {
        cnt = 0;
        func(storey);
        return cnt;
    }

    private int cal1(int number) { // 첫자리 1~4
        System.out.println("# cal1");
        int length = String.valueOf(number).length();
        int nextNum;
        int firstDigit = number / (int) Math.pow(10, length - 1);
        int secondDigit = (number / (int) Math.pow(10, length - 2)) % 10;

        if (secondDigit <= 5) { // 더하는 방식
            nextNum = (int) (number - firstDigit * Math.pow(10, length - 1));
            cnt += firstDigit;
            System.out.println((int)(firstDigit * Math.pow(10, length - 1)) + " + " + nextNum);
        } else { // 빼는 방식
            nextNum = (int) ((firstDigit + 1) * Math.pow(10, length - 1) - number);
            cnt += firstDigit + 1;
            System.out.println((int)((firstDigit + 1) * Math.pow(10, length - 1)) + " - " + number);
        }
        System.out.println("cal1) 다음 숫자: " + nextNum);
        return nextNum;
    }

    private int cal2(int number) { // 첫자리 6~9
        System.out.println("# cal2");
        cnt += 1;
        int nextNum = (int)Math.pow(10, String.valueOf(number).length()) - number;
        System.out.println("cal2) 다음 숫자: " + nextNum);
        return nextNum;
    }

    private void func(int number) {
        if (number == 0) return;

        int length = String.valueOf(number).length();
        if (length == 1) {
            System.out.println("# 1자리 수 연산");
            cnt += Math.min(number, 10 - number + 1); // 5 이상이면 반올림 처리
            return;
        }

        int nextNum;
        int firstDigit = number / (int) Math.pow(10, length - 1);

        if (firstDigit < 5) {
            nextNum = cal1(number);
        } else if (firstDigit > 5) {
            nextNum = cal2(number);
        } else {
            System.out.println("First Digit is 5");
            int secondDigit = (number / (int) Math.pow(10, length - 2)) % 10;
            if (secondDigit < 5) nextNum = cal1(number);
            else nextNum = cal2(number);
        }
        func(nextNum);

    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력값: ");
        int storey = scanner.nextInt();
        long result = sol.solution(storey); // 예상 result: 6
        System.out.println("결과: " + result);
    }
}