class Solution_172927 {
    public int solution(int[] picks, String[] minerals) {
        int ans = 0;
        List<List<String>> amounts = new ArrayList<>();

        //곡갱이는 한번에 5개의 광물을 캐야하므로 각 광물을 5 단위로 나눈다.
        int maxUse = picks[0] + picks[1] + picks[2];
        for (int i = 0; i < minerals.length && amounts.size() < maxUse; i += 5) {
            List<String> amount = new ArrayList<>();
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                amount.add(minerals[j]);
            }
            amounts.add(amount);
        }


        // amount의 돌 곡괭이 기준 피로도 계산
        List<int[]> fatigueList = new ArrayList<>(); // [index, 돌 곡괭이 피로도]
        for (int i = 0; i < amounts.size(); i++) {
            int fatigue = 0;
            for (String m : amounts.get(i)) {
                if (m.equals("diamond")) fatigue += 25;
                else if (m.equals("iron")) fatigue += 5;
                else fatigue += 1;
            }
            fatigueList.add(new int[]{i, fatigue});
        }

        //각 피로도 계산한 것을 정렬한다.
        fatigueList.sort((a, b) -> b[1] - a[1]);

        //피로도가 높은 곳부터 더 좋은 곡갱이를 배정하고 피로도를 계산한다.
        int pickIdx = 0;
        for (int[] f : fatigueList) {
            int idx = f[0];
            List<String> amount = amounts.get(idx);

            int pickType = -1;
            //다이아 곡갱이부터 사용할  수 있는지 확인한다.
            for (int i = 0; i < 3; i++) {
                if (picks[i] > 0) {
                    pickType = i;
                    picks[i]--;
                    break;
                }
            }

            //만약 곡갱이가 부족해 지면 종료한다.
            if (pickType == -1) break;

            for (String m : amount) {
                if (pickType == 0) ans += 1;
                else if (pickType == 1) {
                    if (m.equals("diamond")) ans += 5;
                    else ans += 1;
                } else {
                    if (m.equals("diamond")) ans += 25;
                    else if (m.equals("iron")) ans += 5;
                    else ans += 1;
                }
            }
        }
        return ans;
    }
}