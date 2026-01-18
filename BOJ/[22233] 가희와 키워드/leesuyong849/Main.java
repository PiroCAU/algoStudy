package BOJ_22233_가희와키워드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static HashMap<String, Boolean> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();


        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), false);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            String[] split = s.split(",");

            //map에서 찾아서 true로 변환
            for (String s1 : split) {
                 map.computeIfPresent(s1, (k, v) -> true);
            }

            Set<String> keys = map.keySet();
            int cnt = 0;
            for (String key : keys) {
                Boolean aBoolean = map.get(key);
                if (!aBoolean) cnt++;
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
