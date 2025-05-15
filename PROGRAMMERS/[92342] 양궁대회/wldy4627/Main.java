package pro.p92342.wldy4627;

public class Main {
    public static int maxDiff = 0;
    public static int[] answer = {-1};

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};

        System.out.println(solution(n, info));
    }

    public static int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        return answer;
    }

    public static void dfs(int idx, int arrows, int[] lion, int[] info) {
        if (idx == 11 || arrows == 0) {
            if (arrows > 0) lion[10] += arrows;

            int lionScore = 0;
            int apeachScore = 0;

            for (int i = 0; i < 11; i++) {
                if (lion[i] == 0 && info[i] == 0) continue;
                if (lion[i] > info[i]) lionScore += 10 - i;
                else apeachScore += 10 - i;
            }

            if (lionScore > apeachScore) {
                int diff = lionScore - apeachScore;
                if (diff > maxDiff) {
                    maxDiff = diff;
                    answer = lion.clone();
                } else if (diff == maxDiff) {
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] > answer[i]) {
                            answer = lion.clone();
                            break;
                        } else if (lion[i] < answer[i]) break;
                    }
                }
            }

            if (arrows > 0) lion[10] -= arrows;
            return;
        }

        // 라이언이 점수를 가져가는 경우
        int needed = info[idx] + 1;
        if (arrows >= needed) {
            lion[idx] = needed;
            dfs(idx + 1, arrows - needed, lion, info);
            lion[idx] = 0; // 백트래킹
        }

        // 점수를 포기하고 그냥 넘기기
        dfs(idx + 1, arrows, lion, info);
    }
}
