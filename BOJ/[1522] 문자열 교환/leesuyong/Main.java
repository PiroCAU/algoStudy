package BOJ_1522_문자열교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int min = Integer.MAX_VALUE;
        int aLen = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a')
                aLen++;
        }

        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            for (int j = i; j < aLen + i; j++) {
                if (s.charAt(j % s.length()) =='b') cnt++;
            }
            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }
}
