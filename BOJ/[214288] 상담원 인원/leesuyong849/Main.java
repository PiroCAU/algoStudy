import java.util.*;

public class Main {
    class Solution {
        public int solution(int k, int n, int[][] reqs) {
            int answer = 0;

            List<int[]>[] type = new ArrayList[k+1];
            for (int i = 1; i <= k; i++) {
                type[i] = new ArrayList<>();
            }
            for (int[] r : reqs) type[r[2]].add(r);

            // 각 타입별로 저장한 다음 시작 시간을 기준으로 정렬한다.
            for (int i = 1; i <= k; i++) {
                type[i].sort(Comparator.comparing(a -> a[0]));
            }

            //해당 타입에 얼마의 사람을 배치했을떼 대기시간이 어떤지 확인
            HashMap<Long, Integer> memo = new HashMap<>();

            //일단 각 타입에 사람을 한 명씩 배치한다.
            int[] alloc = new int[k + 1];
            Arrays.fill(alloc, 1);
            int remain = n - k;

            // 미리 현재 대기시간 계산
            int[] curWait = new int[k + 1];
            for (int t = 1; t <= k; t++) curWait[t] = waitTime(type[t], 1, memo, t);

            // 그리디로 남은 인원 배치
            while (remain-- > 0) {
                int bestType = 1, bestGain = -1;

                //각 케이스별로 한 명 늘렸을때 개선되는 정도를 확인한다.
                for (int t = 1; t <= k; t++) {
                    int mNow = alloc[t];
                    int wNow = curWait[t];
                    int wNext = waitTime(type[t], mNow + 1, memo, t);
                    int gain = wNow - wNext; // 감소폭
                    if (gain > bestGain) {
                        bestGain = gain;
                        bestType = t;
                    }
                }
                // bestType에 1명 증설
                alloc[bestType]++;
                curWait[bestType] = waitTime(type[bestType], alloc[bestType], memo, bestType);
            }
            return answer;
        }

        private int waitTime(List<int[]> requests, int m, Map<Long, Integer> memo, int type) {
            if (requests.isEmpty() || m <= 0) return 0;
            long key = ((long) type << 32) | m;
            Integer cached = memo.get(key);
            if (cached != null) return cached;

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < m; i++) {
                pq.add(0);
            }

            int wait = 0;
            for (int[] r : requests) {
                int start = r[0];
                int dur = r[1];
                int avail = pq.poll();
                if (avail > start) {
                    wait += (avail - start);
                }
                int end = Math.max(avail, start) + dur;
                pq.add(end);
            }

            memo.put(key, wait);
            return wait;
        }
    }
}


