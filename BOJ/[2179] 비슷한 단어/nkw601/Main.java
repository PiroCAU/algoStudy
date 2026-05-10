import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Word {
        String str;
        int idx;

        Word(String str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }

    static int getPreLen(String a, String b) {
        int len = Math.min(a.length(), b.length());

        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Word[] words = new Word[N];
        String[] w = new String[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            words[i] = new Word(s, i);
            w[i] = s;
        }

        // 정렬
        Arrays.sort(words, (a, b) -> a.str.compareTo(b.str));

        int maxLen = 0;
        int idx1 = Integer.MAX_VALUE;
        int idx2 = Integer.MAX_VALUE;

        // 최대 접두사 길이
        for (int i = 0; i < N - 1; i++) {
            maxLen = Math.max(maxLen, getPreLen(words[i].str, words[i + 1].str));
        }

        // 접두사 길이 >= 인 애들 모아서 인덱스 확인
        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(words[i].idx);

            int j = i + 1;
            while (j < N && getPreLen(words[i].str, words[j].str) >= maxLen) {
                list.add(words[j].idx);
                j++;
            }

            if (list.size() >= 2) {
                Collections.sort(list);

                int a = list.get(0);
                int b = list.get(1);

                if (a < idx1 || (a == idx1 && b < idx2)) {
                    idx1 = a;
                    idx2 = b;
                }
            }

        }
        System.out.println(w[idx1]);
        System.out.println(w[idx2]);
    }
}

/*
 * 같은 접두사의 길이가 가장 긴 두 단어
 * 근데 이제 입력 순서를 고려한
 * 
 * 1. Word 클래스 만들어서 idx 저장
 * 2. comparator로 정렬
 * 3. idx 꺼내서 보기
 */