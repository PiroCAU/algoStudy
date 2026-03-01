import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        // 등장 횟수
        int[] count = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int ans = 0;

        for (int right = 0; right < N; right++) {
            // right 한 칸 앞 -> 숫자 등장
            count[arr[right]]++;
            // K번보다 많이 나오면
            while (count[arr[right]] > K) {
                // 최장연속수열 불가능
                count[arr[left]]--;
                left++;
            }

            // 길이 갱신하기
            ans = Math.max(ans, right - left + 1);
        }

        System.out.println(ans);
    }
}