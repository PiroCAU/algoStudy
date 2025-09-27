# 사고의 흐름
### 문제 요구사항
- 색종이 종류별로 5개
  - 변의 크기 1~5
- 0에는 색종이 X
- 1에는 색종이 O
- 모든 1 덮는 데 필요한 최소개수 출력
  - 겹치지 않게 붙이기
  - 경계 벗어나지 않게 붙이기

### 생각하기
- 1이 연결된 곳 - 덮고, 0으로 바꾸기
  - 오른쪽, 아래쪽으로 1칸씩 가면서 덮을 수 있는지 여부 체크 
  - => 잘못 덮으면 더 효율적인 덮기 방식 배제될 수 있음.

- 5 x 5 부터 하나씩 덮어보기
  - row별로 순회하며 1이 5개 연속적인 column 시작점 찾기
  - 찾으면: 5회, 아래쪽 row 동일 column 시작점에서 연속 체크
    - 모두 연속적이면: 해당 값 모두 0으로 만들고 count++
    - 아니면: 다음 연속 column 찾기
  - 못 찾으면: 다음 4x4로 넘어가기

이렇게 하면 너무 시간 비효율적일 수 있음. 같은 순회 내에서 5 x 5 부터 1 x 1 까지 하고,
이를 다른 배열에 저장해두기

- 1이 있는 위치에서 가능한 덮기 경우 구하기
  - 가장 큰 색종이부터 덮기 DFS
  - 점점 작은 색종이로 DFS
- DFS 할 때, 최소 count 넘으면 바로 그만 찾기 

### 솔루션

- 1이 있는 위치에서 가능한 덮기 경우 구하기
  - 가장 큰 색종이부터 덮기 DFS
  - 점점 작은 색종이로 DFS
- DFS 할 때, 최소 count 넘으면 바로 그만 찾기

1. 1이 있는 위치 찾기 -> 리스트에 저장
2. 해당 위치에서 가능한 모든 덮기 경우 구하기
3. 큰 색종이부터 덮기 실행(DFS)
   - 최소 count 넘으면 그만찾기
   - 덮었으면 다음 1로 이동해서 DFS
   - 탐색 끝나면 원상복구

# 어려운 점
그냥 어렵다. 생각이 안미쳐..

# 배운 점

# 알고리즘

    public static void dfs(int r, int c, int count) {
    // 끝까지 갔을 때: minCount 와 count 비교
    if (r >= 10) {
    if (minCount > count) minCount = count;
    return;
    }

        // col 추가하면서 위치별로 순회하며 덮어보기
        // col 10이면 row+1
        if (c >= 10) {
            dfs(r + 1, 0, count); // 다음 row로 이동. col 초기화
            return;
        }
        // 최소 count 넘으면 그만찾기
        if (count >= minCount) {
            return;
        }

        // value 0이면 -> 다음 위치로 재귀호출
        if (grid[r][c] == 0) {
            dfs(r, c + 1, count);
            return;
        }
        // 1이면 -> 1~5 모두 덮어보기
        if (grid[r][c] == 1) {
            // 1~5 순회
            for (int size = 1; size <= 5; size++) {
                // 붙일 수 있으면 + 종이가 남아있으면
                if (paperCount[size] > 0 && isAttachable(r, c, size)) {
                    // 붙이고 다음으로 넘어가기 (dfs 재귀호출)
                    attach(r, c, size, 0);
                    paperCount[size]--;

                    count++;
                    dfs(r, c + 1, count);
                    count--;

                    // 떼고 돌아가기
                    attach(r, c, size, 1);
                    paperCount[size]++;
                }
            }
        }
    }