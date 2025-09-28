package BOJ_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int mask = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String code = st.nextToken();

            if (code.equals("all")) {
                mask = (1 << 21) - 1;
                continue;
            } else if (code.equals("empty")) {
                mask = 0;
                continue;
            }

            Integer num = Integer.parseInt(st.nextToken());

            if (code.equals("add")) {
                mask |= (1 << num);
            } else if (code.equals("remove")) {
                mask &= ~(1 << num);
            } else if (code.equals("check")) {
                if ((mask & (1 << num)) != 0 ) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (code.equals("toggle")) {
                mask ^= (1 << num);
            }
        }

        System.out.println(sb.toString());
    }
}
