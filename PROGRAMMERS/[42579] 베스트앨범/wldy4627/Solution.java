package prog.p42579.wldy4627;

import java.util.*;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		Map<String, Integer> genresMap = new HashMap<>();
		Map<String, PriorityQueue<int[]>> songMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];

			genresMap.put(genre, genresMap.getOrDefault(genre, 0) + play);

			songMap.putIfAbsent(genre, new PriorityQueue<>((a, b) -> {
				if (a[1] == b[1]) return Integer.compare(a[0], b[0]); // 재생 횟수 같으면 고유번호 오름차순
				return Integer.compare(b[1], a[1]);  // 재생 횟수 다르면 재생횟수 내림차순
			}));

			songMap.get(genre).add(new int[]{i, play});
		}

		List<String> keySet = new ArrayList<>(genresMap.keySet());
		keySet.sort((o1, o2) -> genresMap.get(o2).compareTo(genresMap.get(o1)));

		List<Integer> resultList = new ArrayList<>();

		for (String genre : keySet) {
			PriorityQueue<int[]> pq = songMap.get(genre);

			int count = 0;
			while (!pq.isEmpty() && count < 2) {
				int[] song = pq.poll();
				resultList.add(song[0]);
				count++;
			}
		}

		return resultList.stream().mapToInt(i -> i).toArray();
	}
}