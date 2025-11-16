import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int N, studentNum;
	private static boolean[] switches;
	private static ArrayList<int[]> students;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		switches = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			if(st.nextToken().equals("1")) switches[i] = true; 
		}
		
		studentNum = Integer.parseInt(br.readLine());
		students = new ArrayList<>();
		
		for(int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			
			students.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		for(int[] student : students) {
			int s = student[0];
			int idx = student[1];
			
			if(s == 1) moveMale(idx);
			else moveFemale(idx);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(switches[i] ? 1 : 0).append(" ");
			if(i % 20 == 0) sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void moveMale(int n) {
		// 남학생: 스위치 번호가 자기가 받은 번호의 배수이면 스위치의 상태를 바꿈
		for(int i = 1; i < 101; i++) {
			int idx = i * n;
			if(idx > N) break;
			boolean cur = switches[idx];
			switches[idx] = !cur;
		}		
	}

	private static void moveFemale(int n) {
		// 여학생: 스위치 번호 중심으로 좌우가 대칭이고, 가장 많은 스위치가 포함하는 범위 찾아서 모두 바꿈
		// 좌우 대칭 범위 찾기
		int d = 0;
		while(true) {
			int next = n + d;
			int prev = n - d;
			
			if(!isIn(next, prev)) break;
			if(switches[next] != switches[prev]) break;
			
			// 끄기
			if(d == 0) {
				boolean cur = switches[n];
				switches[n] = !cur;
			}
			else {
				boolean cur = switches[next];
				switches[next] = !cur;
				switches[prev] = !cur;
			}
			d++;
		}
	}

	private static boolean isIn(int next, int prev) {
		return next <= N && prev > 0;
	}

}
