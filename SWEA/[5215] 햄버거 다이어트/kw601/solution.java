import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int N, L, confidence;
    static int[] scores, kcals;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N  = sc.nextInt(); // 재료 수
            L = sc.nextInt(); // 최대 칼로리
            scores = new int[N];
            kcals = new int[N];
            
            confidence = 0; 
            
            for (int i = 0; i < N; i++){
            	scores[i] = sc.nextInt();
				kcals[i] = sc.nextInt(); 
            }
            
            dfs(0,0,0);
            System.out.println("#" + test_case + " " + confidence);

		}

	}
    public static void dfs(int idx, int sumscore, int sumkcal) {
		if (sumkcal > L) // 총 칼로리가 L을 넘으면
			return;
        else {
        	confidence = Math.max(confidence, sumscore);
        }
		if (idx == N) { // 끝까지 다 갔으면
			return;
		}
		
		dfs(idx + 1, sumscore + scores[idx], sumkcal + kcals[idx]); // 재료 사용 ㅇ
        dfs(idx + 1, sumscore, sumkcal); // 재료 사용 X
	}
}