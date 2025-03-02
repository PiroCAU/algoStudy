import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            String password = st.nextToken();  

            Stack<Character> stack = new Stack<>();
            for(char c : password.toCharArray()){
                if (!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }

            System.out.print("#" + test_case + " ");
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
		}
	}
}