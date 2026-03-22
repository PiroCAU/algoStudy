import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    // 접시 수 N, 초밥 가짓수 d, 연속해서 먹는 접시 수 k, 쿠폰 번호 c
    private static int N, d, k, c;
    private static int[] dishes;

    private static HashMap<Integer, Integer> eaten;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        dishes = new int[N];
        for (int i = 0; i < N; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        eaten = new HashMap<>();

        // int left = 0;
        // int right = 1;

        int ans = 0;

        // k접시 먹기
        for (int i = 0; i < k; i++) {
            if (eaten.containsKey(dishes[i])) {
                eaten.replace(dishes[i], eaten.get(dishes[i]) + 1);
            } else {
                eaten.put(dishes[i], 1);
            }
        }

        for (int l = 0; l < N; l++) {
            // ans 계산
            int r = (l + k) % N;
            if (eaten.containsKey(c)) {
                // 쿠폰 있으면
                ans = Math.max(ans, eaten.size());
            } else {
                ans = Math.max(ans, eaten.size() + 1);
            }

            // 오른쪽 접시 먹기
            if (eaten.containsKey(dishes[r]))
                eaten.replace(dishes[r], eaten.get(dishes[r]) + 1);
            else
                eaten.put(dishes[r], 1);

            // 왼쪽 접시 안먹기
            if (eaten.get(dishes[l]) == 1)
                eaten.remove(dishes[l]);
            else
                eaten.replace(dishes[l], eaten.get(dishes[l]) - 1);

        }

        System.out.println(ans);

        // 초기 세팅
        // int cnt = 2;
        // eaten.put(dishes[0], 1);
        // eaten.put(dishes[1], 1);
        //
        // while(right < N) {
        // if(cnt < k){
        // right++;
        //
        // // 이미 있으면 하나 업데이트
        // if(eaten.containsKey(dishes[right])) {
        // eaten.replace(dishes[right], eaten.get(dishes[right]) + 1);
        // } else {
        // eaten.put(dishes[right], 1);
        // }
        //
        // cnt++;
        // } else {
        // // ans 계산
        // if(eaten.containsKey(c)) {
        // // 쿠폰 있으면
        // ans = Math.max(ans, eaten.size());
        // } else {
        // ans = Math.max(ans, eaten.size() + 1);
        // }
        // if(eaten.get(dishes[left]) == 1 ) eaten.remove(dishes[left]);
        // else eaten.replace(dishes[left], eaten.get(dishes[left]) + 1);
        //
        // left++;
        // }
        // }
    }
}

/*
 * - 1) 벨트의 임의의 한 위치 ~ k개 먹으면 할인된 정액가격
 * - 2) 각 고객에게 초밥의 종류 하나가 적힌 쿠폰 발행 -> 1)에 참여한 경우 쿠폰에 적힌 초밥 하나 무료 제공
 * - 그 종류의 초밥이 없을 경우 요리사가 새로 만들어서 제공
 * 
 * 가능한 한 다양한 종류의 초밥을 먹는 법
 * 
 */