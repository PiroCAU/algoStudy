class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 원래 모두 가지고 있음 -> 한 벌로 체크
        int [] clothes = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }
        
        // 근데 뺏김!
        for (int i : lost) {
            clothes[i]--;
        }
        
        // 여벌 있음
        for (int i : reserve){
            clothes[i]++;    
        }

        // 빌려줌 idx 1부터 시작
        for (int i = 1; i <= n; i++){
            // 체육복이 없으면
            if(clothes[i] == 0){
                // idx 2부터 앞 번호가 있음
                if(i > 1 && clothes[i - 1] >= 2){
                    clothes[i]++;
                    clothes[i-1]--;
                    // idx n까지 -> i+1 <= n, i < n
                } else if (i < n && clothes[i+1] >= 2 ){
                    clothes[i]++;
                    clothes[i+1]--;
                }
            }
        }
         
        // 체육복 있는 사람 세기
        for (int i = 1; i <= n; i++){
            if(clothes[i] >= 1){
                answer++;
            }
        }
        return answer;
    }
}