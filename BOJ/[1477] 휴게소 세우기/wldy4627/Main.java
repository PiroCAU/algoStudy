package boj.b1477.wldy4627;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> original;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        original = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            original.add(sc.nextInt());
        }
        original.add(0);
        original.add(L);
        Collections.sort(original);

        int left = 1;
        int right = L;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 0; i < original.size() - 1; i++) {
                int distance = original.get(i + 1) - original.get(i);
                count += (distance - 1) / mid;
            }

            if (count > M) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
