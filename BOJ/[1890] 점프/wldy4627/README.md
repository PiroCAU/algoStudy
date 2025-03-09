### 고안 방법
1. 결국 도착 지점에 가기 위해서는 오른쪽으로 `(N-1)`번, 아래쪽으로 `(N-1)`번 이동해야함
2. 현재 배열에서의 위치 값을 읽어서 오른쪽으로 또는 아래쪽으로 이동할 수 있는지 확인
3. 이동할 수 있다면 이동
4. 도착했다면 1씩 증가
5. 결국 이를 하기 위해서는 가능한 모든 경로를 찾아야 하므로 **DFS**를 이용해야겠다고 생각

### 첫번째 시도
```
public int solution(int N, int[][] arr) {
        this.N = N;
        dfs(arr, 0, 0);
        return answer;
    }

private void dfs(int[][] arr, int row, int col) {
    if (row == N - 1 && col == N - 1) {
        answer++;
    }

    int value = arr[row][col];
    if (value == 0) return;

    if (col + value < N) {
        dfs(arr, row, col + value);
    }

    if (row + value < N) {
        dfs(arr, row + value, col);
    }
}
```
- 정답은 맞게 나왔으나 시간 초과..

### 변경 방식
- DFS로는 중복 계산이 많아 비효율적임 -> DP를 이용해야 함
- DP 배열을 이용하여 경로의 개수를 저장하며 해결!
- DP 배열 초기화
  - dp[i][j]는 (i, j) 칸까지 도달할 수 있는 경로의 개수를 저장하는 배열
- DP 배열 갱신
  - arr[i][j] 값만큼 오른쪽 또는 아래쪽으로 이동할 수 있으므로, 해당 위치의 dp 값에 현재 dp[i][j] 값을 더함
- dp[N - 1][N - 1] 값이 도착점까지 갈 수 있는 경로의 개수