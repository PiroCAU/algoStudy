package boj.b9019.wldy4627;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int T;  // 테스트 케이스 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            String result = bfs(A, B);
            System.out.println(result);
        }
    }

    public static String bfs(int A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];  // BFS 탐색의 방문 여부 체크
        String[] command = new String[10000];  // 정답 명령어를 담는 배열

        queue.add(A);
        visited[A] = true;
        Arrays.fill(command, "");

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == B) return command[now];

            int D = (2 * now) % 10000;
            int S = (now == 0) ? 9999 : now - 1;
            int L = (now % 1000) * 10 + (now / 1000);
            int R = (now % 10) * 1000 + (now / 10);

            if (!visited[D]) {
                visited[D] = true;
                command[D] = command[now] + "D";
                queue.add(D);
            }

            if (!visited[S]) {
                visited[S] = true;
                command[S] = command[now] + "S";
                queue.add(S);
            }

            if (!visited[L]) {
                visited[L] = true;
                command[L] = command[now] + "L";
                queue.add(L);
            }

            if (!visited[R]) {
                visited[R] = true;
                command[R] = command[now] + "R";
                queue.add(R);
            }
        }
        return "";
    }
}
