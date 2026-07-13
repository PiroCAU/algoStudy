package PRO_43163_단어변환;

import java.util.*;

public class Main {
}


class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환 불가
        boolean hasTarget = Arrays.stream(words).anyMatch(w -> w.equals(target));
        if (!hasTarget) return 0;

        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(begin);
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            //기존의 사이즈만큼만 한다. 나머진 다음 턴에
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                for (int j = 0; j < words.length; j++) {
                    //방문 안하고 차이가 하나인 것들에 대해
                    if (!visited[j] && diffByOne(current, words[j])) {
                        if (words[j].equals(target)) return cnt;
                        visited[j] = true;
                        queue.offer(words[j]);
                    }
                }
            }
        }

        return 0;
    }

    // 두 단어의 다른 글자 수가 1개인지 확인
    private boolean diffByOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}