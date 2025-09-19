import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static List<List<Node>> nodes;

    static class Node {
        int x; int w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        nodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nodes.add(new ArrayList<Node>());
        }

        for (int[] path : paths) {
            int x = path[0];
            int y = path[1];
            int w = path[2];

            if (isGate(x, gates) || isSummit(y, summits)) {
                nodes.get(x).add(new Node(y, w));
            } else if (isGate(y, gates) || isSummit(x, summits)) {
                nodes.get(y).add(new Node(x, w));
            } else {
                nodes.get(x).add(new Node(y, w));
                nodes.get(y).add(new Node(x, w));
            }
        }

        return dij(n, gates, summits);


    }

    private static int[] dij(int n, int[] gates, int[] summits) {
        int[] intensity = new int[n + 1];

        //게이트를 큐에 추가한다. -> 다익스트라 알고리즘에서 시작점을 지정
        Deque<Node> que = new ArrayDeque<>();
        for (int gate : gates) {
            que.add(new Node(gate, 0));
            intensity[gate] = 0;        //시작지점 값은 0
        }


        Arrays.fill(intensity, Integer.MAX_VALUE);

        while (!que.isEmpty()) {
            Node poll = que.poll();

            if (poll.w > intensity[poll.x]) continue;       //x까지 가는 w값이 이미 정해진 값보다 더 크다면 그냥 생략
            for (int i = 0; i < nodes.get(poll.x).size(); i++) {
                Node nextNode = nodes.get(poll.x).get(i);

                //최소값 갱신
                int dis = Math.max(intensity[poll.x], nextNode.w);
                if (intensity[nextNode.x] > dis) {
                    intensity[nextNode.x] = dis;
                    que.add(new Node(nextNode.x, dis));
                }
            }
        }

        int summitNum = Integer.MAX_VALUE;
        int minW = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for (int summit : summits) {
            if (intensity[summit] < minW) {
                minW = intensity[summit];
                summitNum = summit;
            }
        }

        return new int[]{summitNum, minW};
    }

    private static boolean isGate(int num, int[] gates) {
        for (int gate : gates) {
            if (num == gate) return true;
        }
        return false;
    }

    private static boolean isSummit(int num, int[] summits) {
        for (int summit : summits) {
            if (num == summit) return true;
        }
        return false;
    }
}

