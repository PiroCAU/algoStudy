package BOJ_1515_수이어쓰기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targe = br.readLine();
        int N = targe.length();

        int pt = 0;         //targe에서 어디를 보고 있는지
        int base = 0;       //결과가 될 숫자

        for (base = 1; ; base++) {
            String t = String.valueOf(base);

            for (int i = 0; i < t.length(); i++) {
                if (targe.charAt(pt) == t.charAt(i)) {      //만약 문자열이 일치한다면 다음 문자 비교
                    pt++;
                }
                if (pt == N) break;
            }

            if (pt == N) break;
        }
        System.out.println(base);
    }
}
