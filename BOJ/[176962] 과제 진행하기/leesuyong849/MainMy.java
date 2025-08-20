import java.sql.Time;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

class BOJ_176962 {

    class Node {
        int ind;
        int left;

        public Node(int z, int x) {
            ind = z;
            left = x;
        }
    }

    public String[] solution(String[][] plans) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String[]> planss = new ArrayList<>();

        Collections.addAll(planss, plans);

        planss.sort(Comparator.comparing(p -> LocalTime.parse(p[1])));

        Stack<Node> stack = new Stack<>();

        LocalTime now = LocalTime.parse(planss.get(0)[1]);
        for (int i = 0; i < plans.length; i++) {

            if (i < plans.length - 1) {

                LocalTime next = LocalTime.parse(planss.get(i + 1)[1]);
                stack.push(new Node(i, Integer.parseInt(planss.get(i)[2])));

                while (!stack.isEmpty()) {
                    Node pop = stack.pop();
                    LocalTime nextEndw = now.plusMinutes(pop.left);

                    if (nextEndw.isAfter(next)) {
                        int between = (int) ChronoUnit.MINUTES.between(next, nextEndw);
                        stack.push(new Node(pop.ind, between));
                        now = next;
                        break;
                    } else {
                        result.add(planss.get(pop.ind)[0]);
                        now = nextEndw;
                    }
                }
            } else {
                stack.push(new Node(i, Integer.parseInt(planss.get(i)[2])));
                while (!stack.isEmpty()) {
                    Node pop = stack.pop();
                    result.add(planss.get(pop.ind)[0]);
                }
            }
        }
        return result.toArray(String[]::new);

    }
}