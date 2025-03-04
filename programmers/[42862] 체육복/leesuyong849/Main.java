import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        for (Integer integer : lost) {
            lostSet.add(integer);
        }
        for (int i : reserve) {
            if (lostSet.contains(i)) {
                lostSet.remove(i);
            } else {
                set.add(i);
            }
        }

        int cnt = lostSet.size();
        for (int i : lostSet) {
            if (set.contains(i - 1)) {
                cnt -= 1;
                set.remove(i - 1);
            } else if (set.contains(i + 1)) {
                cnt -= 1;
                set.remove(i + 1);
            }
        }
        return n - cnt;
    }
}