

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            String string = bf.readLine();
            int N = Integer.parseInt(bf.readLine());
            int L = string.length();
            List<Integer>[] list = new ArrayList[26];       //각 문자열 별 위치 파악
            int shortAns = Integer.MAX_VALUE;
            int longAns = Integer.MIN_VALUE;

            for (int j = 0; j < 26; j++) {
                list[j] = new ArrayList<>();
            }

            //리스트에 해당 문자열을 가지고 있는 위치(인데스)를 저장
            for (int j = 0; j < L; j++) {
                int ints = string.charAt(j) - 'a';
                list[ints].add(j);
            }

            //슬라이딩 윈도우 시작
            for (int j = 0; j < 26; j++) {
                List<Integer> ints = list[j];
                if (ints.size() < N) {
                    continue;
                }

                for (int c = 0; c + N - 1 < ints.size(); c++) {
                    int left = c;
                    int right = c + N - 1;
                    int dif = ints.get(right) - ints.get(left) + 1;

                    if (dif < shortAns) shortAns = dif;
                    if (dif > longAns) longAns = dif;
                }
            }

            if (shortAns == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(shortAns + " " + longAns);
            }
        }
    }
}