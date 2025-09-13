import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxNum;
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxNum = 2;
		dfs(0);
		System.out.println(maxNum);
	}
	private static void dfs(int cnt) {
		if(cnt == 5) {
			maxNum = Math.max(maxNum, findMax());
			return;
		}
		
		int[][] original = copyArr();
		
		moveTop();
		dfs(cnt + 1);
		board = original;
		
		moveBottom();
		dfs(cnt + 1);
		board = original;

		moveLeft();
		dfs(cnt + 1);
		board = original;

		moveRight();
		dfs(cnt + 1);
		board = original;
	}
	
	private static int findMax() {
		int m = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(m < board[i][j]) m = board[i][j];
			}
		}
		return m;
	}
	
	private static int[][] copyArr(){
		int[][] copy = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				copy[i][j] = board[i][j];
			}
		}
		
		return copy; 
	}
	private static void moveTop() {
	    int[][] result = new int[N][N];
	    for (int j = 0; j < N; j++) {
	        java.util.ArrayDeque<Integer> q = new java.util.ArrayDeque<>();
	        for (int i = 0; i < N; i++) if (board[i][j] != 0) q.add(board[i][j]);

	        int idx = 0;
	        while (!q.isEmpty()) {
	            int cur = q.poll();
	            if (!q.isEmpty() && cur == q.peek()) {
	                cur += q.poll();
	            }
	            result[idx++][j] = cur;
	        }
	    }
	    board = result;
	}

	private static void moveBottom() {
	    int[][] result = new int[N][N];
	    for (int j = 0; j < N; j++) {
	        java.util.ArrayDeque<Integer> q = new java.util.ArrayDeque<>();
	        for (int i = N - 1; i >= 0; i--) if (board[i][j] != 0) q.add(board[i][j]);

	        int idx = N - 1;
	        while (!q.isEmpty()) {
	            int cur = q.poll();
	            if (!q.isEmpty() && cur == q.peek()) {
	                cur += q.poll();
	            }
	            result[idx--][j] = cur;
	        }
	    }
	    board = result;
	}

	private static void moveLeft() {
	    int[][] result = new int[N][N];
	    for (int i = 0; i < N; i++) {
	        java.util.ArrayDeque<Integer> q = new java.util.ArrayDeque<>();
	        for (int j = 0; j < N; j++) if (board[i][j] != 0) q.add(board[i][j]);

	        int idx = 0;
	        while (!q.isEmpty()) {
	            int cur = q.poll();
	            if (!q.isEmpty() && cur == q.peek()) {
	                cur += q.poll();
	            }
	            result[i][idx++] = cur;
	        }
	    }
	    board = result;
	}

	private static void moveRight() {
	    int[][] result = new int[N][N];
	    for (int i = 0; i < N; i++) {
	        java.util.ArrayDeque<Integer> q = new java.util.ArrayDeque<>();
	        for (int j = N - 1; j >= 0; j--) if (board[i][j] != 0) q.add(board[i][j]);

	        int idx = N - 1;
	        while (!q.isEmpty()) {
	            int cur = q.poll();
	            if (!q.isEmpty() && cur == q.peek()) {
	                cur += q.poll();
	            }
	            result[i][idx--] = cur;
	        }
	    }
	    board = result;
	}
}

/*
 * 합쳐질 예정인 블럭을 모아서 한 번에 처리
 * 2 를 위로 밀면 4
 * 2		   2가 되는건가?
 * 2
 * 일단 그 방향대로 다 쭉 밀어
 * 그러다 두개 같으면 하나로 묶어!
 */