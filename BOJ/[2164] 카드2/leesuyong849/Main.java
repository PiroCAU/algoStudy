package BOJ_2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int N;
    static Deque<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        list = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            Integer first = list.removeFirst();

            if (list.size() == 1) break;

            Integer second = list.removeFirst();
            list.addLast(second);
        }

        System.out.println(list.peek());
    }
}
