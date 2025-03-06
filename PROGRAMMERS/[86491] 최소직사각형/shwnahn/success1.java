package src.week3.BruteForceSearch;

public class success1 {
    public int solution(int[][] sizes) {
        int max_w = 0;
        int max_h = 0;
        for (int[] size: sizes){
            // 긴변은 가로, 짧은변은 세로
            int w;
            int h;
            if (size[0] > size[1]) {
                w = size[0];
                h = size[1];
            } else {
                w = size[1];
                h = size[0];
            }

            // 가로, 세로 각각 가장 긴 변 찾기
            if (w > max_w){
                max_w = w;
            }
            if (h > max_h){
                max_h = h;
            }
        }
        int answer = max_w * max_h;
        return answer;
    }
}
