package BOJ_2110_공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, C, T, MAX;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(map);
        //타깃 값을 설정한다.
        MAX = Integer.MIN_VALUE;


        int left = 0;
        int right = map[N - 1] - map[0];
        while (left <= right) {
            int count = 1;
            int lastInstall = 0;
            T = (left + right) / 2;

            for (int i = 1; i < N; i++) {
                //만약 val 값과 거리가 충분하다면 설치
                if (T <= map[i] - map[lastInstall]) {
                    lastInstall = i;
                    count++;
                }
            }

            if (count < C) {
                right = T - 1;
            } else {
                MAX = T;
                left = T + 1;
            }
        }
        System.out.println(MAX);

    }
}
