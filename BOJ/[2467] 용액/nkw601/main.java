import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] solution;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        // 임시로 첫번째 두 개 가지고 계산

        // 하나씩 움직이면서 계산하고, 업데이트 -> 시간초과
        // for(int i = 0; i < N; i++) {
        // for(int j = i + 1; j < N; j++) {
        // int cur = Math.abs(solution[i] + solution[j]);
        //
        // if(cur < absF) {
        // sols[0] = solution[i];
        // sols[1] = solution[j];
        // absF = cur;
        // }
        // }
        // }

        int minAbsF = Integer.MAX_VALUE;
        int minAcid = solution[0];
        int minAlkaline = solution[N - 1];

        int left = 0;
        int right = N - 1;
        int acid = solution[left];
        int alkaline = solution[right];

        // -면: -가 너무 많으니까 left++
        // +면: +가 너무 많으니까 right--;
        while (true) {
            int feature = acid + alkaline;
            int absCur = Math.abs(feature);
            if (minAbsF > absCur) {
                minAcid = acid;
                minAlkaline = alkaline;
                minAbsF = absCur;
            }

            if (feature < 0) {
                if (left + 1 < N && left + 1 != right)
                    acid = solution[++left];
                else
                    break;
            } else {
                if (right - 1 >= 0 && right - 1 != left)
                    alkaline = solution[--right];
                else
                    break;
            }
        }

        // 오름차순 출력
        // Arrays.sort(sols);
        System.out.println(minAcid + " " + minAlkaline);
    }

}

/*
 * 문제 이해
 * N 개의 산성/염기성 용액, 2개를 섞어 합이 0에 가장 가까운 조합 찾기
 * 
 * 생각
 * 조합하면 터질 것 같음. N이 100000이면 100000 C 2 = 약 50억
 * i: 0 ~ N, j: i ~ N해서 계산하기
 * 
 * 아니 시초라고??
 * 정렬돼있구나...
 */