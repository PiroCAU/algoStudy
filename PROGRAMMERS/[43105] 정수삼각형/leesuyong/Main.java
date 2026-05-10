package PRO_43105_정수삼각형;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

    }
}

class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int width = triangle[0].length;
        int[][] map = new int[height][height];

        map[0][0] = triangle[0][0];

        for (int i = 1; i < height; i++) {

            for (int j = 0; j < i + 1; j++) {
                int cur = triangle[i][j];

                if (j == 0) {
                    map[i][j] = map[i - 1][j] + cur;
                } else if (j == i) {
                    map[i][i] = map[i-1][i-1] + cur;
                } else {
                    map[i][j] = Math.max(map[i-1][j], map[i-1][j-1]) + cur;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < height; i++) {
            result = Math.max(result, map[height - 1][i]);
        }

        return result;
    }
}
