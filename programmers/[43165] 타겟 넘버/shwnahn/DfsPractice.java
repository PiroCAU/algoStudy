package src.week3.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DfsPractice {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        // n 노드개수 m 에지개수 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // visited 방문 기록 저장 배열
        visited = new boolean[n + 1];
        // A 그래프 데이터 저장 인접 리스트
        A = new ArrayList[n + 1];
        // ArrayList 초기화
        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // m 개수만큼 반복. 그래프 데이터 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        // n의 개수만큼 반복. 연결요소 개수 ++, DFS 실행
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    // DFS 구현
    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
