import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] map = new int[N];
		int[] find = new int[N];
		// 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
		    // stack이 비어있거나, map[idx]가 더 낮으면
			while (!stack.isEmpty() && map[stack.peek()] <= map[i]) {
		        stack.pop();
		    }
		    find[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
		    stack.push(i);
		}

		
		for(int i = 0; i < N; i++) {
			System.out.print(find[i]+ " ");
		}
	}
}
