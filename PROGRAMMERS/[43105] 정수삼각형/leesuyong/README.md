# 프로그래머스 정수 삼각형 문제

## 📋 문제 설명

삼각형 형태로 배열된 정수들이 주어진다. 위에서 시작하여 아래로 내려가면서 **거쳐간 수의 합을 최대화**하는 문제이다.

- 맨 위에서 출발
- 아래로 이동할 때, 현재 위치에서 **바로 아래 인접한 두 칸 중 하나**로만 이동 가능
- 가장 아래 행에 도달했을 때의 최대 합 구하기

### 예시
```
      1
     2 3
    1 5 1
```
- 경로 1: 1 → 2 → 1 = 4
- 경로 2: 1 → 2 → 5 = 8  ✓
- 경로 3: 1 → 3 → 5 = 9  ✓✓ (최대)

## 💡 풀이 방법: 동적 프로그래밍

**핵심 아이디어**: 각 위치에 도달했을 때의 **최대 경로 합**을 저장하면서 아래로 내려간다.

### 점화식
```
dp[i][j] = 현재 위치의 값 + max(이전 행에서 올 수 있는 위치들의 dp값)
```

### 케이스 분류
1. **j == 0** (맨 왼쪽): 이전 행의 같은 인덱스에서만 올 수 있음
   ```
   dp[i][0] = dp[i-1][0] + triangle[i][0]
   ```

2. **j == i** (맨 오른쪽): 이전 행의 [j-1] 위치에서만 올 수 있음
   ```
   dp[i][i] = dp[i-1][i-1] + triangle[i][i]
   ```

3. **그 외** (중간): 이전 행의 [j-1] 또는 [j] 중 최댓값에서 올 수 있음
   ```
   dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
   ```

## 🔧 풀이 코드

```java
class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] map = new int[height][height];
        
        // 맨 위 초기화
        map[0][0] = triangle[0][0];
        
        // DP 테이블 채우기
        for (int i = 1; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                int cur = triangle[i][j];
                
                if (j == 0) {
                    // 맨 왼쪽
                    map[i][j] = map[i - 1][j] + cur;
                } else if (j == i) {
                    // 맨 오른쪽
                    map[i][i] = map[i-1][i-1] + cur;
                } else {
                    // 중간: 최댓값 선택
                    map[i][j] = Math.max(map[i-1][j], map[i-1][j-1]) + cur;
                }
            }
        }
        
        // 마지막 행에서 최댓값 찾기
        int result = 0;
        for (int i = 0; i < height; i++) {
            result = Math.max(result, map[height - 1][i]);
        }
        
        return result;
    }
}
```

## 📍 코드에서 수정한 부분

원래 코드에서 발견된 문제 2가지:

### 1. 배열 크기 오류
**문제 코드:**
```java
int width = triangle[0].length;  // width = 1
int[][] map = new int[height][width];  // map[height][1] → 너무 작음
```

**수정:**
```java
int[][] map = new int[height][height];  // 정사각형 크기로 할당
```

### 2. 반복 범위 오류
**문제 코드:**
```java
for (int j = 0; j <= i + 1; j++) {  // 범위 초과
```

**수정:**
```java
for (int j = 0; j <= i; j++) {  // i번째 행은 i+1개 원소 (0~i)
```

## 🎯 복잡도 분석

| 항목 | 복잡도 |
|------|--------|
| **시간 복잡도** | O(n²) |
| **공간 복잡도** | O(n²) |

- n: 삼각형의 높이
- 총 원소 개수: 1 + 2 + 3 + ... + n = n(n+1)/2 = O(n²)

## 🚀 최적화 (선택사항)

공간을 O(n)으로 줄일 수 있다. 현재 행만 계산하면 되므로 1차원 배열 사용:

```java
class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[] dp = new int[n];
        dp[0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + triangle[i][j];
                } else if (j == i) {
                    dp[j] = dp[j-1] + triangle[i][j];
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]) + triangle[i][j];
                }
            }
        }
        
        int result = 0;
        for (int val : dp) {
            result = Math.max(result, val);
        }
        
        return result;
    }
}
```

> **역순 반복이 중요**: 앞에서부터 갱신하면 같은 행의 값을 중복 사용하므로 뒤에서부터 반복해야 함