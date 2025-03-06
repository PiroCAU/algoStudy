package src.week3.BruteForceSearch;

public class fail1 {
    public int solution(int[][] sizes) {
        int[] caseA = {sizes[0][0], sizes[0][1]};
        int[] caseB = {sizes[0][0], sizes[0][1]};
        int[] wallet = {sizes[0][0], sizes[0][1]};

        // 명함 하나씩 추가하면서 지갑크기 비교
        for (int[] size : sizes){
            int w = size[0];
            int h = size[1];
            // System.out.println("w: " + w + ", h: " + h);

            // case A (명함 그대로)
            if (w > wallet[0]){
                caseA[0] = w;
            };
            if (h > wallet[1]){
                caseA[1] = h;
            }
            // System.out.println("caseA w: " + caseA[0] + ", h: " + caseA[1]);

            // case B (명함 뒤집기)
            if (h > wallet[0]){
                caseB[0] = h;
            };
            if (w > wallet[1]){
                caseB[1] = w;
            }

            // System.out.println("caseB w: " + caseB[0] + ", h: " + caseB[1]);

            // case A, B 비교하기
            if (caseA[0] * caseA[1] < caseB[0] * caseB[1]){
                wallet[0] = caseA[0];
                wallet[1] = caseA[1];
            } else {
                wallet[0] = caseB[0];
                wallet[1] = caseB[1];
            }
        }

        int answer = wallet[0] * wallet[1];
        return answer;
    }
}
