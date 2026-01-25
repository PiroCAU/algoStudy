package BOJ_21921_블로그;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] map = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;        //역대 최고값
        int cur = 0;        //현재 슬라이딩 윈도우에 들어있는 값
        int freq = 1;       //최고값이 몇 번 나왔는가 (최초에 초기화를 하므로 1에서 시작)

        //초기 슬라이딩 윈도우 설정
        for (int i = 0; i < X; i++) {
            cur += map[i];
        }
        cnt = cur;

        //하나씩 이동하면서 체크
        for (int i = 1; i < N - X + 1; i++) {
            //앞에 것 빼고 뒤에거 넣는다.
            cur = cur - map[i - 1] + map[i + X - 1];
            if (cnt < cur) {
                cnt = cur;
                freq = 1;
            } else if (cnt == cur) {
                freq++;
            }
        }

        if (cnt == 0) {
            System.out.println("SAD");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(cnt).append("\n").append(freq);
            System.out.println(sb.toString());

        }
    }
}
