import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] rotates;
	static boolean[] visited;
	static int N, M, K, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[K];
		rotates = new int[K][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rotates[i][0] = Integer.parseInt(st.nextToken()) - 1;
			rotates[i][1] = Integer.parseInt(st.nextToken()) - 1;
			rotates[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(min);
		
	}
	static void dfs(int idx) {
		if(idx == K) {
			getMin();
			return;
		}
		for(int i = 0; i < K; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			int[][] original = copy();
			rotate(rotates[i]);
			dfs(idx + 1);
			// 백트래킹
			arr = original;
			visited[i] = false;
			
		}
	}
	
	static void rotate(int[] cmd) {
		int r = cmd[0];
		int c = cmd[1];
		int s = cmd[2];
		
		int top = r - s;
	    int left = c - s;
	    int bottom = r + s;
	    int right = c + s;
		
	    // 돌리기...
        while (top < bottom && left < right) {
            int temp = arr[top][left];

            // 왼쪽 
            for (int i = top; i < bottom; i++) {
                arr[i][left] = arr[i + 1][left];
            }
            // 아래
            for (int j = left; j < right; j++) {
                arr[bottom][j] = arr[bottom][j + 1];
            }
            // 오른쪽 
            for (int i = bottom; i > top; i--) {
                arr[i][right] = arr[i - 1][right];
            }
            // 위 
            for (int j = right; j > left + 1; j--) {
                arr[top][j] = arr[top][j - 1];
            }
            // 마지막
            arr[top][left + 1] = temp;

            top++; left++; bottom--; right--;
        }
	}
	
	static int[][] copy() {
		int[][] copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
	
	static void getMin() {
		for(int i = 0; i < N; i++) {
			int s = 0;
			for(int j = 0; j < M; j++) {
				s += arr[i][j];
			}
			min = Math.min(s, min);
		}
	}
}

/*
 * 입력
 * N M K(크기, 회전 연산 개수)
 * N: 배열 정보
 * K: 회전 연산 정보(r, c, s) r-s, c-s ~ r+s, c+s 을 시계 방향으로 돌
 * 
 * 출력
 * A 값의 최소(행 합 중 최소)
 * 
 * 생각
 * 오... 순열 완탐...
 * 돌리기 너무 싫다...
 * 왼쪽 위 저장해두고, 왼쪽부터 쭉 한바퀴 돌리고 마지막에 저장해주기
 * 
 */
