import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int x; int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // 사과 개수
        int K = Integer.parseInt(br.readLine().trim());

        // 보드
        boolean[][] board = new boolean[N + 1][N + 1];

        // 사과 위치 입력
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = true;
        }

        // 방향 변환 횟수 L
        int L = Integer.parseInt(br.readLine().trim());

        // 방향 전환 정보: X초 뒤 'L' 또는 'D'
        Map<Integer, Character> turns = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            turns.put(X, C);
        }

        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(new Node(1,1));


        int curx = 1;
        int cury = 1;
        int dir = 2;
        int time = 0;

        while (true) {

            if (dir == 1) {
                cury -= 1;
            } else if (dir == 2) {
                curx += 1;
            } else if (dir == 3) {
                cury += 1;
            } else if (dir ==4) {
                curx -=1;
            }

            //벽에 다았는지 확인
            if (curx < 1 || curx > N || cury < 1 || cury > N) {
                break;
            }

            //몸에 다았는지 확인
            if (isBody(nodes, curx, cury)) {
                break;
            }

            time++;

            //사과가 있는지 확인
            if (!board[curx][cury]) {
                nodes.poll();
            } else {
                board[curx][cury] = false;
            }
            nodes.add(new Node(curx, cury));

            try {
                dir = fixDir(turns, dir, time);
            } catch (Exception e) {

            }

        }

        System.out.println(time);
    }

    private static int fixDir(Map<Integer, Character> turns, int dir, int time) {
        Character character = turns.get(time);
        if (character.equals('L')) {
            dir -= 1;
            if (dir == 0) {
                dir = 4;
            }
        } else if (character.equals('D')) {
            dir++;
            if (dir == 5) {
                dir = 1;
            }
        }
        return dir;
    }

    private static boolean isBody(Queue<Node> nodes, int curx, int cury) {
        for (Node node : nodes) {
            if (node.x == curx && node.y == cury) {
                return true;
            }
        }
        return false;
    }
}
