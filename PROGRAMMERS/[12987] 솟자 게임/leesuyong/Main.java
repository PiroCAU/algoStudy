package PRO_12987;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int count = 0;
        int i = 0;

        for (int j = 0; j < B.length; j++) {
            if (B[j] > A[i]) {
                count++;
                i++;
            }
        }

        return count;
    }
}
