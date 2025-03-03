package PROGRAMMERS.체육복.wldy4627;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int lostCnt = sc.nextInt();
        int[] lost = new int[lostCnt];
        for (int i = 0; i < lostCnt; i++) {
            lost[i] = sc.nextInt();
        }

        int reserveCnt = sc.nextInt();
        int[] reserve = new int[n];
        for (int i = 0; i < reserveCnt; i++){
            reserve[i] = sc.nextInt();
        }

        sc.close();

        Solution sol = new Solution();
        int answer = sol.solution(n, lost, reserve);

        System.out.println(answer);
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 예외 처리
        Validator validator = new Validator();
        validator.validate(n, lost, reserve);

        int[] cloth = new int[n];
        Arrays.fill(cloth, 1);
        for (int num : lost) {
            cloth[num - 1]--;
        }
        for (int num : reserve) {
            cloth[num - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (cloth[i] == 0) {
                if (i > 0 && cloth[i - 1] == 2) {  // 앞 학생에게 빌리기
                    cloth[i]++;
                    cloth[i - 1]--;
                } else if (i < n - 1 && cloth[i + 1] == 2) {  // 뒤 학생에게 빌리기
                    cloth[i]++;
                    cloth[i + 1]--;
                }
            }
        }

        int answer = 0;
        for (int i : cloth) {
            if (i >= 1) {
                answer++;
            }
        }

        return answer;
    }
}

class Validator {
    public void validate (int n, int[] lost, int[] reserve) {
        // 1. 전체 학생 수는 2명 이상 30명 이하
        if (n < 2 || n > 30) {
            throw new IllegalArgumentException();
        }

        // 2-1. 체육복을 도난당한 학생의 수는 1명 이상 n명 이하
        if (lost.length < 1 || lost.length > n) {
            throw new IllegalArgumentException();
        }
        // 2-2. 체육복을 도난당한 학생은 중복되는 번호가 없어야 함
        HashSet<Integer> lostSet = new HashSet<>();
        for (int num : lost) {
            if (!lostSet.add(num)) {
                throw new IllegalArgumentException();
            }
        }

        // 3-1. 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하
        if (reserve.length < 1 || reserve.length > n) {
            throw new IllegalArgumentException();
        }
        // 3-2. 여벌의 체육복을 가져온 학생은 중복되는 번호가 없어야 함
        HashSet<Integer> reserveSet = new HashSet<>();
        for (int num : reserve) {
            if (!reserveSet.add(num)) {
                throw new IllegalArgumentException();
            }
        }
    }
}