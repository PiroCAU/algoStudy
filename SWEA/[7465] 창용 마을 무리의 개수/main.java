import java.util.*;
import java.io.*;

class Solution
{
    static ArrayList<ArrayList<Integer>> linked;
    static boolean[] visited;

	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            linked = new ArrayList<>();
            // n+1 -> 1부터 시작하기
            visited = new boolean[n + 1];
            
            // 초기화...
            for (int i = 0; i <= n; i++) {
                linked.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // 아는 사람들 입력 -> linkedList
                linked.get(a).add(b);
                linked.get(b).add(a);
            }       

            // 건너 건너 아는 사람이면 같은 무리 -> DFS

            int cnt = 0;
            for (int i = 1; i <= n; i++){
                if(!visited[i]){
                    visited[i] = true;
                    cnt++;
                    dfs(i);
                }
            }

            System.out.println("#" + test_case + " " + cnt);
		}
	}
    static void dfs(int cur){
        for(int neighborIDX : linked.get(cur)){
            if(!visited[neighborIDX]){
                visited[neighborIDX] = true;
                dfs(neighborIDX);
            }
        }
    }

}