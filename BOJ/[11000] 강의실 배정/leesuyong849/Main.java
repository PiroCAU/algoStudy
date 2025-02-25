import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int parseInt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] list = new int[parseInt][2];

        for (int i = 0; i < parseInt; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        //리스트를 정렬한다. (시작 시간을 기준으로 정렬하되, 만약 같다면 끝나는 시간을 기준으로 한다.)
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list[0][1]);

        for (int i = 1; i < parseInt; i++) {
            if (pq.peek() <= list[i][0]) {
                pq.poll();
            }
            pq.add(list[i][1]);
        }

        System.out.println(pq.size());
        br.close();
    }
}
