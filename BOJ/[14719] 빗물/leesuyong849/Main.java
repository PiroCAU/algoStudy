package BOJ_14719_빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_again {

    static int W, H;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[W];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < W; i++) {
            int a = Integer.parseInt(st.nextToken());
            map[i] = a;
        }

        int leftIdx = 0;
        int rightIdx = W - 1;
        int leftMax = map[0];
        int rightMax = map[W - 1];
        int result = 0;

        while (leftIdx < rightIdx) {
            if (leftMax < rightMax) {
                leftIdx++;  //한 칸 왼쪽으로 이동

                if (leftMax < map[leftIdx]) {
                    leftMax = map[leftIdx];
                } else {
                    result += leftMax - map[leftIdx];
                }
            } else {
                rightIdx--;     //오른쪽으로 한칸 이동

                if (rightMax < map[rightIdx]) {
                    rightMax = map[rightIdx];
                } else {
                    result += rightMax - map[rightIdx];
                }
            }
        }

        System.out.println(result);
    }
}
