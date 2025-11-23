import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int W, H;
	private static boolean[][] blocks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		blocks = new boolean[H][W];
		
		// 블록 입력
		st = new StringTokenizer(br.readLine());
		for(int c = 0; c < W; c++) {
			int hei = Integer.parseInt(st.nextToken());
			for(int r = 0; r < hei; r++) {
				blocks[r][c] = true;
			}
		}
		
		int cnt = 0;
		for(int r = 0; r < H; r++) {
			int left = W + 1;
			int right = -1;
			
			for(int c = 0; c < W; c++) {
				if(blocks[r][c]) {
					left = Math.min(left, c);
					right = Math.max(right, c);
				}
			}
			
			if(left != W + 1 && right != -1) {
				for(int c = left; c <= right; c++) {
					if(!blocks[r][c]) cnt++;
				}				
			} else {
				break;
			}
		}
		
		System.out.println(cnt);
		
		// 생각: 가장 낮은 높이부터 시작해서 물 채울 수 있으면 채우고
		// 한 칸도 못 채운 높이가 있으면 break? 근데 일단 그냥 쭉 보자
		
		// 물은 어떤 때 채울 수 있을까?
		// 양 옆이 막혀있으면
		// 한 줄에서: 막힌거 시작, 끝 찾아서 그 사이 채움
	}

}
