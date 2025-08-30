import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();


        int[] freq = new int[26]; // 각 문자 빈도
        int kinds = 0;            // 몇 개의 문자 종류가 사용 중인지 파악
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            int r = s.charAt(right) - 'a';          //문자의 숫자대로 인덱스를 부여
            if (freq[r] == 0) kinds++;
            freq[r]++;

            // 서로 다른 문자가 n을 초과하면 왼쪽을 줄여서 맞춤
            while (kinds > n) {
                int l = s.charAt(left) - 'a';
                freq[l]--;
                if (freq[l] == 0) kinds--;
                left++;
            }

            // 윈도우 길이 갱신
            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}
