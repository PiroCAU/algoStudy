package BOJ_20310_타노스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt0 = 0;
        String s = br.readLine();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0') cnt0++;
        }

        int cnt1 = length - cnt0;
        int remove1 = cnt1 / 2;
        int remove0 = cnt0 / 2;

        StringBuilder sb = new StringBuilder(s);


        for (int i = 0; i < sb.length() && remove1 > 0; i++) {
            if (sb.charAt(i) == '1') {
                sb.deleteCharAt(i);
                remove1--;
                i--; // 삭제하면 인덱스 당겨지므로 보정
            }
        }

        for (int i = sb.length() - 1; i >= 0 && remove0 > 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
                remove0--;
            }
        }
        System.out.println(sb);
    }
}
