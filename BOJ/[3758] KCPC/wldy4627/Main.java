package boj.b3758.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Team {
    int id, totalScore, submitCount, lastSubmitTime;
    int[] scores;

    public Team(int id, int k) {
        this.id = id;
        this.scores = new int[k];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n];
            for (int j = 0; j < n; j++) {
                teams[j] = new Team(j + 1, k);
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                teams[id - 1].scores[num - 1] = Math.max(score, teams[id - 1].scores[num - 1]);
                teams[id - 1].submitCount++;
                teams[id - 1].lastSubmitTime = j;
            }

            List<Team> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int s : teams[j].scores) sum += s;
                teams[j].totalScore = sum;
                list.add(teams[j]);
            }

            Collections.sort(list, (t1, t2) -> {
                if (t1.totalScore != t2.totalScore) return t2.totalScore - t1.totalScore; // 점수 내림차순
                if (t1.submitCount != t2.submitCount) return t1.submitCount - t2.submitCount; // 횟수 오름차순
                return t1.lastSubmitTime - t2.lastSubmitTime; // 시간 오름차순
            });

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).id == t) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}
