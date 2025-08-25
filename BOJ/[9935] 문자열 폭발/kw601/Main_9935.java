import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;

public class Main_9935 {
	static String target, bomb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;
		target = br.readLine();
		bomb = br.readLine();
		int len = bomb.length();
		
		for(char c : target.toCharArray()) {
			sb.append(c);
			if(sb.length() >= len) {
				boolean isMatched = true;
				for(int i = 0; i < len; i++) {
					if(sb.charAt(sb.length() - len + i) != bomb.charAt(i)){
						isMatched = false;
						break;
					}
				}
				if (isMatched) {
					sb.delete(sb.length() - len, sb.length());
				}
			}
		}
		
		System.out.println(sb.length() == 0? "FRULA" : sb);
	}

}

/*
 * 입력
 * target
 * bomb
 * 
 * target에 bomb이 있으면 bomb 없어짐 -> 다시 합침
 * 계속 반복
 * 
 * if !target: FRULA
 * else: target
 * 
 * while(in): target = target.replace(bomb, '')
 * 이렇게 하니까 시간초과가 나더라고요...
 * 스택으로 풀어야만 하는 듯....
 * 그래서 그 김에 자바로 풀기로 함
 * 
 * 스트링빌더도 스택이니까...
 * bomb 길이보다 길어지면 -> sb.len - len + 0 == bomb[i] 비교
 * 끝까지 같으면 빼기
 */
