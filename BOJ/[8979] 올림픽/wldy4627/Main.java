package boj.b8979.wldy4627;

import java.util.*;

public class Main {
    static class Nation {
        int num;
        int gold;
        int silver;
        int bronze;

        public Nation(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Nation[] nations = new Nation[N];
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();

            nations[i] = new Nation(n, gold, silver, bronze);
        }

        Arrays.sort(nations, (a, b) -> {
            if (a.gold != b.gold) return b.gold - a.gold;
            if (a.silver != b.silver) return b.silver - a.silver;
            return b.bronze - a.bronze;
        });

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0 && !sameMedal(nations[i], nations[i - 1])) {
                rank = i + 1;
            }
            if (nations[i].num == K) {
                System.out.println(rank);
                return;
            }
        }
    }

    static boolean sameMedal(Nation a, Nation b) {
        return a.gold == b.gold && a.silver == b.silver && a.bronze == b.bronze;
    }
}
