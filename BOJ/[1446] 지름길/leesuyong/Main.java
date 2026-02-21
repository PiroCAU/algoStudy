package BOJ_1446_지름길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, D;
    static ArrayList<Node>[] list;
    static int[] result;

    static class Node implements Comparable<Node> {
        int d, w;

        public Node(int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        //저장 공간 초기화
        result = new int[D + 1];
        list = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            //범위를 벗어나는 지름길은 무시
            if (s > D || e > D) continue;
            list[s].add(new Node(e, w));
        }

        dij(0);
    }

    public static void dij(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(s, 0));
        result[0] = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (result[poll.d] < poll.w) continue;

            if (poll.d + 1 <= D) {
                int nw = poll.w + 1;
                if (result[poll.d + 1] > nw) {
                    result[poll.d + 1] = nw;
                    pq.add(new Node(poll.d + 1, nw));
                }
            }

            for (Node node : list[poll.d]) {
                int nw = poll.w + node.w;
                if (node.d <= D && result[node.d] > nw) {
                    result[node.d] = nw;
                    pq.add(new Node(node.d, nw));
                }
            }

        }
        System.out.println(result[D]);
    }
}
