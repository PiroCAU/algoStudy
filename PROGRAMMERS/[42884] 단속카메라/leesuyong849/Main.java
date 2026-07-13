package PRO_42884;

import java.util.Arrays;

public class Main {

    public int solution(int[][] routes) {
        //정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int count = 1;
        int camera = routes[0][1];  //처음으로 나가는 사람이 있는곳부터 단속 시작

        for (int i = 1; i < routes.length; i++) {
            // 가장 최신 카메라가 단속 못하면 하나 더 추가
            if (routes[i][0] > camera) {
                count++;
                camera = routes[i][1];
            }
        }

        return count;
    }
}


