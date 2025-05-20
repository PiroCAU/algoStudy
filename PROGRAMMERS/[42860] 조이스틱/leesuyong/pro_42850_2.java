public class pro_42850_2 {
    public int solution(String name) {
        int answer = 0;

        // 1. 알파벳 변경 횟수
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            int up = ch - 'A';
            int down = 'Z' - ch + 1;
            answer += Math.min(up, down);
        }

        // 2. 커서 이동 최소값 계산
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i + name.length() - next + Math.min(i, name.length() - next));
        }

        answer += move;
        return answer;
    }
}
