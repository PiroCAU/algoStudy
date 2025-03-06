### 나의 문제 풀이 방식
- 가로, 세로 중 더 큰 값을 가로에, 작은 값을 세로로 정렬하여 새로운 배열에 할당
- 가로 중 최댓값과 세로 중 최댓값을 찾아서 그 둘을 곱함으로써 넓이를 구함
#### 시간 복잡도
- sizes 배열을 한 번 순회하며 새로운 배열 new_size 생성 -> **O(N)**
- new_size 배열을 한 번 순회하며 가로, 세로 최댓값 갱신 -> **O(N)**
- 총 시간 복잡도: **O(N)**
---
### 타인의 코드
```
class Solution {
    public int solution(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }
}
```
- sizes 배열을 순회할 때 굳이 새로운 배열에 할당하지 않고, 최댓값을 구하는 과정을 한 for 문 안에서 해결
#### 시간 복잡도
- sizes 배열을 한 번 순회하며 최댓값을 갱신 -> **O(N)**
- Math.max()와 Math.min()은 상수 시간 연산 -> **O(1)**
- 총 시간 복잡도: **O(N)**
---
### 차이
시간 복잡도 측면에서는 O(N)으로 동일하나 공간 복잡도 측면에서 나의 코드는 new_size라는 새로운 배열을 생성하기 때문에 **메모리를 낭비**함.
만약 타인의 코드를 이용한다면 공간 복잡도를 O(1)로 개선할 수 있음