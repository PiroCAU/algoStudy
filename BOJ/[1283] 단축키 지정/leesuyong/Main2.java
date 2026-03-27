package BOJ_1283_단축키지정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

    static int N;
    static int[] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[26];

        StringTokenizer st;
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<String> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }

            checkCode(list);
        }
        System.out.println(sb.toString());
    }

    public static void checkCode(ArrayList<String> list) {

        //각 단어의 첫 글자를 비교한다.
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            char c = Character.toUpperCase(s.charAt(0));  //대소문자 구분 안함 - 비교는 전부 대문자로
            int idx = c - 'A';

            //단축키로 지정할 수 있다면
            if (map[idx] == 0) {
                map[idx] = 1;

                //해당 단어 앞의 단어 처리
                if (i != 0) {
                    for (int j = 0; j < i; j++) {
                        sb.append(list.get(j)).append(" ");
                    }
                }
                sb.append("[").append(s.charAt(0)).append("]").append(s.substring(1));

                //해당 단어 뒤의 단어 처리
                if (i + 1 != list.size()) {
                    for (int j = i + 1; j < list.size(); j++) {
                        sb.append(" ").append(list.get(j));
                    }
                }
                sb.append("\n");

                return;
            }
        }

        //각 단어의 첫 문자를 단축어로 지정할 수 없는 경우: 그냥 앞에서 부터 파악
        //일단 하나의 문자열로 만든 후 판단한다.
        StringBuilder sb2 = new StringBuilder();
        for (String s : list) {
            sb2.append(s).append(" ");
        }
        String s2 = sb2.toString();

        for (int i = 0; i < s2.length(); i++) {
            char c = Character.toUpperCase(s2.charAt(i));
            if (c == ' ') continue;

            int i1 = c - 'A';
            if (map[i1] == 0) {
                map[i1] = 1;
                sb.append(s2.substring(0, i)).append("[").append(s2.charAt(i)).append("]").append(s2.substring(i + 1)).append("\n");
                return;
            }
        }
        sb.append(s2).append("\n");
    }
}
