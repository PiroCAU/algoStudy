package BOJ_2304_창고다각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Long result = 0L;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.put(k, v);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        int left = 0;
        int right = list.size() - 1;
        int leftMax = map.get(list.get(left));
        int rightMax = map.get(list.get(right));

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                Integer index = list.get(left);
                Integer newLeft = map.get(index);

                int cal = (index - list.get(left - 1)) * leftMax;
                result += cal;

                if (newLeft > leftMax) {
                    leftMax = newLeft;
                }

            } else {
                right--;
                Integer index = list.get(right);
                Integer newRight = map.get(index);

                int cal = (list.get(right + 1) - index ) * rightMax;
                result += cal;

                if (newRight > rightMax) {
                    rightMax = newRight;
                }
            }
        }

        result += Math.max(leftMax, rightMax);

        System.out.println(result);
    }
}
