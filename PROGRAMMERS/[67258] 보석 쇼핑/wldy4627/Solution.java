package prog.p67258.wldy4627;

import java.util.*;

class Solution {
	public int[] solution(String[] gems) {
		Set<String> gemsSet = new HashSet<>();
		for (String gem : gems) {
			gemsSet.add(gem);
		}
		int totalGems = gemsSet.size();

		int start = 0;
		int end = 0;

		Map<String, Integer> map = new HashMap<>();  // (보석 이름, 보석 개수)
		int minLength = Integer.MAX_VALUE;
		int[] answer = new int[2];  // 정답인 [start, end] 저장

		while (true) {
			// 모든 종류를 모았을 경우 start 줄여서 구간 줄이기
			if (map.size() == totalGems) {
				int currentLength = end - start;

				if (currentLength < minLength) {
					minLength = currentLength;

					answer[0] = start + 1;
					answer[1] = end;
				}

				String startGem = gems[start];
				map.put(startGem, map.get(startGem) - 1);
				if (map.get(startGem) == 0) {
					map.remove(startGem);
				}

				start++;
			}

			// end가 끝에 다다르면 탈출
			else if (end == gems.length) {
				break;
			}

			// 보석이 부족하면 end를 움직여서 구간 늘리기
			else {
				String newGem = gems[end];
				map.put(newGem, map.getOrDefault(newGem, 0) + 1);

				end++;
			}
		}

		return answer;
	}
}