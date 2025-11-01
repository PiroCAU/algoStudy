import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] wei = new int[N];
        int[] hei = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wei[i] = Integer.parseInt(st.nextToken());
            hei[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int level = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue; // 나랑 비교할 필요 없음
                if (wei[j] > wei[i] && hei[j] > hei[i]) level++; // 키 무게 더 크면 ++
            }
            sb.append(level).append(' ');
        }
        System.out.println(sb);
    }
}