package pro.p42860.wldy4627;

public class Main {
    public static void main(String[] args) {
        String name = "JEROEN";

        int answer = solution(name);
    }

    public static int solution(String name) {
        int answer = 0;

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            answer = Math.min(answer, i + i + name.length() - next);
        }

        return answer;
    }
}
