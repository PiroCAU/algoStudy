import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());


        PriorityQueue<Integer> list = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int count = 0;

        while (!list.isEmpty()) {
            ;
            if (list.size() == 1) {  // 집이 1개만 남았을 경우
                count += list.poll(); // 남은 눈의 양만큼 시간이 추가됨
                break;
            }

            count++;

            Integer first = list.poll() -1;
            Integer second = list.poll() - 1;
            if (first > 0) list.add(first);
            if (second > 0) list.add(second);

        }

        if(count > 1440) count = -1;
        System.out.println(count);
    }
}
