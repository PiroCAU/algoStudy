package BOJ_19941_햄버거분배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static Character[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String s = bf.readLine();
        map = new Character[N];

        for (int i = 0; i < N; i++) {
            map[i] = s.charAt(i );
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            //P만 연산
            if (map[i] == 'H' || map[i] == 'O') continue;

            //먹을 수 있는 가장 왼쪽의 것부터 연산
            for (int j = i - K; j <= i + K; j++) {
                if (j < 0 || j >= N) continue;

                if (map[j] == 'H') {
                    result++;
                    map[j] = 'O';
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
