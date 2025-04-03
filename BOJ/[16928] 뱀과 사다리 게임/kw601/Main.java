import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        // 뱀이랑 사다리 저장할 배열
        int[] move = new int[101];
        boolean[] visited = new boolean[101];

        // 사다리
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            move[x] = y;
        }

        // 뱀
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            move[u] = v;
        }

        // 1번 칸 시작
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{1, 0});

        while (!que.isEmpty()) {
            int[] current = que.poll();
            int cur = current[0];
            int cnt = current[1];

            if (cur == 100) {
                System.out.println(cnt);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;

                // 뱀 / 사다리 확인
                if (move[next] != 0) {
                    next = move[next];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    que.add(new int[]{next, cnt + 1});
                }
            }
        }
    }
}