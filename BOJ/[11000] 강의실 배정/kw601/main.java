import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 입력을 쫙 받고
        // 시작 기준 오름차순 정렬
        // 끝나는 시간 minheap
        // if 다음 시작이 가장 위의 끝보다 느리다면 -> 강의실 추가
        PriorityQueue<Integer> end = new PriorityQueue<>();
        List<int[]> lectures = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            lectures.add(new int[]{s, e});
        }

        lectures.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for (int[] lect : lectures) {
            // 가장 먼저 시작하는 거 지정
            int s = lect[0], e = lect[1];

            // 시작 시간이 가장 빨리 끝나는 것보다 빠를 때
            if(!end.isEmpty() && s >= end.peek()){
                end.poll(); // 끝난거 빼기
            }
            end.offer(e); // 지금 시작한 강의의 끝나는 시간 넣기
        }
        System.out.println(end.size());
    }
}