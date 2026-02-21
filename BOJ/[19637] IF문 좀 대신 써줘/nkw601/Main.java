import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static class Status {
        String rank;
        int attack;

        private Status(String rank, int attack) {
            this.rank = rank;
            this.attack = attack;
        }
    }

    private static int N, M;
    private static Status[] statuses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        statuses = new Status[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            statuses[i] = new Status(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            int atk = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N - 1;
            int ans = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (atk <= statuses[mid].attack) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }

            sb.append(statuses[ans].rank).append('\n');

        }

        System.out.print(sb);
    }
}