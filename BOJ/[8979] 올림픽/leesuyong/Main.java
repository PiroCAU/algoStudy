package BOJ_8979_올림픽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());       //0부터 시작하기 위해 -1 함
        int[][] map = new int[N][3];
        int[] target = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            //만약 입력 값이 타겟값이면 map에 저장하지 않고 target이라는 곳에 별도 저장
            if (number == K){
                target[0] = Integer.parseInt(st.nextToken());
                target[1] = Integer.parseInt(st.nextToken());
                target[2] = Integer.parseInt(st.nextToken());
                continue;
            }
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        int rank = 0;
        for (int i = 0; i < N; i++) {
            if (i == K) continue;
            //금메달 비교
            if (target[0] < map[i][0]) rank++;
            else if (target[0] == map[i][0]) {

                //음메달 비교
                if (target[1] < map[i][1]) rank++;
                else if (target[1] == map[i][1]) {

                    //동메달 비교
                    if (target[2] < map[i][2]) rank++;
                }
            }
        }

        System.out.println(rank + 1);
    }
}
