package boj.b13904.wldy4627;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Prob {
    int d, w;

    Prob(int d, int w) {
        this.d = d;
        this.w = w;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Prob> probs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int d = sc.nextInt();
            int w = sc.nextInt();
            probs.add(new Prob(d, w));
        }
        probs.sort((a, b) -> Integer.compare(b.d, a.d));

        int ans = 0;
        int day = probs.get(0).d;
        for (int i = day; i >= 1; i--) {
            int index = -1;
            int result = 0;
            for (int j = 0; j < probs.size(); j++) {
                if (probs.get(j).d >= i && probs.get(j).w > result) {
                    result = probs.get(j).w;
                    index = j;
                }
            }
            if (index != -1) {
                ans += result;
                probs.remove(index);
            }
        }

        System.out.println(ans);
    }
}
