package BOJ_13144_ListOfUniqueNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, curCnt;
    static Long count;
    static int[] map;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        count = 0L;

        map = new int[N];
        check = new int[100001];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        check = new int[100001];
        curCnt = 0;
        int next = 0;       //중복으로 인해 업데이트되지 못한 값. 여기서부터 판단을 시작한다.

        for (int i = 0; i < N; i++) {
            //마지막에 업데이트한 것 다음 것부터 판단.
            for (int j = next; j < N; j++) {
                int c = map[j];
                if (check[c] == 0) {
                    check[c] = -1;
                    curCnt++;
                } else {
                    //이미 사용한 숫자라면 멈추게 된 곳의 인덱스를 저장하고 다음으로 넘긴다.
                    next = j;
                    break;
                }

                if (j == N - 1) next = N;
            }
            count += curCnt;

            int removeTar = map[i];
            check[removeTar] = 0;
            curCnt--;
        }

        System.out.println(count);
    }
}
