import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_19237 {

    static class Node {
        int x, y, id, time;

        public Node(int x, int y, int m, int t) {
            this.x = x;
            this.y = y;
            this.id = m;
            this.time = t;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Shark {
        int direct;
        int id;
        int[][] priority = new int[5][5];

        public Shark(int id, int dir) {
            this.id = id;
            this.direct = dir;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = 0;      //필드의 크기
        int M = 0;      //상어 수
        int K = 0;      //냄새의 지속 시간

        for (int i = 0; i < 3; i++) {
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        }

        int[][] field = new int[N][N];  //field의 데이터: 상어 위치
        LinkedList<Node> que = new LinkedList<>();      //냄새가 남아있는 곳 데이터
        HashMap<Integer, Shark> sharks = new HashMap<>();        //상어들의 리스트

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                field[i][j] = n;
                if (n != 0) {
                    que.add(new Node(i, j, n, K));
                }
            }
        }

        //상어들이 어디를 보고 있는지 확인한다.
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int parseInt = Integer.parseInt(st.nextToken());
            sharks.put(i+1, new Shark(i+1, parseInt));
        }

        //각 상어별로 방향 우선순위를 저장한다.
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int z = 0; z < 4; z++) {
                    Shark shark = sharks.get(i + 1);
                    shark.priority[j][z] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int sec = 0;

        while (sharks.size() > 1) {
            sec++;
            int size = que.size();

            //냄새가 뭍어 있는 노드들을 하나씩 확인한다.
            for (int i = 0; i < size; i++) {
                Node poll = que.poll();

                if (poll.time == 4) {
                    poll.time -= 1;
                    Shark shark = sharks.get(poll.id);

                    int direct = shark.direct;
                    for (int ints : shark.priority[direct]) {
                        int x = poll.x;
                        int y = poll.y;
                        //현재 상어의 방향에 따른 다음 위
                        Node next = moving(new Node(x, y), ints, N);

                        //해당 노드가 냄새가 있는지 확인

                    }
                }

            }
        }


    }

    private static Node moving(Node poll, int ints, int N) {
        if (ints == 1) {
            poll.x += 1;
        } else if (ints == 2) {
            poll.x -= 1;
        } else if (ints == 3) {
            poll.y -= 1;
        } else if (ints == 4) {
            poll.y += 1;
        }

        if (poll.x < 0 || poll.y < 0 || poll.x >= N || poll.y >= N) {
            return null;
        }
        return poll;
    }
}
