package pro.p131130.wldy4627;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));
    }

    public static int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupSize = new ArrayList<Integer>();

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int cnt = 0;
                int current = i;

                while (!visited[current]) {
                    visited[current] = true;
                    current = cards[current] - 1;
                    cnt++;
                }

                groupSize.add(cnt);
            }
        }

        if (groupSize.size() < 2) return 0;

        Collections.sort(groupSize, Collections.reverseOrder());
        return groupSize.get(0) * groupSize.get(1);
    }
}
