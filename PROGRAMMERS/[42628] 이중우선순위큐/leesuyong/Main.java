package PRO_42628_이중우선순위큐;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {
}

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            char cmd = parts[0].charAt(0);
            int num = Integer.parseInt(parts[1]);

            if (cmd == 'I') {
                // 값을 바로 저장하는 것이 아니라 키값(값)과 그 갯수를 저장한다.
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (map.isEmpty()) continue;

                if (num == 1) {
                    // 그냥 값을 삭제하는 것이 아니라 키 값으로 찾고 갯수를 제거한다.
                    int maxKey = map.lastKey();
                    map.put(maxKey, map.get(maxKey) - 1);
                    if (map.get(maxKey) == 0) {
                        map.remove(maxKey);
                    }
                } else {
                    int minKey = map.firstKey();
                    map.put(minKey, map.get(minKey) - 1);
                    if (map.get(minKey) == 0) {
                        map.remove(minKey);
                    }
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{map.lastKey(), map.firstKey()};
    }
}
