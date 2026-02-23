package boj.b17615.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[] ball;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String line = br.readLine();
		ball = new char[N];
		for (int i = 0; i < N; i++) {
			ball[i] = line.charAt(i);
		}

		int rCount = Math.min(move(0, 'R'), move(N-1, 'R'));
		int lCount = Math.min(move(0, 'B'), move(N-1, 'B'));

		System.out.println(Math.min(rCount, lCount));
	}

	static int move(int start, char color) {
		int cnt = 0;

		for (int i = 0; i < ball.length; i++) {
			if (ball[i] == color) {
				cnt++;
			}
		}

		if (start == 0) {
			for (int i = 0; i < ball.length; i++) {
				if (ball[i] == color) {
					cnt--;
				} else {
					return cnt;
				}
			}
		} else {
			for (int i = ball.length - 1; i >= 0; i--) {
				if (ball[i] == color) {
					cnt--;
				} else {
					return cnt;
				}
			}
		}

		return cnt;
	}
}
