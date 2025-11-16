package BOJ_25757_임스와함께하미니게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char type;
    static Set<String> sets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        type = st.nextToken().charAt(0);
        sets = new HashSet<>();

        while (N-- > 0) {
            sets.add(br.readLine());
        }

        int size = sets.size();

        if (type == 'Y') {
            System.out.println(size);
        } else if (type == 'F') {
            double i =  (double) size / 2;
            System.out.println((int) Math.floor(i) );
        } else {
            double i =  (double) size / 3;
            System.out.println((int) Math.floor(i) );
        }
    }
}
