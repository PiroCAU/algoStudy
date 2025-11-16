package BOJ_1205_등수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, NEW, P;
    static ArrayList<Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        NEW = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();


        if (N != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                map.add(Integer.parseInt(st.nextToken()));
            }
        } else {
            map.add(0);
        }

        map.sort(Comparator.reverseOrder());
        int flag = Integer.MAX_VALUE;

        if (map.get(map.size() - 1) >= NEW && N == P) {
            System.out.println(-1);
            return;
        }

        int i = 0;
        for (i = 0; i < N; i++) {
            Integer integer = map.get(i);
            if (integer > NEW) continue;
            else break;
        }

        System.out.println(i + 1);
    }
}
