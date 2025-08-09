import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13904 {

    static class HW {
        int d, w;
        public HW(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<HW> list = new ArrayList<>();
        int maxDay = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new HW(d, w));
            maxDay = Math.max(maxDay, d);
        }

        //정렬
        list.sort(((o1, o2) -> o2.d - o1.d));

        int result = 0;
        int idx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //가장 마감 기간이 먼 것부터 처리
        for (int day = maxDay; day >= 1; day--) {

            //가장 마감일이 먼 것부터 하루치씩
            while (idx < N && list.get(idx).d >= day) {
                pq.add(list.get(idx).w);
                idx++;
            }

            //현재 선택할 수 있는 과제 중 가장 점수가 높은 것 선택
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        System.out.println(result);
    }
}
