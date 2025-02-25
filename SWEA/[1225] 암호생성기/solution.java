import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int cnt = 1;
            sc.nextInt();
            Queue<Integer> que = new LinkedList<Integer>();
            // int a = sc.nextInt();
            
            //큐에 숫자 8개 입력받기
            for (int i = 0; i < 8; i++) {
                int num = sc.nextInt();
				que.offer(num); 
			}

            while(true){
                int first = que.poll();
                first -= cnt;
                cnt++;
                if(cnt >= 6) { cnt = 1; }

                if(first <= 0) { que.offer(0); break; } // 0 이하면 que에 0 넣고 break
               	que.offer(first);
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");
        	for (int num : que) {
            	sb.append(num).append(" ");
        	}

        System.out.println(sb.toString().trim());
            		}
	}
}