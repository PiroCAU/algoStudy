package pro.p176962.wldy4627;

import java.util.*;

public class Main {
    class Plan {
        String name;
        int startTime;
        int playTime;

        public Plan(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }

        public Plan(String name, int playTime) {
            this.name = name;
            this.playTime = playTime;
        }
    }

    public List<String> solution(String[][] plans) {
        PriorityQueue<Plan> pq = new PriorityQueue<>(
            (o1, o2) -> (o1.startTime - o2.startTime)
        );

        for (int i = 0; i < plans.length; i++) {
            String startTime = plans[i][1];
            String[] parts = startTime.split(":");

            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            int totalMinutes = hour * 60 + minute;
            int time = Integer.parseInt(plans[i][2]);

            pq.add(new Plan(plans[i][0], totalMinutes, time));
        }

        List<String> answer = new ArrayList<>();
        Stack<Plan> stack = new Stack<>();

        while (!pq.isEmpty()) {
            Plan currentPlan = pq.poll();

            String curName = currentPlan.name;
            int curStartTime = currentPlan.startTime;
            int curPlayTime = currentPlan.playTime;

            int currentTime = curStartTime;

            // 새로운 과제가 남아있는 경우
            if (!pq.isEmpty()) {
                Plan nextPlan = pq.peek();

                // 지금 과제를 끝내고 다음 과제를 시작할 수 있는 경우
                if (currentTime + curPlayTime < nextPlan.startTime) {
                    answer.add(curName);
                    currentTime += curPlayTime;

                    // 잠시 멈춘 과제가 있는 경우 -> 남는 시간 동안 멈춘 과제 수행
                    while(!stack.isEmpty()) {
                        Plan remain = stack.pop();

                        // 다음 새로운 과제 시작 전까지 끝낼 수 있는 경우
                        if (currentTime + remain.playTime <= nextPlan.startTime) {
                            currentTime += remain.playTime;
                            answer.add(remain.name);
                            continue;
                        } else {
                            // 끝내지 못하는 경우
                            int time = remain.playTime - (nextPlan.startTime - currentTime);
                            stack.push(new Plan(remain.name, time));
                            break;
                        }
                    }
                } else if (curStartTime + curPlayTime == nextPlan.startTime) {
                    // 지금 과제를 끝내면 새로운 과제를 시작해야 하는 경우
                    answer.add(curName);
                    continue;
                } else {
                    // 지금 과제를 못 끝내는 경우
                    int time = nextPlan.startTime - currentTime;
                    stack.push(new Plan(curName, curPlayTime - time));
                }
            } else {
                // 더 이상 새로운 남아있는 과제가 없는 경우
                // 잠시 멈춘 과제도 없는 경우
                if (stack.isEmpty()) {
                    currentTime += curPlayTime;
                    answer.add(curName);
                } else {
                    // 잠시 멈춘 과제가 있는 경우
                    answer.add(curName);
                    while(!stack.isEmpty()) {
                        answer.add(stack.pop().name);
                    }
                }
            }
        }
        return answer;
    }
}
