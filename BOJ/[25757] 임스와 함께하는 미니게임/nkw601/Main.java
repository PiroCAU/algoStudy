import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		char game = st.nextToken().charAt(0);
		
		// 중복 제거를 위한 set
		HashSet<String> players = new HashSet<>();
		for(int i = 0; i < n; i++) {
			players.add(br.readLine());
		}
		
		// 중복 없는 player 수
		int player = players.size();
		
		switch (game) {
        // case 'Y' -> System.out.println(player); 안되네... 14부터 된다고 함
		case 'Y':
			System.out.println(player);
			break;
		case 'F':
			System.out.println(player/ 2);
			break;
		case 'O':
			System.out.println(player/ 3);
			break;
		}
	}

}

/*
 * 입력
 * N 게임종류(윷Y 같은그림F 원카드O)
 * 
 * 출력
 * 조합
 * 
 * 생각
 * 윷 2명, 같은그림 3명, 원카드4명
 * 진짜 그냥 조합 수인데?
 * 아니다 한 사람과는 한 번만 하니까 그냥 나누기겠다
 */