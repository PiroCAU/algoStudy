package BOJ_1253_좋다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);
        int count = 0;
        int left;
        int right;
        for (int k = 0; k < N; k++) {
            left = 0;
            right = N - 1;
            while (left < right) {
                if (left != k && right != k) {
                    if (map[left] + map[right] < map[k]) left++;
                    else if (map[left] + map[right] > map[k]) right--;
                    else {
                        count++;
                        break;
                    }
                } else if (left == k) left++;
                else if (right == k) right--;
            }
        }

        System.out.println(count);
    }
}
