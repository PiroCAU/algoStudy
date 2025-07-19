package pro.p154540.wldy4627;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] map;
    static List<Integer> answer;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }

        answer = new ArrayList<Integer>();
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] != -1) {
                    answer.add(dfs(i, j));
                }
            }
        }

        if (answer.isEmpty()) {
            int[] result = new int[1];
            result[0] = -1;
            return result;
        }
        Collections.sort(answer);
        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    public int dfs(int startX, int startY) {
        visited[startX][startY] = true;
        int sum = map[startX][startY];

        int nextX, nextY;
        for (int i = 0; i < 4; i++) {
            nextX = startX + dx[i];
            nextY = startY + dy[i];
            if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[0].length) {
                if (!visited[nextX][nextY] && map[nextX][nextY] != -1) {
                    sum += dfs(nextX, nextY);
                }
            }
        }

        return sum;
    }
}
