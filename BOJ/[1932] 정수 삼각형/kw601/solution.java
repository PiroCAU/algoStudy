import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> triangleList = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int[] row = new int[line.length];
            for (int j = 0; j < line.length; j++) {
                row[j] = Integer.parseInt(line[j]);
            }
            triangleList.add(row);
        }

        int[][] triangle = triangleList.toArray(new int[0][]);
        
        // 복사를 이렇게 해야 한대...
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle[i].clone();
        } 

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        System.out.println(dp[0][0]);
    }
}