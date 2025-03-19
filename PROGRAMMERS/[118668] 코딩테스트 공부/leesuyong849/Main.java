import java.util.*;

class Solution {
    public long solution(int w, int h) {
//        float inc = h / (float) w;
        long result = 0;

        for (long i = 1; i < w; i++) {
            //기울기를 구하여 w 좌표에서 위치를 파악한다.
            double thisH = (h * i) / (double) w;
            //소수점을 버려서 남은 사각형의 크기 파악
            long box = (long) Math.floor(thisH);
            result += box;
        }
        System.out.println(result * 2);
        return result * 2;
    }
}