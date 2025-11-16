package BOJ_9017_크로스컨트리;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            cal(br);
        }
    }

    public static void cal(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxTeam = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxTeam = Math.max(maxTeam, arr[i]);      //팀의 총 수를 산출
        }

        int[] countMember = new int[maxTeam + 1];
        for (int i : arr) {
            countMember[i]++;
        }

        int[] top4Sum = new int[maxTeam + 1];
        int[] scoreOf5th = new int[maxTeam + 1];
        int[] seen = new int[maxTeam + 1];

        int rank = 0;
        for (int i = 0; i < N; i++) {
            int team = arr[i];
            if (countMember[team] != 6) continue;

            rank++;
            seen[team]++;

            if (seen[team] <= 4) top4Sum[team] += rank;
            else if (seen[team] == 5) scoreOf5th[team] = rank;
        }

        int winner = -1;
        int bestTop4 = Integer.MAX_VALUE;
        int best5 = Integer.MAX_VALUE;


        for (int team = 1; team <= maxTeam; team++) {
            if (countMember[team] != 6) continue;

            if (top4Sum[team] < bestTop4) {
                bestTop4 = top4Sum[team];
                best5 = scoreOf5th[team];
                winner = team;
            } else if (top4Sum[team] == bestTop4) {
                if (scoreOf5th[team] < best5) {
                    best5 = scoreOf5th[team];
                    winner = team;
                }
            }
        }
        System.out.println(winner);
    }
}
