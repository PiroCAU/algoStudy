# 사고의 흐름
### 문제의 요구사항
- 정수 제시받아서, 순서 유지한 채로 +, - 통해서 타겟 넘버 만들기
- 가능한 방법의 수 리턴

### 풀이법 생각
재귀함수 활용해서 풀 수 있으려나?

1, 1, 1 그리고 3이 제시된다고 하면
1. 1 1 1 = 3
2. 1 1 = 2 / 1 1 = 4
3. 1 = 3 / 1 = 1 (o) // 1 = 3 / 1 = 5

가능한 경우의 수를 모두 구할 수 있음.

트리 완전 탐색의 형태! DFS 를 써보자.

### 솔루션(1) BFS 활용

더하는 경우, 빼는 경우 각각 실행하면서 반복

최종 노드까지 도달하면 종료.

(GPT 도움) 최종 노드에서 가능하면 1, 불가하면 0 을 리턴해서 count에 더한다.
이렇게 하면 모든 경우의 수 합할 수 있음.


# 알고리즘
    public static int dfs(int index, int sum, int[] numbers, int target){
        // 리프노드까지 오면 타겟과 비교, 맞으면 +1, 아니면 0
        if(index == numbers.length){
        return sum == target ? 1 : 0;
        }
        int count = 0;
    
        // 더하는 경우와 빼는 경우 모두 고려
        count += dfs(index + 1, sum + numbers[index], numbers, target);
        count += dfs(index + 1, sum - numbers[index], numbers, target);
        
        return count;
    }

# 어려운 점

dfs 라는 것을 감을 잡아도, 코드로 만들기 어렵다.
같은 dfs라도 문제 유형에 따라 구현방식이 다르다...

DFS를 공부했는데, 이번 문제랑은 또 달라서... GPT 도움 받아가며 풀었다.


# 새로 배운 것
- 강의를 듣고 [백준 문제](https://www.acmicpc.net/problem/11724)를 풀어보았다.
  - 재귀함수, ArrayList, Boolean 배열을 통해 DFS 구현을 해볼 수 있었음.
- 전체적인 DFS 구조, 특정 자료형이 필요한 이유에 대해 알 수 있었음.



