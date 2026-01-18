package BOJ_22233_가희와키워드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main2 {
    static int N, M;
    static HashSet<String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashSet<>();

        for (int i = 0; i < N; i++) {
            map.add(br.readLine());
        }

        //아직 남아 있는 수
        int result = N;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] split = line.split(",");

            for (String s : split) {
                if (map.remove(s)) result--;
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
