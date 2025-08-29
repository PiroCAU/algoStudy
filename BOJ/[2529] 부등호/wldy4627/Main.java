package boj.b2529.wldy4627;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int k;
    static Character[] inequality;
    static boolean[] visited;
    static List<String> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();

        inequality = new Character[k+1];
        for (int i = 0; i < k; i++) {
            inequality[i] = sc.next().charAt(0);
        }

        visited = new boolean[10];
        list = new ArrayList<>();
        dfs("", 0);

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    static void dfs(String num, int index) {
        if (index == k + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;

            if (index == 0 || isValid(Character.getNumericValue(num.charAt(index - 1)), i, inequality[index - 1])) {
                visited[i] = true;
                dfs(num + i, index + 1);
                visited[i] = false;
            }
        }
    }

    static boolean isValid(int prev, int curr, Character sign) {
        if (sign.equals('<')) {
            return prev < curr;
        } else {
            return prev > curr;
        }
    }
}
