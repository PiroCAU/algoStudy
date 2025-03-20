package PROGRAMMSERS.p62048.wldy4627;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static long solution(int w, int h) {
        long max = (long) w * (long) h;

        // w와 h의 최대 공약수 구하기
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();

        int notSquare = w + h - gcd;

        return max - (long) notSquare;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w, h;
        w = sc.nextInt();
        h = sc.nextInt();

        sc.close();

        long result = solution(w, h);
        System.out.println(result);
    }
}