package BOJ_2668_숫자고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] map;
    static int[] state;             //0,1,2 를 통해 방문한 곳인지 확인
    static boolean[] inCycle;       //사이클에 들어간 곳인지 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> result = new ArrayList<>();

        map = new int[N + 1];
        state = new int[N + 1];
        inCycle = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < N + 1; i++) {
            if (state[i] == 0) dfs(i);
        }

        //출력
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (inCycle[i]) cnt++;
        }

        sb.append(cnt).append('\n');
        for (int i = 1; i <= N; i++) {
            if (inCycle[i]) sb.append(i).append('\n');
        }

        System.out.println(sb.toString());

    }

    public static void dfs(int x) {
        //도착했다고 표시
        state[x] = 1;

        //다음 목적지
        int nx = map[x];

        //아직 안 간 곳이면 간다.
        if (state[nx] == 0) dfs(nx);
        //이미 간 곳이면 루프 처리
        else if (state[nx] == 1) {
            int cur = nx;
            do {
                inCycle[cur] = true;
                cur = map[cur];
            } while (cur != nx);
        }
        //완료 처리
        state[x] = 2;
    }
}
