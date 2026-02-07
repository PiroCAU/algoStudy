package boj.b19637.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] title;
    static int[] power;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        title = new String[N];
        power = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int strength = Integer.parseInt(br.readLine());
            printName(strength);
        }

        return;
    }

    static void printName(int strength) {
        int left = 0;
        int right = title.length - 1;
        int mid;

        // left가 right보다 작을 때 반복
        while (left <= right) {
            mid = (left + right) / 2;   // left와 right의 중간 지점
            if (power[mid] < strength) {
                // 해당 캐릭터 전투력 > mid 지점
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(title[left]);
        return;
    }
}
