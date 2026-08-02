package BOJ_77486_다단계칫솔;

import java.util.HashMap;

public class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //<자식, 부모>
        HashMap<String, String> parents = new HashMap<>();
        //
        HashMap<String, Integer> index = new HashMap<>();

        for(int i = 0; i < enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }

        int[] profit = new int[enroll.length];

        for(int i = 0; i < seller.length; i++) {
            int money = amount[i] * 100;
            String name = seller[i];

            while (true) {
                int fee = money / 10;
                int mine = money - fee;
                profit[index.get(name)] += mine;

                String parent = parents.get(name);
                if (parent.equals("-") || fee == 0) {
                    break;   // fee는 그냥 버려짐. 몰아주지 않음
                }

                money = fee;
                name = parent;
            }
        }

        return profit;

    }
}
