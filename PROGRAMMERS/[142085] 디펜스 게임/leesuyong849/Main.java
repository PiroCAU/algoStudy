public class Main {
    public int solution(int n, int k, int[] enemy) {

        int cnt = 0;
        int round = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        while (round < enemy.length) {
            cnt += enemy[integers.size()];
            int thisTime = enemy[integers.size()];
            integers.add(thisTime);


            if (cnt > n) {
                if (k > 0) {
                    Integer max = integers.stream().max(Integer::compare).orElse(0);
                    cnt -= max;
                    k--;
                    integers.remove(max);
                } else {
                    return round;
                }
            }
            round++;

        }

        return round;

    }

    /**
     * 에러 발생: 시간 부족
     */
}