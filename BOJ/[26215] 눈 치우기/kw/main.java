//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 입력을 쫙 받고
        // pq에 넣고
        // size 2개 넘으면, poll poll 치우고 다시 넣어
        // 마지막 계산하고 끝
        // 1440 > : -1

        PriorityQueue<Integer> snows = new PriorityQueue<>(Collections.reverseOrder());

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = 0;

        for(int i = 0; i < N; i++) {
            int s = sc.nextInt();
            snows.offer(s);
        }

       while(snows.size() >= 2){
           if(min > 1440) {min = -1; break;}
           min++;

           int first = snows.poll() - 1;
           int second = snows.poll() - 1;

           if (first > 0) {snows.offer(first);}
           if (second > 0) {snows.offer(second);}
       }
       if (!snows.isEmpty()) min += snows.poll();
       if (min > 1440) {min = -1;}
       System.out.println(min);
    }
}