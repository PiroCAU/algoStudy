import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3584 {

    static int[] parent;
    static boolean[] visited;
    static int T, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            parent = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N1 = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());

            solution(N1, N2);
        }
    }

    static void solution(int x, int y) {

        //일단 하나의 노드의 부모를 전부 체크한다.
        while (x > 0) {
            visited[x] = true;
            x = parent[x];
        }

        //나머지 하나의 노드도 아래에서부터 참색하면서 가장 먼저 겹치는 노드를 파악한다.
        while (y > 0) {
            if (visited[y]) {
                System.out.println(y);
                break;
            }
            y = parent[y];
        }
    }
}
