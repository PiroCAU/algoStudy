
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static HashMap<String, Integer> sets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sets = new HashMap<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            //그냥 외울 수 있는 단어라면 패스한다.
            if (s.length() < M) continue;
            Integer setsInteger = sets.getOrDefault(s, 0);
            sets.put(s, setsInteger + 1);
        }

        ArrayList<String> list = new ArrayList<>(sets.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (sets.get(o1) != sets.get(o2)) {
                    return Integer.compare(sets.get(o2), sets.get(o1));
                }

                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }

                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());

    }

}
