package boj.b1283.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		boolean[] alphabet = new boolean[26];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int selectedIndex = -1;

			for (int idx = 0; idx < str.length(); idx++) {
				if (idx == 0 || str.charAt(idx - 1) == ' ') {
					char c = str.charAt(idx);
					char upper = Character.toUpperCase(c);

					if (!alphabet[upper - 'A']) {
						alphabet[upper - 'A'] = true;
						selectedIndex = idx;
						break;
					}
				}
			}

			if (selectedIndex == -1) {
				for (int idx = 0; idx < str.length(); idx++) {
					char c = str.charAt(idx);

					if (c == ' ') continue;

					char upper = Character.toUpperCase(c);

					if (!alphabet[upper - 'A']) {
						alphabet[upper - 'A'] = true;
						selectedIndex = idx;
						break;
					}
				}
			}

			if (selectedIndex == -1) {
				System.out.println(str);
			} else {
				System.out.println(
					str.substring(0, selectedIndex) +
						"[" + str.charAt(selectedIndex) + "]" +
						str.substring(selectedIndex + 1)
				);
			}
		}
	}
}
