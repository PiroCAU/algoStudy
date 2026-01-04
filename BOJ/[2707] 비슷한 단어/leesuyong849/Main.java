package BOJ_2707_비슷한단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        String target = br.readLine();
        int[] map = new int[26];
        transfer(target, map);
        int sum = Arrays.stream(map).sum();

        for (int i = 1; i < N; i++) {
            String newStr = br.readLine();
            int[] newMap = new int[26];
            transfer(newStr, newMap);

            int result = 0;
            for (int j = 0; j < 26; j++) {
                result += Math.abs(newMap[j] - map[j]);
            }

            if (result <= 1) cnt++;
            else if (result == 2 && sum == Arrays.stream(newMap).sum()) cnt++;
        }

        System.out.println(cnt);
    }

    public static void transfer(String str, int[] map) {
        for (int i = 0; i < str.length(); i++) {
            int cur = str.charAt(i) - 'A';
            map[cur] += 1;
        }
    }
}
