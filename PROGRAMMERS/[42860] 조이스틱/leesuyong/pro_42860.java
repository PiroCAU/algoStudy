import java.util.ArrayList;
import java.util.List;

public class pro_42860 {

    public static void main(String[] args) {
        Solution_42860 solution_42860 = new Solution_42860();
        int jeroen = solution_42860.solution("JAN");
        System.out.println(jeroen);
    }
}

class Solution_42860 {
    public int solution(String name) {
        int answer = 0;

        List<Integer> input = new ArrayList<>();
        for (char ch : name.toCharArray()) {
            input.add((int) ch);
        }

        //첫 문자열
        answer += minner(input.get(0));

        //다음 위치로 이동
        // 1. 만약 2번 문자나 마지막 문자가 A인 경우
        if (input.get(1).equals(65)) {
            for (int i = input.size() - 1; i >= 2; i--) {
                answer++;
                Integer integer = input.get(i);
                answer += minner(integer);
            }
        } else {
            for (int i = 1; i < input.size(); i++) {
                answer++;
                Integer integer = input.get(i);
                answer += minner(integer);

                if (i + 2 == input.size() && 65 == input.get(i + 1)) {
                    break;
                }
            }
        }

        return  answer;
    }

    public int minner(Integer integer) {
        int up = integer - 'A';
        int down = 'Z' - integer + 1;
        return Math.min(up, down);
    }
}
/**
 * 이 코드의 문제점
 *  만약 A가 여러개 이어지면서 나오는 경우
 *  앞으로 계속 가는 것이 이득인지 뒤로 돌아가는 것이 이득인지 파악할 수 없다.
 */
