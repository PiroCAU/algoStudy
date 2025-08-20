import java.util.*;

class Solution {
    static class Task {
        String name;
        int remain; // 남은 시간(분)

        Task(String name, int remain) {
            this.name = name;
            this.remain = remain;
        }
    }

    public String[] solution(String[][] plans) {
        Arrays.sort(plans, Comparator.comparingInt(p -> toMin(p[1])));

        Deque<Task> stack = new ArrayDeque<>();
        List<String> done = new ArrayList<>();

        int now = toMin(plans[0][1]);

        //하나씩 최신의 데이터를 불러온다.
        for (int i = 0; i < plans.length; i++) {
            int start = toMin(plans[i][1]);
            int duration = Integer.parseInt(plans[i][2]);

            // 다음 과제 시작 시각(start)까지 남은 시간 동안 스택 과제를 처리
            while (!stack.isEmpty() && now < start) {
                Task cur = stack.peekLast();
                int finish = now + cur.remain;

                if (finish <= start) {
                    stack.pollLast();
                    done.add(cur.name);
                    now = finish;
                } else {
                    cur.remain -= (start - now);
                    now = start;
                }
            }

            // 현재 과제 시작: 스택에 push (새로 시작하므로 맨 뒤에)
            stack.addLast(new Task(plans[i][0], duration));
            now = start; // 포인터를 현재 시작 시각으로 맞춤
        }

        // 남은 거 다 처리
        while (!stack.isEmpty()) {
            done.add(stack.pollLast().name);
        }

        return done.toArray(new String[0]);
    }

    private int toMin(String hhmm) { // "HH:mm" -> 분
        String[] t = hhmm.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}