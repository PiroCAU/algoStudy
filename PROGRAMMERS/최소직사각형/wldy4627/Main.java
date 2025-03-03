import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] sizes = new int[n][2];

        for (int i = 0; i < n; i++) {
            sizes[i][0] = sc.nextInt();
            sizes[i][1] = sc.nextInt();
        }

        sc.close();

        Solution sol = new Solution();
        int answer = sol.solution(sizes);

        System.out.println(answer);
    }
}

class Solution {
    public int solution(int[][] sizes) {
        int[][] new_size = new int[sizes.length][sizes[0].length];

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                new_size[i][0] = sizes[i][0];
                new_size[i][1] = sizes[i][1];
            } else {
                new_size[i][0] = sizes[i][1];
                new_size[i][1] = sizes[i][0];
            }
        }

        int max_w = new_size[0][0];
        int max_h = new_size[0][1];

        for (int i = 0; i < new_size.length; i++) {
            if (max_w < new_size[i][0]) {
                max_w = new_size[i][0];
            }
            if (max_h < new_size[i][1]) {
                max_h = new_size[i][1];
            }
        }

        int answer = max_w * max_h;
        return answer;
    }
}